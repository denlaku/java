package com.denlaku.nio.my.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIOClient {
	public static void main(String[] args) {
		try {
			SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("10.10.10.3", 15000));
			socketChannel.configureBlocking(false);
			Selector selector = Selector.open();
			socketChannel.register(selector, SelectionKey.OP_READ);
			Charset charset = Charset.forName("UTF-8");
			socketChannel.write(charset.encode("++NIOClient++"));
			while (true) {
				System.out.println("outer");
				if (selector.select() == 0) {
					continue;
				}
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectedKeys.iterator();
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					iterator.remove();
					SocketChannel channel = (SocketChannel) key.channel();
					if (key.isConnectable()) {
						System.out.println("isConnectable");
					}
					if (key.isReadable()) {
						System.out.println("isReadable");
					}
					if (key.isWritable()) {
						System.out.println("isWritable");
					}
					if (channel.isConnected()) {
						System.out.println("isConnected");
					}
					key.cancel();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
