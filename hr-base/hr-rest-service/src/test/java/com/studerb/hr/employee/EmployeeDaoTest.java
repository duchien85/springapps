package com.studerb.hr.employee;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
@TransactionConfiguration(defaultRollback = false)
public class EmployeeDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    SessionFactory sessionFactory;

    static final int TOTAL_COUNT = 107;

    @Before
    public void setUp() throws Exception {
        this.simpleJdbcTemplate.update("call reset_hr_dev()", new Object[] {});
    }

    @Test
    public void countRows() {
        assertEquals(countRowsInTable(this.employeeDao.getTableName()), TOTAL_COUNT);
    }

    @Test
    public void getAll() {
        List<Employee> employees = this.employeeDao.getAll();
        assertEquals(employees.size(), TOTAL_COUNT);
    }

    @Test
    public void getOne() {
        Employee employee = this.employeeDao.get(189L);
        assertNotNull(employee);
        assertEquals(employee.getFirstName(), "Jennifer");
        assertEquals(employee.getLastName(), "Dilly");
        assertEquals(employee.getEmail(), "JDILLY");
        assertEquals(employee.getHireDate(), new DateTime(1997, 8, 13, 0, 0, 0, 0, DateTimeZone.forID("America/New_York")));
    }

    @Test
    public void deleteOne() {
        this.employeeDao.delete(101L);
    }

    @Test
    public void addEmployee() {
        // Employee employee = new Employee();
        // employee.setEmail("me@here.com");
        // employee.setFirstName("Mick");
        // employee.setLastName("Smith");
        assertTrue(true);
    }
}
