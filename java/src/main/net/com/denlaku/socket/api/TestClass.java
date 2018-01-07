package com.denlaku.socket.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import org.junit.Test;

public class TestClass {

	@Test
	public void test06() {
		try {
			SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 12001));
			socketChannel.configureBlocking(false);
			Selector selector = Selector.open();
			socketChannel.register(selector, SelectionKey.OP_READ);
			socketChannel.write(charset.encode("AAAA"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Charset charset = Charset.forName("UTF-8");

	@Test
	public void test05() {
		ByteBuffer bb = ByteBuffer.allocate(100);
		int position = bb.position();
		System.out.println(position);
		System.out.println(bb.limit());
	}

	@Test
	public void test04() {
		try {
			SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("10.10.10.3", 15000));
			socketChannel.configureBlocking(false);
			Selector selector = Selector.open();
			socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
			String str = "1�л����񹲺͹�2�л����񹲺͹�3�л����񹲺͹�4�л����񹲺͹�5�л����񹲺͹�6�л����񹲺͹�7�л����񹲺͹�";
			ByteBuffer bb = Charset.forName("UTF-8").encode(str);
			int capacity = bb.capacity();
			System.out.println(capacity);
			socketChannel.write(bb);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test03() {
		String path = "D:\\workspace-sts\\test\\j01\\src\\com\\dens\\nio\\text.txt";
		try (RandomAccessFile fromRAF = new RandomAccessFile(new File(path), "rw");) {
			SocketChannel channel = SocketChannel.open();
			channel.connect(new InetSocketAddress(14001));
			Selector selector = Selector.open();
			channel.register(selector, SelectionKey.OP_WRITE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		String path = "D:\\workspace-sts\\test\\j01\\src\\com\\dens\\nio\\text.txt";
		try (FileInputStream fis = new FileInputStream(new File(path));) {
			FileChannel channel = fis.getChannel();
			ByteBuffer bb = ByteBuffer.allocate(2);
			bb.flip();
			bb.put((byte) 97);
			channel.write(bb);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test01() {
		String fromPath = "D:\\workspace-sts\\test\\j01\\src\\com\\dens\\nio\\text.txt";
		String toPath = "D:\\workspace-sts\\test\\j01\\src\\com\\dens\\nio\\totext.txt";
		try (RandomAccessFile fromRAF = new RandomAccessFile(new File(fromPath), "rw");
				RandomAccessFile toRAF = new RandomAccessFile(new File(toPath), "rw");) {
			FileChannel fromChannel = fromRAF.getChannel();
			FileChannel toChannel = toRAF.getChannel();
			toChannel.transferFrom(fromChannel, 0, fromChannel.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
