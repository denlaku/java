package com.denlaku.base;

import org.junit.Test;

public class TestAssert {

	@Test
	public void test01() {
		run(110);
	}
	
	public void run(int i) {
		assert i < 10 : "i---";
	}
}
