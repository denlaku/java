package com.dens.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public abstract class CompressZip {
	private CompressZip() {
	}

	public static void zip(String inputFilePath, String zipFileName) throws Exception {
		System.out.println(zipFileName);
		zip(new File(inputFilePath), zipFileName);
	}

	public static void zip(File inputFile, String zipFileName) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		zip(out, inputFile, "");
		System.out.println("zip done");
		out.close();
	}

	private static void zip(ZipOutputStream out, File f, String base) throws Exception {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			System.out.println(base);
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
		}
	}

	public static void main(String[] temp) {
		try {
			String inputFileName = "C:\\Users\\User\\Desktop\\javazip";
			String zipFileName = "C:\\Users\\User\\Desktop\\test.zip";
			CompressZip.zip(inputFileName, zipFileName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
