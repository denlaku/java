package com.denlaku.designpattern.decorator;

public class DecoratorZero extends Decorator {

	public DecoratorZero(Human human) {
		super(human);
	}

	public void goHome() {
		System.out.println("进房子。。");
	}

	public void findMap() {
		System.out.println("书房找找Map。。");
	}

	@Override
	public void wearClothes() {
		super.wearClothes();
		goHome();
	}

	@Override
	public void walkToWhere() {
		super.walkToWhere();
		findMap();
	}
}