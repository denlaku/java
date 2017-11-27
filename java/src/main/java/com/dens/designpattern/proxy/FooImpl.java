package com.dens.designpattern.proxy;

public class FooImpl implements Foo {

	@Override
	public void put() {
		System.out.println("FooImpl.f()");
	}

	@Override
	public int get() {
		System.out.println("FooImpl.get()");
		return 100;
	}

}
