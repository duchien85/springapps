package com.studerb.hr.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

public class DepartmentsJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(DepartmentsJaxbTest.class);

    @Test
    public void DepartmentsToXml() throws Exception {
        Departments departments = ModelUtils.createFiveDepartments();
        StringWriter writer = new StringWriter();
        marshaller.marshal(departments, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());

        Department d1 = departments.getDepartments().get(0);
        assertEquals(d1.getId(), Long.valueOf(document.valueOf("/departments/department[1]/@id")));
        assertEquals(d1.getName(), document.valueOf("/departments/department[1]/name"));
        assertEquals(d1.getManagerId(), Long.valueOf(document.valueOf("/departments/department[1]/manager_id")));
        assertEquals(d1.getLocationId(), Long.valueOf(document.valueOf("/departments/department[1]/location_id")));

        Department d2 = departments.getDepartments().get(1);
        assertEquals(d2.getId(), Long.valueOf(document.valueOf("/departments/department[2]/@id")));
        assertEquals(d2.getName(), document.valueOf("/departments/department[2]/name"));
        assertEquals(d2.getManagerId(), Long.valueOf(document.valueOf("/departments/department[2]/manager_id")));
        assertEquals(d2.getLocationId(), Long.valueOf(document.valueOf("/departments/department[2]/location_id")));

        Department d3 = departments.getDepartments().get(2);
        assertEquals(d3.getId(), Long.valueOf(document.valueOf("/departments/department[3]/@id")));
        assertEquals(d3.getName(), document.valueOf("/departments/department[3]/name"));
        assertEquals(d3.getManagerId(), Long.valueOf(document.valueOf("/departments/department[3]/manager_id")));
        assertEquals(d3.getLocationId(), Long.valueOf(document.valueOf("/departments/department[3]/location_id")));

        Department d4 = departments.getDepartments().get(3);
        assertEquals(d4.getId(), Long.valueOf(document.valueOf("/departments/department[4]/@id")));
        assertEquals(d4.getName(), document.valueOf("/departments/department[4]/name"));
        assertEquals(d4.getManagerId(), Long.valueOf(document.valueOf("/departments/department[4]/manager_id")));
        assertEquals(d4.getLocationId(), Long.valueOf(document.valueOf("/departments/department[4]/location_id")));

        Department d5 = departments.getDepartments().get(4);
        assertEquals(d5.getId(), Long.valueOf(document.valueOf("/departments/department[5]/@id")));
        assertEquals(d5.getName(), document.valueOf("/departments/department[5]/name"));
        assertTrue(StringUtils.isBlank(document.valueOf("/departments/department[5]/manager_id")));
        assertEquals(d5.getLocationId(), Long.valueOf(document.valueOf("/departments/department[5]/location_id")));

    }

    @Test
    public void xmlToDepartments() throws JAXBException {
        File f = getClassPathFile("xml/departments.xml");
        assertTrue(f.exists());
        Departments unmarhalled = (Departments) unmarshaller.unmarshal(f);
        Departments obj = ModelUtils.createFiveDepartments();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }
}
