package com.saic.spatial;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration( { "classpath:spring/applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true, transactionManager = "batMSTxMgr")
public class BiometricsMicrosoftSpringTest extends AbstractTransactionalJUnit4SpringContextTests {
    final static Logger log = Logger.getLogger(BiometricsMicrosoftSpringTest.class);
    String insertSql;
    String searchSql;
    DataSource dataSource;
    Connection conn;

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

        assertNotNull(this.spatialDataSource);
        this.spatialJdbcTemplate = new SimpleJdbcTemplate(this.spatialDataSource);
    }

    @Override
    @Resource(name = "batMSDataSource")
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

    @Test
    public void getLocationXML() throws Exception {
        String sql = "SELECT TOP 1 LOCATIONXML FROM dbo.geolocations WHERE locationxml IS NOT NULL";
        String locationXml = this.simpleJdbcTemplate.queryForObject(sql, String.class);
        log.debug(locationXml);
        Document doc = DocumentHelper.parseText(locationXml);
        assertNotNull(doc);
    }

    @Test
    public void getLatLong() throws Exception {
        String sql = "SELECT TOP 1 locationxml FROM dbo.geolocations WHERE locationxml IS NOT NULL";
        String locationXml = this.simpleJdbcTemplate.queryForObject(sql, String.class);
        Document doc = DocumentHelper.parseText(locationXml);
        assertNotNull(doc);
        List nodes = doc.selectNodes("/xml/rs:data/rs:insert/z:row");
        Element row = (Element) nodes.get(0);
        List<Attribute> attributes = row.attributes();
        Double longitude = null;
        Double latitude = null;
        for (Attribute a : attributes) {
            if (a.getName().equalsIgnoreCase("longitude")) {
                longitude = Double.valueOf(a.getValue());
                assertNotNull(longitude);

            }
            if (a.getName().equalsIgnoreCase("latitude")) {
                latitude = Double.valueOf(a.getValue());
                assertNotNull(latitude);
            }
        }
        log.debug(longitude.toString() + "    " + latitude.toString());
    }

    @Test
    public void getLatLongAndReportGuid() throws Exception {
        String sql = "SELECT report_guid, locationxml FROM dbo.geolocations WHERE locationxml IS NOT NULL ORDER BY GUID";
        List<Map<String, Object>> rows = this.simpleJdbcTemplate.queryForList(sql);
        log.debug("Got " + rows.size() + " rows");
        for (Map<String, Object> m : rows) {
            String report_guid = (String) m.get("report_guid");
            assertNotNull(report_guid);
            String locationXml = (String) m.get("locationxml");
            assertNotNull(locationXml);
            Document doc = DocumentHelper.parseText(locationXml);
            assertNotNull(doc);
        }
    }

    @Rollback(value = false)
    @Test
    public void updateAllLatLong() throws Exception {
        String sql = "SELECT report_guid, locationxml FROM dbo.geolocations WHERE locationxml IS NOT NULL ORDER BY GUID";
        List<Map<String, Object>> rows = this.simpleJdbcTemplate.queryForList(sql);
        log.debug("Got " + rows.size() + " bat rows");
        List<RPoint> randomPoints = getRandomPoints();
        log.debug("Got " + randomPoints.size() + " random points");
        int cnt = 0;
        Iterator<RPoint> i = randomPoints.iterator();
        for (Map<String, Object> m : rows) {
            RPoint rp = i.next();
            String report_guid = (String) m.get("report_guid");
            assertNotNull(report_guid);
            String locationXml = (String) m.get("locationxml");
            assertNotNull(locationXml);
            Document doc = DocumentHelper.parseText(locationXml);
            assertNotNull(doc);
            List nodes = doc.selectNodes("/xml/rs:data/rs:insert/z:row");
            Element row = (Element) nodes.get(0);
            Attribute latitude = row.attribute("Latitude");
            Attribute longitude = row.attribute("Longitude");
            latitude.setValue(String.valueOf(rp.latitude));
            longitude.setValue(String.valueOf(rp.longitude));
            int updated = this.simpleJdbcTemplate.update("UPDATE dbo.geolocations set locationxml = ?, Country = ? WHERE report_guid = ?", doc.asXML(),
                    rp.cntryName, report_guid);
            assertTrue(updated == 1);
            cnt++;
            if (cnt % 100 == 0) {
                log.debug("Updated: " + cnt);
            }
        }

        log.debug("--------------------------------------------------------");
        sql = "SELECT report_guid, country, locationxml FROM dbo.geolocations WHERE locationxml IS NOT NULL ORDER BY GUID";
        rows = this.simpleJdbcTemplate.queryForList(sql);
        for (Map<String, Object> m : rows) {
            String locationXml = (String) m.get("locationxml");
            String country = (String) m.get("country");
            Document doc = DocumentHelper.parseText(locationXml);
            List nodes = doc.selectNodes("/xml/rs:data/rs:insert/z:row");
            Element row = (Element) nodes.get(0);
            Attribute latitude = row.attribute("Latitude");
            Attribute longitude = row.attribute("Longitude");
            log.debug(country + " : " + longitude.getValue() + "       " + latitude.getValue());
        }

    }

    @Test
    public void getRPoints() {
        List<RPoint> points = getRandomPoints();
        assertTrue(points.size() == 3000);
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
