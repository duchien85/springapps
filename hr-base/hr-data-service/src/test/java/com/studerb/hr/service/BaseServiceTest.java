package com.studerb.hr.service;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.jaxen.dom4j.Dom4jXPath;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration( { "classpath:spring/test-context.xml" })
@TransactionConfiguration(defaultRollback = true)
public class BaseServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
    protected JAXBContext context;
    protected Marshaller marshaller;
    protected Unmarshaller unmarshaller;
    protected HashMap<String, String> namespaces;
    protected Dom4jXPath xpath;
    protected Schema schema;

    @Value("${db.employee_count}")
    Integer EMPLOYEE_COUNT;

    @Value("${db.bad_employee_id}")
    Long BAD_EMPLOYEE_ID;

    @PostConstruct
    @Rollback(false)
    public void init() throws Exception {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(getClassPathUrl("xml/hr-model.xsd"));
        context = JAXBContext.newInstance("com.studerb.hr.model");
        marshaller = context.createMarshaller();
        marshaller.setSchema(schema);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "hr-model.xsd");
        unmarshaller = context.createUnmarshaller();
        unmarshaller.setSchema(schema);
        simpleJdbcTemplate.update("call reset_hr_dev()", new Object[] {});
    }

    protected URL getClassPathUrl(String path) throws URISyntaxException {
        URL url = BaseServiceTest.class.getClassLoader().getResource(path);
        return url;
    }

    @Test
    public void checkProps() {
        Assert.assertNotNull(EMPLOYEE_COUNT);
        Assert.assertNotNull(BAD_EMPLOYEE_ID);
    }
}
