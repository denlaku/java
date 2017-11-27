package com.dens.jdk8.func;

@FunctionalInterface
public interface Converter2<F> {
	public void convert(F from);
}
