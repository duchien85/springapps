//package com.saic.spatial;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
//
//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import oracle.jdbc.pool.OracleDataSource;
//import oracle.spatial.geometry.JGeometry;
//import oracle.spatial.util.GeometryExceptionWithContext;
//import oracle.spatial.util.WKT;
//import oracle.sql.STRUCT;
//
//import org.apache.log4j.Logger;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//public class OracleSpatialTest {
//    final static Logger log = Logger.getLogger(OracleSpatialTest.class);
//    final static String URL = "jdbc:oracle:thin:@centos2:1521:orcl2";
//    final static String USER = "spatial";
//    final static String PASS = "spatial";
//    OracleDataSource ds;
//    Connection conn;
//    Statement statement;
//    ResultSet resultSet;
//
//    @Before
//    public void setup() throws SQLException {
//        this.ds = new OracleDataSource();
//        this.ds.setURL(URL);
//        this.ds.setUser(USER);
//        this.ds.setPassword(PASS);
//        this.conn = this.ds.getConnection();
//    }
//
//    @After
//    public void teardown() {
//        try {
//            if (this.resultSet != null) {
//                this.resultSet.close();
//                this.resultSet = null;
//            }
//            if (this.statement != null) {
//                this.statement.close();
//                this.statement = null;
//            }
//            if (this.conn != null) {
//                this.conn.close();
//                this.conn = null;
//            }
//            this.conn = null;
//            if (this.ds != null) {
//                this.ds.close();
//                this.ds = null;
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//        }
//
//    }
//
//    @Test
//    public void connect() throws SQLException {
//        assertNotNull("Conn should not be null", this.conn);
//    }
//
//    @Test(expected = SQLException.class)
//    public void badConnect() throws SQLException {
//        OracleDataSource ds = new OracleDataSource();
//        ds.setURL(URL);
//        ds.setUser(USER);
//        ds.setPassword("BADAFDAFAFf");
//        Connection conn = ds.getConnection();
//        fail("Should have not connected");
//    }
//
//    @Test
//    public void getVersion() throws SQLException {
//        DatabaseMetaData meta = this.conn.getMetaData();
//        log.debug("Version: " + meta.getJDBCMajorVersion() + " " + meta.getJDBCMinorVersion());
//    }
//
//    @Test
//    public void getGeometryRow() throws SQLException {
//        this.statement = this.conn.createStatement();
//        this.resultSet = this.statement.executeQuery("SELECT * FROM geometry_examples");
//        while (this.resultSet.next()) {
//            String name = this.resultSet.getString(1);
//            String desc = this.resultSet.getString(2);
//            assertTrue(!name.isEmpty());
//            assertTrue(!desc.isEmpty());
//            log.debug("name: " + name);
//            log.debug("description: " + desc);
//        }
//    }
//
//    @Test
//    public void readGeometries() throws SQLException {
//        this.statement = this.conn.createStatement();
//        this.resultSet = this.statement.executeQuery("SELECT shape FROM geometry_examples");
//        while (this.resultSet.next()) {
//            STRUCT dbObj = (STRUCT) this.resultSet.getObject(1);
//            assertNotNull(dbObj);
//            JGeometry sdoGeom = JGeometry.load(dbObj);
//            log.debug(sdoGeom.toStringFull());
//            assertTrue(sdoGeom.getDimensions() == 2);
//        }
//    }
//
//    @Test
//    public void createFromWKT() throws GeometryExceptionWithContext {
//        String poly = "MULTIPOLYGON(((-4.130859375 54.73388671875,0.439453125 54.82177734375,1.142578125 50.38330078125,-4.3505859375 50.51513671875,-4.4384765625 50.64697265625,-4.130859375 54.73388671875)))";
//        WKT wkt = new WKT();
//        JGeometry jGeom = wkt.toJGeometry(poly.getBytes());
//        jGeom.setSRID(8307);
//        log.debug(jGeom.toStringFull());
//        assertTrue(jGeom.getDimensions() == 2);
//    }
//
//    @Test
//    public void getLondon() throws SQLException, GeometryExceptionWithContext {
//        String britainPoly = "MULTIPOLYGON(((-4.130859375 54.73388671875,0.439453125 54.82177734375,1.142578125 50.38330078125,-4.3505859375 50.51513671875,-4.4384765625 50.64697265625,-4.130859375 54.73388671875)))";
//        WKT wkt = new WKT();
//        JGeometry jGeom = wkt.toJGeometry(britainPoly.getBytes());
//        jGeom.setSRID(8307);
//        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM geometry_examples ge WHERE SDO_ANYINTERACT(ge.shape, SDO_GEOMETRY(?, 8307)) = 'TRUE'");
//        ps.setString(1, britainPoly);
//        this.resultSet = ps.executeQuery();
//        assertTrue(this.resultSet.next());
//        String name = this.resultSet.getString(1);
//        assertEquals("Name should be london: " + name, "london", name);
//        log.debug("Name: " + name);
//
//        STRUCT dbObj = (STRUCT) this.resultSet.getObject(3);
//        JGeometry shape = JGeometry.load(dbObj);
//        String pointString = new String(wkt.fromJGeometry(shape));
//        log.debug(pointString);
//        assertTrue("wkt should contain 'POINT'", pointString.contains("POINT"));
//
//        ps.close();
//    }
// }
