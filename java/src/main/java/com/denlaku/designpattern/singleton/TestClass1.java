package com.denlaku.designpattern.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.denlaku.Constant;

public class TestClass1 {
	private static final String TEMP = Constant.TEMP;
	
	@Test
	public void test02() {
		Singleton0 instance = Singleton0.getInstance();
		File file = new File(TEMP + "serialize/out");
		FileOutputStream fos;
		ObjectOutputStream oos;
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
			oos.flush();
			
			System.out.println(instance);
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			Object readObject = ois.readObject();
			System.out.println(readObject);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test01() {
		Singleton0 instance = Singleton0.getInstance();
		System.out.println(instance);
			Constructor<Singleton0> constructor;
			try {
				constructor = Singleton0.class.getDeclaredConstructor();
				constructor.setAccessible(true);
				Singleton0 newInstance = constructor.newInstance();
				System.out.println(newInstance);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
	}
}
