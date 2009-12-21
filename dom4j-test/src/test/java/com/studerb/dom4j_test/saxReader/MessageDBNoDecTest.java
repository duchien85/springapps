package com.studerb.dom4j_test.saxReader;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.studerb.dom4j_test.AbstractUnicodeTest;

/**
 * Tests xml files (full form of message db schema) that are missing explicit
 * XML declarations that include encodings against Dom4j's SaxReader.
 * <p>
 * Summary - SaxReader can successfully parse MOST XML files that are missing declaration,
 * including UTF-8 WITH Bom.
 * SaxReader does, however, choke on UTF-16BE and UTF-16LE without BOMS.
 * It can handle UTF16-BE and UTF16-LE when BOMs are used.
 *
 * @author studerw
 *
 */
public class MessageDBNoDecTest extends AbstractUnicodeTest {
    final static Logger log = Logger.getLogger(MessageDBNoDecTest.class);
    SAXReader saxReader;

    final static String UTF8_BOM_NO_DEC = "test-files/xml/messagedb_full/well_formed/no_declaration/utf8_bom_no_dec.xml";
    final static String UTF8_NO_DEC = "test-files/xml/messagedb_full/well_formed/no_declaration/utf8_no_dec.xml";
    final static String UTF16BE_BOM_NO_DEC = "test-files/xml/messagedb_full/well_formed/no_declaration/utf16be_bom_no_dec.xml";
    final static String UTF16LE_BOM_NO_DEC = "test-files/xml/messagedb_full/well_formed/no_declaration/utf16le_bom_no_dec.xml";
    final static String UTF16BE_NO_DEC = "test-files/xml/messagedb_full/well_formed/no_declaration/utf16be_no_dec.xml";
    final static String UTF16LE_NO_DEC = "test-files/xml/messagedb_full/well_formed/no_declaration/utf16le_no_dec.xml";

    final static String ESCAPED = "&\u5017\u5019\u501c\u501f\u5022\u505e\u505a\u505e\u5061\u5064&";
    private final String bodyXPath = "/message/message_xml/body_xml_clob/BODY";

    @Before
    public void setup() throws Exception {
        saxReader = new SAXReader();
    }

    @After
    public void teardown() {
        saxReader = null;
    }

    /**
     * Make sure our files haven't been corrupted by testing byte size of file
     */
    @Test
    public void Utf8fileSizeTest() {
        File Utf8File = getClassPathFile(UTF8_NO_DEC);
        File Utf8BomFile = getClassPathFile(UTF8_BOM_NO_DEC);
        assertEquals(Utf8File.length() + 3, Utf8BomFile.length());
    }

    /**
     * Test UTF16 Bom/NoBom and BE/LE byte sizes.
     * Both UTF-16BE and UTF-16LE should be the same.
     * Both UTF-16BE and UTF-16LE with Boms should be the same
     * UTF-16{BE/LE} should be 2 bytes smaller that the same with Bom
     * UTF-16BOM should be the same as the others with bom
     */
    @Test
    public void Utf16fileSizeTest() {
        File Utf16BEBomFile = getClassPathFile(UTF16BE_BOM_NO_DEC);
        File Utf16LEBomFile = getClassPathFile(UTF16LE_BOM_NO_DEC);
        File Utf16LEFile = getClassPathFile(UTF16LE_NO_DEC);
        File Utf16BEFile = getClassPathFile(UTF16BE_NO_DEC);
        assertEquals(Utf16BEFile.length(), Utf16LEFile.length());
        assertEquals(Utf16BEBomFile.length(), Utf16LEBomFile.length());
        assertEquals(Utf16LEFile.length() + 2, Utf16LEBomFile.length());
        assertEquals(Utf16BEFile.length() + 2, Utf16BEBomFile.length());
    }

    /**
     * SaxReader can detect a utf-8 with bom (i.e. from Windows Notepad) xml file
     * @throws Exception
     */
    @Test
    public void Utf8BomNoDecTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_BOM_NO_DEC);
        Document doc = saxReader.read(xmlFile);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message, ESCAPED);
    }

    /**
     * SaxReader can detect a utf-8 without bom xml file (with no declaration)
     * @throws Exception
     */
    @Test
    public void Utf8NoDecTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_NO_DEC);
        Document doc = saxReader.read(xmlFile);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message, ESCAPED);
    }

    /**
     * SaxReader CAN detect a utf-16BE xml file with bom (with no declaration)
     * @throws Exception
     */
    @Test
    public void Utf16BeBomNoDecTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM_NO_DEC);
        Document doc = saxReader.read(xmlFile);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message, ESCAPED);
    }

    /**
     * SaxReader CAN detect a utf-16LE xml file with bom (with NO declaration)
     * @throws Exception
     */
    @Test
    public void Utf16LeBomNoDecTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM_NO_DEC);
        Document doc = saxReader.read(xmlFile);
        String message = doc.valueOf(bodyXPath);
        assertEquals(message, ESCAPED);
    }

    /**
     * SaxReader CANNOT detect a utf-16-be xml file (with NO declaration)
     * and no BOM
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BeNoDecTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_NO_DEC);
        Document doc = saxReader.read(xmlFile);
        fail("should have thrown exception due to lack of bom");
    }

    /**
     * SaxReader CANNOT detect a utf-16-le xml file (with NO declaration)
     * and no BOM
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LeNoDecTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_NO_DEC);
        Document doc = saxReader.read(xmlFile);
        fail("exception due to lack of dom");
    }
}
