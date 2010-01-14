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

public class RegionJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(RegionJaxbTest.class);

    @Test
    public void RegionToXml() throws Exception {
        Region region = ModelUtils.createRegion2();
        StringWriter writer = new StringWriter();
        marshaller.marshal(region, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());
        assertEquals(region.getId(), Long.valueOf(document.valueOf("/region/@id")));
        assertEquals(region.getName(), document.valueOf("/region/name"));
    }

    @Test
    public void xmlToRegion() throws JAXBException {
        File f = getClassPathFile("xml/region.xml");
        assertTrue(f.exists());
        Region unmarhalled = (Region) unmarshaller.unmarshal(f);
        Region obj = ModelUtils.createRegion2();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }
}
