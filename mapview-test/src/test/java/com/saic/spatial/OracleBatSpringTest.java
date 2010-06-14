package com.saic.spatial;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.saic.model.BatPerson;

@ContextConfiguration( { "classpath:spring/applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true)
public class OracleBatSpringTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource(name = "batDataSource")
    DataSource dataSource;
    Connection conn;

    @Before
    public void setup() {
        this.conn = DataSourceUtils.getConnection(this.dataSource);
    }

    @Test
    public void connect() throws SQLException {
        assertNotNull("Datasource should not be null", this.dataSource);
        assertFalse("Conn should be open", this.conn.isClosed());
    }

    @Test
    public void getVersion() throws SQLException {
        DatabaseMetaData meta = this.conn.getMetaData();
        this.logger.debug("Version: " + meta.getJDBCMajorVersion() + " " + meta.getJDBCMinorVersion());
    }

    @Test
    public void getTenBatRows() {
        String sql = "SELECT * from (SELECT mt.id, mt.source_tx, mg.shape from message_geo mg, message_text mt WHERE mg.id = mt.id AND mg.shape IS NOT NULL order by mt.source_tx asc) where rownum < 11";
        List<BatPerson> batPersons = this.simpleJdbcTemplate.query(sql, new BatPersonMapper());
        assertTrue(batPersons.size() == 10);
        for (BatPerson bp : batPersons) {
            assertNotNull(bp.getBatGuid());
            assertNotNull(bp.getMessageId());
        }
    }

    @Test
    public void searchByBadWKT() {
        String multiPoly = "MULTIPOLYGON(((-4.130859375 54.73388671875,0.439453125 54.82177734375,1.142578125 50.38330078125,-4.3505859375 50.51513671875,-4.4384765625 50.64697265625,-4.130859375 54.73388671875)))";
        String sql = "SELECT mt.id, mt.source_tx, mg.shape from message_geo mg, message_text mt " + "WHERE mg.id = mt.id "
                + "AND SDO_ANYINTERACT(mg.shape, SDO_GEOMETRY(?)) = 'TRUE' order by mt.source_tx asc";
        List<BatPerson> batPersons = this.simpleJdbcTemplate.query(sql, new BatPersonMapper(), multiPoly);
        assertTrue("Should not have returned any results", batPersons.isEmpty());
    }

    @Test
    public void searchByGoodWkt() {
        String multiPoly = "MULTIPOLYGON(((-117.421875 44.82421875,-104.765625 44.82421875,-104.765625 27.59765625,-117.0703125 28.65234375,-117.421875 44.82421875)))";
        String sql = "SELECT mg.id, mt.source_tx, mg.shape from message_geo mg, message_text mt " + "WHERE mg.id = mt.id "
                + "AND SDO_ANYINTERACT(mg.shape, SDO_GEOMETRY(?)) = 'TRUE' order by mt.source_tx asc";
        List<BatPerson> batPersons = this.simpleJdbcTemplate.query(sql, new BatPersonMapper(), multiPoly);
        for (BatPerson bp : batPersons) {
            this.logger.debug(bp);
        }
        assertTrue(batPersons.size() > 100);
    }

    static class BatPersonMapper implements RowMapper<BatPerson> {
        public BatPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
            BatPerson batPerson = new BatPerson();
            batPerson.setMessageId(rs.getBigDecimal(1));
            batPerson.setBatGuid(rs.getString(2));
            STRUCT dbObj = (STRUCT) rs.getObject(3);
            JGeometry sdoGeom = JGeometry.load(dbObj);
            batPerson.setGeom(sdoGeom);
            return batPerson;
        }
    }

}
