package com.denlaku;

public abstract class Constant {
	public static final String TEMP = "D:/temp/";
	public static final String ETEMP = "D:/denlaku.git/java-training/java/temp";
	public static final String CLASSPATH = Constant.class.getClassLoader().getResource("").getPath();
	private Constant() {
	}
}
