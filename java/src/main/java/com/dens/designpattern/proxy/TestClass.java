package com.dens.designpattern.proxy;

import java.lang.reflect.Proxy;

public class TestClass {

	public static void main(String[] args) {
		Foo foo = new FooImpl();
		ProxyHandler handler = new ProxyHandler(foo);
		Foo proxy = (Foo) Proxy.newProxyInstance(FooImpl.class.getClassLoader(), FooImpl.class.getInterfaces(),
				handler);
		System.out.println("F: " + proxy);
		int i = proxy.get();
		System.out.println("I : " + i);
	}
}
