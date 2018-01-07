package com.denlaku.designpattern.decorator;

public class TestClass {

	public static void main(String[] args) {
		Human person = new Person();
		Decorator decorator = new DecoratorTwo(new DecoratorFirst(new DecoratorZero(person)));
		decorator.wearClothes();
		decorator.walkToWhere();
	}
}
