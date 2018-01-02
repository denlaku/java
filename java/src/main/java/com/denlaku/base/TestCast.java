package com.denlaku.base;

import org.junit.Test;

public class TestCast {

	@Test
	public void test02() {
		long sum = 0L;
		long start = System.currentTimeMillis();
//		int max = Integer.MAX_VALUE;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			sum += 1;
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(sum);
	}
	
	@Test
	public void test01() {
		Long sum = 0L;
		long start = System.currentTimeMillis();
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(sum);
	}
}
