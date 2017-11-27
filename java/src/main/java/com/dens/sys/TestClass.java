package com.dens.sys;

import org.junit.Test;

public class TestClass {

	@Test
	public void test01() {
		// 判断操作系统的类型
		String osname = System.getProperty("os.name");
		System.out.println(osname);
	}
}

