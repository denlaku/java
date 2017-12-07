package com.denlaku.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerSocketChannelDemo {

	public static void main(String[] args) {
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(14001));
			while (true) {
				SocketChannel socketChannel = serverSocketChannel.accept();
				ByteBuffer bb = ByteBuffer.allocate(64);
				if (socketChannel.read(bb) != -1) {
					bb.flip();
					String string = Charset.forName("UTF-8").newDecoder().decode(bb).toString();
					System.out.println(string);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
