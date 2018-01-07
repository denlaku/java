package com.denlaku.nio.talk.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
	private Selector selector;

	public void initServer(int port) {
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			ServerSocket serverSocket = serverSocketChannel.socket();
			serverSocket.bind(new InetSocketAddress(port));
			this.selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listen() {
		System.out.println("开始监听");
		while (true) {
			try {
				selector.select();
				Iterator<SelectionKey> ite = this.selector.selectedKeys().iterator();
				while (ite.hasNext()) {
					SelectionKey key = (SelectionKey) ite.next();
					ite.remove();
					if (key.isAcceptable()) {
						ServerSocketChannel server = (ServerSocketChannel) key.channel();
						SocketChannel channel = server.accept();
						channel.configureBlocking(false);
						channel.write(ByteBuffer.wrap(new String("AAAA").getBytes()));
						channel.register(this.selector, SelectionKey.OP_READ);
					} else if (key.isReadable()) {
						read(key);
					}

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void read(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(10);
		channel.read(buffer);
		byte[] data = buffer.array();
		String msg = new String(data).trim();
		System.out.println(msg);
		ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
		channel.write(outBuffer);
	}

	/**
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		NIOServer server = new NIOServer();
		server.initServer(8000);
		server.listen();
	}
}
