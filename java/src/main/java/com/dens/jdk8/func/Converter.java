package com.dens.jdk8.func;

@FunctionalInterface
public interface Converter<F, T> {
	public T convert(F from);
}
