package com.dens.jdk8.defaultmethod;

public interface IAnimal {
	default void run() {
		System.out.println(1);
	}
	
	default void run2() {
		System.out.println(1);
	}
}
