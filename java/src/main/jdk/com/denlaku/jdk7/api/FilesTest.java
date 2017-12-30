package com.denlaku.jdk7.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import com.denlaku.Constant;

public class FilesTest {

	@Test
	public void test010() {
		Path path = Paths.get(TEMP + "asm");
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path, "*.class")) {
			directoryStream.forEach(p -> System.out.println(p.getFileName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test04() {
		File file = new File(TEMP + "新建文本文档.txt");
		Path path = Paths.get(TEMP + "新建文本文档.txt");
		try {
			// 判断两个Path是否相同
			System.out.println(Files.isSameFile(path, file.toPath()));
			System.out.println(Files.isHidden(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test03() {
		Path path = Paths.get(TEMP + "新建文本文档.txt");
		try {
			// Files  删除文件
			// Files.delete(path);
			// Files.deleteIfExists(path);
			 Files.createFile(path);
//			Files.createFile(path, new FileAttribute<Set<PosixFilePermission>>(){
//
//				@Override
//				public String name() {
//					return "posix:permissions";
//				}
//
//				@Override
//				public Set<PosixFilePermission> value() {
//					Set<PosixFilePermission> sets = new HashSet<>();
//					sets.add(PosixFilePermission.OWNER_READ);
//					sets.add(PosixFilePermission.GROUP_WRITE);
//					return sets;
//				}
//				
//			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		Path srcPath = Paths.get(TEMP, "class_\\a", "KKK");
		Path targetPath = Paths.get(TEMP, "class_\\b", "KKK");
		try {
			// Files 复制文件
			Files.copy(srcPath, targetPath);
			// Files 移动文件
			// Files.move(srcPath, targetPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test01() {
		/**
		 * 新API Files
		 */
		Path path = Paths.get(TEMP, "class_", "KKK", "");
		try {
			if (!Files.exists(path)) {
				Path createFile = Files.createFile(path);
				File file = createFile.toFile();
				System.out.println(file);
				System.out.println(file.isDirectory());
				System.out.println(file.exists());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static final String TEMP = Constant.TEMP;
}
