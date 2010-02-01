package com.studerb.hr.dao;

import static org.junit.Assert.*;

import java.util.*;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.studerb.hr.model.*;
import com.studerb.hr.util.TestUtil;

@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
@TransactionConfiguration(defaultRollback = true)
public class HibEmployeeDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
    final static Logger log = Logger.getLogger(HibEmployeeDaoTest.class);

    @Resource(name = "hibEmployeeDao")
    EmployeeDao employeeDao;

    @Resource
    SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        simpleJdbcTemplate.update("call reset_hr_dev()", new Object[] {});
    }

    @Test
    public void countRows() {
        assertEquals(countRowsInTable(employeeDao.getTableName()), TestUtil.EMPLOYEE_COUNT);
    }

    @Test
    public void exists() {
        boolean exists = employeeDao.exists(100L);
        assertTrue(exists);
    }

    @Test
    public void notExists() {
        boolean exists = employeeDao.exists(TestUtil.BAD_EMPLOYEE_ID);
        assertFalse(exists);
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
    public void getAssociations() {
        Employee employee = employeeDao.get(101L);
        Employee manager = employee.getManager();

        assertEquals(manager.getId(), new Long(100L));
        assertEquals(manager.getFirstName(), "Steven");
        assertEquals(manager.getLastName(), "King");

        Set<Employee> employees = employee.getEmployees();
        assertTrue(employees.size() == 5);

        List<Long> ids = Arrays.asList(200L, 203L, 204L, 205L, 108L);
        for (Employee e : employees) {
            assertTrue(ids.contains(e.getId()));
        }

        SortedSet<JobHistory> jobHistories = employee.getJobHistory();
        assertTrue(jobHistories.size() == 2);
        assertEquals(jobHistories.first().getJobId(), "AC_ACCOUNT");
        assertEquals(jobHistories.last().getJobId(), "AC_MGR");
    }

    @Test
    public void getNull() {
        Employee e = employeeDao.get(TestUtil.BAD_EMPLOYEE_ID);
        assertNull(e);
    }

    @Test
    public void createNew() {
        Employee employee = ModelUtils.createNewEmployee();
        Long id = employeeDao.save(employee);
        assertNotNull(employee.getId());
        employeeDao.flushAndClear();

        Employee em2 = employeeDao.get(id);
        assertNotNull(em2);
        assertEquals(em2, employee);
        int count = employeeDao.getCount();
        assertEquals(count, TestUtil.EMPLOYEE_COUNT + 1);
    }

    @Test
    public void createNewWithJobHistory() {
        Employee employee = ModelUtils.createNewEmployeeJobHistory();
        Long id = employeeDao.save(employee);
        assertNotNull(employee.getId());
        employeeDao.flushAndClear();

        Employee em2 = employeeDao.get(id);
        assertNotNull(em2);
        assertEquals(em2, employee);
        assertTrue(em2.getJobHistory().size() == 1);
        int count = employeeDao.getCount();
        assertEquals(count, TestUtil.EMPLOYEE_COUNT + 1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void saveDuplicate() {
        Employee e = ModelUtils.createEmployee100();
        employeeDao.save(e);
    }

    @Test
    public void delete() {
        Long employeeId = 101L;
        List<Long> employeeIds = Arrays.asList(200L, 203L, 204L, 205L, 108L);
        Long managerId = 100L;
        employeeDao.delete(employeeId);
        employeeDao.flushAndClear();
        // check we've deleted employee itself
        Employee e = employeeDao.get(employeeId);
        assertNull(e);

        // check job histories have been deleted
        int count = simpleJdbcTemplate
                .queryForInt("select count(*) from job_history where employee_id = ?", employeeId);
        assertTrue(count == 0);

        // make sure all the former employees have had their managers changed
        for (Long tempId : employeeIds) {
            Employee temp = employeeDao.get(tempId);
            assertEquals(temp.getManager().getId(), managerId);
        }
    }

    @Test
    public void deleteDepartmentHead() {
        Long employeeId = 100L;
        int count = simpleJdbcTemplate.queryForInt("select count(*) from departments where manager_id = ?", employeeId);
        assertTrue(count == 1);

        List<Long> employeeIds = Arrays.asList(101L, 102L, 114L, 120L, 121L, 122L, 123L);
        employeeDao.delete(employeeId);
        employeeDao.flushAndClear();

        // check we've deleted employee itself
        Employee e = employeeDao.get(employeeId);
        assertNull(e);

        // check job histories have been deleted
        count = simpleJdbcTemplate.queryForInt("select count(*) from job_history where employee_id = ?", employeeId);
        assertTrue(count == 0);

        count = simpleJdbcTemplate.queryForInt("select count(*) from departments where manager_id = ?", employeeId);
        assertTrue(count == 0);

        // make sure all the former employees have had their managers changed
        for (Long tempId : employeeIds) {
            Employee temp = employeeDao.get(tempId);
            assertNull(temp.getManager());
        }
    }

    @Test
    public void update() {
        Employee employee = ModelUtils.createEmployee100();
        String firstName = "John";
        String lastName = "Grisham";
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employeeDao.update(employee);
        employeeDao.flushAndClear();

        Employee john = employeeDao.get(employee.getId());
        assertEquals(john.getFirstName(), firstName);
        assertEquals(john.getLastName(), lastName);
    }

    @Test
    public void updateManager() {
        Long newManagerId = 101L;
        Employee employee = ModelUtils.createEmployee100();
        employee.setManagerId(new Long(newManagerId));
        employeeDao.update(employee);
        employeeDao.flushAndClear();

        Employee updated = employeeDao.get(employee.getId());
        assertEquals(updated.getManagerId(), newManagerId);
    }

    @Test(expected = NonTransientDataAccessException.class)
    public void updateNonId() {
        Employee e = ModelUtils.createNewEmployee();
        e.setFirstName("Yoshimoto");
        employeeDao.update(e);
    }

    @Test
    public void updateBadId() {
        Employee e = ModelUtils.createEmployee100();
        e.setId(TestUtil.BAD_EMPLOYEE_ID);
        employeeDao.update(e);
    }

    @Test
    public void compareSortedJobHistory() {
        List<Employee> employees = employeeDao.getAll();
        for (Employee e : employees) {
            SortedSet<JobHistory> jobHistory = e.getJobHistory();
            assertNotNull(jobHistory);
            if (jobHistory.size() > 1) {
                Calendar first = jobHistory.first().getStartDate();
                Calendar second = jobHistory.last().getStartDate();
                assertTrue(first.compareTo(second) < 0);
            }
        }
    }
}
