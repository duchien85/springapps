package com.studerb.dom4j_test.xmlToDomTransformer.pi;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.studerb.dom4j_test.AbstractUnicodeTest;
import com.studerb.dom4j_test.XmlToDomTransformer;

/**
 * Tests that assure <code>XmlToDomTransformer</code> really fails on certain docs
 * with invalid or extra declarations / processing instructions. Other tests
 * make sure that <code>XmlToDomTransformer</code> can clean these up
 * @author studerw
 *
 */
public class MessageDbFailsTest extends AbstractUnicodeTest {
    final static Logger log = Logger.getLogger(MessageDbFailsTest.class);
    XmlToDomTransformer xmlToDomTransformer;
    Document doc;

    final static String UTF8 = "test-files/xml/messagedb_full/not_well_formed/invalid_declaration/utf8.xml";
    final static String UTF8_BOM = "test-files/xml/messagedb_full/not_well_formed/invalid_declaration/utf8_bom.xml";
    final static String UTF16BE = "test-files/xml/messagedb_full/not_well_formed/invalid_declaration/utf16be.xml";
    final static String UTF16LE = "test-files/xml/messagedb_full/not_well_formed/invalid_declaration/utf16le.xml";
    final static String UTF16_BEBom = "test-files/xml/messagedb_full/not_well_formed/invalid_declaration/utf16_BEBom.xml";
    final static String UTF16_LEBom = "test-files/xml/messagedb_full/not_well_formed/invalid_declaration/utf16_LEBom.xml";

    final static String ESCAPED = "&\u5017\u5019\u501c\u501f\u5022\u505e\u505a\u505e\u5061\u5064&";
    private final String bodyXPath = "/message/message_xml/body_xml_clob/BODY";

    @Before
    public void setup() throws Exception {
        this.xmlToDomTransformer = new XmlToDomTransformer();
        this.xmlToDomTransformer.setCleanXml(false);
    }

    @After
    public void teardown() {
        this.xmlToDomTransformer = null;
        this.doc = null;
    }


    /**
     * Make sure our files haven't been corrupted by testing byte size of file
     */
    @Test
    public void Utf8fileSize() {
        File Utf8File = getClassPathFile(UTF8);
        File Utf8BomFile = getClassPathFile(UTF8_BOM);
        assertEquals(Utf8File.length() + 3, Utf8BomFile.length());
    }

    /**
     * The UTF16 file has 4 less bytes due to the difference between the
     * declarations (UTF-16 versus UTF-16BE or UTF-16LE). However, the UTF16
     * file has a 2 byte bom, such that it is 2 bytes smaller than the BE/LE
     * files
     */
    @Test
    public void Utf16fileSize() {
        File Utf16_BEBomFile = getClassPathFile(UTF16_BEBom);
        File Utf16_LEBomFile = getClassPathFile(UTF16_LEBom);
        File Utf16BEFile = getClassPathFile(UTF16BE);
        File Utf16LEFile = getClassPathFile(UTF16BE);
        assertEquals(Utf16BEFile.length(), Utf16LEFile.length());
        assertEquals(Utf16_BEBomFile.length(), Utf16_LEBomFile.length());
        assertEquals(Utf16_BEBomFile.length() + 2, Utf16BEFile.length());
        assertEquals(Utf16_LEBomFile.length() + 2, Utf16LEFile.length());

    }

    @Test(expected = RuntimeException.class)
    public void Utf8Fail() throws Exception {
        String xmlString = classPathFileToString(UTF8, "UTF-8");
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf8LinuxFail() throws Exception {
        String xmlString = classPathFileToString(UTF8, LINUX_ENCODING);
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf8WindowsFail() throws Exception {
        String xmlString = classPathFileToString(UTF8, WINDOWS_ENCODING);
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf8BomFail() throws Exception {
        String xmlString = classPathFileToString(UTF8_BOM, "UTF-8");
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf8BomLinuxFail() throws Exception {
        String xmlString = classPathFileToString(UTF8_BOM, LINUX_ENCODING);
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf8BomWindowsFail() throws Exception {
        String xmlString = classPathFileToString(UTF8_BOM, WINDOWS_ENCODING);
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf16_BEBomFail() throws Exception {
        String xmlString = classPathFileToString(UTF16_BEBom, "UTF-16");
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf16_BEBomLinuxFail() throws Exception {
        String xmlString = classPathFileToString(UTF16_BEBom, LINUX_ENCODING);
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf16_BEBomWindowsFail() throws Exception {
        String xmlString = classPathFileToString(UTF16_BEBom, WINDOWS_ENCODING);
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf16_LEBomFail() throws Exception {
        String xmlString = classPathFileToString(UTF16_LEBom, "UTF-16");
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf16_LEBomLinuxFail() throws Exception {
        String xmlString = classPathFileToString(UTF16_LEBom, LINUX_ENCODING);
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf16_LEBomWindowsFail() throws Exception {
        String xmlString = classPathFileToString(UTF16_LEBom, WINDOWS_ENCODING);
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf16BEFail() throws Exception {
        String xmlString = classPathFileToString(UTF16BE, "UTF-16BE");
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf16BELinuxFail() throws Exception {
        String xmlString = classPathFileToString(UTF16BE, LINUX_ENCODING);
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf16BEWindowsFail() throws Exception {
        String xmlString = classPathFileToString(UTF16BE, WINDOWS_ENCODING);
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf16LEFail() throws Exception {
        String xmlString = classPathFileToString(UTF16LE, "UTF-16LE");
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf16LELinuxFail() throws Exception {
        String xmlString = classPathFileToString(UTF16LE, LINUX_ENCODING);
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

    @Test(expected = RuntimeException.class)
    public void Utf16LEWindowsFail() throws Exception {
        String xmlString = classPathFileToString(UTF16LE, WINDOWS_ENCODING);
        xmlToDomTransformer.evaluate(xmlString);
        fail("Should have thrown RuntimeException due to invalid declaration");
    }

}
