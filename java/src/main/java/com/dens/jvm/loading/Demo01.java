package com.dens.jvm.loading;

public class Demo01 {

	public static  String STR = "STR--1111";
	static{
		System.out.println("Demo01.enclosing_method()");
	}
	
	public static String getStr() {
		return STR;
	}
	
	public String getString() {
		return STR;
	}

	public Demo01() {

	}

}
