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
 * Test to make sure SaxReader/Writer encodes entity markers
 * like &amp; before converting to a java string.
 * @author studerw
 *
 */
public class MiscXmlUtilTest extends AbstractUnicodeTest {
    final static Logger log = Logger.getLogger(MiscXmlUtilTest.class);
    SAXReader saxReader;
    Document doc;

    final static String UTF8_XmlUtil= "test-files/xml/misc/utf8_xmlUtil.xml";
    final static String DOUBLE_QUOTES="\u201C\u201D\u201E";
    final static String DOUBLE_QUOTES_XPATH="/root/double_quotes";

    @Before
    public void setup() throws Exception {
        saxReader = new SAXReader();
    }

    @After
    public void teardown() {
        saxReader = null;
        doc = null;
    }

    @Test
    public void DoubleQuotesTest() throws Exception {
        File xmlFile = getClassPathFile(UTF8_XmlUtil);
        doc = saxReader.read(xmlFile);
        String quotes = doc.valueOf(DOUBLE_QUOTES_XPATH);
        assertEquals(DOUBLE_QUOTES, quotes);
        log.debug(quotes);
    }

}
