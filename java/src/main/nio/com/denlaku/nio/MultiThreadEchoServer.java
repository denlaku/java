package com.denlaku.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadEchoServer {

	private static ExecutorService es = Executors.newCachedThreadPool();

	static class HandleMsg implements Runnable {
		Socket client;

		public HandleMsg(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
					PrintWriter pw = new PrintWriter(client.getOutputStream(), true);) {
				String inputLine = null;
				while ((inputLine = br.readLine()) != null) {
					pw.println(inputLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket client = null;
		try {
			ss = new ServerSocket(8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				client = ss.accept();
				es.execute(new HandleMsg(client));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
