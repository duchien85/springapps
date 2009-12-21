package com.studerb.dom4j_test.documentHelper;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.Before;
import org.junit.Test;

import com.studerb.dom4j_test.AbstractUnicodeTest;

/**
 * <p>
 * This class tests the 186 not-well-formed xml files from the folder
 * within the included test resources.
 * </p>
 * <p>
 * All of these files fail when using SaxReader (passing the file itself).
 * However, a few of these tests when generically converted to strings
 * using the the platform default encoding, do actually pass (specifically
 * tests 101.xml and 170.xml).
 * </p>
 * @author studerw
 *
 */
public class NotWellFormedTest extends AbstractUnicodeTest{
    private static Logger log = Logger.getLogger(NotWellFormedTest.class);
    private static final String BASE_DIR = "test-files/xml/xmltest/not-wf/sa/";
    private static final int MIN_TEST = 1;
    private static final int MAX_TEST = 186;
    private List<File> testFiles = null;

    @Before
    public void setup() {
        if (testFiles == null) {
            generateTestFiles();
        }
    }

    /**
     * All of the 186 tests should fail. However
     * tests '101.xml' and '170.xml' actually pass.
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        for(File f : testFiles) {
            try {
                String xmlString = FileUtils.readFileToString(f, "UTF-8");
                Document doc = DocumentHelper.parseText(xmlString);
                log.error(f.getName() + " did not cause exception");
            }
            catch(DocumentException exception) {
                log.debug("File: " + f.getName() + ": " + ExceptionUtils.getRootCauseMessage(exception));
            }
        }
    }

    private void generateTestFiles(){
        this.testFiles = new ArrayList<File>(MAX_TEST);

        for(int i = MIN_TEST; i <= MAX_TEST; ++i) {
            StringBuilder tempNum = new StringBuilder(BASE_DIR);
            if (i < 10) {
                tempNum.append("0");
            }
            if (i < 100) {
                tempNum.append("0");
            }
            tempNum.append(String.valueOf(i)).append(".xml");
            File xmlFile = getClassPathFile(tempNum.toString());
            assertTrue(xmlFile.exists());
            this.testFiles.add(xmlFile);
        }
    }
}
