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

public class JobJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(JobJaxbTest.class);
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
        Job job = ModelUtils.createJobAdPres();
        StringWriter writer = new StringWriter();
        marshaller.marshal(job, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());
        assertEquals(job.getId(), document.valueOf("/job/@id"));
        assertEquals(job.getTitle(), document.valueOf("/job/title"));
        assertEquals(job.getMinSalary(), Long.valueOf(document.valueOf("/job/min_salary")));
        assertEquals(job.getMaxSalary(), Long.valueOf(document.valueOf("/job/max_salary")));
    }

    @Test
    public void xmlToJob() throws JAXBException {
        File f = getClassPathFile("xml/job.xml");
        assertTrue(f.exists());
        Job unmarhalled = (Job) unmarshaller.unmarshal(f);
        Job obj = ModelUtils.createJobAdPres();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }
}
