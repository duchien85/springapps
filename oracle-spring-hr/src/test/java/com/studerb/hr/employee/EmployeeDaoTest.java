package com.studerb.hr.employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.SystemUtils;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.NotTransactional;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class EmployeeDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    SessionFactory sessionFactory;

    private final String path = SystemUtils.USER_DIR + SystemUtils.FILE_SEPARATOR + "db" + SystemUtils.FILE_SEPARATOR;
    String resource = "file:" + path + "test-employeeData.sql";

    @Before
    public void setUp() throws Exception {
        logger.debug("*************************************************************SETTING UP*****************************************");
    }

    @Test
    @NotTransactional
    public void testCreated() {
        logger.debug("****************CREATED***************");
        assertTrue(true);
    }

    public void AddEmployee() {
        Employee employee = new Employee();
        employee.setEmail("me@here.com");
        employee.setFirstName("Mick");
        employee.setLastName("Smith");

        int initialCount = countRowsInTable(employeeDao.getTableName());
        employeeDao.save(employee);
        employeeDao.flush();
        employeeDao.clear();
        logger.debug("LOGGING*********************************************");
        assertNotNull(employee.getId());
        assertEquals(initialCount + 1, countRowsInTable(employeeDao.getTableName()));
    }
}
