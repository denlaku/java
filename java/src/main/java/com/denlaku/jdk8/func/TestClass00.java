package com.denlaku.jdk8.func;

import org.junit.Test;

public class TestClass00 {

	
	@Test
	public void test04() {
		
	}
	
	@Test
	public void test03() {
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted); // 123
	}
	
	@Test
	public void test02() {
		TestClass00 tc = new TestClass00();
		Converter<String, String> converter = tc::valueOf;
		String convert = converter.convert("java");
		System.out.println(convert);
		Converter2<String> convert2 = tc::valuePrint;
		convert2.convert("DD--===");
	}
	
	@Test
	public void test01() {
		Converter<String, String> converter = TestClass00::value;
		String converted = converter.convert("123");
		System.out.println(converted); // 123
	}
	
	public static String value(String str) {
		return str + ".class";
	}

	public String valueOf(String str) {
		return str + ".class";
	}

	public void valuePrint(String str) {
		System.out.println(str);
	}
}
