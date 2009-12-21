package com.studerb.dom4j_test.misc;
import java.io.File;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.junit.Test;


/**
 * Testing to see if sax reader can correctly encode invalid xml chars
 * @author studerw
 *
 */
public class XmlEntityTest {
    private static Logger log = Logger.getLogger(XmlEntityTest.class);
    File desktop = new File("C:/Documents and Settings/studerw/Desktop/");

    @Test
    public void xmlEntityTest() {
        String s = "& this is dome < > test";
        DocumentFactory factory = DocumentFactory.getInstance();
        Document doc = factory.createDocument();
        Element root = doc.addElement("root");
        Element author1 = root.addElement( "author" )
            .addAttribute( "name", "James" )
            .addAttribute( "location", "UK" )
            .addText(s);

        Element author2 = root.addElement( "author" )
        .addAttribute( "name", "Bob" )
        .addAttribute( "location", "US" )
        .addText( "Bob McWhirter" );
        String xml = doc.asXML();
        log.info(xml);
    }
    
}
