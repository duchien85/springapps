package com.studerb.hr.employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.StringWriter;
import java.math.BigDecimal;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.studerb.hr.ModelUtils;

public class EmployeeJaxbTest {
    static final Logger logger = Logger.getLogger(EmployeeJaxbTest.class);
    static JAXBContext context;
    static Marshaller marshaller;
    static Unmarshaller unmarshaller;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = JAXBContext.newInstance("com.studerb.hr.employee");
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "hr-model.xsd");
        unmarshaller = context.createUnmarshaller();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    // context.createBinder();
    }

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
        assertEquals(employee.getJobId(), document.valueOf("/employee/jobId"));
        assertEquals(employee.getDepartmentId(), Long.valueOf(document.valueOf("/employee/departmentId")));
        assertTrue(StringUtils.isBlank(document.valueOf("/employee/managerId")));
    }

    @Test
    public void xmlToEmployee() throws JAXBException {
        File f = ModelUtils.getClassPathFile("xml/employee.xml");
        assertTrue(f.exists());
        Employee unmarhalled = (Employee) unmarshaller.unmarshal(f);
        Employee obj = ModelUtils.createEmployee100();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }

    // @Test
    public void treeWalkTest() throws Exception {
        Employee employee = ModelUtils.createEmployee100();
        StringWriter writer = new StringWriter();
        marshaller.marshal(employee, writer);
        Document document = DocumentHelper.parseText(writer.toString());
        this.treeWalk(document);
    }

    public void treeWalk(Document document) {
        this.treeWalk(document.getRootElement());
    }

    public void treeWalk(Element element) {
        for (int i = 0, size = element.nodeCount(); i < size; i++) {
            Node node = element.node(i);
            if (node instanceof Element) {
                this.treeWalk((Element) node);
            }
            else {
                logger.debug(node.getPath());
            }
        }
    }

}
