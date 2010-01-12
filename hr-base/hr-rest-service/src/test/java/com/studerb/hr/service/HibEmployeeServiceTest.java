package com.studerb.hr.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.StopWatch;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.studerb.hr.TestUtil;
import com.studerb.hr.model.Employee;
import com.studerb.hr.model.ModelUtils;

@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
@TransactionConfiguration(defaultRollback = true)
public class HibEmployeeServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
    final static StopWatch stopWatch = new StopWatch();
    boolean reset = false;

    @Resource(name = "hibEmployeeService")
    EmployeeService employeeService;

    @BeforeClass
    public static void beforeClass() {
        stopWatch.start();
    }

    @AfterClass
    public static void afterClass() {
        stopWatch.stop();
        System.err.println("Time of test class: " + stopWatch.toString());
    }

    @Before
    public void setUp() throws Exception {
        if (!reset) {
            simpleJdbcTemplate.update("call reset_hr_dev()", new Object[] {});
            reset = true;
        }
    }

    @Test
    public void getAll() {
        List<Employee> employees = employeeService.getAllEmployees();
        assertEquals(employees.size(), TestUtil.EMPLOYEE_COUNT);
    }

    @Test
    public void getForeignIds() {
        Employee e = employeeService.getEmployee(189L);
        logger.debug("department class: " + e.getDepartment().getClass().getName());
        logger.debug("manager class: " + e.getManager().getClass().getName());
        logger.debug("job class: " + e.getJob().getClass().getName());
        assertEquals(e.getDepartment().getId(), new Long(50L));
        assertEquals(e.getManager().getId(), new Long(122L));
        assertEquals(e.getJob().getId(), "SH_CLERK");
        logger.debug("====================== GETTING NON-ID Foreign Relationships ===========================");
        assertEquals(e.getDepartment().getName(), "Shipping");
        assertEquals(e.getJob().getTitle(), "Shipping Clerk");
        assertEquals(e.getManager().getLastName(), "Kaufling");
    }

    @Test
    public void getNull() {
        Employee e = employeeService.getEmployee(TestUtil.BAD_EMPLOYEE_ID);
        assertNull(e);
    }

    @Test
    public void saveEmployee() {
        Employee employee = ModelUtils.createNewEmployee();
        Long id = employeeService.saveEmployee(employee);
        assertNotNull(employee.getId());
        int count = employeeService.getEmployeeCount();
        assertEquals(count, TestUtil.EMPLOYEE_COUNT + 1);
    }

}
