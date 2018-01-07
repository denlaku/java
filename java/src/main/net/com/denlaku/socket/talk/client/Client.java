package com.denlaku.socket.talk.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private String serverIp = "10.10.10.2";
	private int serverPort = 8000;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter out;
	private boolean flag = true;

	public void stratUp() {
		BufferedReader sbr = null;
		try {
			socket = new Socket(serverIp, serverPort);
			out = new PrintWriter(socket.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out.println("老林");
			// out.println("老周");
			sbr = new BufferedReader(new InputStreamReader(System.in));

			new Thread(new ClientThread()).start();
			String str = null;
			while (flag && (str = sbr.readLine()) != null) {
				if (!flag)
					break;
				out.println(str);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (sbr != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void receive() {
		try {
			String rs = br.readLine();
			if (rs.equalsIgnoreCase("disconnect")) {
				flag = false;
				System.out.println("点击回车退出");
			}
			System.out.println(rs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class ClientThread implements Runnable {

		@Override
		public void run() {
			while (true) {
				if (!flag)
					break;
				receive();
			}
		}

	}

}