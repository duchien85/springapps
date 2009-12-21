package com.studerb.dom4j_test.saxReader;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.studerb.dom4j_test.AbstractUnicodeTest;

/**
 * <p>
 * Tests xml files (full form of message db schema) that do have explicit
 * XML declarations that include encodings against Dom4j's <code>SaxReader</code>.
 * </p>
 * <p>
 * Summary - SaxReader can successfully parse XML
 * files that contain valid declaration, including UTF-8 With Bom.
 * </p>
 * @author Bill Studer
 *
 */
public class MessageDBTest extends AbstractUnicodeTest {
    final static Logger log = Logger.getLogger(MessageDBTest.class);
    SAXReader saxReader;
    Document doc;

    final static String UTF8 = "test-files/xml/messagedb_full/well_formed/declaration/utf8.xml";
    final static String UTF8_BOM = "test-files/xml/messagedb_full/well_formed/declaration/utf8_bom.xml";
    final static String UTF16 = "test-files/xml/messagedb_full/well_formed/declaration/utf16.xml";
    final static String UTF16_BOM = "test-files/xml/messagedb_full/well_formed/declaration/utf16_bom.xml";
    final static String UTF16BE = "test-files/xml/messagedb_full/well_formed/declaration/utf16be.xml";
    final static String UTF16LE = "test-files/xml/messagedb_full/well_formed/declaration/utf16le.xml";
    final static String UTF16BE_BOM = "test-files/xml/messagedb_full/well_formed/declaration/utf16be_bom.xml";
    final static String UTF16LE_BOM = "test-files/xml/messagedb_full/well_formed/declaration/utf16le_bom.xml";

    final static String ESCAPED = "&\u5017\u5019\u501c\u501f\u5022\u505e\u505a\u505e\u5061\u5064&";
    private final String bodyXPath = "/message/message_xml/body_xml_clob/BODY";

    @Before
    public void setup() throws Exception {
        saxReader = new SAXReader();
    }

    @After
    public void teardown() {
        saxReader = null;
        doc = null;
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

    /**
     * SaxReader can detect a utf-8 without bom xml file (with utf8 declaration)
     * in the file regardless of the VM default decoding
     * @throws Exception
     */
    @Test
    public void Utf8Test() throws Exception {
        File xmlFile = getClassPathFile(UTF8);
        doc = saxReader.read(xmlFile);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message, ESCAPED);
    }

    /**
     * SaxReader can detect a utf-8 with bom xml file (with utf8 declaration)
     * in the file regardless of the VM default decoding
     * @throws Exception
     */
    @Test
    public void Utf8BomTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_BOM);
        doc = saxReader.read(xmlFile);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message, ESCAPED);
    }

    /**
     * SaxReader Can detect a utf-16 xml file (with utf-16 declaration without BOM)
     * @throws Exception
     */
    @Test
    public void Utf16Test() throws Exception {
        File xmlFile = getClassPathFile(UTF16);
        doc = saxReader.read(xmlFile);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message, ESCAPED);
    }

    /**
     * SaxReader Can detect a utf-16 xml file (with utf-16 declaration and bom - BE format)
     * @throws Exception
     */
    @Test
    public void Utf16BomTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16_BOM);
        doc = saxReader.read(xmlFile);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message, ESCAPED);
    }


    /**
     * SaxReader Can detect a utf-16BE xml file (with utf-16BE declaration)
     * @throws Exception
     */
    @Test
    public void Utf16BETest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE);
        doc = saxReader.read(xmlFile);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message, ESCAPED);
    }

   /**
     * SaxReader Can detect a utf-16BE xml file (with utf-16BE declarationa
     * and redundant Bom)
     * @throws Exception
     */
    @Test
    public void Utf16BEBomTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM);
        doc = saxReader.read(xmlFile);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message, ESCAPED);
    }

    /**
     * SaxReader Can detect a utf-16LE xml file (with utf-16LE declaration)
     * @throws Exception
     */
    @Test
    public void Utf16LETest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE);
        doc = saxReader.read(xmlFile);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message, ESCAPED);
    }

    /**
     * SaxReader Can detect a utf-16LE xml file (with utf-16LE declaration and
     * redundant Bom)
     * @throws Exception
     */
    @Test
    public void Utf16LEBomTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM);
        doc = saxReader.read(xmlFile);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message, ESCAPED);
    }

}
