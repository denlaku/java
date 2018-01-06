package com.denlaku.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.denlaku.Constant;

public abstract class CompressZip {

	public static void main(String[] temp) {
		try {
			String inputFileName = Constant.TEMP + "javazip/input";
			String zipFileName = Constant.TEMP + "javazip/output/test.zip";
			CompressZip.zip(inputFileName, zipFileName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
			int buf;
			System.out.println(base);
			while ((buf = in.read()) != -1) {
				out.write(buf);
			}
			in.close();
		}
	}

	private CompressZip() {
	}
}
