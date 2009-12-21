package com.studerb.dom4j_test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
/**
 * Takes a string in the constructor that should be an xml docuemnt.
 * <p>
 * The class will attempt to <em>clean</em> the XML string the best it can,
 * removing illegal characters (as defined by version 1.0 of the XML spec).
 * Also, string that were encoded wrongly may still contain BOM that will fail
 * parsing, such that these characters must be removed.
 * </p>
 * <p>
 * Other common failures within Feedpipes processing will also be addressed,
 * e.g. the insertion of extra processing instructions declaration in the middle
 * of the document.
 *
 * @author studerw
 */
public class XMLCleaner {
    private static Logger log = Logger.getLogger(XMLCleaner.class);
    final static Pattern PI = Pattern.compile("<\\?\\w+.*?\\?>");
    final static Character LESS_THAN = '\u003c';
    final static double UTF16_WARN = .45;
    private String originalString = null;
    private boolean successful = false;
    private Document document = null;
    private String xmlString = null;
    boolean modified = false;
    int removedCharCount = 0;
    int removedPICount = 0;
    boolean bomRemoved = false;


    /**
     * Base constructor, upon which completing, one may call the
     * {@link #isSuccessful()} method.
     *
     * @param xmlString
     */
    public XMLCleaner(String xmlString) {
        if (StringUtils.isEmpty(xmlString)) {
            throw new IllegalArgumentException("Cannot clean empty null or empty string");
        }

        this.xmlString = xmlString;
        this.originalString = xmlString;

        try {
            this.document = DocumentHelper.parseText(xmlString);
            log.info("Able to parse XML without cleaning - just returning...");
            successful = true;
        }
        catch(DocumentException e) {
            cleanXmlString();
        }
    }

    /**
         * Byte Order Marks can generally be detected by the JVM
         * as long as the correct encoding is used. Also, SaxReader
         * can detect them. However, UTF-8 BOMS (via Windows notepad)
         * cause problems as do UTF16 (both BE/LE) when not given
         * correct encodings. If the Xml file/inputStream is converted to
         * an internal Java String without proper encoding, SaxReader
         * will fail as it expects the first actual character to be the opening
         * declaration or root node ('<').
         */
        protected boolean cleanByteOrderMarks() {
            if (BomUtil.isUtf8Bom_Utf8(xmlString)) {
                log.debug("Has Utf8Bom in Utf8 Encoding... removing it");
                this.xmlString = BomUtil.removeUtf8Bom_Utf8(xmlString);
                this.bomRemoved = true;
                return true;
            }
            else if (BomUtil.isUtf8Bom_Windows1252(xmlString)) {
                log.debug("Has Utf8Bom in Windows-1252 Encoding... removing it");
                this.xmlString = BomUtil.removeUtf8Bom_Windows1252(xmlString);
                this.bomRemoved = true;
                return true;
            }
            else if (BomUtil.isUtf16Bom_Utf8(xmlString)) {
                log.debug("Has Utf16Bom in UTF-8 Encoding... removing it");
                this.xmlString = BomUtil.removeUtf16Bom_Utf8(xmlString);
                this.bomRemoved = true;
                return true;
            }
            else if (BomUtil.isUtf16Bom_Windows1252(xmlString)) {
                log.debug("Has Utf16 Bom in Windows-1252 Encoding... removing it");
                this.xmlString = BomUtil.removeUtf16Bom_Windows1252(xmlString);
                this.bomRemoved = true;
                return true;
            }
            return false;
        }

    /**
     * Silly wrapper method around GPL'd <code>removeInvalidXMLChars</code>
     * below
     */
    protected void cleanInvalidChars() {
        if (this.xmlString != null) {
            this.xmlString = removeInvalidXMLCharacters(this.xmlString);
        }
    }

    /**
     * scans through the xml string, removing all processing instructions,
     * including extra declarations. If will not remove a valid declaration
     * if found at the very beginning of the string (thus it's important to remove
     * any BOMs before running this method).
     */
    protected void cleanProcessingInstructions() {
        Matcher matcher = PI.matcher(this.xmlString);
        StringBuffer buff = new StringBuffer();
        while(matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String current = xmlString.substring(start, end);
            //don't  replace the actual XML declaration
            if (start == 0 && current.startsWith("<?xml")) {
                continue;
            }
            else {
                matcher.appendReplacement(buff, "");
                log.debug("removing processing instruction: " + current);
                this.removedPICount++;
            }
        }
        matcher.appendTail(buff);

        if (this.removedPICount > 0) {
            this.xmlString = buff.toString();
        }
    }

    protected void cleanXmlString() {
        this.bomRemoved = cleanByteOrderMarks();
        cleanInvalidChars();
        cleanProcessingInstructions();
        try {
            this.document = DocumentHelper.parseText(this.xmlString);
            successful = true;
            log.info(cleanDescription());
        }
        catch (DocumentException e) {
            log.warn("Failed cleaning: " + ExceptionUtils.getRootCauseMessage(e));
            this.document = null;
            successful = false;
        }
    }

    /**
     * Returns the successfully created Dom4j Doc Will throw a RunTimeException
     * is the cleaner was not successful, thus one must check before calling
     * this method.
     *
     * @return Document
     */
    public Document getDom4JDoc() {
        if (successful) {
            return this.document;
        }
        else {
            throw new RuntimeException("No document created because xml was never / unable to be cleaned");
        }
    }

    public int getRemovedCharCount() {
        return this.removedCharCount;
    }

    public String getOriginalString() {
        return this.originalString;
    }

    public int getRemovedPICount() {
        return this.removedPICount;
    }

    public String getXmlString() {
        return xmlString;
    }

    public boolean isBomRemoved() {
        return bomRemoved;
    }

    public boolean isModified() {
        return this.originalString.equals(this.xmlString);
    }

    /**
     * After constructing the object, this method may be called in order to
     * determine if the cleaning was successful. If so, one may grab the
     * already-created Dom4j Document. If not successful, and one attempts to
     * obtain the Docuemnt, an RunTimeException will be thrown.
     *
     * @return
     */
    public boolean isSuccessful() {
        return successful;
    }

    /**
     * Ensures that the output String has only valid XML unicode characters as
     * specified by the XML 1.0 standard. For reference, please see the
     * standard. This method will return an empty String if the input is null or
     * empty.
     *
     * @author Donoiu Cristian, GPL
     * @param The
     *            String whose non-valid characters we want to remove.
     * @return The in String, stripped of non-valid characters.
     */
    private String removeInvalidXMLCharacters(String s) {
        int charUnitCount = s.length();
        int replacedNulls = 0;
        int replacedChars = 0;
        StringBuilder out = new StringBuilder();
        int codePoint;
        int i = 0;

        while (i < s.length()) {
            log.trace("i=" + i);
            codePoint = s.codePointAt(i);
            if ((codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF))) {
                out.append(Character.toChars(codePoint));
            }
            else {
                //log.trace("At char: " + i + " removing illegal code point: " + Integer.toHexString(codePoint));
                replacedChars++;
                if (codePoint == 0) {
                    replacedNulls++;
                }
            }
            i += Character.charCount(codePoint);
        }
        if (replacedChars > 0) {
            log.debug(replacedChars + " invalid chars were removed.");
        }
        checkRemovedNulls(charUnitCount, replacedNulls);
        removedCharCount += replacedChars;
        return out.toString();
    }

    private void checkRemovedNulls(int total, int nulls) {
        double fractionRemoved = (double)nulls / (double)total;
        if (fractionRemoved >= UTF16_WARN) {
            int percent = (int) (fractionRemoved * 100.0);
            log.warn(percent + "% of illegal XML characters removed were null (\\x00). You've most likely wrongly decoded a UTF-16 encoded file.");
        }
    }

    public String cleanDescription() {
        StringBuilder description = new StringBuilder();

        if (this.isModified()) {
            if (bomRemoved) {
                description.append("Byte Order Mark removed from beginning chars of string\n");
            }
            if ( removedCharCount > 0) {
                description.append(removedCharCount + " Invalid XML characters were removed from the string\n");
            }
            if (removedPICount > 0) {
                description.append(removedPICount + " processing instructions were removed\n");
            }
        }
        else {
            description.append("XmlCleaner did not find anything to clean.");
        }

        return description.toString();
    }
}
