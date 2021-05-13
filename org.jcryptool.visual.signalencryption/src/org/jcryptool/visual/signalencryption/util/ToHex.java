package org.jcryptool.visual.signalencryption.util;

public class ToHex {

    private final static char[] HEX_DIGITS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    public static String toString(byte[] bytes) {
        return toString(bytes, 0, bytes.length);
    }

    public static String toString(byte[] bytes, int offset, int length) {
        StringBuffer buf = new StringBuffer();
        buf.append("0x");
        for (int i = 0; i < length; i++) {
            appendHexChar(buf, bytes[offset + i]);
            if (i % 2 == 0) {
                buf.append(" ");
            }
        }
        buf.append(length);
        return buf.toString();
    }
    
    private static void appendHexChar(StringBuffer buf, int b) {
        buf.append(HEX_DIGITS[(b >> 4) & 0xf]);
        buf.append(HEX_DIGITS[b & 0xf]);
      }

}
