package com.denlaku.socket.service.impl;

import com.denlaku.socket.service.HelloService;
import com.denlaku.socket.vo.SocketVO;

public class HelloServiceImpl implements HelloService {

	@Override
	public SocketVO findById(Long id) {
		SocketVO socket = new SocketVO();
		socket.setId(id);
		socket.setName("name-" + id);
		return socket;
	}

}