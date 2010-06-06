package com.saic.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

public class BatPersonJaxbTest extends AbstractJaxbTest {

    @Test
    public void BatPersonToXml() throws Exception {
        BatPerson batPerson = new BatPerson("A3S2-SD19S-2FDF-2342");
        StringWriter writer = new StringWriter();
        marshaller.marshal(batPerson, writer);
        log.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());
        assertEquals(document.valueOf("/BatPerson/batGuid"), batPerson.getBatGuid());
    }

    @Test
    public void xmlToEmployee() throws JAXBException {
        File f = getClassPathFile("jaxb/batPerson.xml");
        assertTrue(f.exists());
        BatPerson unmarhalled = (BatPerson) unmarshaller.unmarshal(f);
        BatPerson obj = new BatPerson("A3S2-SD19S-2FDF-2342");
        log.debug("from XML\n" + unmarhalled.toString());
        log.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }

    @Test
    public void treeWalkTest() throws Exception {
        BatPerson batPerson = new BatPerson("A3S2-SD19S-2FDF-2342");
        StringWriter writer = new StringWriter();
        marshaller.marshal(batPerson, writer);
        Document document = DocumentHelper.parseText(writer.toString());
        treeWalk(document);
    }

}
