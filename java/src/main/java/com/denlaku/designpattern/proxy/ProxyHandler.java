package com.denlaku.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
	private Object delegate;

	public ProxyHandler(Object delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before ...");
		Object invoke = method.invoke(delegate, args);
		System.out.println("after ...");
		return invoke;
	}

}
