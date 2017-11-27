package com.dens.clazz;

public class ClassSub extends ClassSuper {

	private String name;

	public ClassSub() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println("ClassSub.eat()");
	}

	@Override
	public String toString() {
		return "ClassSub [name=" + name + "]";
	}

}
