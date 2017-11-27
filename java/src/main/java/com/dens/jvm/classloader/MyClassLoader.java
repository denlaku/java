package com.dens.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
	
	private byte[] bts;
	
	public MyClassLoader(byte[] bts) {
		super();
		this.bts = bts;
	}
	
	public MyClassLoader() {
		super();
	}



	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		byte[] bytes = this.bts;
		try {
			if (bytes == null || bytes.length == 0) {
				InputStream is = getBytesByName(name);
				if (is == null) {
					return super.loadClass(name);
				}
				byte[] buf = new byte[is.available()];
				is.read(buf);
				bytes = buf;
			}
			return defineClass(name, bytes, 0, bytes.length);
		} catch (IOException e) {
			throw new ClassNotFoundException();
		}
	}



	private InputStream getBytesByName(String name) {
		String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
		InputStream is = getClass().getResourceAsStream(fileName);
		return is;
	}
	
}
