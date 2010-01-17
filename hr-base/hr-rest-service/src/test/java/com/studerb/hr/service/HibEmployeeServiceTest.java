package com.studerb.hr.service;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.studerb.hr.TestUtil;
import com.studerb.hr.model.Employee;
import com.studerb.hr.model.ModelUtils;
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

}
