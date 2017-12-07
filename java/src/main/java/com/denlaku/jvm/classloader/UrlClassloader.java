package com.denlaku.jvm.classloader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

public class UrlClassloader {

	public static void main(String[] args) throws IOException {
		URL url;
		try {
			url = new URL("http://localhost:10000/classes/Point2.class");
			URLConnection openConnection = url.openConnection();
			URL url2 = openConnection.getURL();
			
			try (URLClassLoader loader = new URLClassLoader(new URL[] { url2 });) {

				Class<?> loadClass = loader.loadClass("com.dens.jvm.classloader.Point2");
				System.out.println(loadClass);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}
}
