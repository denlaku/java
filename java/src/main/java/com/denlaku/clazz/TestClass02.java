
package com.denlaku.clazz;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestClass02 {

	
	@Test
	public void test02() {
		try {
			Constructor<ClassSub> constructor = ClassSub.class.getConstructor();
			Constructor<?>[] declaredConstructors = ClassSub.class.getDeclaredConstructors();
			System.out.println(declaredConstructors.length);
			System.out.println(constructor);
			Annotation[] annotations = constructor.getAnnotations();
			System.out.println(annotations.length);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test01() {
		Annotation[] annotations = ClassSub.class.getAnnotations();
		System.out.println(annotations.length);
		AnnotatedType[] annotatedInterfaces = ClassSub.class.getAnnotatedInterfaces();
		for (AnnotatedType annotatedType: annotatedInterfaces) {
			System.out.println(annotatedType);
		}
	}
}
