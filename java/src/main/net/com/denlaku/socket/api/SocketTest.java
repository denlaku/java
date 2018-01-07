package com.denlaku.socket.api;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {

	public static void main(String[] args) {
		try (Socket socket = new Socket("10.10.10.2", 8088);) {
			ObjectOutputStream ois = new ObjectOutputStream(socket.getOutputStream());
			ois.writeUTF("中国");
			ois.flush();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
