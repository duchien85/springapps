/*
 * $Id$ Copyright
 * (c) 2006 SAIC
 */

package com.studerb.dom4j_test;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

/**
 * This transformer is used to convert an XML string to a DOM object.
 *
 * @version $Revision$
 * @author Paul Speed
 */
public class XmlToDomTransformer {
    static final Logger log = Logger.getLogger(XmlToDomTransformer.class);
    private XMLCleaner xmlCleaner;
    private Exception currentException;
    private boolean cleanXml = false;

    public boolean isCleanXml() {
        return cleanXml;
    }

    public void setCleanXml(boolean cleanXml) {
        this.cleanXml = cleanXml;
    }

    public XmlToDomTransformer() {}

    public XmlToDomTransformer(boolean cleanXml) {
        this.cleanXml = cleanXml;
    }

    public Object evaluate(Object input) {
        String xmlString = String.valueOf(input);
        if (log.isDebugEnabled()) {
            log.debug("Transformer started: input=" + input);
        }

        try {
            // Load the XML into a DOM
            return (DocumentHelper.parseText(xmlString));
        }
        catch (DocumentException e) {
            this.currentException = e;
            if (isCleanXml()) {
                return tryClean(xmlString);
            }
            else {
                throw new RuntimeException("Error converting XML to DOM", e);
            }
        }
    }

    protected Document tryClean(String s) {
        log.warn("Unable to create XML document - attempting to fix it...");
        xmlCleaner = new XMLCleaner(s);
        if (xmlCleaner.isSuccessful()) {
            return xmlCleaner.getDom4JDoc();
        }
        else {
            throw new RuntimeException("Error converting XML to DOM - could not clean it", this.currentException);
        }
    }

    public String toString() {
        return "XmlToDomTransformer[]";
    }
}
