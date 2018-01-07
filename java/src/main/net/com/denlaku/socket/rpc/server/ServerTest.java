package com.denlaku.socket.rpc.server;

import java.io.IOException;

import com.denlaku.socket.rpc.service.HelloService;
import com.denlaku.socket.rpc.service.impl.HelloServiceImpl;

public class ServerTest {
	public static void main(String[] args) throws IOException {
		new Thread(new Runnable() {
			public void run() {
				try {
					Server serviceServer = new ServerCenter(8088);
					serviceServer.register(HelloService.class, HelloServiceImpl.class);
					serviceServer.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
