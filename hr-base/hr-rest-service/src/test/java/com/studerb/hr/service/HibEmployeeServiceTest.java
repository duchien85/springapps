package com.studerb.hr.service;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.*;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;

import com.studerb.hr.model.*;
import com.studerb.hr.util.TestUtil;
import com.sun.jersey.api.NotFoundException;

public class HibEmployeeServiceTest extends AbstractServiceTest {

    @Resource(name = "hibEmployeeService")
    EmployeeService employeeService;

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
    public void createFromXml() throws Exception {
        URL url = getClassPathUrl("xml/new_employee.xml");
        Employee unmarhalled = (Employee) unmarshaller.unmarshal(url);
        logger.debug("from XML\n" + unmarhalled.toString());
        Long id = employeeService.saveEmployee(unmarhalled);
        assertNotNull(id);

        employeeService.flushAndClear();
        int count = employeeService.getEmployeeCount();
        assertEquals(count, TestUtil.EMPLOYEE_COUNT + 1);
    }

    @Test
    public void createWithJobHistoryFromXml() throws Exception {
        URL url = getClassPathUrl("xml/new_employee_job_history.xml");
        Employee unmarhalled = (Employee) unmarshaller.unmarshal(url);
        logger.debug("from XML\n" + unmarhalled.toString());
        Long id = employeeService.saveEmployee(unmarhalled);
        assertNotNull(id);
        employeeService.flushAndClear();
        int count = employeeService.getEmployeeCount();
        assertEquals(count, TestUtil.EMPLOYEE_COUNT + 1);

        Employee e = employeeService.getEmployee(id);
        assertNotNull(e);
        assertTrue(e.getJobHistory().size() == 1);
        Employee created = ModelUtils.createNewEmployeeJobHistory();
        JobHistory fromHib = e.getJobHistory().first();
        JobHistory fromModel = created.getJobHistory().first();
        assertEquals(fromHib.getDepartmentId(), fromModel.getDepartmentId());
        assertTrue(DateUtils.isSameDay(fromHib.getStartDate(), fromModel.getStartDate()));
        assertTrue(DateUtils.isSameDay(fromHib.getEndDate(), fromModel.getEndDate()));
        assertEquals(fromHib.getJobId(), fromModel.getJobId());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void createDuplicate() throws Exception {
        URL url = getClassPathUrl("xml/employee.xml");
        Employee unmarshalled = (Employee) unmarshaller.unmarshal(url);
        logger.debug("from XML: " + unmarshalled.toString());
        employeeService.saveEmployee(unmarshalled);
    }

    @Test
    public void deleteFromXml() throws Exception {
        URL url = getClassPathUrl("xml/employee.xml");
        Employee unmarshalled = (Employee) unmarshaller.unmarshal(url);
        logger.debug("from XML: " + unmarshalled.toString());
        Long id = unmarshalled.getId();
        employeeService.deleteEmployee(id);

        employeeService.flushAndClear();
        int count = employeeService.getEmployeeCount();
        assertEquals(count, TestUtil.EMPLOYEE_COUNT - 1);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNoExist() throws Exception {
        Employee employee = ModelUtils.createEmployee100();
        employee.setId(TestUtil.BAD_EMPLOYEE_ID);
        employeeService.updateEmployee(employee);
    }

    @Test
    public void updateFromXml() throws Exception {
        URL url = getClassPathUrl("xml/employee.xml");
        Employee unmarshalled = (Employee) unmarshaller.unmarshal(url);
        logger.debug("from XML: " + unmarshalled.toString());

        String firstName = "John";
        String lastName = "Grisham";
        unmarshalled.setFirstName(firstName);
        unmarshalled.setLastName(lastName);
        employeeService.updateEmployee(unmarshalled);

        employeeService.flushAndClear();
        Employee john = employeeService.getEmployee(unmarshalled.getId());
        assertEquals(john.getFirstName(), firstName);
        assertEquals(john.getLastName(), lastName);
        int count = employeeService.getEmployeeCount();
        assertEquals(count, TestUtil.EMPLOYEE_COUNT);
    }

    @Test(expected = NotFoundException.class)
    public void updateNoExist() throws Exception {
        Employee employee = ModelUtils.createEmployee100();
        employee.setId(TestUtil.BAD_EMPLOYEE_ID);
        employeeService.updateEmployee(employee);
    }

    @Test
    public void createFirstJobHistory() {
        Employee e100 = ModelUtils.createEmployee100();
        e100.setJobId("ST_MAN");
        employeeService.updateEmployee(e100);
        employeeService.flushAndClear();

        Employee temp = employeeService.getEmployee(100L);
        logger.debug("JOB HISTORY: " + temp.getJobHistory());
        SortedSet<JobHistory> jobHistory = temp.getJobHistory();
        assertTrue(jobHistory.size() == 1);
        assertEquals(jobHistory.first().getJobId(), e100.getJobId());
        assertTrue(DateUtils.isSameDay(jobHistory.first().getStartDate(), e100.getHireDate()));
        assertTrue(DateUtils.isSameDay(jobHistory.first().getEndDate(), Calendar.getInstance()));
    }

    @Test
    public void updateJob() {
        Employee e = ModelUtils.createEmployee101();
        int jhCount = e.getJobHistory().size();
        e.setJob(new Job("SA_MAN"));
        employeeService.updateEmployee(e);
        employeeService.flushAndClear();

        Employee updated = employeeService.getEmployee(e.getId());
        assertEquals(jhCount + 1, updated.getJobHistory().size());
    }

    @Test
    public void updateDepartment() {
        fail("not implemented");
    }

}
