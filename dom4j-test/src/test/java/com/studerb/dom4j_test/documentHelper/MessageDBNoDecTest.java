package com.studerb.dom4j_test.documentHelper;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import com.studerb.dom4j_test.AbstractUnicodeTest;
import com.studerb.dom4j_test.UnicodeReader;

/**
 * <p>
 * Tests xml strings (full form of message db schema) that do have explicit
 * XML declarations that include encodings against Dom4j's
 * <code>DocumentHelper.parseText(String xmlString)</code> method.
 * Some of the tests may change the default encoding to Windows-1252 in order
 * to mimic Windows XP's (Server, Vista, ??) default JVM encoding.
 * </p>
 * <P>
 * Summary - <code>DocumentHelper.parseTest</code>, regardless of the JVM encoding,
 * chokes when reading UTF-8 Strings With Bom, even when they have correct declarations.
 * If {@link UnicodeReader#} is used to read in the file, then the method will work, even
 * with a UTF-8 Bom.
 *  </p>
 * @author studerw
 *
 */
public class MessageDBNoDecTest extends AbstractUnicodeTest {
    final static String UTF8_BOM_NO_DEC = "test-files/xml/messagedb_full/well_formed/no_declaration/utf8_bom_no_dec.xml";
    final static String UTF8_NO_DEC = "test-files/xml/messagedb_full/well_formed/no_declaration/utf8_no_dec.xml";
    final static String UTF16BE_BOM_NO_DEC = "test-files/xml/messagedb_full/well_formed/no_declaration/utf16be_bom_no_dec.xml";
    final static String UTF16LE_BOM_NO_DEC = "test-files/xml/messagedb_full/well_formed/no_declaration/utf16le_bom_no_dec.xml";
    final static String UTF16BE_NO_DEC = "test-files/xml/messagedb_full/well_formed/no_declaration/utf16be_no_dec.xml";
    final static String UTF16LE_NO_DEC = "test-files/xml/messagedb_full/well_formed/no_declaration/utf16le_no_dec.xml";
    private final String bodyXPath = "/message/message_xml/body_xml_clob/BODY";

    final static Logger log = Logger.getLogger(MessageDBNoDecTest.class);
    final static String ESCAPED = "&\u5017\u5019\u501c\u501f\u5022\u505e\u505a\u505e\u5061\u5064&";
    final static int MESSAGE_LENGTH = 12;


    /**
     * <code>DocumentHelper</code> will fail in interpreting multibyte characters when
     * Windows-1252 is used to read a UTF-8 xml file
     * @throws Exception
     */
    @Test
    public void Utf8WindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertFalse(message.length() == MESSAGE_LENGTH);
    }


    /**
     * Success when UTF8 is explicitly used to read a UTF-8 xml file
     * @throws Exception
     */
    @Test
    public void Utf8Utf8Test() throws Exception {
        File xmlFile = getClassPathFile(UTF8_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-8");
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.length() == MESSAGE_LENGTH);
    }

    /**
     * Success when Linux encoding is explicitly used to read a
     * UTF-8 xml file - obvious because default Linux encodes with
     * UTF-8 itself
     * @throws Exception
     */
    @Test
    public void Utf8LinuxTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.length() == MESSAGE_LENGTH);
    }


    /**
     * <code>DocumentHelper</code> works with utf8 xml file with utf-8 encoding and
     * <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test
    public void Utf8Utf8UnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-8");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message.length(), MESSAGE_LENGTH);
    }

    /**
     * <code>DocumentHelper</code> works with utf8 xml file with Linux encoding
     * and <code>UnicodeReader</code>, as Linux encodes with UTF-8
     * @throws Exception
     */
    @Test
    public void Utf8LinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message.length(), MESSAGE_LENGTH);
    }

    /**
     * <code>DocumentHelper</code> fails with utf8 xml file with Windowse encoding
     * and <code>UnicodeReader</code> as initial bytes fool
     * up the parser
     * @throws Exception
     */
    @Test
    public void Utf8WindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertFalse(message.length() ==  MESSAGE_LENGTH);
    }

    /**
     * <code>DocumentHelper</code> fails with utf8-bom xml file when using windows encoding
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf8BomWindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_BOM_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("should have thrown Exception due to bom at char position 1");
    }

    /**
     * <code>DocumentHelper</code> fails with utf8-bom xml file when using Linux encoding
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf8BomLinuxTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_BOM_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("should have thrown Exception due to bom at char position 1");
    }


    /**
     * <code>DocumentHelper</code> fails with utf8-bom xml file with utf-8 encoding even
     * when string read with utf8 encoding
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf8BomUtf8Test() throws Exception {
        File xmlFile = getClassPathFile(UTF8_BOM_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-8");
        Document doc = DocumentHelper.parseText(xmlString);
        fail("should have thrown Exception due to bom at char position 1");
    }


    /**
     * <code>DocumentHelper</code> works with utf8-bom xml file with utf-8 encoding
     * using <code>UnicodeReaderb</code>
     * @throws Exception
     */
    @Test
    public void Utf8BomUtf8UnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_BOM_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-8");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message.length(), MESSAGE_LENGTH);
    }

    /**
     * <code>DocumentHelper</code> works with utf8-bom xml file using
     * <code>UnicodeReaderb</code> as the bom is detected correctly
     * @throws Exception
     */
    @Test
    public void Utf8BomWindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_BOM_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message.length(), MESSAGE_LENGTH);
    }

    /**
     * <code>DocumentHelper</code> works with utf8-bom xml file using
     * <code>UnicodeReaderb</code> as the bom is detected correctly
     * @throws Exception
     */
    @Test
    public void Utf8BomLinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_BOM_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message.length(), MESSAGE_LENGTH);
    }


    /**
     * DocumentHelper fails on UTF-16LE file with windows encoding
     * because the multibyte chars get interpreted wrongly
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LEWindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }

    /**
     * <code>DocumentHelper</code> fails on UTF-16LE file with Linux encoding
     * because the multibyte chars get interpreted wrongly
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LELinuxTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }

    /**
     * <code>DocumentHelper</code> succeeds with UTF-16LE xml file when explicity
     * using UTF-16LE encoding to convert to string.
     * @throws Exception
     */
    @Test
    public void Utf16LEUtf16LETest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16LE");
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.length() == MESSAGE_LENGTH);
    }


    /**
     * <code>DocumentHelper</code> works with utf-16LE xml file with utf-16LE and
     * <code>UnicodeReader</code>. Even though bom is not detected,
     * the encoding is correctly used.
     * @throws Exception
     */
    @Test
    public void Utf16LEUtf16LEUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16LE");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message.length(), MESSAGE_LENGTH);
    }

   /**
     * <code>DocumentHelper</code> fails with utf-16LE without Bom and Linux
     * encoding with <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LELinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
    }

    /**
     * <code>DocumentHelper</code> fails with utf-16LE xml file with windows
     * encoding and <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LEWindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
    }


    /**
     * <code>DocumentHelper</code> will fail to read the first line of xml file when UTF16LE
     * is not explicitly used to read a UTF-16 xml file because the multibyte
     * chars on line get interpreted wrong
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LEBomLinuxTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }

    /**
     * <code>DocumentHelper</code> will fail to read the first line of xml file when UTF16LE
     * is not explicitly used to read a UTF-16 xml file because the multibyte
     * chars on line get interpreted wrong
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LEBomWindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }


    /**
     * <code>DocumentHelper</code> fails because JVM does not remove the UTF16LE BOM
     * explicity when UTF16LE is passed as the encoding, and the
     * xml parser views the extra bytes as invalid before the
     * declaration/root element
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LEBomUtf16LETest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16LE");
        Document doc = DocumentHelper.parseText(xmlString);
    }

    /**
     * <code>DocumentHelper</code> works with utf-16LE xml file with utf-16LE and
     * <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test
    public void Utf16LEBomUtf16LEUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16LE");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message.length(), MESSAGE_LENGTH);
    }

    /**
     * <code>DocumentHelper</code> works with utf-16LE xml file with windows
     * encoding and <code>UnicodeReader</code>, as the bom is recognized
     * @throws Exception
     */
    @Test
    public void Utf16LEBomWindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message.length(), MESSAGE_LENGTH);
    }

    /**
     * <code>DocumentHelper</code> works with utf-16LE xml file with linux encoding and
     * <code>UnicodeReader</code>, as the bom is recognized
     * @throws Exception
     */
    @Test
    public void Utf16LEBomLinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message.length(), MESSAGE_LENGTH);
    }


    /**
     * <code>DocumentHelper</code> will fail to read the first line of xml file when UTF16BE
     * is not explicitly used to read a UTF-16 xml file because the multibyte
     * chars before the declaration/root are interpreted wrongly
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BEWindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }

    /**
     * <code>DocumentHelper</code> will fail to read the first line of xml file when UTF16BE
     * is not explicitly used to read a UTF-16 xml file because the multibyte
     * chars before the declaration/root are interpreted wrongly
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BELinuxTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }


    /**
     * DocumentHelper succeeds when UTF-16BE is explicitly
     * used to read a UTF-16BE xml file.
     * @throws Exception
     */
    @Test
    public void Utf16BEUtf16BETest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16BE");
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.length() == MESSAGE_LENGTH);
    }

    /**
     * <code>DocumentHelper</code> works with utf-16BE xml file with utf-16BE and
     * <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test
    public void Utf16BEUtf16BEUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16BE");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message.length(), MESSAGE_LENGTH);
    }

    /**
     * <code>DocumentHelper</code> fails with utf-16BE xml file with windows
     * encoding and <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BEWindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
    }

    /**
     * <code>DocumentHelper</code> fails with utf-16BE xml file with linux encoding
     * and <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BELinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
    }


    /**
     * <code>DocumentHelper</code> will fail to read the first line of xml file when UTF16-BE
     * is not explicitly used to read a UTF-16 xml file because the multibyte
     * chars on line get interpreted wrong
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BEBomWindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }

    /**
     * <code>DocumentHelper</code> will fail to read the first line of xml file when UTF-16BE
     * is not explicitly used to read a UTF-16 xml file because the multibyte
     * chars on line get interpreted wrong
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BEBomLinuxTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }


    /**
     * <code>DocumentHelper</code> fails because BOM is not removed by JVM
     * even when explicity using UTF-16BE encoding
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BEBomUtf16BETest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM_NO_DEC);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16BE");
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed as bom not removed and 1st char in file bad char");
    }


    /**
     * <code>DocumentHelper</code> works with utf-16BE_bom xml file with
     * utf-16BE encoding and <code>UnicodeReader</code>.
     * @throws Exception
     */
    @Test
    public void Utf16BEBomUtf16BEUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16BE");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message.length(), MESSAGE_LENGTH);
    }

    /**
     * <code>DocumentHelper</code> works with utf-16BE xml file with
     * windows encoding and <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test
    public void Utf16BEBomWindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message.length(), MESSAGE_LENGTH);
    }

    /**
     * <code>DocumentHelper</code> works with utf-16BE xml file with linux
     * encoding and <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test
    public void Utf16BEBomLinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM_NO_DEC);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message.length(), MESSAGE_LENGTH);
    }

}
