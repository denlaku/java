package com.dens.clazz;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.util.ClassUtils;

@MessageMapping
public class TestClass01 {
	
//	{
//		class LocalClass {}
//		System.out.println("TestClass.enclosing_method()");
//		System.out.println(LocalClass.class.isLocalClass());
//	}
	
//	static {
//		class LocalClass {}
//		System.out.println("static TestClass.enclosing_method()");
//		System.out.println(LocalClass.class.isLocalClass());
//	}

	public native boolean isInstance(Object obj);
	
	class LocalClass2 {
		private LocalClass2(){}
	}
	
	private class InnerClass {
		private InnerClass() {}
	}
	
	public Object obj = new Object() {};
	
	@Test
	public void test07() {
		Package package1 = TestClass01.class.getPackage();
		System.out.println(package1.isSealed());
		System.out.println(package1.getAnnotations().length);
		for (Annotation annotation: package1.getAnnotations()) {
			Method[] methods = annotation.getClass().getDeclaredMethods();
			for(Method method: methods) {
				try {
					System.out.println(method);
					if (method.getParameterCount() == 0) {
						Object invoke = method.invoke(annotation);
						System.out.println(method.getName() + ", invoke: " + invoke);
					}
					
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void test06() {
//		System.out.println(Array.getLength(new Object())); //报错
		System.out.println(Array.getLength(new Object[10]));
		System.out.println(Array.getByte(new Object[]{1, 2, 3}, 0));
	}
	
	@Test
	public void test05() {
		System.out.println(int[].class.getName());
		System.out.println(Integer[].class.getName());
		System.out.println(byte[].class.getName());
		System.out.println(boolean[].class.getName());
		System.out.println(String[].class.getName());
		System.out.println(String[].class.getComponentType()); // 组件类型 ,只有数组类型才有这个值，其他的类型为bull
		System.out.println(String.class.getComponentType());
		System.out.println(ClassUtils.getQualifiedName(String[].class));
		System.out.println(String[].class.getName());
		System.out.println(String[].class.getSimpleName());
		System.out.println(ClassUtils.getQualifiedName(String[][].class));
		System.out.println(String[][].class.getName());
		System.out.println(String[][].class.getSimpleName());
	}
	
	/**
	 * java中基础类有9个 byte， short， int， long， float， double， boolean， char， void， 共9个
	 */
	@Test
	public void test04() {
		System.out.println(int.class.isPrimitive());
		System.out.println(Integer.class.isPrimitive());
		System.out.println(String.class.isPrimitive());
		System.out.println(void.class.isPrimitive());
		System.out.println(Class.class.isPrimitive());
		System.out.println(Object.class.isPrimitive());
	}
	
	@Test
	public void test03() {
		System.out.println(TestClass01.class.isSynthetic());
		try {
			System.out.println(InnerClass.class.getMethod("toString").isSynthetic());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 本地类： 在方法体内、代码块、 静态代码块中声明的类
	 */
	@Test
	public void test02() {
		class LocalClass {
//			class InnerClass11{}
		}
		System.out.println(TestClass01.class.isLocalClass());
		System.out.println(TestClass01.class.getEnclosingClass());
		System.out.println(LocalClass2.class.isLocalClass());
		System.out.println(LocalClass.class.isLocalClass());
		System.out.println(obj.getClass().isAnonymousClass());
	}
	
	/**
	 * 判定此 Class 对象所表示的类或接口与指定的 Class 参数所表示的类或接口是否相同，或是否是其超类或超接口。
	 */
	@Test
	public void test01() {
		System.out.println(TestClass01.class.isAssignableFrom(Object.class));
		System.out.println(Object.class.isAssignableFrom(TestClass01.class));
		System.out.println(Object.class.isAssignableFrom(List.class));
		System.out.println(Object.class.isAssignableFrom(Object.class));
//		System.out.println(Object.class.isAssignableFrom(null)); 报错
		System.out.println(ArrayList.class.isAssignableFrom(ArrayList.class));
		System.out.println(List.class.isAssignableFrom(ArrayList.class));
	}
}
