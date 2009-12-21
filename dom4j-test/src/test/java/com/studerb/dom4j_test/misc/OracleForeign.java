package com.studerb.dom4j_test.misc;

import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleConnection;
import oracle.jdbc.driver.OraclePreparedStatement;
import oracle.jdbc.pool.OracleDataSource;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Testing how oracle handles unicode in a default 10G install
 * @author studerw
 *
 *
 */
public class OracleForeign {

    private static final Logger log = Logger.getLogger(OracleForeign.class);
    private static OracleDataSource ods;
    private OracleConnection oracleConn;
    public static String ESCAPED  = "\u4f8b\u4fbe\u4fca\u4fd6\u4ff3\u504d\u507a\u517e\u5180\u51f4";

    //@BeforeClass
    public static void beforeClass() throws SQLException {
        //Class.forName("jdbc.driver.OracleDriver");
        ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:hr/hr@centos:1521/orcl");
    }

    //@Before
    public void setup() throws Exception {
        oracleConn = (OracleConnection) ods.getConnection();
        oracleConn.setAutoCommit(false);
    }

    //@After
    public void tearDown() throws Exception {
        if (!oracleConn.isClosed()) {
            oracleConn.commit();
            oracleConn.close();
        }
        oracleConn = null;

    }

    @Test
    public void dummyTest(){
        assertTrue(true);
    }

    //@Test
    public void listForeignTest() throws SQLException {
        String query = "SELECT FOREIGN_CHARS FROM TEST_FOREIGN";
        Statement s2 = oracleConn.createStatement();
        ResultSet rs = s2.executeQuery(query);
        while(rs.next()) {
            String foreignChars = rs.getNString(1);
            if (foreignChars.equals(ESCAPED)) {
                log.info("TITLE EQUALS"  + ESCAPED);
            }
            log.debug(rs.getNString("FOREIGN_CHARS"));
        }
        rs.close();
    }

    //@Test
    public void insertForeignText() throws SQLException {
        String insert = "INSERT INTO hr.TEST_FOREIGN VALUES(?))";
        OraclePreparedStatement ops = (OraclePreparedStatement)oracleConn.prepareStatement(insert);
        ops.setNString(1, ESCAPED);
        log.debug("Inserting ESCAPED: " + ESCAPED);
        int ret = ops.executeUpdate();
        ops.close();
    }

}
