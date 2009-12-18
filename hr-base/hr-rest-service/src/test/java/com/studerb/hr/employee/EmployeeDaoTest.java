package com.studerb.hr.employee;

import static org.junit.Assert.assertTrue;

import java.util.List;

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

    // private final String path = SystemUtils.USER_DIR +
    // SystemUtils.FILE_SEPARATOR + "db" + SystemUtils.FILE_SEPARATOR;
    // String resource = "file:" + path + "test-employeeData.sql";

    @Before
    public void setUp() throws Exception {
        this.logger.debug("*************************************************************SETTING UP*****************************************");
    }

    @Test
    @NotTransactional
    public void testCreated() {
        this.logger.debug("****************CREATED***************");
        assertTrue(true);
    }

    @Test
    public void getAll() {
        // Employee employee = new Employee();
        // employee.setEmail("me@here.com");
        // employee.setFirstName("Mick");
        // employee.setLastName("Smith");

        int initialCount = countRowsInTable(this.employeeDao.getTableName());
        this.logger.debug("LOGGING*********************************************");
        List<Employee> employees = this.employeeDao.getAll();
        for (Employee e : employees) {
            this.logger.debug(e);
        }
    }
}
