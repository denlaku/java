package com.denlaku.jdk8.func;

@FunctionalInterface
public interface PersonFactory<P extends Person> {
	@SuppressWarnings("unchecked")
	<E> P create(E... args); 
}
