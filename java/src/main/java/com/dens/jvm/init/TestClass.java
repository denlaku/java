package com.dens.jvm.init;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

import org.junit.Test;

public class TestClass implements Serializable, Closeable {

	private static final long serialVersionUID = 1L;
	public static final int i = 10;

	@Test
	public void test04() {
		System.out.println(SubClass.SAME);
	}

	@Test
	public void test03() {
		/*
		 * 引用类的常量时，也不会触发此类的初始化。
		 * 因为常量在类编译阶段就会存入调用类的常量池
		 * 本质上并没有直接引用到定义常量的类
		 */
		String type = SubClass.TYPE;
		System.out.println(type);
	}

	@Test
	public void test02() {
		// 通过数组定义类应用类， 不会触发类的初始化
		SubClass[] subs = new SubClass[10];
		System.out.println(subs);
	}

	@Test
	public void test01() {
		// 通过子类调用父类的静态字段、静态方法， 不会触发子类的初始化，只会初始化父类
		String pI = SubClass.PI;
		System.out.println(pI);
		String pi2 = SubClass.getPI();
		System.out.println(pi2);
	}

	@Override
	public void close() throws IOException {

	}

}
