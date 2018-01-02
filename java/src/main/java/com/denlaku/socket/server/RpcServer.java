package com.denlaku.socket.server;

import java.io.IOException;

import com.denlaku.socket.service.HelloService;
import com.denlaku.socket.service.impl.HelloServiceImpl;

public class RpcServer {

	public static void main(String[] args) throws IOException {
		new Thread(new Runnable() {
			public void run() {
				try {
					Server serviceServer = new ServiceCenter(8088);
					serviceServer.register(HelloService.class, HelloServiceImpl.class);
					serviceServer.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}