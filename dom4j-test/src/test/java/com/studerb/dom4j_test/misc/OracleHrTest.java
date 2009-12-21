package com.studerb.dom4j_test.misc;

import static org.junit.Assert.assertTrue;

import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * making sure can connect to oracle
 * @author studerw
 *
 */
public class OracleHrTest {

    private static final Logger log = Logger.getLogger(OracleHrTest.class);
    private static OracleDataSource ods;
    private Connection conn;
    public static String ESCAPED  = "\u4f8b\u4fbe\u4fca\u4fd6\u4ff3\u504d\u507a\u517e\u5180\u51f4";

    //@BeforeClass
    public static void beforeClass() throws SQLException {
        //Class.forName("jdbc.driver.OracleDriver");
        ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:hr/hr@centos:1521/orcl");
    }

    //@Before
    public void setup() throws Exception {
        conn = ods.getConnection();
        conn.setAutoCommit(false);
    }

    //@After
    public void tearDown() throws Exception {
        if (!conn.isClosed()) {
            conn.commit();
            conn.close();
        }
        conn = null;

    }

    //@Test
    public void deleteJobs() throws SQLException {
        String query = "DELETE FROM hr.jobs where JOB_ID not like '%\\_%' escape '\\'";
        Statement s = conn.createStatement();
        int deleted = s.executeUpdate(query);
        log.debug("deleted: " + deleted + " jobs");
    }

    //@Test
    public void listJobs() throws SQLException {
        String query = "SELECT * FROM jobs";
        Statement s2 = conn.createStatement();
        ResultSet rs = s2.executeQuery(query);
        while(rs.next()) {
            String id = rs.getString(1);
            String title = rs.getString(2);
            Integer minSalary = rs.getInt(3);
            Integer maxSalary = rs.getInt(4);
            if (title.equals(ESCAPED)) {
                log.info("TITLE EQUALS"  + ESCAPED);

            }
            log.debug(id + "\t\t\t" + title + "\t\t\t" + minSalary + "\t\t\t" + maxSalary);
        }
    }

    //@Test
    public void insertJob() throws SQLException {
        String id = RandomStringUtils.randomAlphabetic(5);
        String title = RandomStringUtils.randomAlphabetic(20);
        int minSalary = RandomUtils.nextInt(50000);
        int maxSalary = RandomUtils.nextInt(50000) + minSalary;
        String insert = "INSERT INTO hr.jobs(JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY) VALUES(?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setString(1, id);
        ps.setString(2, ESCAPED);
        log.debug("Inserting id - ESCAPED: " + id + "  -  " + ESCAPED);
        ps.setInt(3, minSalary);
        ps.setInt(4, maxSalary);
        int ret = ps.executeUpdate();
    }

    @Test
    public void dummy() {
        assertTrue(true);
    }
}
