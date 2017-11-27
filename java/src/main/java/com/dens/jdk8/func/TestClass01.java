package com.dens.jdk8.func;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestClass01 {

	@Test
	public void test01() {
		List<String> list = Arrays.asList("a", "bbbb");
		list.forEach(TestClass01::forEach);
	}
	
	public static void forEach(String t) {
		System.out.println(t);
	}
}
