package com.denlaku.socket.rpc.service;

import com.denlaku.socket.rpc.vo.SocketVO;

public interface HelloService {

	SocketVO findById(Long id);

}