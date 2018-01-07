package com.denlaku.socket.api;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

public class NIOServer {

	private static final Charset charset = Charset.forName("UTF-8");

	public static void main(String[] args) {
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress(8000));
			serverSocketChannel.configureBlocking(false);
			Selector selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			while (true) {
				int select = selector.select();
				if (select > 0) {
					Set<SelectionKey> selectedKeys = selector.selectedKeys();
					for (SelectionKey key : selectedKeys) {
						if (key.isAcceptable()) {
							SocketChannel channel = (SocketChannel) key.channel();
							channel.configureBlocking(false);
							channel.register(selector, SelectionKey.OP_READ);
							channel.write(charset.encode("Hello"));
						}
						if (key.isReadable()) {
							SocketChannel channel = (SocketChannel) key.channel();
							ByteBuffer buff = ByteBuffer.allocate(1024);
							StringBuilder content = new StringBuilder();
							try {
								while (channel.read(buff) > 0) {
									buff.flip();
									content.append(charset.decode(buff));

								}
								System.out.println("client " + channel.getRemoteAddress() + " data rev is: " + content);
								key.interestOps(SelectionKey.OP_READ);
							} catch (IOException io) {
								key.cancel();
								if (key.channel() != null) {
									key.channel().close();
								}
							}
						}

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
