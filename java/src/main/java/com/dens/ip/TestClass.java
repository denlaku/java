package com.dens.ip;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import org.junit.Test;

public class TestClass {

	@Test
	public void test02() {
		// 获取本机IP地址的方法二
		try {
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress addr = null;
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				String name = netInterface.getName();
//				System.out.println(name);
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					addr = (InetAddress) addresses.nextElement();
					if (addr != null && addr instanceof Inet4Address) {
						System.out.println("本机的IP: " + addr.getHostAddress() + ", name: " + name);
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test01() {
		/*
		 * 只能在Windows上使用，Linux平台就gei屁了
		 */
		try {
			System.out.println("本机的IP = " + InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
