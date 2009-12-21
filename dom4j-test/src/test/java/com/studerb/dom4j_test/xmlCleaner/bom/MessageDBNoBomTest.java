package com.studerb.dom4j_test.xmlCleaner.bom;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.After;
import org.junit.Test;

import com.studerb.dom4j_test.AbstractUnicodeTest;
import com.studerb.dom4j_test.XMLCleaner;


/**
 * Check that XmlCleaner can handle XML files without BOMS, even if some are required
 *
 * @author studerw
 *
 */
public class MessageDBNoBomTest extends AbstractUnicodeTest {
    final static Logger log = Logger.getLogger(MessageDBNoBomTest.class);
    XMLCleaner xmlCleaner;
    Document doc;

    final static String UTF8 = "test-files/xml/messagedb_full/well_formed/declaration/utf8.xml";
    final static String UTF8_BOM = "test-files/xml/messagedb_full/well_formed/declaration/utf8_bom.xml";
    final static String UTF16 = "test-files/xml/messagedb_full/well_formed/declaration/utf16.xml";
    final static String UTF16BE = "test-files/xml/messagedb_full/well_formed/declaration/utf16be.xml";
    final static String UTF16LE = "test-files/xml/messagedb_full/well_formed/declaration/utf16le.xml";

    final static String CHINESE = "&\u5017\u5019\u501c\u501f\u5022\u505e\u505a\u505e\u5061\u5064&";
    final static String SUBJECT = "Somali town cleared of radicals";

    private final String CHINESEXPATH = "/message/message_xml/body_xml_clob/BODY";
    private final String SUBJECTXPATH = "/message/message_xml/subject_tx";

    @After
    public void teardown() {
        doc = null;
        xmlCleaner = null;
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
        File Utf16BEFile = getClassPathFile(UTF16BE);
        File Utf16LEFile = getClassPathFile(UTF16LE);

        assertEquals(Utf16BEFile.length(), Utf16LEFile.length());
        assertEquals(Utf16File.length() + 4, Utf16LEFile.length());
    }


    @Test(expected = DocumentException.class)
    public void Utf16BELinuxFailTest() throws Exception {
        String xmlString = classPathFileToString(UTF16BE, LINUX_ENCODING);
        DocumentHelper.parseText(xmlString);
        fail("should have throw excpetion due to beginning bytes");
    }

    @Test(expected = DocumentException.class)
    public void Utf16BEWindowsFailTest() throws Exception {
        String xmlString = classPathFileToString(UTF16BE, WINDOWS_ENCODING);
        DocumentHelper.parseText(xmlString);
        fail("should have throw excpetion due to beginning bytes");
    }


    @Test(expected = DocumentException.class)
    public void Utf16LELinuxFailTest() throws Exception {
        String xmlString = classPathFileToString(UTF16LE, LINUX_ENCODING);
        DocumentHelper.parseText(xmlString);
        fail("should have throw excpetion due to bom bytes");
    }

    @Test(expected = DocumentException.class)
    public void Utf16LEWindowsFailTest() throws Exception {
        String xmlString = classPathFileToString(UTF16LE, WINDOWS_ENCODING);
        DocumentHelper.parseText(xmlString);
        fail("should have throw excpetion due to bom bytes");
    }


    /**
     * This won't even need cleaning, just test to make
     * sure that XmlCleaner works on valid XML Strings
     * @throws Exception
     */
    @Test
    public void Utf8LinuxTest() throws Exception {
        String xmlString = classPathFileToString(UTF8, LINUX_ENCODING);
        xmlCleaner = new XMLCleaner(xmlString);
        assertTrue(xmlCleaner.isSuccessful());
        Document doc = xmlCleaner.getDom4JDoc();
        String chinese = doc.valueOf(CHINESEXPATH);
        assertEquals(CHINESE, chinese);
    }

    /**
     * The cleaner again doesn't even need cleaning,
     * however, high bit chars (outside of ascii range)
     * are mangled. Depending on the actual high bit chars,
     * some illegal chars might be removed.
     * @throws Exception
     */
    @Test
    public void Utf8WindowsTest() throws Exception {
        String xmlString = classPathFileToString(UTF8, WINDOWS_ENCODING);
        xmlCleaner = new XMLCleaner(xmlString);
        assertTrue(xmlCleaner.isSuccessful());
        Document doc = xmlCleaner.getDom4JDoc();

        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String chinese = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(chinese));
    }


    /**
     * No Bom needing removal, but all the null
     * high byte null chars are removed. High Bit
     * Chinese chars are mangled.
     * @throws Exception
     */
    @Test
    public void Utf16BELinuxTest() throws Exception {
        String xmlString = classPathFileToString(UTF16BE, LINUX_ENCODING);
        xmlCleaner = new XMLCleaner(xmlString);
        assertTrue(xmlCleaner.isSuccessful());
        Document doc = xmlCleaner.getDom4JDoc();

        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String message = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(message));
    }

    /**
     * No Bom needing removal, but all the null
     * high byte null chars are removed. High Bit
     * Chinese chars are mangled.
     * @throws Exception
     */
    @Test
    public void Utf16BEWindowsTest() throws Exception {
        String xmlString = classPathFileToString(UTF16BE, WINDOWS_ENCODING);
        xmlCleaner = new XMLCleaner(xmlString);
        assertTrue(xmlCleaner.isSuccessful());
        Document doc = xmlCleaner.getDom4JDoc();

        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String message = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(message));
    }


    /**
     * No Bom needing removal, but all the null
     * high byte null chars are removed. High Bit
     * Chinese chars are mangled.
     * @throws Exception
     */
    @Test
    public void Utf16LELinuxTest() throws Exception {
        String xmlString = classPathFileToString(UTF16LE, LINUX_ENCODING);
        xmlCleaner = new XMLCleaner(xmlString);
        assertTrue(xmlCleaner.isSuccessful());
        Document doc = xmlCleaner.getDom4JDoc();

        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String message = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(message));
    }


    @Test
    public void Utf16LEWindowsTest() throws Exception {
        String xmlString = classPathFileToString(UTF16, WINDOWS_ENCODING);
        xmlCleaner = new XMLCleaner(xmlString);
        assertTrue(xmlCleaner.isSuccessful());
        Document doc = xmlCleaner.getDom4JDoc();

        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String message = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(message));
    }


    @Test
    public void Utf16LinuxTest() throws Exception {
        String xmlString = classPathFileToString(UTF16, LINUX_ENCODING);
        xmlCleaner = new XMLCleaner(xmlString);
        assertTrue(xmlCleaner.isSuccessful());
        Document doc = xmlCleaner.getDom4JDoc();

        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String message = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(message));
    }

    @Test
    public void Utf16WindowsTest() throws Exception {
        String xmlString = classPathFileToString(UTF16, WINDOWS_ENCODING);
        xmlCleaner = new XMLCleaner(xmlString);
        assertTrue(xmlCleaner.isSuccessful());
        Document doc = xmlCleaner.getDom4JDoc();

        String subject = doc.valueOf(SUBJECTXPATH);
        assertEquals(SUBJECT, subject);

        String message = doc.valueOf(CHINESEXPATH);
        assertFalse(CHINESE.equals(message));
    }
}
