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

public class JobsJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(JobsJaxbTest.class);
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
    public void JobsToXml() throws Exception {
        Jobs jobs = ModelUtils.createFourJobs();
        StringWriter writer = new StringWriter();
        marshaller.marshal(jobs, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());

        Job j1 = jobs.getJobs().get(0);
        assertEquals(j1.getId(), (document.valueOf("/jobs/job[1]/@id")));
        assertEquals(j1.getTitle(), document.valueOf("/jobs/job[1]/title"));
        assertEquals(j1.getMinSalary(), Long.valueOf(document.valueOf("/jobs/job[1]/min_salary")));
        assertEquals(j1.getMaxSalary(), Long.valueOf(document.valueOf("/jobs/job[1]/max_salary")));

        Job j2 = jobs.getJobs().get(1);
        assertEquals(j2.getId(), (document.valueOf("/jobs/job[2]/@id")));
        assertEquals(j2.getTitle(), document.valueOf("/jobs/job[2]/title"));
        assertEquals(j2.getMinSalary(), Long.valueOf(document.valueOf("/jobs/job[2]/min_salary")));
        assertEquals(j2.getMaxSalary(), Long.valueOf(document.valueOf("/jobs/job[2]/max_salary")));

        Job j3 = jobs.getJobs().get(2);
        assertEquals(j3.getId(), (document.valueOf("/jobs/job[3]/@id")));
        assertEquals(j3.getTitle(), document.valueOf("/jobs/job[3]/title"));
        assertEquals(j3.getMinSalary(), Long.valueOf(document.valueOf("/jobs/job[3]/min_salary")));
        assertEquals(j3.getMaxSalary(), Long.valueOf(document.valueOf("/jobs/job[3]/max_salary")));

        Job j4 = jobs.getJobs().get(3);
        assertEquals(j4.getId(), (document.valueOf("/jobs/job[4]/@id")));
        assertEquals(j4.getTitle(), document.valueOf("/jobs/job[4]/title"));
        assertEquals(j4.getMinSalary(), Long.valueOf(document.valueOf("/jobs/job[4]/min_salary")));
        assertEquals(j4.getMaxSalary(), Long.valueOf(document.valueOf("/jobs/job[4]/max_salary")));
    }

    @Test
    public void xmlToJobs() throws JAXBException {
        File f = getClassPathFile("xml/jobs.xml");
        assertTrue(f.exists());
        Jobs unmarhalled = (Jobs) unmarshaller.unmarshal(f);
        Jobs obj = ModelUtils.createFourJobs();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }
}
