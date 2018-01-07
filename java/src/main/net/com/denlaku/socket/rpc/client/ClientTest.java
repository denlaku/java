package com.denlaku.socket.rpc.client;

import java.net.InetSocketAddress;

import com.denlaku.socket.rpc.service.HelloService;

public class ClientTest {
	public static void main(String[] args) {
		HelloService service = RpcClient.getRemoteProxyObj(HelloService.class,
				new InetSocketAddress("localhost", 8088));
		System.out.println(service.findById(1L));
	}
}
