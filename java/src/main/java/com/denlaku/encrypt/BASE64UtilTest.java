package com.denlaku.encrypt;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class BASE64UtilTest {

	@Test
	public void test() {
		String str = "Not yet implemented地方法规很反感";
		try {
			String encryptBASE64 = BASE64Util.encryptBASE64(str.getBytes("UTF-8"));
			System.out.println(encryptBASE64);
			String encryptBASE642 = BASE64Util.encryptBASE64(str);
			System.out.println(encryptBASE642);
			
			
			String decryptBASE64 = BASE64Util.decryptBASE64(encryptBASE64);
			System.out.println(decryptBASE64);
			System.out.println(BASE64Util.decryptBASE64(encryptBASE64.getBytes("UTF-8")));
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
