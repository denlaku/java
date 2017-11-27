package com.dens.jvm.classloader;

import java.net.MalformedURLException;

public class MyClassLoaderTest {
	
	public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {

		MyClassLoader loader = new MyClassLoader();
//		Thread currentThread = Thread.currentThread();
//		ClassLoader contextClassLoader = currentThread.getContextClassLoader();
//		System.out.println(contextClassLoader);
//		Thread.currentThread().setContextClassLoader(loader);
		Class<?> pointClass = loader.loadClass("com.dens.jvm.classloader.Point");
		System.out.println(pointClass);
		try {
			
			System.out.println(Point.class.equals(pointClass));
			System.out.println(pointClass.getClassLoader());
			// 父类的类加载器要么和子类相同，要么就一定是应用类加载器
			// 以java.开头的类，不能通过自定义的类加载器进行加载
			System.out.println(pointClass.getSuperclass() + ": " + pointClass.getSuperclass().getClassLoader());
			System.out.println(pointClass.getSuperclass().getSuperclass() + ": " + pointClass.getSuperclass().getSuperclass().getClassLoader());
			
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	}
	
}
