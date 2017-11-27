package com.dens.clazz;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.Test;

import com.dens.ArrayUtil;

public class TestClass04 {

	@Test
	public void test01() {
		// 根据指定的类型 创建数组
		String[] newArray = ArrayUtil.newArray(String.class, 10);
		System.out.println(Arrays.toString(newArray));
	}
	
	@Test
	public void test02() throws IOException {
		ClassLoader classLoader = TestClass04.class.getClassLoader();
		InputStream is = classLoader.getResourceAsStream("com/dens/clazz/TestClass04.class");
		System.out.println(is.available());
		byte[] buf = new byte[8];
		try {
//			while ((is.read(buf)) != -1) {
//				System.out.println(Arrays.toString(buf));
//			}
			is.read(buf);
			System.out.println(new String(buf,"UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
