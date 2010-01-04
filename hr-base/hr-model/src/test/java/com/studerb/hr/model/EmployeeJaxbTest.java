package com.studerb.hr.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.StringWriter;
import java.math.BigDecimal;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import com.studerb.hr.model.Employee;
import com.studerb.hr.model.ModelUtils;

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
        assertTrue(DateUtils.isSameDay(employee.getHireDate(), DatatypeConverter.parseDate(document.valueOf("/employee/hire_date"))));
        assertEquals(employee.getSalary(), new BigDecimal(document.valueOf("/employee/salary")));
        assertTrue(StringUtils.isBlank(document.valueOf("/employee/commission_pct")));
        assertEquals(employee.getJobId(), document.valueOf("/employee/job_id"));
        assertEquals(employee.getDepartmentId(), Long.valueOf(document.valueOf("/employee/department_id")));
        assertTrue(StringUtils.isBlank(document.valueOf("/employee/manager_id")));
    }

    @Test
    public void xmlToEmployee() throws JAXBException {
        File f = getClassPathFile("xml/employee.xml");
        assertTrue(f.exists());
        logger.debug("*******************************       " + f.getAbsolutePath() + " *****************");
        Employee unmarhalled = (Employee) unmarshaller.unmarshal(f);
        Employee obj = ModelUtils.createEmployee100();
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
