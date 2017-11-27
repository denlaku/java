package com.dens.j2ee.rmi.client;

import java.rmi.Naming;

import com.dens.j2ee.rmi.IHello;

public class HelloRmiClient {
	public static void main(String[] args) {
		try {
			IHello hello = (IHello) Naming.lookup("rmi://10.10.10.3:1099/hello");
			System.out.println(hello.sayHello("zhangxianxin===11"));
			System.out.println(hello.run(100));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}