package com.studerb.hr.employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.BeforeClass;
import org.junit.Test;

import com.studerb.hr.ModelUtils;

public class DepartmentJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(DepartmentJaxbTest.class);
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

    @Test
    public void DeparatmentToXml() throws Exception {
        Department department = ModelUtils.createDepartment10();
        StringWriter writer = new StringWriter();
        marshaller.marshal(department, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());
        assertEquals(department.getId(), Long.valueOf(document.valueOf("/department/@id")));
        assertEquals(department.getName(), document.valueOf("/department/name"));
        assertEquals(department.getLocationId(), Long.valueOf(document.valueOf("/department/locationId")));
        assertEquals(department.getManagerId(), Long.valueOf(document.valueOf("/department/managerId")));
    }

    @Test
    public void xmlToDepartment() throws JAXBException {
        File f = getClassPathFile("xml/department.xml");
        assertTrue(f.exists());
        Department unmarhalled = (Department) unmarshaller.unmarshal(f);
        Department obj = ModelUtils.createDepartment10();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }
}
