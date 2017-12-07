package com.denlaku.base;

import org.junit.Test;

public class TestFloat {

	@Test
	public void test02() {
		// System.out.println(1 / 0);//报错, 除数和被除数都是整除，且除数为0，会抛异常
		System.out.println(1 / 0.0);// Infinity
		System.out.println(1.0 / 0); // Infinity
		System.out.println(1.0 / -0); // Infinity
		System.out.println(-1.0 / 0); // -Infinity
		System.out.println(0.0 / 0); // NaN
		System.out.println(0.0 / -0); // NaN
		System.out.println(0x1p+4);
		System.out.println(0x1.0p-3);
		System.out.println(Float.NaN == Float.NaN);// false
	}

	@Test
	public void test01() {

		System.out.println(1.00f - 0.42f);
		System.out.println(0.05 + 0.01);
		System.out.println(1.0 - 0.42);
		System.out.println(4.015 * 100);
		System.out.println(123.3 / 100);

		float f = .3f;
		System.out.println(Integer.toBinaryString(Float.floatToIntBits(f)));

		int e = 0b10000101;
		System.out.println(e);
	}
}
