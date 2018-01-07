package com.denlaku.nio.talk.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 
 * @author С·
 */
public class NIOClient {
	private Selector selector;

	/**
	 * 
	 * @param ip
	 * @param port
	 * @throws IOException
	 */
	public void initClient(String ip, int port) throws IOException {
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		this.selector = Selector.open();

		channel.connect(new InetSocketAddress(ip, port));
		channel.register(selector, SelectionKey.OP_CONNECT);
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void listen() throws IOException {
		while (true) {
			selector.select();
			Iterator<SelectionKey> ite = this.selector.selectedKeys().iterator();
			while (ite.hasNext()) {
				SelectionKey key = (SelectionKey) ite.next();
				ite.remove();
				if (key.isConnectable()) {
					SocketChannel channel = (SocketChannel) key.channel();
					if (channel.isConnectionPending()) {
						channel.finishConnect();

					}
					channel.configureBlocking(false);
					channel.write(ByteBuffer.wrap(new String("AAAAAAAAAAAAAAAAA").getBytes()));
					channel.register(this.selector, SelectionKey.OP_READ);

				} else if (key.isReadable()) {
					read(key);
				}

			}

		}
	}

	/**
	 * 
	 * @param key
	 * @throws IOException
	 */
	public void read(SelectionKey key) throws IOException {
	}

	/**
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		NIOClient client = new NIOClient();
		client.initClient("localhost", 8000);
		client.listen();
	}

}