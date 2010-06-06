package com.saic.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

public class BatPersonsJaxbTest extends AbstractJaxbTest {

    @Test
    public void BatPersonsToXml() throws Exception {
        BatPersons batPersons = createThreeBatPersons();
        StringWriter writer = new StringWriter();
        marshaller.marshal(batPersons, writer);
        log.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());
        assertEquals(Integer.valueOf(document.valueOf("/BatPersons/@count")), new Integer(3));
        assertEquals("A3S2-SD19S-2FDF-2342", document.valueOf("/BatPersons/BatPerson[1]/batGuid"));
        assertEquals("B3S2-SD19S-2FDF-2342", document.valueOf("/BatPersons/BatPerson[2]/batGuid"));
        assertEquals("C3S2-SD19S-2FDF-2342", document.valueOf("/BatPersons/BatPerson[3]/batGuid"));
    }

    @Test
    public void xmlToBatPersons() throws JAXBException {
        File f = getClassPathFile("jaxb/batPersons.xml");
        assertTrue(f.exists());
        BatPersons unmarhalled = (BatPersons) unmarshaller.unmarshal(f);
        BatPerson obj = new BatPerson("A3S2-SD19S-2FDF-2342");
        assertEquals(obj, unmarhalled.getBatPersons().get(0));
        obj = new BatPerson("B3S2-SD19S-2FDF-2342");
        assertEquals(obj, unmarhalled.getBatPersons().get(1));
        obj = new BatPerson("C3S2-SD19S-2FDF-2342");
        assertEquals(obj, unmarhalled.getBatPersons().get(2));
        log.debug("from XML\n" + unmarhalled.toString());
    }

    @Test
    public void treeWalkTest() throws Exception {
        BatPersons batPersons = createThreeBatPersons();
        StringWriter writer = new StringWriter();
        marshaller.marshal(batPersons, writer);
        Document document = DocumentHelper.parseText(writer.toString());
        treeWalk(document);
    }

    protected BatPersons createThreeBatPersons() {
        BatPersons batPersons = new BatPersons();
        batPersons.getBatPersons().add(new BatPerson("A3S2-SD19S-2FDF-2342"));
        batPersons.getBatPersons().add(new BatPerson("B3S2-SD19S-2FDF-2342"));
        batPersons.getBatPersons().add(new BatPerson("C3S2-SD19S-2FDF-2342"));
        return batPersons;
    }

}
