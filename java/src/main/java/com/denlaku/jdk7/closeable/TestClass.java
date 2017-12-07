package com.denlaku.jdk7.closeable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.OutputStream;

import org.junit.Test;

public class TestClass {

	@Test
	public void test01() {
		/**
		 * 实现了Closeable的接口
		 */
		try (CloseableResource mr = new CloseableResource();) {
			System.out.println(mr);
		} catch (Exception e) {

		}
	}
	
	@Test
	public void test02() {
		String filePath = "D:/sts-bundle-3.8.4/workspace/spring/test/j01/src/main/java/com/dens/jdk7/Animal.java";
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
				OutputStream oc = null;) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
		} finally {

		}
	}
}
