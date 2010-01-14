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

public class RegionsJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(RegionsJaxbTest.class);

    @Test
    public void RegionsToXml() throws Exception {
        Regions regions = ModelUtils.createThreeRegions();
        StringWriter writer = new StringWriter();
        marshaller.marshal(regions, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());

        Region r1 = regions.getRegions().get(0);
        assertEquals(r1.getId(), Long.valueOf((document.valueOf("/regions/region[1]/@id"))));
        assertEquals(r1.getName(), document.valueOf("/regions/region[1]/name"));

        Region r2 = regions.getRegions().get(1);
        assertEquals(r2.getId(), Long.valueOf(document.valueOf("/regions/region[2]/@id")));
        assertEquals(r2.getName(), document.valueOf("/regions/region[2]/name"));

        Region r3 = regions.getRegions().get(2);
        assertEquals(r3.getId(), Long.valueOf(document.valueOf("/regions/region[3]/@id")));
        assertEquals(r3.getName(), document.valueOf("/regions/region[3]/name"));
    }

    @Test
    public void xmlToRegions() throws JAXBException {
        File f = getClassPathFile("xml/regions.xml");
        assertTrue(f.exists());
        Regions unmarhalled = (Regions) unmarshaller.unmarshal(f);
        Regions obj = ModelUtils.createThreeRegions();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }
}
