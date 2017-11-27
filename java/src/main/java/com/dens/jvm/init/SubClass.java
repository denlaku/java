package com.dens.jvm.init;

public class SubClass extends SuperClass implements Inter{
	
	public static String SAME = "SAME";
	public static String SUBPI = "s3.14";
	public static final String TYPE = "Java";
	static {
		System.out.println("SubClass.init");
	}
}
