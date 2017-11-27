package com.dens.encrypt;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class BASE64Util {
	
	private static final String UTF8 = "UTF-8";

	public static String encryptBASE64(byte[] bts) throws Exception {
		Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(bts);
    }
	
	public static String encryptBASE64(String value) throws Exception {
        return encryptBASE64(value.getBytes(UTF8));
    }
	
	public static String decryptBASE64(byte[] bts) throws Exception {
		Decoder decoder = Base64.getDecoder();
		byte[] decode = decoder.decode(bts);
        return new String(decode, UTF8);
    }
	
	public static String decryptBASE64(String str) throws Exception {
//		Decoder decoder = Base64.getDecoder();
//		byte[] decode = decoder.decode(str);
//        return new String(decode, UTF8);
		return decryptBASE64(str.getBytes(UTF8));
    }
}
