package com.studerb.dom4j_test;

import org.apache.log4j.Logger;

public class BomUtil {

    private static final Logger log = Logger.getLogger(BomUtil.class);

    public static String removeUtf8Bom_Utf8(String s) {
        if (!isUtf8Bom_Utf8(s)) {
            throw new IllegalStateException("String arg doesn't contain Utf8 Bom decoded as Utf8");
        }
        String removed = s.substring(1);
        return removed;
    }

    public static String removeUtf8Bom_Windows1252(String s) {
        if (!isUtf8Bom_Windows1252(s)) {
            throw new IllegalStateException("String arg doesn't contain Utf8 Bom decoded as Windows-1252");
        }
        String removed = s.substring(3);
        return removed;
    }

    public static String removeUtf16Bom_Utf8(String s) {
        if (!isUtf16Bom_Utf8(s)) {
            throw new IllegalStateException("String arg doesn't contain Utf-16BE BOM decoded as UTF-8");
        }
        String removed = s.substring(2);
        return removed;
    }

    public static String removeUtf16Bom_Windows1252(String s) {
        if (!isUtf16Bom_Windows1252(s)) {
            throw new IllegalStateException("String arg doesn't contain Utf-16 BOM decoded Windows-1252");
        }

        String removed = s.substring(2);
        return removed;
    }

    public static boolean isUtf8Bom_Utf8(String s) {
        int codePoint = s.codePointAt(0);
        return (codePoint == '\uFEFF');
    }

    public static boolean isUtf8Bom_Windows1252(String s) {
        char[] three = new char[3];
        s.getChars(0, 3, three, 0);
        return ((three[0] == '\u00ef') && (three[1] == '\u00bb') && (three[2] == '\u00bf'));
    }

    /**
     * The utf16 bom is '\\ufe\\uff'. Neither of these are even valid Utf8
     * sequences, thus are both encoded as U+FFFD (unicode replacement
     * character). This actually works for both ut16be and utf16le since
     * the reversed BOM for le (\\uff\\ufe) also gets converted into two
     * 'unicode replacement characters'.
     *
     * @param s
     * @return
     */
    public static boolean isUtf16Bom_Utf8(String s) {
        char[] two = new char[2];
        s.getChars(0, 2, two, 0);
        return ((two[0] == '\ufffd') && (two[1] == '\ufffd'));
    }

    public static boolean isUtf16Bom_Windows1252(String s) {
        char[] two = new char[2];
        s.getChars(0, 2, two, 0);
        if ((two[0] == '\u00fe') && (two[1] == '\u00ff')) {
            return true;
        }
        else if ((two[0] == '\u00ff') && (two[1] == '\u00fe')) {
            return true;
        }
        return false;
    }

    protected static void logChars(String s, int num) {
    num = (s.length() < num ? s.length() : num);

    for (int i = 0; i < num; ++i) {
        char c = s.charAt(i);
        int codePoint = s.codePointAt(i);
        log.debug(i + " (char / codePoint): " + c + " / " + Integer.toHexString(codePoint));
    }
}


}
