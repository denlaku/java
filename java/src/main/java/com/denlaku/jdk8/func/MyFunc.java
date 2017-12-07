package com.denlaku.jdk8.func;

@FunctionalInterface
public interface MyFunc<E, T> {
	public E value(T i);
}
