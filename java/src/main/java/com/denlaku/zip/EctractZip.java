package com.denlaku.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class EctractZip {

	public static void main(String[] args) {
		// EctractZip z = new EctractZip();
		String outputDest = "C:\\Users\\User\\Desktop\\javazip\\";
		String zipFileName = "C:\\Users\\User\\Desktop\\test.zip";
		ArrayList<String> a = EctractZip.ectract(zipFileName, outputDest);
		for (String s : a) {
			System.out.println(s);
		}
	}
	
	public static ArrayList<String> ectract(File zipFile, String destPath) {
		ArrayList<String> allFileName = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream(zipFile);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = null;
			byte[] ch = new byte[256];
			while ((ze = zis.getNextEntry()) != null) {
				System.out.println("ZipEntryName: " + ze.getName());
				File zfile = new File(destPath + ze.getName());
				File fpath = new File(zfile.getParentFile().getPath());
				if (ze.isDirectory()) {
					if (!zfile.exists())
						zfile.mkdirs();
					zis.closeEntry();
				} else {
					if (!fpath.exists())
						fpath.mkdirs();
					FileOutputStream fos = new FileOutputStream(zfile);
					int i;
					allFileName.add(zfile.getAbsolutePath());
					while ((i = zis.read(ch)) != -1)
						fos.write(ch, 0, i);
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

	public static ArrayList<String> ectract(String zipFileName, String destPath) {
		return ectract(new File(zipFileName), destPath);
	}
}
