package com.dens.jdk8.defaultmethod;

import com.dens.jdk8.func.IAnimal;

public class Mule implements IAnimal, IDonkey, IHorse {

	@Override
	public void eat() {
	}

	@Override
	public void run() {
		IHorse.super.run();
	}

}
