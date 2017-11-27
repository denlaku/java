package com.dens.vo;

public class AnimalVO {

	public static MessageVO message = new MessageVO("Animal.message");
	static{
		System.out.println("Animal.static....");
	}
	public AnimalVO() {
		System.out.println("Animal.Animal()");
		System.out.println(this);
	}
}
