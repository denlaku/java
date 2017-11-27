package com.dens.zip;

import java.io.File;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String inputFileName = "C:\\Users\\User\\Desktop\\javazip";
		File file = new File(inputFileName);
		System.out.println(Arrays.toString(file.listFiles()));
	}
}
