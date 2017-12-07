package com.denlaku.j2ee.rmi.server;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.denlaku.j2ee.rmi.HelloImpl;
import com.denlaku.j2ee.rmi.IHello;

public class HelloRmiServer {

	public static void main(String[] args) {
		try {
			InetAddress localHost = Inet4Address.getLocalHost();
			System.out.println(localHost);
			IHello hello = new HelloImpl();
			int port = 1100;
			LocateRegistry.createRegistry(port);
			Naming.rebind("rmi://" + localHost + "/hello", hello);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
