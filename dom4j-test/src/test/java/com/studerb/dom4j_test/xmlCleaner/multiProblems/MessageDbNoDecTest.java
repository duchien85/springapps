package com.studerb.dom4j_test.xmlCleaner.multiProblems;

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
import com.studerb.dom4j_test.XMLCleaner;

/**
 * Tests to make sure <code>XmlCleaner</code> can correclty deal with files
 * that have multiple problems - invalid control characters, undetected (by the JVM)
 * byte order marks, and extra declarations / processing instructions.
 * <p>
 * These tests are specific in that the XML files do not have any leading declarations
 * @author studerw
 *
 */
public class MessageDbNoDecTest extends AbstractUnicodeTest {
    final static Logger log = Logger.getLogger(MessageDbNoDecTest.class);
    Document doc;

    final static String UTF8 = "test-files/xml/messagedb_full/not_well_formed/multi_problems/no_dec/utf8.xml";
    final static String UTF8_BOM = "test-files/xml/messagedb_full/not_well_formed/multi_problems/no_dec/utf8_bom.xml";
    final static String UTF16BE = "test-files/xml/messagedb_full/not_well_formed/multi_problems/no_dec/utf16be.xml";
    final static String UTF16LE = "test-files/xml/messagedb_full/not_well_formed/multi_problems/no_dec/utf16le.xml";
    final static String UTF16_BEBom = "test-files/xml/messagedb_full/not_well_formed/multi_problems/no_dec/utf16_BEBom.xml";
    final static String UTF16_LEBom = "test-files/xml/messagedb_full/not_well_formed/multi_problems/no_dec/utf16_LEBom.xml";

    final static String ESCAPED = "&\u5017\u5019\u501c\u501f\u5022\u505e\u505a\u505e\u5061\u5064&";
    private final String bodyXPath = "/message/message_xml/body_xml_clob/BODY";
    private final int PI_COUNT = 5;
    private final int INVALID_CHARS = 5;

    @Before
    public void setup() throws Exception {
    }

    @After
    public void teardown() {
        doc = null;
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
     * The straight UTF16 files have a 2 byte bom and are 2 bytes
     * smaller than the BE/LE. Without declarations, there are no differences
     * between the encoding declaration strings (e.g. UTF-16 versus UTF-16BE/LE).
     */
    @Test
    public void Utf16fileSize() {
        File Utf16_BEBomFile = getClassPathFile(UTF16_BEBom);
        File Utf16_LEBomFile = getClassPathFile(UTF16_LEBom);
        File Utf16BEFile = getClassPathFile(UTF16BE);
        File Utf16LEFile = getClassPathFile(UTF16BE);
        assertEquals(Utf16BEFile.length(), Utf16LEFile.length());
        assertEquals(Utf16_BEBomFile.length(), Utf16_LEBomFile.length());
        assertEquals(Utf16_BEBomFile.length() - 2, Utf16BEFile.length());
        assertEquals(Utf16_LEBomFile.length() - 2, Utf16LEFile.length());

    }

    @Test
    public void Utf8() throws Exception {
        String xmlString = classPathFileToString(UTF8, "UTF-8");
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertEquals(INVALID_CHARS, cleaner.getRemovedCharCount());
        }
    }

    @Test
    public void Utf8Linux() throws Exception {
        String xmlString = classPathFileToString(UTF8, LINUX_ENCODING);
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertEquals(INVALID_CHARS, cleaner.getRemovedCharCount());
        }
    }

    @Test
    public void Utf8Windows() throws Exception {
        String xmlString = classPathFileToString(UTF8, WINDOWS_ENCODING);
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertEquals(INVALID_CHARS, cleaner.getRemovedCharCount());
        }
    }

    @Test
    public void Utf8Bom() throws Exception {
        String xmlString = classPathFileToString(UTF8_BOM, "UTF-8");
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertEquals(INVALID_CHARS, cleaner.getRemovedCharCount());
            assertTrue(cleaner.isBomRemoved());
        }
    }

    @Test
    public void Utf8BomLinux() throws Exception {
        String xmlString = classPathFileToString(UTF8_BOM, LINUX_ENCODING);
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertEquals(INVALID_CHARS, cleaner.getRemovedCharCount());
            assertTrue(cleaner.isBomRemoved());
        }
    }

    @Test
    public void Utf8BomWindows() throws Exception {
        String xmlString = classPathFileToString(UTF8_BOM, WINDOWS_ENCODING);
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertEquals(INVALID_CHARS, cleaner.getRemovedCharCount());
            assertTrue(cleaner.isBomRemoved());
        }
    }

    @Test
    public void Utf16_BEBom() throws Exception {
        String xmlString = classPathFileToString(UTF16_BEBom, "UTF-16");
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertEquals(INVALID_CHARS, cleaner.getRemovedCharCount());
            assertFalse(cleaner.isBomRemoved());
        }
    }

    @Test
    public void Utf16_BEBomLinux() throws Exception {
        String xmlString = classPathFileToString(UTF16_BEBom, LINUX_ENCODING);
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertTrue(cleaner.isBomRemoved());
        }
    }

    @Test
    public void Utf16_BEBomWindows() throws Exception {
        String xmlString = classPathFileToString(UTF16_BEBom, WINDOWS_ENCODING);
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertTrue(cleaner.isBomRemoved());
        }
    }

    @Test
    public void Utf16_LEBom() throws Exception {
        String xmlString = classPathFileToString(UTF16_LEBom, "UTF-16");
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertEquals(INVALID_CHARS, cleaner.getRemovedCharCount());
            assertFalse(cleaner.isBomRemoved());
        }
    }

    @Test
    public void Utf16_LEBomLinux() throws Exception {
        String xmlString = classPathFileToString(UTF16_LEBom, LINUX_ENCODING);
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertTrue(cleaner.isBomRemoved());
        }
    }

    @Test
    public void Utf16_LEBomWindows() throws Exception {
        String xmlString = classPathFileToString(UTF16_LEBom, WINDOWS_ENCODING);
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertTrue(cleaner.isBomRemoved());
        }
    }

    @Test
    public void Utf16BE() throws Exception {
        String xmlString = classPathFileToString(UTF16BE, "UTF-16BE");
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertEquals(INVALID_CHARS, cleaner.getRemovedCharCount());
        }
    }

    @Test
    public void Utf16BELinux() throws Exception {
        String xmlString = classPathFileToString(UTF16BE, LINUX_ENCODING);
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
        }
    }

    @Test
    public void Utf16BEWindows() throws Exception {
        String xmlString = classPathFileToString(UTF16BE, WINDOWS_ENCODING);
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
        }
    }

    @Test
    public void Utf16LE() throws Exception {
        String xmlString = classPathFileToString(UTF16LE, "UTF-16LE");
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
            assertEquals(INVALID_CHARS, cleaner.getRemovedCharCount());
        }
    }

    @Test
    public void Utf16LELinux() throws Exception {
        String xmlString = classPathFileToString(UTF16LE, LINUX_ENCODING);
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
        }
    }

    @Test
    public void Utf16LEWindows() throws Exception {
        String xmlString = classPathFileToString(UTF16LE, WINDOWS_ENCODING);
        try {
            doc = DocumentHelper.parseText(xmlString);
            fail("should have throw excpetion due to extra xml declaration");
        }
        catch (DocumentException e) {
            XMLCleaner cleaner = new XMLCleaner(xmlString);
            assertTrue(cleaner.isSuccessful());
            doc = cleaner.getDom4JDoc();
            assertNotNull(doc);
            assertEquals(PI_COUNT, cleaner.getRemovedPICount());
        }
    }
}
