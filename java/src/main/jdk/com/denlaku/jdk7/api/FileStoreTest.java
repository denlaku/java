package com.denlaku.jdk7.api;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;

import org.junit.Test;

import com.denlaku.Constant;

public class FileStoreTest {
	
	@Test
	public void test02() {
		Path path = Paths.get(TEMP);
		FileSystem fileSystem = path.getFileSystem();
		System.out.println("separator: " + fileSystem.getSeparator());
		FileSystemProvider provider = fileSystem.provider();
		System.out.println("provider: " + provider);
	}
	
	@Test
	public void test01() {
		Path path = Paths.get(TEMP);
		try {
			FileStore fileStore = Files.getFileStore(path);
			System.out.println("name: " + fileStore.name());
			System.out.println("type: " + fileStore.type());
			System.out.println("getTotalSpace: " + fileStore.getTotalSpace());
			System.out.println("getUnallocatedSpace: " + fileStore.getUnallocatedSpace());
			System.out.println("getUsableSpace: " + fileStore.getUsableSpace());
			System.out.println("isReadOnly: " + fileStore.isReadOnly());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static final String TEMP = Constant.TEMP;
}
