package com.denlaku.jdk8.defaultmethod;

public interface IDonkey {

	void eat();

	default void run() {
		System.out.println("IDonkey.run()");
	}
}
