package cn.edu.nenu.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * Encodes Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-05-24 7:31
 */
public class Encodes {
    private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public Encodes() {
    }

    public static String encodeHex(byte[] input) {
        return Hex.encodeHexString(input);
    }

    public static byte[] decodeHex(String input) {
        try {
            return Hex.decodeHex(input.toCharArray());
        } catch (DecoderException var2) {
            throw Exceptions.unchecked(var2);
        }
    }
}
