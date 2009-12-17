package com.studerb.staff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class StaffDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private StaffDao staffDao;
    String resource = "classpath:db/test-staffData.sql";

    @Before
    public void setUp() throws Exception {
        executeSqlScript(resource, false);
        assertTrue(countRowsInTable(staffDao.getTableName()) == 7);
    }

    @After
    public void tearDown() throws Exception {
    // no op;
    }

    @Test
    public void getAll() {
        List<Staff> staff = staffDao.getAll();
        assertEquals(staff.size(), 7);
    }

    @Test
    public void findByGoodUsername() {
        String good = "userguy1";
        Staff goodStaff = staffDao.findByUsername(good);
        assertEquals(goodStaff.getId(), new Long(1L));
    }

    @Test
    public void findByGoodUsernameCase() {
        String good = "USERgUy1";
        Staff goodStaff = staffDao.findByUsername(good);
        assertEquals(goodStaff.getId(), new Long(1L));
    }

    @Test
    public void findByBadUsername() {
        String bad = "not_exist";
        Staff badStaff = staffDao.findByUsername(bad);
        assertNull(badStaff);
    }

}
