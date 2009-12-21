package com.studerb.dom4j_test.xmlToDomTransformer.bom;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.studerb.dom4j_test.AbstractUnicodeTest;
import com.studerb.dom4j_test.XmlToDomTransformer;


/**
 * Test that <code>XmlToDomTransformer</code> can successfully handle
 * files with byte order marks that the JVM cannot itself.
 * @author studerw
 *
 */
public class MessageDBBomTest extends AbstractUnicodeTest {
    final static Logger log = Logger.getLogger(MessageDBBomTest.class);
    XmlToDomTransformer xmlToDomTransformer;
    Document doc;

    final static String UTF8 = "test-files/xml/messagedb_full/well_formed/declaration/utf8.xml";
    final static String UTF8_BOM = "test-files/xml/messagedb_full/well_formed/declaration/utf8_bom.xml";
    final static String UTF16 = "test-files/xml/messagedb_full/well_formed/declaration/utf16.xml";
    final static String UTF16_BOM = "test-files/xml/messagedb_full/well_formed/declaration/utf16_bom.xml";
    final static String UTF16BE = "test-files/xml/messagedb_full/well_formed/declaration/utf16be.xml";
    final static String UTF16LE = "test-files/xml/messagedb_full/well_formed/declaration/utf16le.xml";
    final static String UTF16BE_BOM = "test-files/xml/messagedb_full/well_formed/declaration/utf16be_bom.xml";
    final static String UTF16LE_BOM = "test-files/xml/messagedb_full/well_formed/declaration/utf16le_bom.xml";

    final static String CHINESE = "&\u5017\u5019\u501c\u501f\u5022\u505e\u505a\u505e\u5061\u5064&";
    final static String SUBJECT = "Somali town cleared of radicals";

    private final String CHINESEXPATH = "/message/message_xml/body_xml_clob/BODY";
    private final String SUBJECTXPATH = "/message/message_xml/subject_tx";

    @Before
    public void setup() {
        this.xmlToDomTransformer = new XmlToDomTransformer();
    }

    @After
    public void teardown() {
        this.doc = null;
        this.xmlToDomTransformer = null;
    }

    /**
     * Make sure our files haven't been corrupted by testing byte size of file
     */
    @Test
    public void Utf8fileSizeTest() {
        File Utf8File = getClassPathFile(UTF8);
        File Utf8BomFile = getClassPathFile(UTF8_BOM);
        assertEquals(Utf8File.length() + 3, Utf8BomFile.length());
    }

    /**
     * The UTF16 file has 4 less bytes due to the difference
     * between the declarations (UTF-16 versus UTF-16BE or UTF-16LE).
     * However, the UTF16 file has a 2 byte bom, such that it is
     * 2 bytes smaller than the BE/LE files
     */
    @Test
    public void Utf16fileSizeTest() {
        File Utf16File = getClassPathFile(UTF16);
        File Utf16_BomFile = getClassPathFile(UTF16_BOM);
        File Utf16BEFile = getClassPathFile(UTF16BE);
        File Utf16LEFile = getClassPathFile(UTF16LE);
        File Utf16BE_BomFile = getClassPathFile(UTF16BE_BOM);
        File Utf16LE_BomFile = getClassPathFile(UTF16LE_BOM);

        assertEquals(Utf16BEFile.length(), Utf16LEFile.length());
        assertEquals(Utf16BE_BomFile.length(), Utf16LE_BomFile.length());
        assertEquals(Utf16_BomFile.length(), Utf16File.length() + 2);
        assertEquals(Utf16LE_BomFile.length(), Utf16LEFile.length() + 2);
        assertEquals(Utf16BE_BomFile.length(), Utf16BEFile.length() + 2);
        assertEquals(Utf16File.length() + 6, Utf16LE_BomFile.length());
        assertEquals(Utf16File.length() + 4, Utf16LEFile.length());
    }


    @Test(expected = DocumentException.class)
    public void Utf8BomLinuxFailTest() throws Exception {
        String xmlString = classPathFileToString(UTF8_BOM, LINUX_ENCODING);
        DocumentHelper.parseText(xmlString);
        fail("should have throw excpetion due to bom bytes");
    }

    @Test(expected = DocumentException.class)
    public void Utf8BomWindowsFailTest() throws Exception {
        String xmlString = classPathFileToString(UTF8_BOM, WINDOWS_ENCODING);
        DocumentHelper.parseText(xmlString);
        fail("should have throw excpetion due to bom bytes");
    }

    @Test(expected = DocumentException.class)
    public void Utf16BEBomLinuxFailTest() throws Exception {
        String xmlString = classPathFileToString(UTF16BE_BOM, LINUX_ENCODING);
        DocumentHelper.parseText(xmlString);
        fail("should have throw excpetion due to bom bytes");
    }

    @Test(expected = DocumentException.class)
    public void Utf16BEBomWindowsFailTest() throws Exception {
        String xmlString = classPathFileToString(UTF16BE_BOM, WINDOWS_ENCODING);
        DocumentHelper.parseText(xmlString);
        fail("should have throw excpetion due to bom bytes");
    }

    @Test(expected = DocumentException.class)
    public void Utf16LEBomLinuxFailTest() throws Exception {
        String xmlString = classPathFileToString(UTF16LE_BOM, LINUX_ENCODING);
        DocumentHelper.parseText(xmlString);
        fail("should have throw excpetion due to bom bytes");
    }

    @Test(expected = DocumentException.class)
    public void Utf16LEBomWindowsFailTest() throws Exception {
        String xmlString = classPathFileToString(UTF16LE_BOM, WINDOWS_ENCODING);
        DocumentHelper.parseText(xmlString);
        fail("should have throw excpetion due to bom bytes");
    }


    /**
     * After removing the bom, we are able to get the message
     * as expected since it was encoded using the correct UTF-8
     * encoding.
     * @throws Exception
     */
    @Test
    public void Utf8BomLinuxTest() throws Exception {
        String xmlString = classPathFileToString(UTF8_BOM, LINUX_ENCODING);
        xmlToDomTransformer.setCleanXml(true);
        this.doc = (Document)xmlToDomTransformer.evaluate(xmlString);
        assertNotNull(doc);

        String chinese = doc.valueOf(CHINESEXPATH);
        assertEquals(CHINESE, chinese);
    }

    /**
     * We can at least remove the bom, but since the message
     * was incorrectly decoded into Windows-1252 instead of Utf-8,
     * the high bit Chinese characters are garbled.
     * @throws Exception
     */
    @Test
    public void Utf8BomWindowsTest() throws Exception {
        String xmlString = classPathFileToString(UTF8_BOM, WINDOWS_ENCODING);
        xmlToDomTransformer.setCleanXml(true);
        this.doc = (Document)xmlToDomTransformer.evaluate(xmlString);
        assertNotNull(doc);


        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String chinese = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(chinese));
    }

    /**
     * We can remove the Bom and all the high bit null bytes
     * that were originally ascii characters. However, the 16 bit
     * Chinese chars are completely mangled.
     * @throws Exception
     */
    @Test
    public void Utf16BEBomLinuxTest() throws Exception {
        String xmlString = classPathFileToString(UTF16BE_BOM, LINUX_ENCODING);
        xmlToDomTransformer.setCleanXml(true);
        this.doc = (Document)xmlToDomTransformer.evaluate(xmlString);
        assertNotNull(doc);


        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String message = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(message));
    }


    /**
     * We can remove the Bom and all the high bit null bytes
     * that were originally ascii characters. However, the 16 bit
     * Chinese chars are completely mangled.
     * @throws Exception
     */
    @Test
    public void Utf16BEBomWindowsTest() throws Exception {
        String xmlString = classPathFileToString(UTF16BE_BOM, WINDOWS_ENCODING);
        xmlToDomTransformer.setCleanXml(true);
        this.doc = (Document)xmlToDomTransformer.evaluate(xmlString);
        assertNotNull(doc);

        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String message = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(message));
    }

    /**
     * We can remove the Bom and all the high bit null bytes
     * that were originally ascii characters. However, the 16 bit
     * Chinese chars are completely mangled.
     * @throws Exception
     */
    @Test
    public void Utf16LEBomLinuxTest() throws Exception {
        String xmlString = classPathFileToString(UTF16LE_BOM, LINUX_ENCODING);
        xmlToDomTransformer.setCleanXml(true);
        this.doc = (Document)xmlToDomTransformer.evaluate(xmlString);
        assertNotNull(doc);

        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String message = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(message));
    }


    /**
     * We can remove the Bom and all the high bit null bytes
     * that were originally ascii characters. However, the 16 bit
     * Chinese chars are completely mangled.
     * @throws Exception
     */
    @Test
    public void Utf16LEBomWindowsTest() throws Exception {
        String xmlString = classPathFileToString(UTF16LE_BOM, WINDOWS_ENCODING);
        xmlToDomTransformer.setCleanXml(true);
        this.doc = (Document)xmlToDomTransformer.evaluate(xmlString);
        assertNotNull(doc);

        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String message = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(message));
    }

    /**
     * We can remove the Bom and all the high bit null bytes
     * that were originally ascii characters. However, the 16 bit
     * Chinese chars are completely mangled.
     * @throws Exception
     */
    @Test
    public void Utf16BomLinuxTest() throws Exception {
        String xmlString = classPathFileToString(UTF16_BOM, LINUX_ENCODING);
        xmlToDomTransformer.setCleanXml(true);
        this.doc = (Document)xmlToDomTransformer.evaluate(xmlString);
        assertNotNull(doc);

        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String message = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(message));
    }

    /**
     * We can remove the Bom and all the high bit null bytes
     * that were originally ascii characters. However, the 16 bit
     * Chinese chars are completely mangled.
     * @throws Exception
     */
    @Test
    public void Utf16BomWindowsTest() throws Exception {
        String xmlString = classPathFileToString(UTF16_BOM, WINDOWS_ENCODING);
        xmlToDomTransformer.setCleanXml(true);
        this.doc = (Document)xmlToDomTransformer.evaluate(xmlString);
        assertNotNull(doc);

        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String message = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(message));
    }
}
