package com.saic.spatial;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.bbn.openmap.LatLonPoint;
import com.bbn.openmap.proj.coords.MGRSPoint;

@ContextConfiguration( { "classpath:spring/applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true, transactionManager = "dimsfMSTxMgr")
public class DimsfMicrosoftSpringTest extends AbstractTransactionalJUnit4SpringContextTests {
    final static Logger log = Logger.getLogger(DimsfMicrosoftSpringTest.class);
    String insertSql;
    String searchSql;
    DataSource dataSource;
    Connection conn;
    String insertGeoLocationSql;
    String insertCoordinateSql;
    String updateGeoLocationSql;

    SimpleJdbcTemplate spatialJdbcTemplate;

    @Resource(name = "spatialDataSource")
    DataSource spatialDataSource;

    @PostConstruct
    public void postConstruct() {
        StringBuilder bldr = new StringBuilder("SELECT ID FROM world_countries wc ");
        bldr.append("WHERE SDO_ANYINTERACT(wc.GEOM, SDO_GEOMETRY(?, 8307)) = 'TRUE' ");
        bldr.append("UNION ALL ");
        bldr.append("SELECT 0 FROM DUAL WHERE NOT EXISTS ");
        bldr.append("(SELECT ID FROM world_countries wc ");
        bldr.append("WHERE SDO_ANYINTERACT(wc.GEOM, SDO_GEOMETRY(?, 8307)) = 'TRUE')");
        this.searchSql = bldr.toString();

        this.insertSql = "INSERT INTO random_points_countries(id, country_id, geom) VALUES(?, ?, SDO_GEOMETRY(?, 8307))";
        this.insertGeoLocationSql = "insert into dbo.PER_Locations(LocationGUID, GUID2, Country, DateCreated, LastModified) VALUES(:locationGuid, :mgrs, :country, GETDATE(), GETDATE())";
        this.insertCoordinateSql = "insert into dbo.Per_Coordinates(CoordinateGUID, MGRS, DateCreated, LastModified) VALUES(NEWID(), ?, NOW(), NOW())";
        this.updateGeoLocationSql = "update BiometricsDatabaseSQL.dbo.GeoLocations set Country = :country, locationXml = :locationXml where REPORT_GUID = :reportGuid";
        assertNotNull(this.spatialDataSource);
        this.spatialJdbcTemplate = new SimpleJdbcTemplate(this.spatialDataSource);
    }

    @Override
    @Resource(name = "dimsfMSDataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

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

    @Rollback(value = false)
    @Test
    public void insertCoordinates() {
        List<RPoint> randomPoints = getRandomPoints();
        List<String> captureGuids = getCaptureGuids();
        assertTrue(captureGuids.size() < randomPoints.size());
        for (int i = 0; i < captureGuids.size(); ++i) {
            // lets leave a few just blank - no coordinates
            if (RandomUtils.nextInt() % 10 == 0) {
                log.debug("Skipping guid: " + captureGuids.get(i));
                continue;
            }
            MapSqlParameterSource locationArgs = new MapSqlParameterSource();
            String locationGuid = StringUtils.upperCase(UUID.randomUUID().toString());
            RPoint point = randomPoints.get(i);
            // RPoint point = getValidMGRS(randomPoints);
            locationArgs.addValue("locationGuid", locationGuid);
            locationArgs.addValue("guid2", captureGuids.get(i));
            locationArgs.addValue("country", point.cntryName);
            String insertLocationSql = "insert into dbo.PER_Locations(LocationGUID, GUID2, Country, DateCreated, LastModified) VALUES(:locationGuid, :guid2, :country, GETDATE(), GETDATE())";
            int x = this.simpleJdbcTemplate.update(insertLocationSql, locationArgs);
            assertTrue(x == 1);

            MapSqlParameterSource coordinateArgs = new MapSqlParameterSource();
            String insertCoordSql = "insert into dbo.Per_Coordinates(CoordinateGUID, LocationGuid, MGRS, DateCreated, LastModified) VALUES(NEWID(), :locationGuid, :mgrs, GETDATE(), GETDATE())";
            coordinateArgs.addValue("locationGuid", locationGuid);
            String mgrs = latLongToMGRS(point.longitude.floatValue(), point.latitude.floatValue());
            log.debug("Lat/long: " + point.latitude.floatValue() + "/" + point.longitude.floatValue() + mgrs);
            coordinateArgs.addValue("mgrs", mgrs);
            int y = this.simpleJdbcTemplate.update(insertCoordSql, coordinateArgs);
            assertTrue(y == 1);
        }
    }

    protected List<String> getCaptureGuids() {
        String sql = "SELECT CaptureGUID from dbo.PER_CapturePacketReportData";
        List<Map<String, Object>> guidMapList = this.simpleJdbcTemplate.queryForList(sql);
        List<String> guids = new ArrayList<String>();
        for (int i = 0; i < guidMapList.size(); ++i) {
            Map<String, Object> map = guidMapList.get(i);
            String guid = (String) map.get("CaptureGuid");
            assertFalse(StringUtils.isBlank(guid));
            guids.add(guid);
        }

        log.debug("Got count of: " + guids.size());
        assertTrue(guids.size() == 110);
        log.debug(guids);
        return guids;

    }

    public static RPoint getValidMGRS(List<RPoint> points) {
        while (true) {
            RPoint rpoint = points.get(RandomUtils.nextInt(points.size()));
            LatLonPoint point = new LatLonPoint(rpoint.latitude, rpoint.longitude);
            MGRSPoint mgrs = new MGRSPoint(point);
            String mgrsStr = mgrs.getMGRS();
            if (!mgrsStr.contains("limit exceeded")) {
                return rpoint;
            }
        }
    }

    public static String latLongToMGRS(float longitude, float latitude) {
        float latF = LatLonPoint.normalize_latitude(latitude);
        LatLonPoint point = new LatLonPoint(latF, longitude);
        MGRSPoint mgrs = new MGRSPoint(point);
        String mgrsStr = mgrs.getMGRS();
        return mgrsStr;
    }

    @Test
    public void printRPoints() throws IOException {
        File f = new File("random_country_points.csv");
        FileWriter writer = new FileWriter(f);
        List<RPoint> points = getRandomPoints();
        assertTrue(points.size() == 3000);
        for (RPoint rp : points) {
            if (rp.cntryName.contains("\t")) {
                throw new RuntimeException("NO COMMAS ALLOWED IN: " + rp.cntryName);
            }
            String s = rp.cntryName + "\t" + String.valueOf(rp.longitude) + "\t" + String.valueOf(rp.latitude) + SystemUtils.LINE_SEPARATOR;
            writer.write(s);
        }

        IOUtils.closeQuietly(writer);
    }

    protected List<RPoint> getRandomPoints() {
        String sql = "SELECT wc.cntry_name, rpc.geom FROM random_points_countries rpc, world_countries wc WHERE rpc.country_id = wc.id";
        List<RPoint> points = this.spatialJdbcTemplate.query(sql, new RPointMapper());
        return points;
    }

    protected static class RPointMapper implements RowMapper<RPoint> {
        @Override
        public RPoint mapRow(ResultSet rs, int rowNum) throws SQLException {
            RPoint rp = new RPoint();
            rp.cntryName = rs.getString(1);
            STRUCT dbObj = (STRUCT) rs.getObject("GEOM");
            rp.geom = JGeometry.load(dbObj);
            double[] point = rp.geom.getFirstPoint();
            rp.longitude = point[0];
            rp.latitude = point[1];
            return rp;
        }

    }

    protected static class RPoint {
        public JGeometry geom;
        public String cntryName;
        public Double longitude;
        public Double latitude;
    }

    @Test
    public void getPointsFromFile() throws IOException {
        List<RPoint> points = new ArrayList<RPoint>();
        File f = this.applicationContext.getResource("classpath:/random_country_points.txt").getFile();
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] three = line.split("\t");
            assertTrue(three.length == 3);
            RPoint r = new RPoint();
            r.cntryName = three[0];
            r.longitude = Double.parseDouble(three[1]);
            r.latitude = Double.parseDouble(three[2]);
            points.add(r);
            log.debug(r.cntryName + "\t" + String.valueOf(r.longitude) + "\t" + String.valueOf(r.latitude));
        }

        assertTrue(points.size() == 3000);
    }
}
