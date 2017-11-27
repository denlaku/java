package com.dens.jdk8.func;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Person {

	private String name;
	private String address;
	private Integer age;

	public Person() {
	}
	
//	@SafeVarargs
//	public <E> Person(E...args) {
//		System.out.println("Person.Person(E...args)");
//	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person(String name, String address) {
		super();
		System.out.println("Person.Person(String name, String address)");
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void run(int base, Consumer<Integer> c) {
		c.accept(base);
		c.andThen(c);
	}

	public String run2(int base, MyFunc<String, Integer> mf) {
		return mf.value(base);
	}

	public String run3(int a) {
		return String.valueOf(a);
	}

	public Person create(Supplier<Person> s) {
		return s.get();
	}

	@SafeVarargs
	public static <E, F> Person create(PersonFactory<Person> pf, E... args) {
		return pf.create(args);
	}

	public void run3(Consumer<Integer> c) {
		c.andThen(a -> {
			System.out.println("b:" + a);
			a++;
		}).andThen(a -> {
			System.out.println("c: " + a);
			a++;
		}).accept(100);
		;
	}
}
