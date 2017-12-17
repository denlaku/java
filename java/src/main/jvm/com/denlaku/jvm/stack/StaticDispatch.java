package com.denlaku.jvm.stack;

public class StaticDispatch {

	public void sayHello(Animal animal) {
		System.out.println("Animal animal");
	}

	public void sayHello(Person<Man> person) {
		System.out.println("Person person");
	}

	public void sayHello(Human human) {
		System.out.println("Human human");
	}

	public void sayHello(Man man) {
		System.out.println("Man man");
	}

	public void sayHello(Woman woman) {
		System.out.println("Woman woman");
	}

	public static void main(String[] args) {
		StaticDispatch sd = new StaticDispatch();

		Man man = new Man();

		sd.sayHello((Human) man);
	}
}
