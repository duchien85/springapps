package com.saic.spatial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DimsfMicrosoftTest {

    final static Logger log = Logger.getLogger(DimsfMicrosoftTest.class);
    final static String URL = "jdbc:sqlserver://192.168.9.12:1433/databaseName=DIMSFusionDatabaseTestData;user=sa;password=sa";

    final static String USER = "sa";
    final static String PASS = "sa";
    SQLServerDataSource ds;
    Connection conn;
    Statement statement;
    ResultSet resultSet;

    @Before
    public void setup() throws SQLException {
        this.ds = new SQLServerDataSource();
        this.ds.setServerName("192.168.9.12");
        this.ds.setDatabaseName("DIMSFusionDatabaseTestData");
        this.ds.setUser(USER);
        this.ds.setPassword(PASS);
        this.conn = this.ds.getConnection();
    }

    @After
    public void teardown() {
        try {
            if (this.resultSet != null) {
                this.resultSet.close();
                this.resultSet = null;
            }
            if (this.statement != null) {
                this.statement.close();
                this.statement = null;
            }
            if (this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
            this.conn = null;
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

    }

    @Test
    public void connect() throws SQLException {
        assertNotNull("Conn should not be null", this.conn);
    }

    @Test(expected = SQLException.class)
    public void badConnect() throws SQLException {
        this.ds.setUser(USER);
        this.ds.setPassword("BADAFDAFAFf");
        Connection conn = this.ds.getConnection();
        fail("Should have not connected");
    }

    @Test
    public void getVersion() throws SQLException {
        DatabaseMetaData meta = this.conn.getMetaData();
        log.debug("Version: " + meta.getJDBCMajorVersion() + " " + meta.getJDBCMinorVersion());
    }

    @Test
    public void getLocationXML() throws Exception {
        String sql = "SELECT TOP 1 LOCATIONXML FROM dbo.geolocations WHERE locationxml IS NOT NULL";
        this.statement = this.conn.createStatement();
        this.resultSet = this.statement.executeQuery(sql);
        assertTrue(this.resultSet.next());
        Clob clob = this.resultSet.getClob(1);
        String locationXml = IOUtils.toString(clob.getCharacterStream());
        log.debug(locationXml);
        Document doc = DocumentHelper.parseText(locationXml);
        assertNotNull(doc);
    }

    @Test
    public void getLatLong() throws Exception {
        String sql = "SELECT TOP 1 LOCATIONXML FROM dbo.geolocations WHERE locationxml IS NOT NULL";
        this.statement = this.conn.createStatement();
        this.resultSet = this.statement.executeQuery(sql);
        assertTrue(this.resultSet.next());
        String locationXml = this.resultSet.getString(1);
        log.debug(locationXml);
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
            }
            if (a.getName().equalsIgnoreCase("latitude")) {
                latitude = Double.valueOf(a.getValue());
            }
        }
        assertNotNull(longitude);
        log.debug("Long: " + longitude.toString());
        assertNotNull(latitude);
        log.debug("Lat: " + latitude.toString());
    }

    @Test
    public void updateLatLongDom4j() throws Exception {
        String sql = "SELECT  TOP 1 locationxml FROM dbo.geolocations WHERE locationxml IS NOT NULL ORDER BY GUID";
        this.statement = this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        this.resultSet = this.statement.executeQuery(sql);
        assertTrue(this.resultSet.next());
        String locationXml = this.resultSet.getString(1);
        log.debug(locationXml);
        Document doc = DocumentHelper.parseText(locationXml);
        assertNotNull(doc);
        List nodes = doc.selectNodes("/xml/rs:data/rs:insert/z:row");
        Element row = (Element) nodes.get(0);
        Attribute latitude = row.attribute("Latitude");
        latitude.setValue("0");
        Attribute longitude = row.attribute("Longitude");
        longitude.setValue("0");
        log.debug(doc.asXML());
        this.resultSet.updateString(1, doc.asXML());
        this.resultSet.updateRow();
        this.statement.close();
        this.resultSet.close();

        this.statement = this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        this.resultSet = this.statement.executeQuery(sql);
        assertTrue(this.resultSet.next());
        locationXml = this.resultSet.getString(1);
        log.debug(locationXml);
        doc = DocumentHelper.parseText(locationXml);
        assertNotNull(doc);
        nodes = doc.selectNodes("/xml/rs:data/rs:insert/z:row");
        row = (Element) nodes.get(0);
        assertEquals(row.attribute("Latitude").getValue(), "0");
        assertEquals(row.attribute("Longitude").getValue(), "0");

    }

    @Test
    public void updateLatLongReplaceStr() throws Exception {
        String sql = "SELECT  TOP 1 locationxml FROM dbo.geolocations WHERE locationxml IS NOT NULL ORDER BY GUID";
        this.statement = this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        this.resultSet = this.statement.executeQuery(sql);
        assertTrue(this.resultSet.next());
        String locationXml = this.resultSet.getString(1);
        log.debug(locationXml);
        // Pattern pattern = Pattern.compile("Longitude=\"(\\d+\.\\n)
        // this.resultSet.updateString(1, doc.asXML());
        this.resultSet.updateRow();
        this.statement.close();
        this.resultSet.close();

        this.statement = this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        this.resultSet = this.statement.executeQuery(sql);
        assertTrue(this.resultSet.next());
        locationXml = this.resultSet.getString(1);
        log.debug(locationXml);
    }

    public static void treeWalk(Document document) {
        treeWalk(document.getRootElement());
    }

    public static void treeWalk(Element element) {
        log.debug(element.getPath());
        for (int i = 0, size = element.nodeCount(); i < size; i++) {
            Node node = element.node(i);
            if (node instanceof Element) {
                treeWalk((Element) node);
            }
            else {
                log.debug(node.getPath());
            }
        }
    }
}
