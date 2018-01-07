package com.denlaku.nio.talk;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Server {

	private static List<SocketChannel> clientList = new LinkedList<SocketChannel>();
	private static Selector clientManager = null;
	private static ServerSocketChannel server = null;
	private static ByteBuffer buff = ByteBuffer.allocate(1500);
	private static int port = 3333;

	public static void main(String[] args) {
		if (args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.out.println("�˿ں�ֻ��Ϊ����");
				return;
			}
		}

		try {
			if (!init())
				return;

			while (clientManager.isOpen()) {
				select();

				Set<SelectionKey> keys = clientManager.selectedKeys();

				Iterator<SelectionKey> it = keys.iterator();
				while (it.hasNext()) {
					SelectionKey key = it.next();
					if (!key.isValid()) {
						it.remove();
						continue;
					}

					if (key.isAcceptable()) {
						accept(key);
					} else if (key.isReadable()) {
						broadcast(key);
					}

					it.remove();
				}
			}
		} catch (ClosedSelectorException | CancelledKeyException e) {
		} finally {
			try {
				if (clientManager != null)
					clientManager.close();
			} catch (IOException e) {
			}

			try {
				if (server != null)
					server.close();
			} catch (IOException e) {
			}

			closeAll();
			System.out.println("��������ֹͣ");
		}
	}

	private static boolean init() {
		System.out.println("������������...");

		try {
			clientManager = Selector.open();
		} catch (IOException e) {
			System.out.println("����������ʧ�ܣ�ԭ��ͨ���������޷���ȡ");
			return false;
		}

		try {
			server = ServerSocketChannel.open();
		} catch (IOException e) {
			System.out.println("����������ʧ�ܣ�ԭ��socketͨ���޷���");
			return false;
		}

		try {
			server.socket().bind(new InetSocketAddress(port));
		} catch (IOException e) {
			System.out.println("����������ʧ�ܣ�ԭ�򣺶˿ںŲ�����");
			return false;
		}

		try {
			server.configureBlocking(false);
		} catch (IOException e) {
			System.out.println("����������ʧ�ܣ�ԭ�򣺷�����ģʽ�л�ʧ��");
			return false;
		}

		try {
			server.register(clientManager, SelectionKey.OP_ACCEPT);
		} catch (ClosedChannelException e) {
			System.out.println("����������ʧ�ܣ�ԭ�򣺷�����ͨ���ѹر�");
			return false;
		}

		System.out.println("�����������ɹ�");
		return true;
	}

	private static void select() {
		try {
			clientManager.select();
		} catch (IOException e) {
		}
	}

	private static void accept(SelectionKey key) {
		SocketChannel socket = null;

		try {
			socket = ((ServerSocketChannel) key.channel()).accept();
		} catch (IOException e) {
		}

		if (socket == null)
			return;

		SocketAddress address = null;

		try {
			address = socket.getRemoteAddress();
			socket.configureBlocking(false);
			socket.register(clientManager, SelectionKey.OP_READ);
		} catch (ClosedChannelException e) {
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e1) {
			}
			return;
		} catch (IOException e) {
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e1) {
			}
			return;
		}
		clientList.add(socket);
		System.out.println("����" + address + "���ӵ�������");
	}

	private static void broadcast(SelectionKey key) {
		SocketChannel sender = (SocketChannel) key.channel();
		buff.clear();

		int status = -1;
		try {
			status = sender.read(buff);
		} catch (IOException e) {
			status = -1;
		}

		if (status <= 0) {
			remove(sender);
			return;
		}

		for (SocketChannel client : clientList) {
			if (client == sender)
				continue;
			buff.flip();
			try {
				client.write(buff);
			} catch (IOException e) {
				remove(client);
			}
		}
	}

	private static void remove(SocketChannel client) {
		SocketAddress address = null;// �洢������ַ��Ϣ

		clientList.remove(client);// ���б����Ƴ�

		try {
			address = client.getRemoteAddress();// ��ȡ�ͻ��˵�ַ��Ϣ
		} catch (IOException e1) {
		}

		try {
			client.close();// �ر�����
		} catch (IOException e1) {
		}
		client.keyFor(clientManager).cancel();// ��ע��
		System.out.println("������" + address + "�Ͽ�����");
	}

	// �ر��б���ȫ��ͨ��
	private static void closeAll() {
		for (SocketChannel client : clientList) {
			try {
				if (client != null)
					client.close();
			} catch (IOException e) {
			}
		}
	}
}