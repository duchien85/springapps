package com.studerb.dom4j_test.xmlToDomTransformer.invalidChars;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.junit.Test;

import com.studerb.dom4j_test.AbstractUnicodeTest;
import com.studerb.dom4j_test.XmlToDomTransformer;

/**
 * <p>
 * Tests xml files that have illegal XML characters.
 * </p>
 * <p>
 * We read these files straight to string using the platform defaults,
 * First we check that they fail when using <code>XmlToDomTransferake sure
 * they all fail using <code>XmlToDomTransformer</code> with its <code>
 * <code>cleanXml</code> property set to false.
 * </p>
 * <p>
 * Then we try again with the same docs, this time setting the property to true.
 * </p>
 * @author Bill Studer
 *
 */
public class XmlTestsTest extends AbstractUnicodeTest {
    final static Logger log = Logger.getLogger(XmlTestsTest.class);

    private static String BASE_DIR = "test-files/xml/xmltest/not-wf/sa/";
    //illegal char files:
    private String[] TEST_FILES = new String[] {"030", "030", "031", "032", "033", "166", "167", "171", "172", "173", "174", "177"};
    private final String EXT = ".xml";

    /**
     * Files with illegal chars should all fail
     * @throws IOException
     */
    @Test
    public void invalidCharsFail() throws IOException {
        int failed = 0;
        XmlToDomTransformer xmlToDomTransformer = null;

        for (String path : TEST_FILES) {
            String fullPath = BASE_DIR + path + EXT;
            File f = getClassPathFile(fullPath);
            String xmlString = FileUtils.readFileToString(f, "UTF-8");
            try {
                xmlToDomTransformer = new XmlToDomTransformer();
                xmlToDomTransformer.setCleanXml(false);
                xmlToDomTransformer.evaluate(xmlString);
                fail("Should have failed due to illegal exception on file: " + f.getName());
            }
            catch(RuntimeException e) {
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
    public void invalidCharsCleaned() throws IOException{
        int passed = 0;

        for (String path : TEST_FILES) {
            String fullPath = BASE_DIR + path + EXT;
            File f = getClassPathFile(fullPath);
            String xmlString = FileUtils.readFileToString(f, "UTF-8");
            XmlToDomTransformer xmlToDomTransformer = new XmlToDomTransformer();
            xmlToDomTransformer.setCleanXml(true);
            Document doc = (Document)xmlToDomTransformer.evaluate(xmlString);
            assertNotNull(doc);
            passed++;
        }
        assertEquals(passed, TEST_FILES.length);
    }
}
