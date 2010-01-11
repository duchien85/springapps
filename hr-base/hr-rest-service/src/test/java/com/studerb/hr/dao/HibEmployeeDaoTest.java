package com.studerb.hr.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.studerb.hr.TestUtil;
import com.studerb.hr.model.Department;
import com.studerb.hr.model.Employee;
import com.studerb.hr.model.Job;

@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
@TransactionConfiguration(defaultRollback = true)
public class HibEmployeeDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
    final static Logger log = Logger.getLogger(HibEmployeeDaoTest.class);
    final static StopWatch stopWatch = new StopWatch();
    boolean reset = false;

    @Resource(name = "hibEmployeeDao")
    EmployeeDao employeeDao;

    @Resource
    SessionFactory sessionFactory;

    @BeforeClass
    public static void beforeClass() {
        stopWatch.start();
    }

    @AfterClass
    public static void afterClass() {
        stopWatch.stop();
        log.debug("Time of test class: " + stopWatch.toString());
    }

    @Before
    public void setUp() throws Exception {
        if (!reset) {
            simpleJdbcTemplate.update("call reset_hr_dev()", new Object[] {});
            reset = true;
        }
    }

    @Test
    public void countRows() {
        assertEquals(countRowsInTable(employeeDao.getTableName()), TestUtil.EMPLOYEE_COUNT);
    }

    @Test
    public void getAll() {
        List<Employee> employees = employeeDao.getAll();
        assertEquals(employees.size(), TestUtil.EMPLOYEE_COUNT);
    }

    @Test
    public void getOne() {
        Employee employee = employeeDao.get(189L);
        assertNotNull(employee);
        assertEquals(employee.getFirstName(), "Jennifer");
        assertEquals(employee.getLastName(), "Dilly");
        assertEquals(employee.getEmail(), "JDILLY");
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        c.set(1997, 7, 13);
        assertTrue(DateUtils.isSameDay(employee.getHireDate(), c));
    }

    @Test
    public void getNull() {
        Employee e = employeeDao.get(TestUtil.BAD_EMPLOYEE_ID);
        assertNull(e);
    }

    // @Test(expected = Throwable.class)
    public void deleteOne() {
        employeeDao.delete(101L);
    }

    @Test
    public void addEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Bob");
        employee.setLastName("Alvabcc");
        employee.setEmail("ALVABCC");
        employee.setHireDate(Calendar.getInstance());
        employee.setCommissionPct(new BigDecimal("0.50"));
        employee.setPhoneNumber("123.456.7890");
        employee.setManager(new Employee(100L));
        employee.setDepartment(new Department(30L));
        employee.setJob(new Job("PU_MAN"));
        employee.setSalary(new BigDecimal("11000"));
        Long id = employeeDao.save(employee);
        employeeDao.flush();
        assertNotNull(employee.getId());

        Employee em2 = employeeDao.get(id);
        assertNotNull(em2);
        assertEquals(em2, employee);
        int count = employeeDao.getCount();
        assertEquals(count, TestUtil.EMPLOYEE_COUNT + 1);
    }
}
