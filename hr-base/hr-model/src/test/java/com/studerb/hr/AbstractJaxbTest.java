package com.studerb.hr;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.jaxen.dom4j.Dom4jXPath;
import org.junit.BeforeClass;

public abstract class AbstractJaxbTest {
    final static Logger logger = Logger.getLogger(AbstractJaxbTest.class);
    public static JAXBContext context;
    public static Marshaller marshaller;
    public static Unmarshaller unmarshaller;
    public static HashMap<String, String> namespaces;
    public static Dom4jXPath xpath;
    public static Schema schema;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(getClassPathFile("xml/hr-model.xsd"));
        context = JAXBContext.newInstance("com.studerb.hr.employee");
        marshaller = context.createMarshaller();
        marshaller.setSchema(schema);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "hr-model.xsd");
        unmarshaller = context.createUnmarshaller();
        unmarshaller.setSchema(schema);

    }

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
