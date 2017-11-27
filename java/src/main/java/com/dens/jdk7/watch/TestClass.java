package com.dens.jdk7.watch;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import org.junit.Test;

public class TestClass {

	@Test
	public void test01() throws IOException, InterruptedException {

		String filePath = ("C:/Users/User/Desktop/temp");

		// 获取文件系统的WatchService对象
		WatchService watchService = FileSystems.getDefault().newWatchService();
		Paths.get(filePath).register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.OVERFLOW);

//		File file = new File(filePath);
//		LinkedList<File> fList = new LinkedList<File>();
//		fList.addLast(file);
//		while (fList.size() > 0) {
//			File f = fList.removeFirst();
//			if (f.listFiles() == null)
//				continue;
//			for (File file2 : f.listFiles()) {
//				if (file2.isDirectory()) {// 下一级目录
//					fList.addLast(file2);
//					// 依次注册子目录
//					Paths.get(file2.getAbsolutePath()).register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
//							StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
//				}
//			}
//		}

		while (true) {
			// 获取下一个文件改动事件
			WatchKey key = watchService.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				System.out.println(event.context() + " --> " + event.kind());
			}
			// 重设WatchKey
			boolean valid = key.reset();
			// 如果重设失败，退出监听
			if (!valid) {
				break;
			}
		}
	}
}
