package com.studerb.dom4j_test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Abstract class from which most unicode and xml tests extend.
 * <p>
 * We're assuming that the publicly available encoding labels 'LINUX_ENCODING'
 * and 'WINDOWS_ENCODING' are UTF-8 and WINDOWS-1252 (cp1252). At least this is true
 * on our default supported versions of Linux (Redhat 5.x) and Windows XP / Server 2003.
 * This also assumes the standard locales set to United States English.
 * @author studerw
 *
 */
public abstract class AbstractUnicodeTest {
    private final static Logger log = Logger.getLogger(AbstractUnicodeTest.class);
    private final static String originalEncoding = Charset.defaultCharset().displayName();
    public static String LINUX_ENCODING = "UTF-8";
    public static String WINDOWS_ENCODING = "windows-1252";
    public final static char BOM = '\uFEFF';

    @BeforeClass
    public static void beforeClass() {
        log.info("Default Encoding: " + originalEncoding);
    }

    @AfterClass
    public static void afterClass() {}


    /**
     * Get a file from the classpath (/tests/resources)
     * @param filePath
     * @return
     */
    public static File getClassPathFile(String filePath) {
        URL xmlUrl = AbstractUnicodeTest.class.getClassLoader().getResource(filePath);
        File file = new File(xmlUrl.getFile());
        return file;
    }

    public static String classPathFileToString(String filePath) throws IOException {
        File file = getClassPathFile(filePath);
        String s = FileUtils.readFileToString(file);
        return s;
    }

    public static String classPathFileToString(String filePath, String encoding) throws IOException {
        File file = getClassPathFile(filePath);
        String s = FileUtils.readFileToString(file, encoding);
        return s;
    }

}

