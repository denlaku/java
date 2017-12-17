package com.denlaku.jvm.test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.junit.Test;

public class TestClass {

	@Test
	public void test01() {

	}

	public static void main(String[] args) {
		try {
			Double calculate = new TestClass().calculate("1000 + 1000");
			System.out.println(calculate);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public Double calculate(String expr) throws URISyntaxException {
		String className = "CalculatorMain";
		String methodName = "calculate";
		String source = "class " + className
				+ " { public static void main(String[] args){System.out.println(calculate());} public static double "
				+ methodName + "() { return " + expr + "; } }";
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		StringSourceJavaObject sourceObject = new TestClass.StringSourceJavaObject("Main", source);
		Iterable<? extends JavaFileObject> fileObjects = Arrays.asList(sourceObject);
		CompilationTask task = compiler.getTask(null, fileManager, null, null, null, fileObjects);

		boolean result = task.call();
		if (result) {
//			ClassLoader loader = Thread.currentThread().getClass().getClassLoader();
			ClassLoader loader = getClass().getClassLoader();
			try {
				Class<?> clazz = loader.loadClass(className);
				Method method = clazz.getMethod(methodName, new Class<?>[] {});
				Object value = method.invoke(null, new Object[] {});
				return (Double) value;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0D;

	}

	static class StringSourceJavaObject extends SimpleJavaFileObject {

		private String content = null;

		public StringSourceJavaObject(String name, String content) throws URISyntaxException {
			super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
			this.content = content;
		}

		public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
			return content;
		}
	}

}
