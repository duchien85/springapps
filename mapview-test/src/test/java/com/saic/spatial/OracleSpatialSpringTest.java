package com.saic.spatial;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang.time.StopWatch;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.saic.model.RandomPoint;

@ContextConfiguration( { "classpath:spring/applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true)
public class OracleSpatialSpringTest extends AbstractTransactionalJUnit4SpringContextTests {

    String insertSql;
    String searchSql;

    @PostConstruct
    public void postConstruct() {
        StringBuilder bldr = new StringBuilder("SELECT OBJECTID FROM world_continents wc ");
        bldr.append("WHERE SDO_ANYINTERACT(wc.GEOM, SDO_GEOMETRY(?, 8307)) = 'TRUE' ");
        bldr.append("UNION ALL ");
        bldr.append("SELECT 0 FROM DUAL WHERE NOT EXISTS ");
        bldr.append("(SELECT objectid FROM world_continents wc ");
        bldr.append("WHERE SDO_ANYINTERACT(wc.GEOM, SDO_GEOMETRY(?, 8307)) = 'TRUE')");
        this.searchSql = bldr.toString();

        this.insertSql = "INSERT INTO random_points(continent_id, geom) VALUES(?, SDO_GEOMETRY(?, 8307))";
    }

    @Override
    @Resource(name = "spatialDataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

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
    public void searchByGoodWkt() {
        // Point in Ireland (objectId = 61)
        String point = "POINT(-7 53)";
        int objectId = this.simpleJdbcTemplate.queryForInt(this.searchSql.toString(), point, point);
        this.logger.debug("Got object id: " + objectId + " for point: " + point);
        assertTrue(objectId == 61);
    }

    @Test
    public void searchByBadWKT() {
        // Point in North Pole(objectId is NULL -> 0)
        String point = "POINT(0 90)";
        int objectId = this.simpleJdbcTemplate.queryForInt(this.searchSql, point, point);
        this.logger.debug("Got object id: " + objectId + " for point: " + point);
        assertTrue(objectId == 0);
    }

    @Test
    public void insertGoodPoint() {
        // Point in Ireland (objectId = 61)
        String point = "POINT(-7 53)";
        int inserted = this.simpleJdbcTemplate.update(this.insertSql, 61, point);
        assertTrue(inserted == 1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void insertBadPoint() {
        String point = "POINT(-7 53)";
        int inserted = this.simpleJdbcTemplate.update(this.insertSql, 0, point);
        fail("Should have thrown exception on bad foreign key of continent: 0");
    }

    @Test
    public void createRandomPoints() {
        StopWatch stopWatch = new StopWatch();
        int count = 10;
        Set<String> points = new HashSet<String>(count);
        List<String> misses = new ArrayList<String>();
        stopWatch.start();
        while (points.size() < count) {
            String point = createRandomPointWKT();
            int objectId = this.simpleJdbcTemplate.queryForInt(this.searchSql, point, point);
            if (objectId != 0) {
                this.logger.debug(point);
                points.add(point);
            }
            else {
                misses.add(point);
            }
        }
        stopWatch.stop();
        assertTrue(points.size() == count);
        this.logger.debug("Misses: " + misses);
        this.logger.debug(stopWatch.toString());
    }

    @Test
    public void insertRandomPoints() {
        StopWatch stopWatch = new StopWatch();
        int count = 10;
        int total = 0;
        List<String> misses = new ArrayList<String>();
        stopWatch.start();
        while (total < count) {
            String point = createRandomPointWKT();
            int objectId = this.simpleJdbcTemplate.queryForInt(this.searchSql, point, point);
            if (objectId != 0) {
                this.logger.debug("inserting: " + point);
                int inserted = this.simpleJdbcTemplate.update(this.insertSql, objectId, point);
                assertTrue(inserted == 1);
                total++;
            }
            else {
                misses.add(point);
            }
        }
        this.logger.debug("*********** Misses: " + misses.size() + "***************");
        stopWatch.stop();

        List<RandomPoint> points = this.simpleJdbcTemplate.query("SELECT id, continent_id, geom FROM random_points", new RandomPointMapper());
        assertTrue("points not size, instead: " + points.size(), points.size() == count);
        for (RandomPoint p : points) {
            this.logger.debug(p);
        }
        this.logger.debug(stopWatch.toString());
    }

    @Test
    public void createGoodPointWKT() {
        double lon = -153.3242;
        double lat = 43.32423242;
        String wkt = createPointWKT(lon, lat);
        this.logger.debug(wkt);
        assertTrue(wkt.contains("POINT("));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createBadPointWKT() {
        double lon = -180.3242;
        double lat = 43.32423242;
        String wkt = createPointWKT(lon, lat);
        fail("Should have thrown IllegalArgException on bad point");
    }

    protected String createPointWKT(Double longitude, Double latitude) {
        if (longitude < -180 || longitude > 180 || latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Long and Lat must be between +-(180,90)");
        }
        StringBuilder temp = new StringBuilder("POINT(");
        temp.append(String.valueOf(longitude)).append(" ").append(String.valueOf(latitude));
        temp.append(")");
        return temp.toString();
    }

    protected String createRandomPointWKT() {
        Double lon = RandomUtils.nextDouble() * 180;
        Double lat = RandomUtils.nextDouble() * 90;
        if (RandomUtils.nextBoolean()) {
            lon *= -1.0;
        }
        if (RandomUtils.nextBoolean()) {
            lat *= -1.0;
        }
        String point = createPointWKT(lon, lat);
        return point;
    }

    protected static class RandomPointMapper implements RowMapper<RandomPoint> {
        public RandomPoint mapRow(ResultSet rs, int rowNum) throws SQLException {
            RandomPoint randomPoint = new RandomPoint();
            randomPoint.setId(rs.getInt("ID"));
            randomPoint.setContinentId(rs.getInt("CONTINENT_ID"));
            STRUCT dbObj = (STRUCT) rs.getObject("GEOM");
            JGeometry sdoGeom = JGeometry.load(dbObj);
            randomPoint.setGeom(sdoGeom);
            return randomPoint;
        }
    }

}
