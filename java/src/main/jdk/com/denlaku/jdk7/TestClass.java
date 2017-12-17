package com.denlaku.jdk7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

import org.junit.Test;

public class TestClass {
	
	@Test
	public void test09() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		LocalDate now2 = LocalDate.now();
		System.out.println(now2);
		LocalTime now3 = LocalTime.now();
		System.out.println(now3);
		ZoneId of = ZoneId.of("Australia/Darwin");
		System.out.println(of);
	}


	@Test
	public void test03() {
		File srcFile = new File("");
		File targetFile = new File("");
		try {
			FileInputStream fis = new FileInputStream(srcFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			InputStreamReader isr = new InputStreamReader(bis);
			BufferedReader br = new BufferedReader(isr);

			FileOutputStream fos = new FileOutputStream(targetFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			OutputStreamWriter osw = new OutputStreamWriter(bos);
			BufferedWriter bw = new BufferedWriter(osw);

			String line = br.readLine();
			bw.write(line);

			br.close();
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SafeVarargs
	public static <T> T useVarargs(T... args) {
		return args.length > 0 ? args[0] : null;
	}

	@Test
	public void test02() {
		/**
		 * 二进制、八进制、十进制、十六进制的数字字面量 数字能以下划线分隔
		 */
		int i = 131_191;
		System.out.println(i);
		int a = 0b111;
		System.out.println(a);
		int b = 0234;
		System.out.println(b);
		int c = 0x30;
		System.out.println(c);
	}

	@Test
	public void test01() {
		String i = "";
		// byte i = 1;
		// short i = 1;
		// int i = 0;
		// Byte i = 1;
		// Short i = 1;
		// Integer i = 1;

		// char i = 'A';
		// Character i = 1;
		switch (i) {

		}
	}
}
