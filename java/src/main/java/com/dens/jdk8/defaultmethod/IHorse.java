package com.dens.jdk8.defaultmethod;

public interface IHorse {

	void eat();

	default void run() {
		System.out.println("IHorse.run()");
	}

}
