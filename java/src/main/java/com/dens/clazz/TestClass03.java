package com.dens.clazz;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.ParameterDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestClass03 {
	
	@Test
	public void test05() {
		Map<String, Object> props = new HashMap<>();
		props.put("name", "Tom");
		props.put("age", 1000);
		Class<ClassSub> cls = ClassSub.class;
		try {
			ClassSub newInstance = cls.newInstance();
			BeanInfo beanInfo = Introspector.getBeanInfo(cls);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propDesc: propertyDescriptors) {
				Method writeMethod = propDesc.getWriteMethod();
				if (writeMethod != null) {
//					String displayName = propDesc.getDisplayName();
					String name = propDesc.getName();
					Object value = props.get(name);
					writeMethod.invoke(newInstance, value);
				}
//				String displayName = propDesc.getDisplayName();
//				String name = propDesc.getName();
//				System.out.println(displayName);
//				System.out.println(name);
			}
			System.out.println(newInstance);
		} catch (IntrospectionException e) {
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
	
	@Test
	public void test04() {
		Class<ClassSub> cls = ClassSub.class;
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(cls);
			MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
			for (MethodDescriptor methodDescriptor: methodDescriptors) {
				String displayName = methodDescriptor.getDisplayName();
				String name = methodDescriptor.getName();
				ParameterDescriptor[] parameterDescriptors = methodDescriptor.getParameterDescriptors();
				System.out.println("displayName: " + displayName);
				System.out.println("name: " + name);
				System.out.println("parameterDescriptors: " + parameterDescriptors);
				System.out.println(methodDescriptor.getDisplayName() + ": " + methodDescriptor.isExpert());
				System.out.println(methodDescriptor.getDisplayName() + ": " + methodDescriptor.isHidden());
				System.out.println(methodDescriptor.getDisplayName() + ": " + methodDescriptor.isPreferred());
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test03() {
		Class<ClassSub> cls = ClassSub.class;
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(cls);
			BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
			Class<?> beanClass = beanDescriptor.getBeanClass();
			System.out.println(beanClass);
			Enumeration<String> attributeNames = beanDescriptor.attributeNames();
			if (attributeNames != null) {
				while(attributeNames.hasMoreElements()) {
					System.out.println(attributeNames.nextElement());
				}
			}
			
			String displayName = beanDescriptor.getDisplayName();
			String name = beanDescriptor.getName();
			String shortDescription = beanDescriptor.getShortDescription();
			Class<?> customizerClass = beanDescriptor.getCustomizerClass();
			System.out.println("customizerClass: " + customizerClass);
			System.out.println("displayName: " + displayName);
			System.out.println("name: " + name);
			System.out.println("shortDescription: " + shortDescription);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test02() {
		Class<ClassSub> cls = ClassSub.class;
		Constructor<?>[] constructors = cls.getConstructors();
		for (Constructor<?> constructor: constructors) {
			try {
				System.out.println(constructor.newInstance());
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

	@Test
	public void test01() {
		Class<ClassSub> cls = ClassSub.class;
		Method[] methods = cls.getDeclaredMethods();
		ClassSub cs = new ClassSub();
		for (Method method: methods) {
			try {
				System.out.println(method.getName() + ":" + method.invoke(cs));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}
