package com.denlaku.jvm.classloader;

import org.junit.Test;

public class TestClassloder {

	@Test
	public void test01() {
		ClassLoader classLoader = TestClassloder.class.getClassLoader();
		System.out.println(classLoader);
		System.out.println(classLoader.getClass().getSuperclass());
	}
}
