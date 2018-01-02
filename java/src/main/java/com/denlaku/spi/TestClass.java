package com.denlaku.spi;

import java.util.ServiceLoader;

import org.junit.Test;

import com.denlaku.spi.service.SpiService;

public class TestClass {

	@Test
	public void test01() {
		ServiceLoader<SpiService> matcher = ServiceLoader.load(SpiService.class);
		matcher.forEach(a -> {
			System.out.println(a);
		});
	}
	
}
