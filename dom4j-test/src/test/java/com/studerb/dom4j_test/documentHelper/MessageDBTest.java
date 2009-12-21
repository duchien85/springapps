package com.studerb.dom4j_test.documentHelper;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import com.studerb.dom4j_test.AbstractUnicodeTest;
import com.studerb.dom4j_test.UnicodeReader;

/**
 * <p>
 * Tests xml strings (full form of message db schema) that <strong>do have</strong>
 *  explicit XML declarations (with defined encodings) against Dom4j's
 * <code>DocumentHelper.parseText(String xmlString)</code> method.
 * Some of the tests may change the default encoding to Windows-1252 in order
 * to mimic Windows XP's (Server, Vista, ??) default JVM encoding.
 * </p>
 * <p>
 * Summary - <code>DocumentHelper.parseTest</code>, regardless of the JVM encoding,
 * chokes when reading UTF-8 Strings With Bom, even when they have correct declarations.
 * If {@link UnicodeReader#} is used to read in the file, then the method will work, even
 * with a UTF-8 Bom.
 * </p>
 *
 * @author studerw
 *
 */
public class MessageDBTest extends AbstractUnicodeTest {
    final static Logger log = Logger.getLogger(MessageDBTest.class);

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
     * success when UTF8 is explicitly used to read a
     * UTF-8 declared xml file
     * @throws Exception
     */
    @Test
    public void Utf8Test() throws Exception {
        File xmlFile = getClassPathFile(UTF8);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-8");
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    /**
     * success when Linux encoding (UTF8) is explicitly used to read a
     * UTF-8 declared xml file
     * @throws Exception
     */
    @Test
    public void Utf8LinuxTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    /**
     * DocumentHelper will fail in interpreting multibyte characters when Windows-1252
     * is used to read a UTF-8 declated xml file
     * @throws Exception
     */
    @Test
    public void Utf8WindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertFalse(message.equals(ESCAPED));
    }

    /**
     * DocmentHelper works with utf8 xml file with utf-8 declaration
     * @throws Exception
     */
    @Test
    public void Utf8UnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-8");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }


    /**
     * DocmentHelper works with utf8 xml file with utf-8 declaration
     * @throws Exception
     */
    @Test
    public void Utf8LinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    /**
     *
     * DocmentHelper can actually create the xml file, but fails to
     * read correctly the utf8 xml with default windows encoding and
     * <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test
    public void Utf8WindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertFalse(message.equals(ESCAPED));
    }

    /**
     * DocmentHelper fails with utf8-bom xml file with utf-8 declaration even
     * when string read with UTF-8 encoding
     * @throws Exception
     */
    @Test/*(expected = DocumentException.class)*/
    public void Utf8BomTest() throws Exception {
        try {
        File xmlFile = getClassPathFile(UTF8_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-8");
        Document doc = DocumentHelper.parseText(xmlString);
        //fail("should have thrown Exception due to bom at char position 1");
        }
        catch (Exception e) {
            System.err.println(ExceptionUtils.getRootCauseMessage(e));
        }
    }

    /**
     * DocmentHelper fails with utf8-bom xml file with utf-8 declaration even
     * when string read with Linux (UTF-8) encoding
     * @throws Exception
     */
    @Test/*(expected = DocumentException.class)*/
    public void Utf8BomLinuxTest() throws Exception {
        try {
        File xmlFile = getClassPathFile(UTF8_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        //fail("should have thrown Exception due to bom at char position 1");

        }
        catch (Exception e) {
          System.err.println(ExceptionUtils.getRootCauseMessage(e));
        }
    }

    /**
     * DocmentHelper fails with utf8-bom xml file with utf-8 declaration
     * when string read with non-utf8 encoding
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf8BomWindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("should have thrown Exception due to bom at char position 1");
    }

    /**
     * DocmentHelper works with utf8-bom xml file with utf-8 declaration regardless
     * of the VM default encoding using UnicodeReader
     * @throws Exception
     */
    @Test
    public void Utf8BomUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-8");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    /**
     * DocmentHelper works with utf8-bom xml file with utf-8 declaration regardless
     * of the VM default encoding using UnicodeReader
     * @throws Exception
     */
    @Test
    public void Utf8BomLinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    /**
     * DocmentHelper works with utf8-bom xml file with utf-8 declaration regardless
     * of the VM default encoding using UnicodeReader
     * @throws Exception
     */
    @Test
    public void Utf8BomWindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }


    /**
     * DocumentHelper succeeds when using explicity when UTF16BE is explicitly
     * used to read a UTF-16BE declared xml file
     * @throws Exception
     */
    @Test
    public void Utf16BETest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16BE");
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    /**
     * DocumentHelper will fail to read the first line of xml file when UTF16BE
     * is not explicitly used to read a UTF-16BE declared xml file because the
     * multibyte chars on line get interpreted wrong
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BELinuxTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to extra chars");
    }

    /**
     * DocumentHelper will fail to read the first line of xml file when UTF16BE
     * is not explicitly used to read a UTF-16BE declared xml file because the
     * multibyte chars on line get interpreted wrong
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BEWindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to extra chars");
    }

    /**
     * This succeeds whereas the same try with a UTF16LE
     * encoded file fails. This is due to UTF-16BE being
     * assumed when not explicitly used.
     * @throws Exception
     */
    @Test
    public void Utf16BEUtf16Test() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16");
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }


    /**
     * DocmentHelper works with utf-16BE xml file with utf-16BE declaration and
     * <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test
    public void Utf16BEUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16BE");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    /**
     * DocmentHelper fails with utf-16BE xml file with Linux encoding and
     * <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BELinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to extra chars");
    }

    /**
     * DocmentHelper fails with utf-16BE xml with windows encoding and
     * <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BEWindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to extra chars");
    }

    /**
     * JVM is able to encode the doc correctly without explicit endian defined.
     * @throws Exception
     */
    @Test
    public void Utf16BEUtf16UnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }


    /**
     * JVM fails on interpreting (and removing Bom) - thus
     * DocuemntHelper chokes on the BOM character (\ufeff)
     * before the declaration / initial root element.
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BEBomTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16BE");
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to extra chars");
    }

    /**
     * JVM fails on interpreting BOM since wrong encoding used.
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BEBomLinuxTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to extra chars");
    }

    /**
     * JVM fails on interpreting BOM since wrong encoding used.
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16BEBomWindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to extra chars");
    }

    /**
     * JVM actually removes BOM and decodes in UTF-16BE
     * In contrast, using encoding UTF-16BE, JVM chokes
     * as it doesn't expect the BOM.
     * @throws Exception
     */
    @Test
    public void Utf16BEBomUtf16Test() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16");
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }


    /**
     * <code>UnicodeReader</code> saves the day by detecting the BOM
     * and explicitly changing encoding (which wasn't needed, actually)
     * to UTF-16BE which JVM can interpret now that the Bom has been removed.
     * @throws Exception
     */
    @Test
    public void Utf16BEBomUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16BE");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    /**
     * <code>UnicodeReader</code> saves the day by detecting the BOM
     * and explicitly changing encoding to UTF-16BE which JVM can interpret
     * now that the Bom has been removed.
     * @throws Exception
     */
    @Test
    public void Utf16BEBomLinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    /**
     * <code>UnicodeReader</code> saves the day by detecting the BOM
     * and explicitly changing encoding to UTF-16BE which JVM can interpret
     * now that the Bom has been removed.
     * @throws Exception
     */
    @Test
    public void Utf16BEBomWindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    /**
     * <code>UnicodeReader</code> saves the day by detecting the BOM
     * and explicitly changing encoding to UTF-16BE which JVM can interpret
     * now that the Bom has been removed.
     * @throws Exception
     */
    @Test
    public void Utf16BEBomUtf16UnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16BE_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    /**
     * JVM able to correclty interpret UTF-16LE without Bom. Thus
     * DocmentHelper succeeds with utf-16LE declared xml file.
     * @throws Exception
     */
    @Test
    public void Utf16LETest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16LE");
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }


    /**
     * DocumentHelper will fail to read the first line of xml file when
     * UTF16LE is not explicitly used to read a UTF-16 declared xml file
     * because the multibyte chars on first line get interpreted wrong
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LELinuxTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }

    /**
     * DocumentHelper will fail to read the first line of xml file when
     * UTF16LE is not explicitly used to read a UTF-16 declared xml file
     * because the multibyte chars on first line get interpreted wrong
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LEWindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }


    /**
     * Fails because of UTF-16 assumes Big Endian
     * and the file is encoded Little Endian
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LEUtf16Test() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16");
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 due to wrong endian encoding");
    }

    /**
     * DocmentHelper works with utf-16LE xml file with utf-16LE declaration and
     * <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test
    public void Utf16LEUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16LE");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }


    /**
     * DocmentHelper works with utf-16LE declared xml file with Linux
     * encodingd and <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LELinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("should have thrown Exception due to extra chars at beginning");
    }


    /**
     * DocmentHelper fails with utf-16LE xml file with Windows encoding and
     * <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LEWindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("should have thrown Exception due to extra chars at beginning");
    }


    @Test(expected = DocumentException.class)
    public void Utf16LEUtf16UnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }

    @Test(expected = DocumentException.class)
    public void Utf16LEBomTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16LE");
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }


    @Test(expected = DocumentException.class)
    public void Utf16LEBomLinuxTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }


    @Test(expected = DocumentException.class)
    public void Utf16LEBomWindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("Should have failed on line 1 String due to UTF16 BOM");
    }


    @Test
    public void Utf16LEBomUtf16Test() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16");
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    @Test
    public void Utf16LEBomUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16LE");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }


    @Test
    public void Utf16LEBomLinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    @Test
    public void Utf16LEBomWindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }


    @Test
    public void Utf16LEBomUtf16UnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16LE_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }


    /**
     * DocumentHelper succeeds when using explicity when UTF16 is
     * explicitly used to read a UTF-16 declared xml file
     * @throws Exception
     */
    @Test
    public void Utf16Test() throws Exception {
        File xmlFile = getClassPathFile(UTF16);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16");
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    /**
     * DocumentHelper will fail to read the first line of xml file when UTF16
     * is not explicitly used to read a UTF-16 declared xml file because the
     * multibyte chars on line get interpreted wrong
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16LinuxTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("should have thrown Exception due to bom at char position 1");
    }


    /**
     * DocumentHelper fails when Windows encoding is
     * used to read a UTF-16 declared xml file
     * @throws Exception
     */
    @Test(expected = DocumentException.class)
    public void Utf16WindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("should have thrown Exception due to bom at char position 1");
    }


    /**
     * DocmentHelper works with utf16 xml file with utf-16 explicityly
     * declared encoding and <code>UnicodeReader</code>
     * @throws Exception
     */
    @Test
    public void Utf16UnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    @Test(expected = DocumentException.class)
    public void Utf16LinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("should have thrown Exception due to bom at char position 1");
    }


    @Test(expected = DocumentException.class)
    public void Utf16WindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("should have thrown Exception due to bom at char position 1");
    }

    @Test
    public void Utf16BomTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, "UTF-16");
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    @Test(expected = DocumentException.class)
    public void Utf16BomLinuxTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, LINUX_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("should have thrown Exception due to bom at char position 1");
    }


    @Test(expected = DocumentException.class)
    public void Utf16BomWindowsTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16_BOM);
        String xmlString = FileUtils.readFileToString(xmlFile, WINDOWS_ENCODING);
        Document doc = DocumentHelper.parseText(xmlString);
        fail("should have thrown Exception due to bom at char position 1");
    }


    @Test
    public void Utf16BomUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, "UTF-16");
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    @Test
    public void Utf16BomLinuxUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, LINUX_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }

    @Test
    public void Utf16BomWindowsUnicodeReaderTest() throws Exception {
        File xmlFile = getClassPathFile(UTF16_BOM);
        FileInputStream fis = new FileInputStream(xmlFile);
        UnicodeReader reader = new UnicodeReader(fis, WINDOWS_ENCODING);
        String xmlString = IOUtils.toString(reader);
        Document doc = DocumentHelper.parseText(xmlString);
        String message = doc.valueOf(bodyXPath);
        assertTrue(message.equals(ESCAPED));
    }
}
