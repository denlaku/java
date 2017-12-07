package com.denlaku.jdk8.defaultmethod;

import com.denlaku.jdk8.func.IAnimal;

public class Mule implements IAnimal, IDonkey, IHorse {

	@Override
	public void eat() {
	}

	@Override
	public void run() {
		IHorse.super.run();
	}

}
