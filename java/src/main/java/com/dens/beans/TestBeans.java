package com.dens.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.ParameterDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Arrays;

import org.junit.Test;

public class TestBeans {

	
	@Test
	public void test09() {
		Class<Person> clazz = Person.class;
		try {
			PropertyDescriptor pd = new PropertyDescriptor("id", clazz);
			pd.getReadMethod();
			System.out.println(pd.getDisplayName());
			System.out.println(pd.getName());
			System.out.println(pd.getShortDescription());
			System.out.println(pd.getPropertyType());
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test08() {
		Class<Person> clazz = Person.class;
		try {
			Method method = clazz.getMethod("setId", int.class);
			MethodDescriptor md = new MethodDescriptor(method);
			ParameterDescriptor[] parameterDescriptors = md.getParameterDescriptors();
			System.out.println(Arrays.toString(parameterDescriptors));
			Parameter[] parameters = method.getParameters();
			for (Parameter parameter: parameters) {
				System.out.println(parameter.getType());
				System.out.println(parameter.getName());
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test07() {
		Class<Sub> clazz = Sub.class;
		try {
			Method method = clazz.getMethod("setDiv", String.class);
			MethodDescriptor md = new MethodDescriptor(method);
			ParameterDescriptor[] parameterDescriptors = md.getParameterDescriptors();
			System.out.println(Arrays.toString(parameterDescriptors));
			Parameter[] parameters = method.getParameters();
			for (Parameter parameter: parameters) {
				System.out.println(parameter);
				System.out.println(parameter.getName());
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test06() {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(Sub.class, Introspector.IGNORE_IMMEDIATE_BEANINFO);
			MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
			for (MethodDescriptor methodDescriptor : methodDescriptors) {
				ParameterDescriptor[] parameterDescriptors = methodDescriptor.getParameterDescriptors();
				System.out.println(methodDescriptor.getDisplayName());
				System.out.println(Arrays.toString(parameterDescriptors));
			}

		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test05() {
		Class<Person> clazz = Person.class;
		try {
			Method method = clazz.getMethod("setName", String.class);

			method.getReturnType();
			Object defaultValue = method.getDefaultValue();
			System.out.println(defaultValue);

			Class<?>[] parameterTypes = method.getParameterTypes();
			System.out.println(parameterTypes);

			Parameter[] parameters = method.getParameters();
			for (Parameter parameter : parameters) {
				Class<?> type = parameter.getType();
				String name = type.getName();
				System.out.println(name);

				Type parameterizedType = parameter.getParameterizedType();
				System.out.println(parameterizedType);

				Annotation[] annotations = parameter.getAnnotations();
				System.out.println(Arrays.toString(annotations));

				Dom[] annotationsByType = parameter.getAnnotationsByType(Dom.class);
				System.out.println(Arrays.toString(annotationsByType));

				Annotation[] declaredAnnotations = parameter.getDeclaredAnnotations();
				System.out.println(Arrays.toString(declaredAnnotations));
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test04() {
		try {
			PropertyDescriptor pd = new PropertyDescriptor("student", Person.class);
			Method readMethod = pd.getReadMethod();
			Person p = new Person();
			Object invoke = readMethod.invoke(p);
			System.out.println(invoke);
			System.out.println("property type : " + pd.getPropertyType());
		} catch (IntrospectionException e) {
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

	@Test
	public void test03() {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
			MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
			for (MethodDescriptor methodDescriptor : methodDescriptors) {
				Method method = methodDescriptor.getMethod();
				System.out.println(method.getName());
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		SimpleBeanInfo sb = new SimpleBeanInfo();
		MethodDescriptor[] methodDescriptors = sb.getMethodDescriptors();
		for (MethodDescriptor methodDescriptor : methodDescriptors) {
			Method method = methodDescriptor.getMethod();
			System.out.println(method.getName());
		}
	}

	@Test
	public void test01() {
		try {
			PropertyDescriptor pd = new PropertyDescriptor("id", Person.class);
			System.out.println(pd);
			Person p1 = new Person();
			Method writeMethod = pd.getWriteMethod();
			writeMethod.invoke(p1, 100);

			PropertyDescriptor pd2 = new PropertyDescriptor("student", Person.class);
			Method writeMethod2 = pd2.getWriteMethod();
			writeMethod2.invoke(p1, true);

			System.out.println(p1);
		} catch (IntrospectionException e) {
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
