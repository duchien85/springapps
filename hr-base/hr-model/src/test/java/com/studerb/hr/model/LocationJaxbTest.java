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

public class LocationJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(LocationJaxbTest.class);

    @Test
    public void LocationToXml() throws Exception {
        Location location = ModelUtils.createLocation1000();
        StringWriter writer = new StringWriter();
        marshaller.marshal(location, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());
        assertEquals(location.getId(), Long.valueOf(document.valueOf("/location/@id")));
        assertEquals(location.getStreetAddress(), document.valueOf("/location/street_address"));
        assertEquals(location.getPostalCode(), document.valueOf("/location/postal_code"));
        assertEquals(location.getCity(), document.valueOf("/location/city"));
        assertEquals(location.getStateProvince(), document.valueOf("/location/state_province"));
        assertEquals(location.getCountryId(), document.valueOf("/location/country_id"));
    }

    @Test
    public void xmlToLocation() throws JAXBException {
        File f = getClassPathFile("xml/location.xml");
        assertTrue(f.exists());
        Location unmarhalled = (Location) unmarshaller.unmarshal(f);
        Location obj = ModelUtils.createLocation1000();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }
}
