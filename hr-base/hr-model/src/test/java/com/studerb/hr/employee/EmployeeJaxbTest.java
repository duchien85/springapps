package com.studerb.hr.employee;

import static org.junit.Assert.assertTrue;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeJaxbTest {

    static JAXBContext context;
    static Marshaller marsharller;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = JAXBContext.newInstance("com.studerb.hr.employee");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        context.createBinder();
    }

    @Test
    public void createEmployeeXML() {
        assertTrue(true);
    }
}
