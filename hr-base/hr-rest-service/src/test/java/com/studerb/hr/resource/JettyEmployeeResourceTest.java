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
        client = Client.create();
        client.addFilter(new LoggingFilter(System.err));
    }

    @Before
    public void setup() {
        simpleJdbcTemplate.update("call reset_hr_dev()", new Object[] {});
        webResource = client.resource(TestUtil.JETTY_URI);
        clientResponse = null;
        responseStatus = null;
    }

    @After
    public void tearDown() {
        webResource = null;
    }

    @Test
    public void getAllText() throws Exception {
        clientResponse = webResource.path("employees/").accept(MediaType.TEXT_PLAIN).get(ClientResponse.class);
        String employeeLines = clientResponse.getEntity(String.class);
        List<String> lines = Arrays.asList(employeeLines.split("\n"));
        assertTrue(lines.size() == TestUtil.EMPLOYEE_COUNT);
    }

    @Test
    public void getAllXml() throws Exception {
        clientResponse = webResource.path("employees/").accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
        assertEquals("should have got 200 OK", clientResponse.getClientResponseStatus(), ClientResponse.Status.OK);
        Employees employeesType = clientResponse.getEntity(Employees.class);
        List<Employee> fromRest = employeesType.getEmployees();
        assertTrue(fromRest.size() == TestUtil.EMPLOYEE_COUNT);

        List<Employee> fromHib = employeeService.getAllEmployees();
        assertEquals(fromRest, fromHib);
    }

    @Test
    public void getEmployeeHtml() throws Exception {
        clientResponse = webResource.path("employees/").accept(MediaType.TEXT_HTML).get(ClientResponse.class);
        responseStatus = clientResponse.getClientResponseStatus();
        assertEquals("expected 406 NOT Acceptable", clientResponse.getClientResponseStatus(), ClientResponse.Status.NOT_ACCEPTABLE);
    }

    @Test
    public void getEmployeeXml() throws Exception {
        Long employeeId = 100L;
        clientResponse = webResource.path("employees/").path(String.valueOf(employeeId)).path("/").accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
        Employee fromXml = clientResponse.getEntity(Employee.class);
        assertNotNull(fromXml);
        Employee fromHib = employeeService.getEmployee(employeeId);
        assertEquals(fromHib, fromXml);
    }

    @Test
    public void getNullEmployeeXml() {
        clientResponse = webResource.path("employees/").path(String.valueOf(TestUtil.BAD_EMPLOYEE_ID)).get(ClientResponse.class);
        assertEquals(clientResponse.getClientResponseStatus(), ClientResponse.Status.NOT_FOUND);
    }

    @Test
    public void getBadIdEmployeeXml() {
        clientResponse = webResource.path("employees/").path("abc").get(ClientResponse.class);
        assertEquals(clientResponse.getClientResponseStatus(), ClientResponse.Status.NOT_FOUND);
    }

    @Test
    public void addEmployee() {
        Employee employee = ModelUtils.createNewEmployee();
        clientResponse = webResource.path("employees/").type(MediaType.APPLICATION_XML).post(ClientResponse.class, employee);
        int count = employeeService.getEmployeeCount();
        log.debug("Count after adding: " + count);
        assertTrue(count == (TestUtil.EMPLOYEE_COUNT + 1));
    }
}
