package com.dens.designpattern.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.dens.Constant;

public class TestClass {
	@Test
	public void test01() {
		Singleton instance = Singleton.INSTANCE;
		System.out.println(instance);
		File file = new File(Constant.TEMP + "serialize/out");
		FileOutputStream fos;
		ObjectOutputStream oos;
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
			oos.flush();
			
			System.out.println(instance);
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			Object readObject = ois.readObject();
			System.out.println(readObject);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
