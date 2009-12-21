package com.studerb.dom4j_test.xmlCleaner.invalidChars;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import com.studerb.dom4j_test.AbstractUnicodeTest;
import com.studerb.dom4j_test.XMLCleaner;


/**
 * <p>
 * Tests xml files that have illegal XML characters.
 * </p>
 * <p>
 * We read these files straight to string using the platform defaults,
 * make sure they all fail using Dom4j's <code>DocumentHelper.parseTest(string)</code>.
 * Then we make sure the <code>XMLCleaner</code> removes the illegal chars.
 * </p>
 * @author Bill Studer
 *
 */
public class XmlTestsTest extends AbstractUnicodeTest {
    final static Logger log = Logger.getLogger(XmlTestsTest.class);
    XMLCleaner xmlCleaner;
    Document doc;

    private static String BASE_DIR = "test-files/xml/xmltest/not-wf/sa/";
    //illegal char files:
    private String[] TEST_FILES = new String[] {"030", "030", "031", "032", "033", "166", "167", "171", "172", "173", "174", "177"};
    private final String EXT = ".xml";

    /**
     * Files with illegal chars should all fail
     * @throws IOException
     */
    @Test
    public void invalidCharsFailTest() throws IOException {
        int failed = 0;
        Document doc = null;

        for (String path : TEST_FILES) {
            String fullPath = BASE_DIR + path + EXT;
            File f = getClassPathFile(fullPath);
            String s = FileUtils.readFileToString(f, "UTF-8");
            assertNotNull(s);
            try {
                doc = DocumentHelper.parseText(s);
                fail("Should have failed due to illegal exception on file: " + f.getName());
            }
            catch(DocumentException e) {
                log.debug(ExceptionUtils.getRootCauseMessage(e));
                failed++;
            }
        }
        assertEquals(failed, TEST_FILES.length);
    }

    /**
     * Files that previously all failed will be cleaned
     * by <code>XMLCleaner</code> and should now passed,
     * having the illegal XML chars removed.
     * @throws IOException
     */
    @Test
    public void invalidCharsCleanedTest() throws IOException{
        int passed = 0;
        Document doc = null;
        for (String path : TEST_FILES) {
            String fullPath = BASE_DIR + path + EXT;
            File f = getClassPathFile(fullPath);
            String s = FileUtils.readFileToString(f, "UTF-8");
            assertNotNull(s);
            xmlCleaner = new XMLCleaner(s);
            assertTrue(xmlCleaner.isSuccessful());
            doc = xmlCleaner.getDom4JDoc();
            assertNotNull(xmlCleaner);
            passed++;
        }
        assertEquals(passed, TEST_FILES.length);
    }
}
