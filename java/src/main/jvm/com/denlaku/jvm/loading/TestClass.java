package com.denlaku.jvm.loading;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestClass {

	@Test
	public void test02() {
		String str = Demo01.STR;
		System.out.println(str);
	}

	@Test
	public void test01() {
		Class<?> clazz = Demo01.class;
		try {
			Method declaredMethod = clazz.getDeclaredMethod("getString");
			Object invoke = declaredMethod.invoke(new Demo01());
			System.out.println(invoke);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
