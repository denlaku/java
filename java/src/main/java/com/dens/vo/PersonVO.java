package com.dens.vo;

public class PersonVO extends AnimalVO{

	static{
		System.out.println("Person.static....");
	}
	public static MessageVO message = new MessageVO("Person.message");
	public PersonVO(){
		System.out.println("Person.Person()");
		System.out.println(this);
	}
}
