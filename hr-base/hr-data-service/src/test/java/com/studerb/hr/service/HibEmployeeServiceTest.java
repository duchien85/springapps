package com.studerb.hr.service;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;

import com.studerb.hr.exception.EntityNotExistException;
import com.studerb.hr.model.*;

public class HibEmployeeServiceTest extends BaseServiceTest {

    @Resource(name = "hibEmployeeService")
    EmployeeService employeeService;

    @Test
    public void getAll() {
        List<Employee> employees = employeeService.getAllEmployees();
        assertEquals(employees.size(), EMPLOYEE_COUNT.intValue());
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
        Employee e = employeeService.getEmployee(BAD_EMPLOYEE_ID);
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
        assertEquals(count, EMPLOYEE_COUNT + 1);
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
        assertEquals(count, EMPLOYEE_COUNT + 1);

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
        assertEquals(count, EMPLOYEE_COUNT - 1);
    }

    @Test(expected = EntityNotExistException.class)
    public void deleteNoExist() throws Exception {
        employeeService.deleteEmployee(BAD_EMPLOYEE_ID);
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
        assertEquals(count, EMPLOYEE_COUNT.intValue());
    }

    @Test(expected = EntityNotExistException.class)
    public void updateNoExist() throws Exception {
        Employee employee = ModelUtils.createEmployee100();
        employee.setId(BAD_EMPLOYEE_ID);
        employeeService.updateEmployee(employee);
    }

    @Test
    public void updateJob() {
        Employee e = employeeService.getEmployee(101L);
        int jhCount = e.getJobHistory().size();
        e.setJob(new Job("SA_MAN"));
        employeeService.updateEmployee(e);
        employeeService.flushAndClear();
        Employee updated = employeeService.getEmployee(e.getId());
        assertEquals(jhCount + 1, updated.getJobHistory().size());
    }

    @Test
    public void updateDepartment() {
        Employee e = employeeService.getEmployee(101L);
        int jhCount = e.getJobHistory().size();
        e.setDepartment(new Department(new Long(10L)));
        employeeService.updateEmployee(e);
        employeeService.flushAndClear();
        Employee updated = employeeService.getEmployee(e.getId());
        assertEquals(jhCount + 1, updated.getJobHistory().size());
    }
}
