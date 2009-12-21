package com.studerb.dom4j_test.saxReader;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

import com.studerb.dom4j_test.AbstractUnicodeTest;

public class NotWellFormedXmlTest extends AbstractUnicodeTest{
    private static Logger log = Logger.getLogger(NotWellFormedXmlTest.class);
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

    @Test
    public void test() {
        SAXReader saxReader = new SAXReader();

        for(File f : testFiles) {
            try {
                Document doc = saxReader.read(f);
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
