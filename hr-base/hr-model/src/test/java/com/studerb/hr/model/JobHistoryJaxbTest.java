package com.studerb.hr.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

public class JobHistoryJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(JobHistoryJaxbTest.class);

    @Test
    public void JobHistoryToXml() throws Exception {
        JobHistory jobHistory = ModelUtils.createJobHistory102();
        logger.debug("JOBHISTORY: -------------\n" + jobHistory);
        StringWriter writer = new StringWriter();
        marshaller.marshal(jobHistory, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());
        assertEquals(jobHistory.getEmployeeId(), Long.valueOf(document.valueOf("/job_history/@employee_id")));
        assertTrue(DateUtils.isSameDay(jobHistory.getStartDate(), DatatypeConverter.parseDate(document.valueOf("/job_history/@start_date"))));
        assertTrue(DateUtils.isSameDay(jobHistory.getEndDate(), DatatypeConverter.parseDate(document.valueOf("/job_history/end_date"))));
        assertEquals(jobHistory.getJobId(), document.valueOf("/job_history/job_id"));
        assertEquals(jobHistory.getDepartmentId(), Long.valueOf(document.valueOf("/job_history/department_id")));

    }

    @Test
    public void xmlToJobHistory() throws JAXBException {
        File f = getClassPathFile("xml/jobHistory.xml");
        assertTrue(f.exists());
        JobHistory unmarhalled = (JobHistory) unmarshaller.unmarshal(f);
        JobHistory obj = ModelUtils.createJobHistory102();
        System.err.println(unmarhalled.getEndDate());
        System.err.println(obj.getEndDate());
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }
}
