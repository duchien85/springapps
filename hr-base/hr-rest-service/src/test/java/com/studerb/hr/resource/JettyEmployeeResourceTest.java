package com.studerb.hr.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studerb.hr.TestUtil;
import com.studerb.hr.model.Employee;
import com.studerb.hr.model.Employees;
import com.studerb.hr.model.ModelUtils;
import com.studerb.hr.service.EmployeeService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
public class JettyEmployeeResourceTest {
    private final Logger log = Logger.getLogger(JettyEmployeeResourceTest.class);

    Client client;
    ClientResponse clientResponse;
    ClientResponse.Status responseStatus;
    WebResource webResource;

    @Resource(name = "hibEmployeeService")
    EmployeeService employeeService;

    @Resource(name = "simpleJdbcTemplate")
    SimpleJdbcTemplate simpleJdbcTemplate;

    public JettyEmployeeResourceTest() {
        super();
        this.client = Client.create();
        this.client.addFilter(new LoggingFilter(System.err));
    }

    @Before
    public void setup() {
        this.simpleJdbcTemplate.update("call reset_hr_dev()", new Object[] {});
        this.webResource = this.client.resource(TestUtil.JETTY_URI);
        this.clientResponse = null;
        this.responseStatus = null;
    }

    @After
    public void tearDown() {
        this.webResource = null;
    }

    @Test
    public void getAllText() throws Exception {
        this.clientResponse = this.webResource.path("employees/").accept(MediaType.TEXT_PLAIN).get(ClientResponse.class);
        String employeeLines = this.clientResponse.getEntity(String.class);
        List<String> lines = Arrays.asList(employeeLines.split("\n"));
        assertTrue(lines.size() == TestUtil.EMPLOYEE_COUNT);
    }

    @Test
    public void getAllXml() throws Exception {
        this.clientResponse = this.webResource.path("employees/").accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
        assertEquals("should have got 200 OK", this.clientResponse.getClientResponseStatus(), ClientResponse.Status.OK);
        Employees employeesType = this.clientResponse.getEntity(Employees.class);
        List<Employee> fromRest = employeesType.getEmployees();
        assertTrue(fromRest.size() == TestUtil.EMPLOYEE_COUNT);

        List<Employee> fromHib = this.employeeService.getAllEmployees();
        assertTrue(fromHib.size() == TestUtil.EMPLOYEE_COUNT);
        for (int i = 0; i < fromHib.size(); ++i) {
            Employee e1 = fromHib.get(i);
            Employee e2 = fromRest.get(i);
            if (!e1.equals(e2)) {
                this.log.warn("e1 != e2 at index: " + i);
                this.log.warn("e1: " + e1);
                this.log.warn("e2: " + e2);
            }
        }
        assertEquals(fromRest, fromHib);
    }

    @Test
    public void getEmployeeHtml() throws Exception {
        this.clientResponse = this.webResource.path("employees/").accept(MediaType.TEXT_HTML).get(ClientResponse.class);
        this.responseStatus = this.clientResponse.getClientResponseStatus();
        assertEquals("expected 406 NOT Acceptable", this.clientResponse.getClientResponseStatus(), ClientResponse.Status.NOT_ACCEPTABLE);
    }

    @Test
    public void getEmployeeXml() throws Exception {
        Long employeeId = 100L;
        this.clientResponse = this.webResource.path("employees/").path(String.valueOf(employeeId)).path("/").accept(MediaType.APPLICATION_XML).get(
                ClientResponse.class);
        Employee fromXml = this.clientResponse.getEntity(Employee.class);
        assertNotNull(fromXml);
        Employee fromHib = this.employeeService.getEmployee(employeeId);
        assertEquals(fromHib, fromXml);
    }

    @Test
    public void getNullEmployeeXml() {
        this.clientResponse = this.webResource.path("employees/").path(String.valueOf(TestUtil.BAD_EMPLOYEE_ID)).get(ClientResponse.class);
        assertEquals(this.clientResponse.getClientResponseStatus(), ClientResponse.Status.NOT_FOUND);
    }

    @Test
    public void getBadIdEmployeeXml() {
        this.clientResponse = this.webResource.path("employees/").path("abc").get(ClientResponse.class);
        assertEquals(this.clientResponse.getClientResponseStatus(), ClientResponse.Status.NOT_FOUND);
    }

    @Test
    public void addEmployee() {
        Employee employee = ModelUtils.createNewEmployee();
        this.clientResponse = this.webResource.path("employees/").type(MediaType.APPLICATION_XML).post(ClientResponse.class, employee);
        int count = this.employeeService.getEmployeeCount();
        this.log.debug("Count after adding: " + count);
        assertTrue(count == (TestUtil.EMPLOYEE_COUNT + 1));
    }
}
