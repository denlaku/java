package com.denlaku.jdk8.func;

import java.util.function.Function;

import org.junit.Test;

public class TestClass02 {

	@Test
	public void test06() {
	}
	
	@Test
	public void test05() {
		Person p = new Person();
		Person create = p.create(Person::new);
		System.out.println(create);
	}
	
	@Test
	public void test04() {
		Person p = new Person();
		p.run3(a->{
			System.out.println("a: " + a);
		});
	}

	@Test
	public void test03() {
		Person p = new Person();
		Function<Integer, String> func = p::run3;
		String apply = func.apply(100);
		System.out.println(apply);
	}
	
	@Test
	public void test02() {
		Person p = new Person();
		p.run2(100, a -> {
			return "";
		});
	}

	@Test
	public void test01() {
		Person p = new Person();
		p.run(100, a -> {
			System.out.println(a);
		});
	}
}
