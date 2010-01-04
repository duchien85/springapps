package com.studerb.hr.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.studerb.hr.model.Employee;
import com.studerb.hr.service.EmployeeService;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
@TransactionConfiguration(defaultRollback = false)
public class DefaultEmployeeServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    EmployeeService employeeService;

    static final int TOTAL_COUNT = 107;

    @Before
    public void setUp() throws Exception {
        this.simpleJdbcTemplate.update("call reset_hr_dev()", new Object[] {});
    }

    @Test
    public void getAll() {
        List<Employee> employees = this.employeeService.getAllEmployees();
        assertEquals(employees.size(), TOTAL_COUNT);
    }

    @Test
    public void getForeignIds() {
        Employee e = this.employeeService.getEmployee(189L);
        this.logger.debug("department class: " + e.getDepartment().getClass().getName());
        this.logger.debug("manager class: " + e.getManager().getClass().getName());
        this.logger.debug("job class: " + e.getJob().getClass().getName());
        assertEquals(e.getDepartment().getId(), new Long(50L));
        assertEquals(e.getManager().getId(), new Long(122L));
        assertEquals(e.getJob().getId(), "SH_CLERK");
        this.logger.debug("====================== GETTING NON-ID Foreign Relationships ===========================");
        assertEquals(e.getDepartment().getName(), "Shipping");
        assertEquals(e.getJob().getTitle(), "Shipping Clerk");
        assertEquals(e.getManager().getLastName(), "Kaufling");
    }
}
