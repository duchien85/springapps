package com.studerb.dom4j_test.xmlCleaner.pi;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import com.studerb.dom4j_test.AbstractUnicodeTest;
import com.studerb.dom4j_test.XMLCleaner;


/**
 * Simple test to make sure the PI regex is working in XmlCleaner
 * @author studerw
 *
 */
public class SimplePITest extends AbstractUnicodeTest{
    private static final Logger log = Logger.getLogger(SimplePITest.class);

    @Test(expected = DocumentException.class)
    public void testSimpleFail() throws Exception {
        String xmlString = classPathFileToString("test-files/xml/declaration/simple_utf8.xml");
        Document doc = DocumentHelper.parseText(xmlString);
        fail("should have failed due to multi declarations...");
    }

    @Test
    public void testSimpleClean() throws Exception {
        String xmlString = classPathFileToString("test-files/xml/declaration/simple_utf8.xml");
        XMLCleaner xmlCleaner = new XMLCleaner(xmlString);
        assertTrue(xmlCleaner.isSuccessful());
    }
}
