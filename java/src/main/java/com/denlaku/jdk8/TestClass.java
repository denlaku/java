package com.denlaku.jdk8;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.junit.Test;

public class TestClass {

	@Test
	public void test03() {
		List<String> asList = Arrays.asList("AA", "BB");
		System.out.println(asList);
	}

	@Test
	public void test02() {
		final String text = "Base64 finally in Java 8!";
		final String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
		System.out.println(encoded);

		final String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
		System.out.println(decoded);
	}

	@Test
	public void test01() {
		List<String> list = Arrays.asList("AA", "BB", "CC");
		list.stream().filter(ele -> !"AA".equals(ele)).forEach(ele -> {
			System.out.println(ele);
		});
	}

}
