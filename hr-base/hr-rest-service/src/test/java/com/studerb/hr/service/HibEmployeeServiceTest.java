package com.studerb.hr.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.SortedSet;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;

import com.studerb.hr.model.Employee;
import com.studerb.hr.model.JobHistory;
import com.studerb.hr.model.ModelUtils;
import com.studerb.hr.util.TestUtil;
import com.sun.jersey.api.NotFoundException;

public class HibEmployeeServiceTest extends AbstractServiceTest {

    @Resource(name = "hibEmployeeService")
    EmployeeService employeeService;

    @Test
    public void getAll() {
        List<Employee> employees = this.employeeService.getAllEmployees();
        assertEquals(employees.size(), TestUtil.EMPLOYEE_COUNT);
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

    @Test
    public void getNull() {
        Employee e = this.employeeService.getEmployee(TestUtil.BAD_EMPLOYEE_ID);
        assertNull(e);
    }

    @Test
    public void createFromXml() throws Exception {
        URL url = getClassPathUrl("xml/new_employee.xml");
        Employee unmarhalled = (Employee) this.unmarshaller.unmarshal(url);
        this.logger.debug("from XML\n" + unmarhalled.toString());
        Long id = this.employeeService.saveEmployee(unmarhalled);
        assertNotNull(id);

        this.employeeService.flushAndClear();
        int count = this.employeeService.getEmployeeCount();
        assertEquals(count, TestUtil.EMPLOYEE_COUNT + 1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void createDuplicate() throws Exception {
        URL url = getClassPathUrl("xml/employee.xml");
        Employee unmarshalled = (Employee) this.unmarshaller.unmarshal(url);
        this.logger.debug("from XML: " + unmarshalled.toString());
        this.employeeService.saveEmployee(unmarshalled);
    }

    @Test
    public void deleteFromXml() throws Exception {
        URL url = getClassPathUrl("xml/employee.xml");
        Employee unmarshalled = (Employee) this.unmarshaller.unmarshal(url);
        this.logger.debug("from XML: " + unmarshalled.toString());
        Long id = unmarshalled.getId();
        this.employeeService.deleteEmployee(id);

        this.employeeService.flushAndClear();
        int count = this.employeeService.getEmployeeCount();
        assertEquals(count, TestUtil.EMPLOYEE_COUNT - 1);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNoExist() throws Exception {
        Employee employee = ModelUtils.createEmployee100();
        employee.setId(TestUtil.BAD_EMPLOYEE_ID);
        this.employeeService.updateEmployee(employee);
    }

    @Test
    public void updateFromXml() throws Exception {
        URL url = getClassPathUrl("xml/employee.xml");
        Employee unmarshalled = (Employee) this.unmarshaller.unmarshal(url);
        this.logger.debug("from XML: " + unmarshalled.toString());

        String firstName = "John";
        String lastName = "Grisham";
        unmarshalled.setFirstName(firstName);
        unmarshalled.setLastName(lastName);
        this.employeeService.updateEmployee(unmarshalled);

        this.employeeService.flushAndClear();
        Employee john = this.employeeService.getEmployee(unmarshalled.getId());
        assertEquals(john.getFirstName(), firstName);
        assertEquals(john.getLastName(), lastName);
        int count = this.employeeService.getEmployeeCount();
        assertEquals(count, TestUtil.EMPLOYEE_COUNT);
    }

    @Test(expected = NotFoundException.class)
    public void updateNoExist() throws Exception {
        Employee employee = ModelUtils.createEmployee100();
        employee.setId(TestUtil.BAD_EMPLOYEE_ID);
        this.employeeService.updateEmployee(employee);
    }

    @Test
    public void createFirstJobHistory() {
        Employee e100 = ModelUtils.createEmployee100();
        e100.setJobId("ST_MAN");
        this.employeeService.updateEmployee(e100);
        this.employeeService.flushAndClear();

        Employee temp = this.employeeService.getEmployee(100L);
        this.logger.debug("*********************" + temp.getJobHistory() + "*********************i");
        SortedSet<JobHistory> jobHistory = temp.getJobHistory();
        assertTrue(jobHistory.size() == 1);
        assertEquals(jobHistory.first().getJobId(), e100.getJobId());
        assertTrue(DateUtils.isSameDay(jobHistory.first().getStartDate(), e100.getHireDate()));
        assertTrue(DateUtils.isSameDay(jobHistory.first().getEndDate(), Calendar.getInstance()));
    }
}
