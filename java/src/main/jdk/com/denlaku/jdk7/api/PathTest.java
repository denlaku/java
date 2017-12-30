package com.denlaku.jdk7.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class PathTest {

	@Test
	public void test02() throws IOException {
		Path path = Paths.get("C:\\Users\\User", "Desktop", "class_\\a", "KKK");
		File file = path.toFile();
		System.out.println(Files.isReadable(path));
		System.out.println(Files.size(path));
		Path path2 = Paths.get(file.toURI());
		System.out.println(path2);
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile());
	}

	@Test
	public void test01() {
		/**
		 * 新API Path
		 */
		Path path = Paths.get("C:\\Users\\User", "Desktop", "class_", "ArrayBlockingQueue.png");
		System.out.println(path.getClass());
		System.out.println(path.startsWith("C:\\"));
		System.out.println(path.endsWith("ArrayBlockingQueue.png"));
		System.out.println(path.toUri());
		System.out.println("----------------------------------------");
		path.forEach((a) -> {
			System.out.println(a);
		});
		System.out.println("----------------------------------------");
		System.out.println("path: " + path);
		System.out.println("path.toFile(): " + path.toFile());
		System.out.println("path.getNameCount(): " + path.getNameCount());
		System.out.println("path.getRoot(): " + path.getRoot());
		System.out.println("path.getFileName(): " + path.getFileName());
		System.out.println("path.isAbsolute(): " + path.isAbsolute());
		System.out.println("path.getParent(): " + path.getParent());
	}

}
