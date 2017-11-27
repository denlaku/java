package com.dens.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.util.ReflectionUtils;

public class TestClass {
	@Test
	public void test02() {
		Annotation[] annotations = Annos.class.getAnnotations();
		AnnotatedType[] annotatedInterfaces = Annos.class.getAnnotatedInterfaces();
		AnnotatedType annotatedSuperclass = Annos.class.getAnnotatedSuperclass();
		Annotation[] annotations2 = Annos.class.getPackage().getAnnotations();
		System.out.println(annotations.length);
		System.out.println(annotatedInterfaces.length);
		System.out.println(annotatedSuperclass);
		System.out.println(annotations2.length);
	}
	
	@Test
	public void test01() throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Field field = Annos.class.getDeclaredField("name");
		Annotation[] annotations = field.getDeclaredAnnotations();
		for (Annotation annotation: annotations) {
			Class<? extends Annotation> annotationType = annotation.annotationType();
			Method[] declaredMethods = annotationType.getDeclaredMethods();
			for (Method method: declaredMethods) {
				Object invoke = method.invoke(annotation);
				System.out.println(method.getName() + ":" + invoke);
			}
			
		}
	}
	
	static List<Method> getAttributeMethods(Class<? extends Annotation> annotationType) {
		List<Method> methods = new ArrayList<Method>();
		for (Method method : annotationType.getDeclaredMethods()) {
			if (isAttributeMethod(method)) {
				ReflectionUtils.makeAccessible(method);
				methods.add(method);
			}
		}

		return methods;
	}
	
	static boolean isAttributeMethod(Method method) {
		return (method != null && method.getParameterTypes().length == 0 && method.getReturnType() != void.class);
	}
}
