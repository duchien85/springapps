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

public class CountriesJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(CountriesJaxbTest.class);

    @Test
    public void CountriesToXml() throws Exception {
        Countries countries = ModelUtils.createThreeCountries();
        StringWriter writer = new StringWriter();
        marshaller.marshal(countries, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());

        Country c1 = countries.getCountries().get(0);
        assertEquals(c1.getId(), (document.valueOf("/countries/country[1]/@id")));
        assertEquals(c1.getName(), document.valueOf("/countries/country[1]/name"));
        assertEquals(c1.getRegionId(), Long.valueOf(document.valueOf("/countries/country[1]/region_id")));

        Country c2 = countries.getCountries().get(1);
        assertEquals(c2.getId(), (document.valueOf("/countries/country[2]/@id")));
        assertEquals(c2.getName(), document.valueOf("/countries/country[2]/name"));
        assertEquals(c2.getRegionId(), Long.valueOf(document.valueOf("/countries/country[2]/region_id")));

        Country c3 = countries.getCountries().get(2);
        assertEquals(c3.getId(), (document.valueOf("/countries/country[3]/@id")));
        assertEquals(c3.getName(), document.valueOf("/countries/country[3]/name"));
        assertEquals(c3.getRegionId(), Long.valueOf(document.valueOf("/countries/country[3]/region_id")));
    }

    @Test
    public void xmlToCountries() throws JAXBException {
        File f = getClassPathFile("xml/countries.xml");
        assertTrue(f.exists());
        Countries unmarhalled = (Countries) unmarshaller.unmarshal(f);
        Countries obj = ModelUtils.createThreeCountries();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }
}
