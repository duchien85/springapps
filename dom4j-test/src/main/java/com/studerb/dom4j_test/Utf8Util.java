package com.studerb.dom4j_test;

import java.io.ByteArrayOutputStream;

public class Utf8Util {
    /*
     * Author : Shivakumar Mail : shiva (at) blisspark.com Disclaimer : This
     * code is provided without any implied or expressed warranty and may not
     * work as expected. If have any bugs, inform me or post the fix here.
     */

    public static String UTF8Decode(byte in[], int offset, int length) {
        StringBuffer buff = new StringBuffer();
        int max = offset + length;
        for (int i = offset; i < max; i++) {
            char c = 0;
            if ((in[i] & 0x80) == 0) {
                c = (char) in[i];
            }
            else if ((in[i] & 0xe0) == 0xc0) // 11100000
            {
                c |= ((in[i] & 0x1f) << 6); // 00011111
                i++;
                c |= ((in[i] & 0x3f) << 0); // 00111111
            }
            else if ((in[i] & 0xf0) == 0xe0) // 11110000
            {
                c |= ((in[i] & 0x0f) << 12); // 00001111
                i++;
                c |= ((in[i] & 0x3f) << 6); // 00111111
                i++;
                c |= ((in[i] & 0x3f) << 0); // 00111111
            }
            else if ((in[i] & 0xf8) == 0xf0) // 11111000
            {
                c |= ((in[i] & 0x07) << 18); // 00000111 (move 18, not 16?)
                i++;
                c |= ((in[i] & 0x3f) << 12); // 00111111
                i++;
                c |= ((in[i] & 0x3f) << 6); // 00111111
                i++;
                c |= ((in[i] & 0x3f) << 0); // 00111111
            }
            else {
                c = '?';
            }
            buff.append(c);
        }
        return buff.toString();
    }

    public static byte[] UTF8Encode(String str) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            int strlen = str.length();

            for (int i = 0; i < strlen; i++) {
                char t = str.charAt(i);
                int c = t & 0xffff;

                if (c >= 0 && c < 0x80) {
                    bos.write((byte) (c & 0xff));
                }
                else if (c > 0x7f && c < 0x800) {
                    bos.write((byte) (((c >>> 6) & 0x1f) | 0xc0));
                    bos.write((byte) (((c >>> 0) & 0x3f) | 0x80));
                }
                else if (c > 0x7ff && c < 0x10000) {
                    bos.write((byte) (((c >>> 12) & 0x0f) | 0xe0)); // <--
                                                                    // correction
                                                                    // (mb)
                    bos.write((byte) (((c >>> 6) & 0x3f) | 0x80));
                    bos.write((byte) (((c >>> 0) & 0x3f) | 0x80));
                }
                else if (c > 0x00ffff && c < 0xfffff) {
                    bos.write((byte) (((c >>> 18) & 0x07) | 0xf0));
                    bos.write((byte) (((c >>> 12) & 0x3f) | 0x80));
                    bos.write((byte) (((c >>> 6) & 0x3f) | 0x80));
                    bos.write((byte) (((c >>> 0) & 0x3f) | 0x80));
                }
            }
            bos.flush();
        }
        catch (Exception e) {}
        return bos.toByteArray();
    }

}
