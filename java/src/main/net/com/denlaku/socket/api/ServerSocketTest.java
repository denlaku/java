package com.denlaku.socket.api;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {

	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket();) {
			ss.bind(new InetSocketAddress(8088));
			int i = 1;
			while (true) {
				System.out.println("第" + i + "次: start");
				Socket accept = ss.accept();
				ObjectInputStream ois = new ObjectInputStream(accept.getInputStream());
				String readUTF = ois.readUTF();
				System.out.println("第" + (i++) + "次: " + readUTF);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
