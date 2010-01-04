package com.studerb.hr.model;

import static org.junit.Assert.*;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import com.studerb.hr.model.JobHistories;
import com.studerb.hr.model.JobHistory;
import com.studerb.hr.model.ModelUtils;

public class JobHistoriesJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(JobHistoriesJaxbTest.class);

    @Test
    public void JobHistoriesToXml() throws Exception {
        JobHistories jobHistories = ModelUtils.createJobHistories101();
        StringWriter writer = new StringWriter();
        marshaller.marshal(jobHistories, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());

        JobHistory j1 = jobHistories.getJobHistories().get(0);
        assertEquals(j1.getEmployeeId(), Long.valueOf(document.valueOf("/job_histories/job_history[1]/@employee_id")));
        assertTrue(DateUtils.isSameDay(j1.getStartDate(), DatatypeConverter.parseDate(document.valueOf("/job_histories/job_history[1]/@start_date"))));
        assertTrue(DateUtils.isSameDay(j1.getEndDate(), DatatypeConverter.parseDate(document.valueOf("/job_histories/job_history[1]/end_date"))));
        assertEquals(j1.getJobId(), document.valueOf("/job_histories/job_history[1]/job_id"));
        assertEquals(j1.getDepartmentId(), Long.valueOf(document.valueOf("/job_histories/job_history[1]/department_id")));

        JobHistory j2 = jobHistories.getJobHistories().get(1);
        assertEquals(j2.getEmployeeId(), Long.valueOf(document.valueOf("/job_histories/job_history[2]/@employee_id")));
        assertTrue(DateUtils.isSameDay(j2.getStartDate(), DatatypeConverter.parseDate(document.valueOf("/job_histories/job_history[2]/@start_date"))));
        assertTrue(DateUtils.isSameDay(j2.getEndDate(), DatatypeConverter.parseDate(document.valueOf("/job_histories/job_history[2]/end_date"))));
        assertEquals(j2.getJobId(), document.valueOf("/job_histories/job_history[2]/job_id"));
        assertEquals(j2.getDepartmentId(), Long.valueOf(document.valueOf("/job_histories/job_history[2]/department_id")));
    }

    @Test
    public void xmlToJobHistories() throws JAXBException {
        File f = getClassPathFile("xml/jobHistories.xml");
        assertTrue(f.exists());
        JobHistories unmarhalled = (JobHistories) unmarshaller.unmarshal(f);
        JobHistories obj = ModelUtils.createJobHistories101();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }
}
