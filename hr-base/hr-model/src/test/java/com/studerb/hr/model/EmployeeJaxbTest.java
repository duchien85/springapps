package com.studerb.hr.model;

import static org.junit.Assert.*;

import java.io.File;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

public class EmployeeJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(EmployeeJaxbTest.class);

    @Test
    public void employeeToXml() throws Exception {
        Employee employee = ModelUtils.createEmployee100();
        StringWriter writer = new StringWriter();
        marshaller.marshal(employee, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());

        assertEquals(employee.getId(), Long.valueOf(document.valueOf("/employee/@id")));
        assertEquals(employee.getFirstName(), document.valueOf("/employee/first_name"));
        assertEquals(employee.getLastName(), document.valueOf("/employee/last_name"));
        assertEquals(employee.getEmail(), document.valueOf("/employee/email"));
        assertEquals(employee.getPhoneNumber(), document.valueOf("/employee/phone_number"));
        assertTrue(DateUtils.isSameDay(employee.getHireDate(), DatatypeConverter.parseDate(document
                .valueOf("/employee/hire_date"))));
        assertEquals(employee.getSalary(), new BigDecimal(document.valueOf("/employee/salary")));
        assertTrue(StringUtils.isBlank(document.valueOf("/employee/commission_pct")));
        assertEquals(employee.getJobId(), document.valueOf("/employee/job_id"));
        assertEquals(employee.getDepartmentId(), Long.valueOf(document.valueOf("/employee/department_id")));
        assertTrue(StringUtils.isBlank(document.valueOf("/employee/manager_id")));
        assertTrue(StringUtils.isBlank(document.valueOf("/employee/job_histories")));
    }

    @Test
    public void xmlToEmployee() throws JAXBException {
        File f = getClassPathFile("xml/employee.xml");
        assertTrue(f.exists());
        Employee unmarhalled = (Employee) unmarshaller.unmarshal(f);
        Employee obj = ModelUtils.createEmployee100();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }

    @Test
    public void newEmployeeToXml() throws Exception {
        Employee employee = ModelUtils.createNewEmployee();
        StringWriter writer = new StringWriter();
        marshaller.marshal(employee, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());
        assertTrue(StringUtils.isBlank(document.valueOf("/employee/@id")));
        assertEquals(employee.getFirstName(), document.valueOf("/employee/first_name"));
        assertEquals(employee.getLastName(), document.valueOf("/employee/last_name"));
        assertEquals(employee.getEmail(), document.valueOf("/employee/email"));
        assertEquals(employee.getPhoneNumber(), document.valueOf("/employee/phone_number"));
        assertTrue(DateUtils.isSameDay(employee.getHireDate(), DatatypeConverter.parseDate(document
                .valueOf("/employee/hire_date"))));
        assertEquals(employee.getSalary(), new BigDecimal(document.valueOf("/employee/salary")));
        assertEquals(employee.getCommissionPct(), new BigDecimal(document.valueOf("/employee/commission_pct")));
        assertEquals(employee.getJobId(), document.valueOf("/employee/job_id"));
        assertEquals(employee.getDepartmentId(), Long.valueOf(document.valueOf("/employee/department_id")));
        assertEquals(employee.getManagerId(), Long.valueOf(document.valueOf("/employee/manager_id")));
        assertTrue(employee.getJobHistory().isEmpty());
        assertTrue(StringUtils.isBlank(document.valueOf("/employee/job_histories")));
    }

    @Test
    public void xmlToNewEmployee() throws JAXBException {
        File f = getClassPathFile("xml/new_employee.xml");
        assertTrue(f.exists());
        Employee unmarhalled = (Employee) unmarshaller.unmarshal(f);
        Employee obj = ModelUtils.createNewEmployee();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }

    @Test
    public void employeeWithJobHistoryToXml() throws Exception {
        Employee employee = ModelUtils.createEmployee101();
        StringWriter writer = new StringWriter();
        marshaller.marshal(employee, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());

        assertEquals(employee.getId(), Long.valueOf(document.valueOf("/employee/@id")));
        assertEquals(employee.getFirstName(), document.valueOf("/employee/first_name"));
        assertEquals(employee.getLastName(), document.valueOf("/employee/last_name"));
        assertEquals(employee.getEmail(), document.valueOf("/employee/email"));
        assertEquals(employee.getPhoneNumber(), document.valueOf("/employee/phone_number"));
        assertTrue(DateUtils.isSameDay(employee.getHireDate(), DatatypeConverter.parseDate(document
                .valueOf("/employee/hire_date"))));
        assertEquals(employee.getSalary(), new BigDecimal(document.valueOf("/employee/salary")));
        assertTrue(StringUtils.isBlank(document.valueOf("/employee/commission_pct")));
        assertEquals(employee.getJobId(), document.valueOf("/employee/job_id"));
        assertEquals(employee.getDepartmentId(), Long.valueOf(document.valueOf("/employee/department_id")));
        assertEquals(employee.getManagerId(), Long.valueOf(document.valueOf("/employee/manager_id")));

        List<JobHistory> jhList = new ArrayList<JobHistory>(employee.getJobHistory());
        JobHistory jh1 = jhList.get(0);
        assertEquals(jh1.getEmployeeId(), Long.valueOf(document
                .valueOf("/employee/job_histories/job_history[1]/@employee_id")));
        assertTrue(DateUtils.isSameDay(jh1.getStartDate(), DatatypeConverter.parseDate(document
                .valueOf("/employee/job_histories/job_history[1]/@start_date"))));
        assertTrue(DateUtils.isSameDay(jh1.getEndDate(), DatatypeConverter.parseDate(document
                .valueOf("/employee/job_histories/job_history[1]/end_date"))));
        assertEquals(jh1.getJobId(), document.valueOf("/employee/job_histories/job_history[1]/job_id"));
        assertEquals(jh1.getDepartmentId(), Long.valueOf(document
                .valueOf("/employee/job_histories/job_history[1]/department_id")));

        JobHistory jh2 = jhList.get(1);
        assertEquals(jh2.getEmployeeId(), Long.valueOf(document
                .valueOf("/employee/job_histories/job_history[2]/@employee_id")));
        assertTrue(DateUtils.isSameDay(jh2.getStartDate(), DatatypeConverter.parseDate(document
                .valueOf("/employee/job_histories/job_history[2]/@start_date"))));
        assertTrue(DateUtils.isSameDay(jh2.getEndDate(), DatatypeConverter.parseDate(document
                .valueOf("/employee/job_histories/job_history[2]/end_date"))));
        assertEquals(jh2.getJobId(), document.valueOf("/employee/job_histories/job_history[2]/job_id"));
        assertEquals(jh2.getDepartmentId(), Long.valueOf(document
                .valueOf("/employee/job_histories/job_history[2]/department_id")));

    }

    @Test
    public void xmlToEmployeeWithJobHistory() throws JAXBException {
        File f = getClassPathFile("xml/employee_job_histories.xml");
        assertTrue(f.exists());
        Employee unmarhalled = (Employee) unmarshaller.unmarshal(f);
        Employee obj = ModelUtils.createEmployee101();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }

    @Test
    public void newEmployeeWithJobHistoryToXml() throws Exception {
        Employee employee = ModelUtils.createNewEmployeeJobHistory();
        StringWriter writer = new StringWriter();
        marshaller.marshal(employee, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());
        assertTrue(StringUtils.isBlank(document.valueOf("/employee/@id")));
        assertEquals(employee.getFirstName(), document.valueOf("/employee/first_name"));
        assertEquals(employee.getLastName(), document.valueOf("/employee/last_name"));
        assertEquals(employee.getEmail(), document.valueOf("/employee/email"));
        assertEquals(employee.getPhoneNumber(), document.valueOf("/employee/phone_number"));
        assertTrue(DateUtils.isSameDay(employee.getHireDate(), DatatypeConverter.parseDate(document
                .valueOf("/employee/hire_date"))));
        assertEquals(employee.getSalary(), new BigDecimal(document.valueOf("/employee/salary")));
        assertEquals(employee.getCommissionPct(), new BigDecimal(document.valueOf("/employee/commission_pct")));
        assertEquals(employee.getJobId(), document.valueOf("/employee/job_id"));
        assertEquals(employee.getDepartmentId(), Long.valueOf(document.valueOf("/employee/department_id")));
        assertEquals(employee.getManagerId(), Long.valueOf(document.valueOf("/employee/manager_id")));

        JobHistory jh1 = employee.getJobHistory().first();
        assertEquals(jh1.getEmployeeId(), Long.valueOf(document
                .valueOf("/employee/job_histories/job_history[1]/@employee_id")));
        assertTrue(DateUtils.isSameDay(jh1.getStartDate(), DatatypeConverter.parseDate(document
                .valueOf("/employee/job_histories/job_history[1]/@start_date"))));
        assertTrue(DateUtils.isSameDay(jh1.getEndDate(), DatatypeConverter.parseDate(document
                .valueOf("/employee/job_histories/job_history[1]/end_date"))));
        assertEquals(jh1.getJobId(), document.valueOf("/employee/job_histories/job_history[1]/job_id"));
        assertEquals(jh1.getDepartmentId(), Long.valueOf(document
                .valueOf("/employee/job_histories/job_history[1]/department_id")));

    }

    @Test
    public void xmlToNewEmployeeWithJobHistory() throws JAXBException {
        File f = getClassPathFile("xml/new_employee_job_history.xml");
        assertTrue(f.exists());
        Employee unmarhalled = (Employee) unmarshaller.unmarshal(f);
        Employee obj = ModelUtils.createNewEmployeeJobHistory();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }

    @Test
    public void treeWalkTest() throws Exception {
        Employee employee = ModelUtils.createEmployee100();
        StringWriter writer = new StringWriter();
        marshaller.marshal(employee, writer);
        Document document = DocumentHelper.parseText(writer.toString());
        treeWalk(document);
    }

}
