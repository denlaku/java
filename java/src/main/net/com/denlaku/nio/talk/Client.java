package com.denlaku.nio.talk;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client implements Runnable {

	private static String ip = null;
	private static String name = null;
	private static String serverHost = "10.10.10.3";// ��������ַ
	private static int port = 3333;// �������˿ں�
	private static SocketChannel socket = null;// �����������ͨ��

	public static void main(String[] args) {
		if (args.length > 0) {

			if (args[0].indexOf(':') == -1) {
				System.err.println("Ŀ���ַ��ʽ����ȷ");
				return;
			}

			serverHost = args[0].split(":")[0];
			try {
				port = Integer.parseInt(args[0].split(":")[1]);
			} catch (NumberFormatException e) {
				System.err.println("�˿ں�ֻ��Ϊ����");
				return;
			}
		}

		try {
			if (!init())
				return;

			ByteBuffer buff = ByteBuffer.allocate(1500);
			while (socket.read(buff) != -1) {
				String msg = new String(buff.array(), 0, buff.position());
				buff.clear();
				System.out.println(msg);
			}

		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			close();
			System.out.println("");
		}
	}

	@SuppressWarnings("resource")
	public void run() {
		try {
			Scanner sc = new Scanner(System.in);
			while (sc.hasNextLine()) {
				String msg = sc.nextLine();

				if (".exit".equals(msg)) {
					socket.write(ByteBuffer.wrap((name + "-" + ip + "������").getBytes()));// ����������Ϣ
					break;
				}

				msg = name + "-" + ip + ":" + msg;
				socket.write(ByteBuffer.wrap(msg.getBytes()));
			}
		} catch (IOException e) {
			System.out.println("��������Ͽ�����");
		} finally {
			close();
		}
	}

	private static boolean init() {
		System.out.println("����������������...");
		try {
			socket = SocketChannel.open(new InetSocketAddress(serverHost, port));// ��ͨ��
		} catch (IOException e) {
			System.out.println("�޷����ӵ�������");
			return false;
		}
		System.out.println("��������������");

		try {
			InetAddress address = InetAddress.getLocalHost();// ��ȡ����������Ϣ
			ip = address.getHostAddress();// ����ip
			name = address.getHostName();// ������
			socket.write(ByteBuffer.wrap((name + "-" + ip + "������").getBytes()));// ����������Ϣ
		} catch (IOException e) {
			System.out.println("�����쳣");
			return false;
		}

		Thread thread = new Thread(new Client());
		thread.setDaemon(true);// ���ú�̨�߳�
		thread.start();
		return true;
	}

	// �ر�ͨ��
	private static void close() {
		try {
			if (socket != null)
				socket.close();
		} catch (IOException e) {
		}
	}
}