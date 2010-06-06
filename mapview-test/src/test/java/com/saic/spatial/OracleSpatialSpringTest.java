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
public class OracleSpatialSpringTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource(name = "spatialDataSource")
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

    private static final class BatPersonMapper implements RowMapper<BatPerson> {
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
    // @Test
    // public void getGeometryRow() throws SQLException {
    // this.statement = this.conn.createStatement();
    // this.resultSet =
    // this.statement.executeQuery("SELECT * FROM geometry_examples");
    // while (this.resultSet.next()) {
    // String name = this.resultSet.getString(1);
    // String desc = this.resultSet.getString(2);
    // assertTrue(!name.isEmpty());
    // assertTrue(!desc.isEmpty());
    // log.debug("name: " + name);
    // log.debug("description: " + desc);
    // }
    // }

    // @Test
    // public void readGeometries() throws SQLException {
    // this.statement = this.conn.createStatement();
    // this.resultSet =
    // this.statement.executeQuery("SELECT shape FROM geometry_examples");
    // while (this.resultSet.next()) {
    // STRUCT dbObj = (STRUCT) this.resultSet.getObject(1);
    // assertNotNull(dbObj);
    // JGeometry sdoGeom = JGeometry.load(dbObj);
    // log.debug(sdoGeom.toStringFull());
    // assertTrue(sdoGeom.getDimensions() == 2);
    // }
    // }
    //
    // @Test
    // public void createFromWKT() throws GeometryExceptionWithContext {
    // String poly =
    // "MULTIPOLYGON(((-4.130859375 54.73388671875,0.439453125 54.82177734375,1.142578125 50.38330078125,-4.3505859375 50.51513671875,-4.4384765625 50.64697265625,-4.130859375 54.73388671875)))";
    // WKT wkt = new WKT();
    // JGeometry jGeom = wkt.toJGeometry(poly.getBytes());
    // jGeom.setSRID(8307);
    // log.debug(jGeom.toStringFull());
    // assertTrue(jGeom.getDimensions() == 2);
    // }
    //
    // @Test
    // public void getLondon() throws SQLException, GeometryExceptionWithContext
    // {
    // String britainPoly =
    // "MULTIPOLYGON(((-4.130859375 54.73388671875,0.439453125 54.82177734375,1.142578125 50.38330078125,-4.3505859375 50.51513671875,-4.4384765625 50.64697265625,-4.130859375 54.73388671875)))";
    // WKT wkt = new WKT();
    // JGeometry jGeom = wkt.toJGeometry(britainPoly.getBytes());
    // jGeom.setSRID(8307);
    // PreparedStatement ps =
    // this.conn.prepareStatement("SELECT * FROM geometry_examples ge WHERE SDO_ANYINTERACT(ge.shape, SDO_GEOMETRY(?, 8307)) = 'TRUE'");
    // ps.setString(1, britainPoly);
    // this.resultSet = ps.executeQuery();
    // assertTrue(this.resultSet.next());
    // String name = this.resultSet.getString(1);
    // assertEquals("Name should be london: " + name, "london", name);
    // log.debug("Name: " + name);
    //
    // STRUCT dbObj = (STRUCT) this.resultSet.getObject(3);
    // JGeometry shape = JGeometry.load(dbObj);
    // String pointString = new String(wkt.fromJGeometry(shape));
    // log.debug(pointString);
    // assertTrue("wkt should contain 'POINT'", pointString.contains("POINT"));
    //
    // ps.close();
    // }
}
