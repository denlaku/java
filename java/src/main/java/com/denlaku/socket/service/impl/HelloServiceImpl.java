package com.denlaku.socket.service.impl;

import com.denlaku.socket.service.HelloService;

public class HelloServiceImpl implements HelloService {

	public String sayHi(String name) {
		return "Hi, 1111--" + name;
	}

}