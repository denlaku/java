package com.denlaku.clazz;

public class ClassSuper extends ClassRoot {

	@Anno01
	public ClassSuper() {
	}

	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void run() {
		System.out.println("ClassSuper.run()");
	}

}
