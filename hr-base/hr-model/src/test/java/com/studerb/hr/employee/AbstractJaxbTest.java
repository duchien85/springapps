package com.studerb.hr.employee;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

public abstract class AbstractJaxbTest {
    final static Logger logger = Logger.getLogger(AbstractJaxbTest.class);

    public static File getClassPathFile(String filePath) {
        URL xmlUrl = AbstractJaxbTest.class.getClassLoader().getResource(filePath);
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

    public static void treeWalk(Document document) {
        treeWalk(document.getRootElement());
    }

    public static void treeWalk(Element element) {
        for (int i = 0, size = element.nodeCount(); i < size; i++) {
            Node node = element.node(i);
            if (node instanceof Element) {
                treeWalk((Element) node);
            }
            else {
                logger.debug(node.getPath());
            }
        }
    }

}
