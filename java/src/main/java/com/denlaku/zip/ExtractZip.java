package com.denlaku.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.denlaku.Constant;

public abstract class ExtractZip {

	public static void main(String[] args) {
		String outputDest = Constant.TEMP + "javazip/input/";
		String zipFileName = Constant.TEMP + "javazip/output/test.zip";
		ArrayList<String> a = ExtractZip.unzip(zipFileName, outputDest);
		for (String s : a) {
			System.out.println(s);
		}
	}
	
	public static ArrayList<String> unzip(File zipFile, String destPath) {
		Objects.requireNonNull(destPath);
		String tempPath = destPath;
		if (!tempPath.endsWith("/")) {
			tempPath += "/";
		}
		ArrayList<String> allFileName = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream(zipFile);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = null;
			byte[] ch = new byte[256];
			while ((ze = zis.getNextEntry()) != null) {
				System.out.println("ZipEntryName: " + ze.getName());
				File zfile = new File(destPath + ze.getName());
				if (ze.isDirectory()) {
					if (!zfile.exists())
						zfile.mkdirs();
					zis.closeEntry();
				} else {
					File fpath = new File(zfile.getParentFile().getPath());
					if (!fpath.exists())
						fpath.mkdirs();
					FileOutputStream fos = new FileOutputStream(zfile);
					int size;
					allFileName.add(zfile.getAbsolutePath());
					while ((size = zis.read(ch)) != -1)
						fos.write(ch, 0, size);
					zis.closeEntry();
					fos.close();
				}
			}
			zis.close();
			zis.close();
		} catch (Exception e) {
			System.err.println("Extract error:" + e.getMessage());
		}
		return allFileName;
	}

	public static ArrayList<String> unzip(String zipFileName, String destPath) {
		return unzip(new File(zipFileName), destPath);
	}
	
	private ExtractZip() {}
}
