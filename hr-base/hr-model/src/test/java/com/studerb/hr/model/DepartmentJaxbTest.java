package com.studerb.hr.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import com.studerb.hr.model.Department;
import com.studerb.hr.model.ModelUtils;

public class DepartmentJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(DepartmentJaxbTest.class);

    @Test
    public void DeparatmentToXml() throws Exception {
        Department department = ModelUtils.createDepartment10();
        StringWriter writer = new StringWriter();
        marshaller.marshal(department, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());
        assertEquals(department.getId(), Long.valueOf(document.valueOf("/department/@id")));
        assertEquals(department.getName(), document.valueOf("/department/name"));
        assertEquals(department.getLocationId(), Long.valueOf(document.valueOf("/department/location_id")));
        assertEquals(department.getManagerId(), Long.valueOf(document.valueOf("/department/manager_id")));
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
