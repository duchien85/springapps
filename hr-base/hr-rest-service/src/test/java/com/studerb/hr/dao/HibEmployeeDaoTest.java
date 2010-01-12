package com.studerb.hr.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import com.studerb.hr.model.Employee;
import com.studerb.hr.model.ModelUtils;

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
        if (!this.reset) {
            this.simpleJdbcTemplate.update("call reset_hr_dev()", new Object[] {});
            this.reset = true;
        }
    }

    @Test
    public void countRows() {
        assertEquals(this.countRowsInTable(this.employeeDao.getTableName()), TestUtil.EMPLOYEE_COUNT);
    }

    @Test
    public void getAll() {
        List<Employee> employees = this.employeeDao.getAll();
        assertEquals(employees.size(), TestUtil.EMPLOYEE_COUNT);
    }

    @Test
    public void getOne() {
        Employee employee = this.employeeDao.get(189L);
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
        Employee e = this.employeeDao.get(TestUtil.BAD_EMPLOYEE_ID);
        assertNull(e);
    }

    // @Test(expected = Throwable.class)
    public void deleteOne() {
        this.employeeDao.delete(101L);
    }

    @Test
    public void addEmployee() {
        Employee employee = ModelUtils.createNewEmployee();
        Long id = this.employeeDao.save(employee);
        assertNotNull(employee.getId());

        this.employeeDao.flush();
        Employee em2 = this.employeeDao.get(id);
        assertNotNull(em2);
        assertEquals(em2, employee);
        int count = this.employeeDao.getCount();
        assertEquals(count, TestUtil.EMPLOYEE_COUNT + 1);
    }
}
