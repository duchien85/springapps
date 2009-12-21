package com.studerb.dom4j_test.unicode;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.studerb.dom4j_test.AbstractUnicodeTest;
import com.studerb.dom4j_test.UnicodeReader;

/**
 * <p>
 * Tests the JVMs standard ability to successfully import files with Unicode
 * characters in multiple encodings using various classes, while also simulating
 * the default Linux and Windows XP environments with regard to encoding.
 * For example, the default encoding on Windows XP is <code>windows-1252</code>
 * while on Linux it is <code>UTF-8</code>. This can be determined by viewing the
 * System Property with key <code>file.encoding</code>
 * </p>
 * <p>
 * For this test, a simple file
 * encoding is explicity set on converting a file, socket, etc into a String.
 * UTF8 with Boms (i.e. from Windows Notepad) always fail unless the imported
 * {@ link UnicodeReader UniocdeReader} is used. Even <code>UnicodeReader</code>
 * chokes on Windows machines (using <code>Windows-1252</code> encoding) when
 * the correct encoding is not explicitly passed to the method converting
 * bytes to characters.
 * </p>
 * @author studerw
 *
 */
public class TwentyUnicodeTest extends AbstractUnicodeTest {
    private final static Logger log = Logger.getLogger(TwentyUnicodeTest.class);

    final static String UTF8_BOM = "test-files/unicode/twenty_random/utf8_bom.txt";
    final static String UTF8 = "test-files/unicode/twenty_random/utf8.txt";
    final static String UTF16LE = "test-files/unicode/twenty_random/utf16le.txt";
    final static String UTF16BE = "test-files/unicode/twenty_random/utf16be.txt";
    final static String UTF16LE_BOM = "test-files/unicode/twenty_random/utf16le_bom.txt";
    final static String UTF16BE_BOM = "test-files/unicode/twenty_random/utf16be_bom.txt";

    final static int NUM_CHARS = 21;
    final static String ESCAPED = "!\u00e6\u019b\u01fe\u02a8\u0411\u0634\u0b9a\u0ceb\u1136\u1eda\u210d\u22d9\u2629\u2602\u2622\u2785\u04c1\u054f\u229e\n";

    @BeforeClass
    public static void beforeClass() {
        AbstractUnicodeTest.beforeClass();
        log.info("Testing a Twenty-Random-Unicode-Character String: " + ESCAPED);
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
     * The UTF-16 without Bom files should be equal.
     * The UTF-16 Bom files should be equal
     * The files without boms should be 2 bytes less than
     * those same files with Bom
     */
    @Test
    public void Utf16fileSizeTest() {
        File Utf16BEFile = getClassPathFile(UTF16BE);
        File Utf16LEFile = getClassPathFile(UTF16BE);
        File Utf16BEBomFile = getClassPathFile(UTF16BE_BOM);
        File Utf16LEBomFile = getClassPathFile(UTF16LE_BOM);
        assertEquals(Utf16BEFile.length(), Utf16LEFile.length());
        assertEquals(Utf16BEBomFile.length(), Utf16LEBomFile.length());
        assertEquals(Utf16BEFile.length() + 2, Utf16LEBomFile.length());
        assertEquals(Utf16LEFile.length() + 2, Utf16LEBomFile.length());
    }


    /**
     * UTF-8 without Bom works when correct encoding set
     * @throws IOException
     */
    @Test
    public void Utf8Test() throws IOException {
        File file = getClassPathFile(UTF8);
        String decodedString = FileUtils.readFileToString(file, "UTF-8");
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-8 file works using UTF-8. Same as if running on a Linux machine and
     * no encoding specified (uses default)
     * @throws IOException
     */
    @Test
    public void Utf8LinuxTest() throws IOException {
        File file = getClassPathFile(UTF8);
        String decodedString = FileUtils.readFileToString(file, LINUX_ENCODING);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-8 Fails with incorrect encoding set. Same as if running
     * on a Windows XP machine and no encoding specified (uses default)
     * @throws IOException
     */
    @Test
    public void Utf8WindowsTest() throws IOException {
        File file = getClassPathFile(UTF8);
        String decodedString = FileUtils.readFileToString(file, WINDOWS_ENCODING);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }


    /**
     * UTF-8 without Bom works correctly with <code>UnicodeReader</code>
     * and correct encoding
     * @throws IOException
     */
    @Test
    public void Utf8UnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF8);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), "UTF-8");
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-8 works when using UTF-8 encoding with UnicodeReader.
     * Same as if running on Linux using default encoding
     * @throws IOException
     */
    @Test
    public void Utf8LinuxUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF8);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), LINUX_ENCODING);
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-8 fails when using Windows-1252 encoding even with UnicodeReader
     * Same as if running on Windows XP using default encoding
     * @throws IOException
     */
    @Test
    public void Utf8WindowsUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF8);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), WINDOWS_ENCODING);
        String decodedString = IOUtils.toString(reader);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-8 With Bom (e.g. Windows Notepad) FAILS even with correct encoding set
     * @throws IOException
     */
    @Test
    public void Utf8BomTest() throws IOException {
        File file = getClassPathFile(UTF8_BOM);
        String decodedString = FileUtils.readFileToString(file, "UTF-8");
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-8 With Bom (e.g. Windows Notepad) FAILS while running using UTF8.
     * Same as if running on a Linux machine and no encoding specified
     * (uses default <code>file.encoding</code>
     * @throws IOException
     */
    @Test
    public void Utf8BomLinuxTest() throws IOException {
        File file = getClassPathFile(UTF8_BOM);
        String decodedString = FileUtils.readFileToString(file, LINUX_ENCODING);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-8 With Bom (e.g. Windows Notepad) FAILS with incorrect encoding set
     * Same as if running on a Windows XP machine and no encoding specified
     * (uses default <code>file.encoding</code>
     * @throws IOException
     */
    @Test
    public void Utf8BomWindowsTest() throws IOException {
        File file = getClassPathFile(UTF8_BOM);
        String decodedString = FileUtils.readFileToString(file, WINDOWS_ENCODING);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }


    /**
     * UTF-8 with Bom works when correct encoding and <code>UnicodeReader</code>
     * @throws IOException
     */
    @Test
    public void Utf8BomUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF8_BOM);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), "UTF-8");
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-8 with Bom works with encoding as if running on Linux using
     * default encoding
     *
     * @throws IOException
     */
    @Test
    public void Utf8BomLinuxUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF8_BOM);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), LINUX_ENCODING);
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-8 with Bom works even when using incorrect Windows-1252 encoding
     * but using UnicodeReader. Same as if running on Windows XP using
     * default encoding
     *
     * @throws IOException
     */
    @Test
    public void Utf8BomWindowsUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF8_BOM);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), WINDOWS_ENCODING);
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }


   /**
     * UTF-16BE works with correct encoding provided
     * @throws IOException
     */
    @Test
    public void Utf16BETest() throws IOException {
        File file = getClassPathFile(UTF16BE);
        String decodedString = FileUtils.readFileToString(file, "UTF-16BE");
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-16BE does not work when using UTF-8 (Linux Default) encoding
     * @throws IOException
     */
    @Test
    public void Utf16BELinuxTest() throws IOException {
        File file = getClassPathFile(UTF16BE);
        String decodedString = FileUtils.readFileToString(file, LINUX_ENCODING);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-16BE does not work when encoding set incorrectly
     * @throws IOException
     */
    @Test
    public void Utf16BEWindowsTest() throws IOException {
        File file = getClassPathFile(UTF16BE);
        String decodedString = FileUtils.readFileToString(file, WINDOWS_ENCODING);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    @Test
    public void Utf16BEUtf16Test() throws IOException {
        File file = getClassPathFile(UTF16BE);
        String decodedString = FileUtils.readFileToString(file, "UTF-16");
        assertTrue(decodedString.length() == NUM_CHARS);
        assertTrue(decodedString.equals(ESCAPED));
    }

    /**
     * UTF16-BE works correctly when correct encoding used with UnicodeReader
     * even without bom
     * @throws IOException
     */
    @Test
    public void Utf16BEUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16BE);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), "UTF-16BE");
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-16 (BE) fails when using UTF-8 (Linux Default) encoding
     * even with UnicodeReader
     * @throws IOException
     */
    @Test
    public void Utf16BELinuxUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16BE);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), LINUX_ENCODING);
        String decodedString = IOUtils.toString(reader);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-16 (BE) fails when using Windows-1252 encoding even with UnicodeReader
     * @throws IOException
     */
    @Test
    public void Utf16BEWindowsUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16BE);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), WINDOWS_ENCODING);
        String decodedString = IOUtils.toString(reader);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }


    /**
     * Utf-16BE file without bom is decoded successfully using
     * just Utf-16 (not UTF-16BE encoding) because when a bom
     * is not used on UTF-16, Big Endian is assumed
     * @throws IOException
     */
    @Test
    public void Utf16BEUtf16UnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16BE);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), "UTF-16");
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-16BE with bom fails with correct encoding provided
     * @throws IOException
     */
    @Test
    public void Utf16BEBomTest() throws IOException {
        File file = getClassPathFile(UTF16BE_BOM);
        String EncodedString = FileUtils.readFileToString(file, "UTF-16BE");
        assertFalse(EncodedString.length() == NUM_CHARS);
        assertFalse(EncodedString.equals(ESCAPED));
    }


    /**
     * UTF-16BE with bom does not work when using UTF-8 (Linux default) encoding
     * @throws IOException
     */
    @Test
    public void Utf16BEBomLinuxTest() throws IOException {
        File file = getClassPathFile(UTF16BE_BOM);
        String decodedString = FileUtils.readFileToString(file, LINUX_ENCODING);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-16BE with bom does not work when encoding set incorrectly
     * @throws IOException
     */
    @Test
    public void Utf16BEBomWindowsTest() throws IOException {
        File file = getClassPathFile(UTF16BE_BOM);
        String decodedString = FileUtils.readFileToString(file, WINDOWS_ENCODING);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * The length of the string is figured correctly, but the text
     * is reversed. Not Sure what is going on here
     * @throws IOException
     */
    @Test
    public void Utf16BEBomUtf16Test() throws IOException {
        File file = getClassPathFile(UTF16BE_BOM);
        String decodedString = FileUtils.readFileToString(file, "UTF-16");
        assertTrue(decodedString.length() == NUM_CHARS);
        assertTrue(decodedString.equals(ESCAPED));
    }

    /**
     * UTF16-BE works correctly when correct encoding used with UnicodeReader
     * @throws IOException
     */
    @Test
    public void Utf16BEBomUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16BE_BOM);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), "UTF-16BE");
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-16 (BE with Bom) works even when using UTF-8 encoding
     * (Linux default) and using UnicodeReader
     * @throws IOException
     */
    @Test
    public void Utf16BEBomLinuxUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16BE_BOM);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), LINUX_ENCODING);
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-16 (BE with Bom) works even when using Windows-1252 encoding
     * but using UnicodeReader
     * @throws IOException
     */
    @Test
    public void Utf16BEBomWindowsUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16BE_BOM);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), WINDOWS_ENCODING);
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    @Test
    public void Utf16BEBomUtf16UnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16BE_BOM);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), "UTF-16");
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-16LE works with correct encoding provided
     * @throws IOException
     */
    @Test
    public void Utf16LETest() throws IOException {
        File file = getClassPathFile(UTF16LE);
        String decodedString = FileUtils.readFileToString(file, "UTF-16LE");
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-16 without bom does not work when using default Linux encoding (UTF-8)
     * @throws IOException
     */
    @Test
    public void Utf16LELinuxTest() throws IOException {
        File file = getClassPathFile(UTF16LE);
        String decodedString = FileUtils.readFileToString(file, LINUX_ENCODING);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-16LE without bom does not work when using default Windows
     * encoding
     * @throws IOException
     */
    @Test
    public void Utf16LEWindowsTest() throws IOException {
        File file = getClassPathFile(UTF16LE);
        String decodedString = FileUtils.readFileToString(file, WINDOWS_ENCODING);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-16LE (WITHOUT BOM) fails text match when using Utf-16 as encoding;
     * The character length is correct, but the bytes are reversed,
     * such that the string does not match.
     * The reasoning is that when UTF-16 is used, a bom can be used
     * and if not, UTF-16BE is assumed. Not sure about this...
     * @throws IOException
     */
    @Test
    public void Utf16LEUtf16Test() throws IOException {
        File file = getClassPathFile(UTF16LE);
        String decodedString = FileUtils.readFileToString(file, "UTF-16");
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-16LE without BOM works with UnicodeReader
     * @throws IOException
     */
    @Test
    public void Utf16LEUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16LE);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), "UTF-16LE");
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-16 (BE) fails when using Default Linux (UTF-8) encoding
     * even with UnicodeReader
     * @throws IOException
     */
    @Test
    public void Utf16LELinuxUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16LE);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), LINUX_ENCODING);
        String decodedString = IOUtils.toString(reader);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-16LE fails when using Windows-1252 encoding even with UnicodeReader
     * @throws IOException
     */
    @Test
    public void Utf16LEWindowsUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16LE);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), WINDOWS_ENCODING);
        String decodedString = IOUtils.toString(reader);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * There is no BOM, so UnicodeReader just uses UTF-16 as the encoding.
     * Java then looks assumes that UTF-16 without a Bom is UTF-16BE.
     * The length matches, but the string is reversed? Not sure about this.
     * @throws IOException
     */
    @Test
    public void Utf16LEUtf16UnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16LE);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), "UTF-16");
        String decodedString = IOUtils.toString(reader);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-16LE with BOM does NOT work even with correct encoding provided
     * Probably because explicitly encoded docs aren't supposed to need BOMs.
     * @throws IOException
     */
    @Test
    public void Utf16LEBomTest() throws IOException {
        File file = getClassPathFile(UTF16LE_BOM);
        String decodedString = FileUtils.readFileToString(file, "UTF-16LE");
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-16 with bom does not work when using default Linux encoding (UTF-8)
     * @throws IOException
     */
    @Test
    public void Utf16LEBomLinuxTest() throws IOException {
        File file = getClassPathFile(UTF16LE_BOM);
        String decodedString = FileUtils.readFileToString(file, LINUX_ENCODING);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-16LE with bom does not work when using default Windows encoding
     * @throws IOException
     */
    @Test
    public void Utf16LEBomWindowsTest() throws IOException {
        File file = getClassPathFile(UTF16LE_BOM);
        String decodedString = FileUtils.readFileToString(file, WINDOWS_ENCODING);
        assertFalse(decodedString.length() == NUM_CHARS);
        assertFalse(decodedString.equals(ESCAPED));
    }

    /**
     * File encoded as Utf16LE with Bom and converted using Utf-16
     * passes the length test, but fails to match the message.
     * Not sure why this is going on...
     * @throws IOException
     */
    @Test
    public void Utf16LEBomUTF16Test() throws IOException {
        File file = getClassPathFile(UTF16LE_BOM);
        String decodedString = FileUtils.readFileToString(file, "UTF-16");
        assertTrue(decodedString.length() == NUM_CHARS);
        assertTrue(decodedString.equals(ESCAPED));
    }

    /**
     * UTF-16LE with Bom works with UnicodeReader
     * @throws IOException
     */
    @Test
    public void Utf16LEBomUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16LE_BOM);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), "UTF-16LE");
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-16 (BE with Bom) works even when using default (UTF-8) Linux
     * encoding but using UnicodeReader
     * @throws IOException
     */
    @Test
    public void Utf16LEBomLinuxUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16LE_BOM);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), LINUX_ENCODING);
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * UTF-16 (LE with Bom) works even when using Windows-1252 encoding
     * but using UnicodeReader
     * @throws IOException
     */
    @Test
    public void Utf16LEBomWindowsUnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16LE_BOM);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), WINDOWS_ENCODING);
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }

    /**
     * File encoded as Utf16LE with Bom and converted using Utf-16 works
     * because the bom is removed by UnicodeReader and the encoding
     * changed to Utf-16LE
     * @throws IOException
     */
    @Test
    public void Utf16LEBomUTF16UnicodeReaderTest() throws IOException {
        File file = getClassPathFile(UTF16LE_BOM);
        UnicodeReader reader = new UnicodeReader(new FileInputStream(file), "UTF-16");
        String decodedString = IOUtils.toString(reader);
        assertTrue(decodedString.length() == NUM_CHARS);
        assertEquals(decodedString, ESCAPED);
    }
}

