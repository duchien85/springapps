package com.studerb.dom4j_test.misc;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.studerb.dom4j_test.Utf8Util;

/**
 * Test to see how new JVM string/char unicode processing works
 * @author studerw
 *
 */
public class CharacterTest {
    private Logger log = Logger.getLogger(CharacterTest.class);

    //@Test
    public void javaStringTest(){
        String oneChar = "\uffff";
        String twoChars = "\ud801\udc00";

        log.debug("length of oneChar: " + oneChar.length());
        log.debug("length of twoChars: " + twoChars.length());
        log.debug("codePointCount oneChar(0,1): " + oneChar.codePointCount(0, 1));
        log.debug("codePointCount twoChars(0,1): " + twoChars.codePointCount(0, 1));
        log.debug("codePointCount twoChars(0,2): " + twoChars.codePointCount(0, 2));

        log.debug("twoChars.charAt(0): " + twoChars.charAt(0));
        log.debug("twoChars.charAt(1): " + twoChars.charAt(1));

        log.debug("twoChars.codePointAt(0):" + Integer.toHexString(twoChars.codePointAt(0)));
        log.debug("twoChars.codePointAt(1):" + Integer.toHexString(twoChars.codePointAt(1)));

        log.debug("twoChars.codePointBefore(1): " + Integer.toHexString(twoChars.codePointBefore(1)));
        log.debug("twoChars.codePointBefore(2): " + Integer.toHexString(twoChars.codePointBefore(2)));

        log.debug("Character.isDefined(\ud801): " + Character.isDefined(55297));

        byte[] b = Utf8Util.UTF8Encode("\ufffd\ufffd");
        log.debug(Arrays.toString(b));
    }

    @Test
    public void dummy() {
        assertTrue(true);
    }

}
