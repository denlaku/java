package com.dens.nio.my.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;

public class DatagramChannelClient {

	public static void main(String[] args) {
		try {
			DatagramChannel open = DatagramChannel.open();
			byte[] bts = "1这种速度发育会研发和豆腐干豆腐干111速度速度要让对方".getBytes("UTF-8");
			System.out.println(Arrays.toString(bts));
			open.send(ByteBuffer.wrap(bts), new InetSocketAddress("10.10.10.3", 15001));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
