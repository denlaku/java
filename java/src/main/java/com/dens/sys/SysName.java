package com.dens.sys;

import java.util.Properties;

public class SysName {

	public static void main(String[] args) {
		String osname = System.getProperty("os.name");
		System.out.println(osname);
		Properties properties = System.getProperties();
		properties.keys();
		for (Object key: properties.keySet()) {
			Object value = properties.get(key);
			System.out.println(key + " : " + value);
		}
	}
}
