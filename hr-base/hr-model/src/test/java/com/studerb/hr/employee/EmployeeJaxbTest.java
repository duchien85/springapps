package com.studerb.hr.employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class EmployeeJaxbTest {

    static JAXBContext context;
    static Marshaller marsharller;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = JAXBContext.newInstance(Employee.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        context.createBinder();
    }

}
