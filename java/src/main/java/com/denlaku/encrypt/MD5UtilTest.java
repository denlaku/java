package com.denlaku.encrypt;

import org.junit.Test;

public class MD5UtilTest {

	@Test
	public void test01() throws Exception {
		String str = new String("amigoxiexiexingxing");
        System.out.println("原始：" + str);
        System.out.println("MD5后：" + MD5Util.md5Encode(str));
	}
}
