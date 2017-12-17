package com.denlaku.jdk8.func;

public interface IAnimal {

	default void breath() {
		System.out.println("IAnimal.breath()");
	}
}
