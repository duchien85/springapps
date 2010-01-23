package com.studerb.hr.resource;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studerb.hr.model.*;
import com.studerb.hr.service.EmployeeService;
import com.studerb.hr.util.TestUtil;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.filter.LoggingFilter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
public class JettyEmployeeResourceTest {
    private final Logger log = Logger.getLogger(JettyEmployeeResourceTest.class);
    static final String BASE = "employees";

    Client client;
    ClientResponse clientResponse;
    ClientResponse.Status responseStatus;
    WebResource webResource;

    @Resource(name = "hibEmployeeService")
    EmployeeService employeeService;

    @Resource(name = "simpleJdbcTemplate")
    SimpleJdbcTemplate simpleJdbcTemplate;

    @PostConstruct
    void init() {
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

    /********************************* GET *****************************************/

    @Test
    public void getAllText() throws Exception {
        clientResponse = webResource.path(BASE).accept(MediaType.TEXT_PLAIN).get(ClientResponse.class);
        String employeeLines = clientResponse.getEntity(String.class);
        List<String> lines = Arrays.asList(employeeLines.split("\n"));
        assertTrue(lines.size() == TestUtil.EMPLOYEE_COUNT);
    }

    @Test
    public void getAllXml() throws Exception {
        clientResponse = webResource.path(BASE).accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
        assertEquals("should have got 200 OK", clientResponse.getClientResponseStatus(), ClientResponse.Status.OK);
        Employees employeesType = clientResponse.getEntity(Employees.class);
        List<Employee> fromRest = employeesType.getEmployees();
        assertTrue(fromRest.size() == TestUtil.EMPLOYEE_COUNT);

        List<Employee> fromHib = employeeService.getAllEmployees();
        assertTrue(fromHib.size() == TestUtil.EMPLOYEE_COUNT);
        assertEquals(fromRest, fromHib);
    }

    @Test
    public void getAllRawXml() throws Exception {
        clientResponse = webResource.path(BASE).accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
        assertEquals("should have got 200 OK", clientResponse.getClientResponseStatus(), ClientResponse.Status.OK);
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(clientResponse.getEntityInputStream());
        String xmlString = document.asXML();
        log.debug(xmlString);
        assertFalse(StringUtils.isBlank(xmlString));
    }

    @Test
    public void getAllJson() throws Exception {
        clientResponse = webResource.path(BASE).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        assertEquals("should have got 200 OK", clientResponse.getClientResponseStatus(), ClientResponse.Status.OK);
        Employees employeesType = clientResponse.getEntity(Employees.class);
        List<Employee> fromRest = employeesType.getEmployees();
        assertTrue(fromRest.size() == TestUtil.EMPLOYEE_COUNT);

        List<Employee> fromHib = employeeService.getAllEmployees();
        assertTrue(fromHib.size() == TestUtil.EMPLOYEE_COUNT);
        assertEquals(fromRest, fromHib);
    }

    @Test
    public void getHtml() throws Exception {
        clientResponse = webResource.path(BASE).accept(MediaType.TEXT_HTML).get(ClientResponse.class);
        responseStatus = clientResponse.getClientResponseStatus();
        assertEquals("expected 406 NOT Acceptable", clientResponse.getClientResponseStatus(),
                ClientResponse.Status.NOT_ACCEPTABLE);
    }

    @Test
    public void getXml() throws Exception {
        Long employeeId = 100L;
        clientResponse = webResource.path(BASE).path(String.valueOf(employeeId)).path("/").accept(
                MediaType.APPLICATION_XML).get(ClientResponse.class);
        assertEquals("should have got 200 OK", clientResponse.getClientResponseStatus(), ClientResponse.Status.OK);

        Employee fromXml = clientResponse.getEntity(Employee.class);
        assertNotNull(fromXml);
        Employee fromHib = employeeService.getEmployee(employeeId);
        assertEquals(fromHib, fromXml);
    }

    @Test
    public void getNullXml() {
        clientResponse = webResource.path(BASE).path(String.valueOf(TestUtil.BAD_EMPLOYEE_ID))
                .get(ClientResponse.class);
        assertEquals(clientResponse.getClientResponseStatus(), ClientResponse.Status.NOT_FOUND);
    }

    @Test
    public void getBadIdXml() {
        clientResponse = webResource.path(BASE).path("abc").get(ClientResponse.class);
        assertEquals(clientResponse.getClientResponseStatus(), ClientResponse.Status.NOT_FOUND);
    }

    /********************************* CREATE *****************************************/
    @Test
    public void create() {
        Employee employee = ModelUtils.createNewEmployee();
        clientResponse = webResource.path(BASE).type(MediaType.APPLICATION_XML).post(ClientResponse.class, employee);
        assertEquals(clientResponse.getClientResponseStatus(), ClientResponse.Status.CREATED);
        int count = employeeService.getEmployeeCount();
        log.debug("Count after adding: " + count);
        assertTrue(count == (TestUtil.EMPLOYEE_COUNT + 1));
    }

    @Test
    public void createDuplicate() {
        Employee employee = ModelUtils.createEmployee100();
        clientResponse = webResource.path(BASE).type(MediaType.APPLICATION_XML).post(ClientResponse.class, employee);
        assertEquals(clientResponse.getClientResponseStatus(), ClientResponse.Status.CONFLICT);
        int count = employeeService.getEmployeeCount();
        log.debug("Count after adding: " + count);
        assertTrue(count == TestUtil.EMPLOYEE_COUNT);
    }

    /********************************* DELETE *****************************************/

    @Test
    public void delete() {
        Long eId = 101L;
        clientResponse = webResource.path(BASE).path(eId.toString()).delete(ClientResponse.class);
        assertEquals(clientResponse.getClientResponseStatus(), ClientResponse.Status.NO_CONTENT);
        Employee e = employeeService.getEmployee(eId);
        assertNull("employee Should be null", e);
        int count = employeeService.getEmployeeCount();
        assertTrue(count == (TestUtil.EMPLOYEE_COUNT - 1));
    }

    @Test
    public void deleteNoExist() {
        Long eId = TestUtil.BAD_EMPLOYEE_ID;
        clientResponse = webResource.path(BASE).path(eId.toString()).delete(ClientResponse.class);
        assertEquals(clientResponse.getClientResponseStatus(), ClientResponse.Status.NOT_FOUND);
        int count = employeeService.getEmployeeCount();
        assertTrue(count == TestUtil.EMPLOYEE_COUNT);
    }

    /********************************* UPDATE *****************************************/

    @Test
    public void update() {
        String firstName = "John";
        String lastName = "Grisham";

        Employee employee = ModelUtils.createEmployee100();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        clientResponse = webResource.path(BASE).path(employee.getId().toString()).type(MediaType.APPLICATION_XML).put(
                ClientResponse.class, employee);
        assertEquals(clientResponse.getClientResponseStatus(), ClientResponse.Status.NO_CONTENT);
        // count should be same
        int count = employeeService.getEmployeeCount();
        log.debug("Count after adding: " + count);
        assertTrue(count == TestUtil.EMPLOYEE_COUNT);
        // employee should be changed
        Employee updated = employeeService.getEmployee(employee.getId());
        assertEquals(updated.getFirstName(), firstName);
        assertEquals(updated.getLastName(), lastName);
    }

    @Test
    public void updateBadId() {
        Employee employee = ModelUtils.createNewEmployee();
        employee.setId(TestUtil.BAD_EMPLOYEE_ID);
        clientResponse = webResource.path(BASE).path(employee.getId().toString()).type(MediaType.APPLICATION_XML).put(
                ClientResponse.class, employee);
        assertEquals(clientResponse.getClientResponseStatus(), ClientResponse.Status.NOT_FOUND);
        // count should be same
        int count = employeeService.getEmployeeCount();
        log.debug("Count after adding: " + count);
        assertTrue(count == TestUtil.EMPLOYEE_COUNT);
        // employee should not be found
        Employee notExists = employeeService.getEmployee(TestUtil.BAD_EMPLOYEE_ID);
        assertNull(notExists);
    }

    @Test
    public void updateViolateConstraint() {
        Employee employee = ModelUtils.createEmployee100();
        String initialEmail = employee.getEmail();
        employee.setEmail("JDILLY");
        clientResponse = webResource.path(BASE).path(employee.getId().toString()).type(MediaType.APPLICATION_XML).put(
                ClientResponse.class, employee);
        assertEquals(clientResponse.getClientResponseStatus(), ClientResponse.Status.CONFLICT);
        // count should be same
        int count = employeeService.getEmployeeCount();
        log.debug("Count after adding: " + count);
        assertTrue(count == TestUtil.EMPLOYEE_COUNT);
        // employee should not be modified
        Employee noChange = employeeService.getEmployee(employee.getId());
        assertEquals(noChange.getEmail(), initialEmail);
    }
}
