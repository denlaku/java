package com.dens.spi;

import java.util.ServiceLoader;

import org.junit.Test;

public class TestClass {

	@Test
	public void test01() {
		ServiceLoader<IService> matcher = ServiceLoader.load(IService.class);
		matcher.forEach(a -> {
			System.out.println(a);
		});
	}
	
}
