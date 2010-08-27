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
import java.util.Arrays;
import java.util.Iterator;
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
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
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

@ContextConfiguration( { "classpath:spring/applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true, transactionManager = "batMSTxMgr")
public class BiometricsMicrosoftSpringTest extends AbstractTransactionalJUnit4SpringContextTests {
    final static Logger log = Logger.getLogger(BiometricsMicrosoftSpringTest.class);
    String insertSql;
    String searchSql;
    DataSource dataSource;
    Connection conn;
    String insertGeoLocationSql;
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
        this.insertGeoLocationSql = "insert into BiometricsDatabaseSQL.dbo.GeoLocations (REPORT_GUID, GUID, Feature_Type, Country, LocationXML) VALUES(:report_guid, :guid, 'CAPTURELOC', :country, :locationXml)";
        this.updateGeoLocationSql = "update BiometricsDatabaseSQL.dbo.GeoLocations set Country = :country, locationXml = :locationXml where REPORT_GUID = :reportGuid";
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

    /**
     * This grabs all persons and adds a random geolocation to the geolocation
     * table
     */
    @Rollback(value = true)
    @Test
    public void createRandomGeolocations() {
        String template = getLocationXmlTemplate();
        String sql = "SELECT report_guid FROM dbo.geolocations ORDER BY report_guid asc";
        List<Map<String, Object>> guidMapList = this.simpleJdbcTemplate.queryForList(sql);
        List<RPoint> points = getRandomPoints();
        ArrayList<MapSqlParameterSource> argsList = new ArrayList<MapSqlParameterSource>();
        log.debug(String.format("Adding geolocations for %d persons", guidMapList.size()));
        for (int i = 0; i < guidMapList.size(); ++i) {
            Map<String, Object> map = guidMapList.get(i);
            String guid = (String) map.get("guid");
            assertFalse(StringUtils.isBlank(guid));
            String locationXml = template.replace("${GUID}", guid);
            String reportGuid = StringUtils.upperCase(UUID.randomUUID().toString());
            locationXml = locationXml.replace("${REPORT_GUID}", reportGuid);
            RPoint rpoint = points.get(RandomUtils.nextInt(points.size()));
            locationXml = locationXml.replace("${LATITUDE}", String.valueOf(rpoint.latitude));
            locationXml = locationXml.replace("${LONGITUDE}", String.valueOf(rpoint.longitude));
            // :report_guid, :guid, 'CAPTURELOC', :country, :locationXml)";
            MapSqlParameterSource args = new MapSqlParameterSource();
            args.addValue("report_guid", reportGuid);
            args.addValue("guid", guid);
            args.addValue("country", rpoint.cntryName);
            args.addValue("locationXml", locationXml);
            argsList.add(args);
            if (((i % 100) == 0) || ((i + 1) == guidMapList.size())) {
                MapSqlParameterSource[] argsArray = argsList.toArray(new MapSqlParameterSource[0]);
                log.debug(String.format("Updating user: %s at number: %d", guid, i));
                log.debug("************************** INSERT ******************************");
                int[] returnArray = this.simpleJdbcTemplate.batchUpdate(this.insertGeoLocationSql, argsArray);
                log.debug(returnArray);
                argsList.clear();
            }
        }
    }

    /**
     * This updates the the geocoordinates table for those rows that have no
     * valid location xml fields with a new random country and locationXml
     */
    @Rollback(value = false)
    @Test
    public void updateWithNewRandomLocationXml() {
        String template = getLocationXmlTemplate();
        String sql = "SELECT report_guid, guid FROM dbo.geolocations ORDER BY report_guid asc";
        List<Map<String, Object>> guidMapList = this.simpleJdbcTemplate.queryForList(sql);
        List<RPoint> points = getRandomPoints();
        ArrayList<MapSqlParameterSource> argsList = new ArrayList<MapSqlParameterSource>();
        log.debug(String.format("Adding geolocations for %d persons", guidMapList.size()));
        for (int i = 0; i < guidMapList.size(); ++i) {
            Map<String, Object> map = guidMapList.get(i);
            String reportGuid = (String) map.get("report_guid");
            assertFalse(StringUtils.isBlank(reportGuid));
            String guid = (String) map.get("guid");
            assertFalse(StringUtils.isBlank(guid));
            String locationXml = template.replace("${GUID}", guid);
            locationXml = locationXml.replace("${REPORT_GUID}", reportGuid);
            RPoint rpoint = points.get(RandomUtils.nextInt(points.size()));
            locationXml = locationXml.replace("${LATITUDE}", String.valueOf(rpoint.latitude));
            locationXml = locationXml.replace("${LONGITUDE}", String.valueOf(rpoint.longitude));
            // "update BiometricsDatabaseSQL.dbo.GeoLocations set Country = :country, locationXml = :locationXml where REPORT_GUID = :reportGuid";
            MapSqlParameterSource args = new MapSqlParameterSource();
            args.addValue("reportGuid", reportGuid);
            args.addValue("country", rpoint.cntryName);
            args.addValue("locationXml", locationXml);
            argsList.add(args);
            if (((i % 1000) == 0) || ((i + 1) == guidMapList.size())) {
                MapSqlParameterSource[] argsArray = argsList.toArray(new MapSqlParameterSource[0]);
                log.debug(String.format("Updating user: %s at number: %d", guid, i));
                int[] returnArray = this.simpleJdbcTemplate.batchUpdate(this.updateGeoLocationSql, argsArray);
                log.debug(Arrays.toString(returnArray));
                argsList.clear();
            }
        }
    }

    /**
     * 
     * Grabs the lat and long from all the non-null locationxml columns in the
     * GEOLOCATIONS table
     * 
     * @throws Exception
     * 
     */
    @Test
    public void getAllLatLong() throws Exception {
        String sql = "SELECT top 1000 locationxml FROM dbo.geolocations";
        List<Map<String, Object>> mapList = this.simpleJdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : mapList) {
            String locationXml = (String) map.get("locationxml");
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
            log.debug(String.format("%f, %f", longitude, latitude));
        }
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

    @Rollback(value = true)
    @Test
    public void updateAllLatLong() throws Exception {
        String sql = "SELECT report_guid, locationxml FROM dbo.geolocations";
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

    private String getLocationXmlTemplate() {
        StringBuilder locationXml = new StringBuilder("<xml xmlns:s='uuid:BDC6E3F0-6DA3-11d1-A2A3-00AA00C14882'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("xmlns:dt='uuid:C2F41010-65B3-11d1-A29F-00AA00C14882'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("xmlns:rs='urn:schemas-microsoft-com:rowset'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("xmlns:z='#RowsetSchema'>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:Schema id='RowsetSchema'>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:ElementType name='row' content='eltOnly' rs:updatable='true'>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:AttributeType name='GUID' rs:number='1' rs:write='true'>");
        locationXml.append("<s:datatype dt:type='string' dt:maxLength='4294967295'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:precision='0' rs:long='true' rs:maybenull='false'/>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</s:AttributeType>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:AttributeType name='REPORT_GUID' rs:number='2' rs:write='true'>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:datatype dt:type='string' dt:maxLength='4294967295'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:precision='0' rs:long='true' rs:maybenull='false'/>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</s:AttributeType>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:AttributeType name='ToolVersion' rs:number='3' rs:nullable='true'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:write='true'>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:datatype dt:type='string' dt:maxLength='4294967295'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:precision='0' rs:long='true' rs:maybenull='false'/>");
        locationXml.append("</s:AttributeType>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:AttributeType name='EntityType' rs:number='4' rs:nullable='true'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:write='true'>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:datatype dt:type='string' dt:maxLength='4294967295'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:precision='0' rs:long='true' rs:maybenull='false'/>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</s:AttributeType>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:AttributeType name='FeatureType' rs:number='5' rs:nullable='true'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:write='true'>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:datatype dt:type='string' dt:maxLength='4294967295'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:precision='0' rs:long='true' rs:maybenull='false'/>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</s:AttributeType>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:AttributeType name='GeoType' rs:number='6' rs:nullable='true'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:write='true'>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:datatype dt:type='int' dt:maxLength='4' rs:precision='0'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:fixedlength='true' rs:maybenull='false'/>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</s:AttributeType>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:AttributeType name='Latitude' rs:number='7' rs:nullable='true'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:write='true'>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:datatype dt:type='float' dt:maxLength='8' rs:precision='0'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:fixedlength='true' rs:maybenull='false'/>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</s:AttributeType>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:AttributeType name='Longitude' rs:number='8' rs:nullable='true'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:write='true'>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:datatype dt:type='float' dt:maxLength='8' rs:precision='0'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:fixedlength='true' rs:maybenull='false'/>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</s:AttributeType>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:AttributeType name='DATECREATED' rs:number='9' rs:nullable='true'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:write='true'>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:datatype dt:type='string' dt:maxLength='4294967295'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:precision='0' rs:long='true' rs:maybenull='false'/>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</s:AttributeType>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:AttributeType name='LASTMODIFIED' rs:number='10'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:nullable='true' rs:write='true'>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:datatype dt:type='string' dt:maxLength='4294967295'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("rs:precision='0' rs:long='true' rs:maybenull='false'/>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</s:AttributeType>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<s:extends type='rs:rowbase'/>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</s:ElementType>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</s:Schema>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<rs:data>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<rs:insert>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("<z:row GUID='{${GUID}}'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("REPORT_GUID='{${REPORT_GUID}}' ToolVersion='1.0'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("EntityType='Person' FeatureType='ADR_LOC' GeoType='0'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("Latitude='${LATITUDE}' Longitude='${LONGITUDE}'").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("DATECREATED='3/19/2010 7:52:43 AM' LASTMODIFIED='3/19/2010 7:52:43 AM'/>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</rs:insert>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</rs:data>").append(SystemUtils.LINE_SEPARATOR);
        locationXml.append("</xml>").append(SystemUtils.LINE_SEPARATOR);

        return locationXml.toString();
    }
}
