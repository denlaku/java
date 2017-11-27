package com.dens.ip;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.junit.Test;

public class MacAddress {
	@Test
	public void test01() {
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + address.getHostAddress());
			String macAddress = getMacAddress(address);
			System.out.println(macAddress);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	private String getMacAddress(InetAddress address) throws SocketException {
		NetworkInterface network = NetworkInterface.getByInetAddress(address);
		byte[] mac = network.getHardwareAddress();
		System.out.println("name->IP: " + address.getHostName() + "->" + address.getHostAddress());
		if (mac == null) {
			System.err.println("Mac address is null");
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}
		return sb.toString();
	}
	
	@Test
	public void test02() {
		List<InetAddress> addresses = getAddresses();
		for (InetAddress address: addresses) {
			try {
				String macAddress = getMacAddress(address);
				System.out.println("Current MAC address : " + macAddress);
			} catch (SocketException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<InetAddress> getAddresses() {
		List<InetAddress> addrs = new ArrayList<>();
		try {
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress addr = null;
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				// String name = netInterface.getName();
				// System.out.println(name);
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					addr = (InetAddress) addresses.nextElement();
					if (addr != null && addr instanceof Inet4Address) {
						addrs.add(addr);
						// System.out.println("本机的IP: " + addr.getHostAddress()
						// + ", name: " + name);
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return addrs;
	}
}
