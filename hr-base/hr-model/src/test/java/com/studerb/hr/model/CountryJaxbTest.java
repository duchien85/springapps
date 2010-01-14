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

public class CountryJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(CountryJaxbTest.class);

    @Test
    public void CountryToXml() throws Exception {
        Country country = ModelUtils.createCountryAR();
        StringWriter writer = new StringWriter();
        marshaller.marshal(country, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());
        assertEquals(country.getId(), (document.valueOf("/country/@id")));
        assertEquals(country.getName(), document.valueOf("/country/name"));
        assertEquals(country.getRegionId(), Long.valueOf(document.valueOf("/country/region_id")));
    }

    @Test
    public void xmlToCountry() throws JAXBException {
        File f = getClassPathFile("xml/country.xml");
        assertTrue(f.exists());
        Country unmarhalled = (Country) unmarshaller.unmarshal(f);
        Country obj = ModelUtils.createCountryAR();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }
}
