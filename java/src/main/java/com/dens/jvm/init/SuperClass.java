package com.dens.jvm.init;

public class SuperClass {

	public static String SAME = "SuperClass-SAME";
	public static String PI = "3.14";
	static {
		System.out.println("SuperClass.init");
	}

	public static String getPI() {
		return PI;
	}

	public static void setPI(String pI) {
		PI = pI;
	}

}
