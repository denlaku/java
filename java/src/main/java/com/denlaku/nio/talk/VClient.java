package com.denlaku.nio.talk;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class VClient implements Runnable {

	private String ip = null;
	private String name = null;
	private String serverHost = "127.0.0.1";// ������ip��ַ
	private int port = 3333;// �������˿ں�
	private SocketChannel socket = null;// �����������ͨ��
	private static String[] msgs = { "��Һ�", "������", "����ø�ʲô��", "��������ö࣬�Ȳ�����",
			"jQuery�Ǽ�prototype֮����һ�������Javascript�⡣������������js�� ��������CSS3�������ݸ����������IE 6.0+, FF 1.5+, Safari 2.0+, Opera 9.0+����jQuery2.0�������汾������֧��IE6/7/8�������jQueryʹ�û��ܸ�����ش���HTML����׼ͨ�ñ�������µ�һ��Ӧ�ã���events��ʵ�ֶ���Ч�������ҷ����Ϊ��վ�ṩAJAX������jQuery����һ���Ƚϴ�������ǣ������ĵ�˵����ȫ�����Ҹ���Ӧ��Ҳ˵�ú���ϸ��ͬʱ����������Ĳ���ɹ�ѡ��jQuery�ܹ�ʹ�û���htmlҳ�汣�ִ����html���ݷ��룬Ҳ����˵����������html�������һ��js�����������ˣ�ֻ��Ҫ����id����[8]��",
			"˭���п���", "˭��ʱ�����ȥȡ�����", ".exit" };
	private Random random = new Random();

	public VClient(String serverHost, int port) {
		this.serverHost = serverHost;
		this.port = port;
	}

	public void run() {
		try {
			// ��ʼ��ʧ���˳�����
			if (!init())
				return;

			ByteBuffer buff = ByteBuffer.allocate(1500);// �ֽڻ�����

			while (!Thread.interrupted() && socket.read(buff) != -1) {// ��ȡ��Ϣ���ж��˳�
				String msg = new String(buff.array(), 0, buff.position());// ת���ַ���
				buff.clear();// ����
				System.out.println(msg);
			}

		} catch (IOException e) {
			System.out.println("��������Ͽ�����");
		} finally {
			close();
			System.out.println("�������˳�");
		}
	}

	// ��ʼ������
	private boolean init() {
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

		Thread thread = new Thread(new Daemon());// ˽���ڲ���
		thread.setDaemon(true);// ���ú�̨�߳�
		thread.start();
		return true;
	}

	// �ر�ͨ��
	private void close() {
		try {
			if (socket != null)
				socket.close();
		} catch (IOException e) {
		}
	}

	// ˽���ڲ��ࡢ�ػ��̡߳������
	private class Daemon implements Runnable {

		public void run() {
			try {
				// �Զ�ѭ��������Ϣ
				while (true) {
					String msg = msgs[random.nextInt(msgs.length)];// �����һ��д�õ���Ϣ

					if (".exit".equals(msg)) {
						socket.write(ByteBuffer.wrap((name + "-" + ip + "������").getBytes()));// ����������Ϣ
						break;
					}

					msg = name + "-" + ip + ":" + msg;
					socket.write(ByteBuffer.wrap(msg.getBytes()));

					TimeUnit.SECONDS.sleep(random.nextInt(9) + 2);// ģ���û�������̣�2-10�룬ƽ��6�뷢һ��
				}
			} catch (IOException e) {
				System.out.println("��������Ͽ�����");
			} catch (InterruptedException e) {
				System.out.println("��������Ͽ�����");
			} finally {
				close();
			}
		}
	}

}