package com.dens.cglib;

import java.lang.reflect.Method;

import org.junit.Test;

import net.sf.cglib.beans.BeanGenerator;

public class TestClass {

	@Test
	public void test01() {
		BeanGenerator bg = new BeanGenerator();
		bg.addProperty("id", int.class);
		Object createClass = bg.createClass();
		if (createClass instanceof Class<?>) {
			Class<?> cls = (Class<?>)createClass;
			Method[] methods = cls.getDeclaredMethods();
			for (Method method: methods) {
				System.out.println(method.getName());
			}
			try {
				Object newInstance = cls.newInstance();
				System.out.println(newInstance);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
