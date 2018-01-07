package com.denlaku.socket.talk.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
	private List<ServerThread> clients = null;
	ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 3, TimeUnit.MINUTES,
			new LinkedBlockingQueue<>());

	public void startUp() {
		System.out.println("startUp...");
		ServerSocket ss = null;
		Socket s = null;
		try {
			ss = new ServerSocket(8000);
			clients = new ArrayList<ServerThread>();
			while (true) {
				s = ss.accept();
				ServerThread st = new ServerThread(s);
//				new Thread(st).start();
				threadPoolExecutor.execute(st);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ss != null)
					ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private class ServerThread implements Runnable {
		private Socket s = null;
		private BufferedReader br;
		private PrintWriter out;
		private String name;
		private boolean flag = true;

		public ServerThread(Socket socket) throws IOException {
			this.s = socket;
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			String str = br.readLine();
			name = str + "[" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "]";
			clients.add(this);
			send(name + "上线了");
		}

		private void send(String msg) {
			System.out.println(msg);
			for (ServerThread st : clients)
				st.out.println(msg);
		}

		private void receive() throws IOException {
			String str = null;
			while ((str = br.readLine()) != null) {
				if (str.equalsIgnoreCase("quit")) {
					stop();
					out.println("disconnect");
					break;
				}
				send(name + ":" + str);
			}
		}

		private void stop() {
			clients.remove(this);
			flag = false;
			send(name + "已经下线了");
		}

		@Override
		public void run() {
			try {
				while (true) {
					if (!flag)
						break;
					receive();
				}
			} catch (SocketException e) {
				stop();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (s != null)
						s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}