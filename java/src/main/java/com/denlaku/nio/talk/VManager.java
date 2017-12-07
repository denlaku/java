package com.denlaku.nio.talk;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VManager implements Runnable {

    private static String serverHost = "127.0.0.1";
    private static int port = 3333;
    private static int num = 3;// ��ʼ������ͻ�����Ŀ
    private static int min = 5;// ��С����ͻ�����Ŀ
    private static int max = 15;// �������ͻ�����Ŀ
    private static Random random=new Random();

    @SuppressWarnings("resource")
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

	if (args.length > 1) {
	    try {
		num = Integer.parseInt(args[1]);
	    } catch (NumberFormatException e) {
		System.err.println("��ʼ����Ŀֻ��Ϊ����");
		return;
	    }
	}

	if (args.length > 2) {
	    try {
		min = Integer.parseInt(args[2]);
	    } catch (NumberFormatException e) {
		System.err.println("��С��Ŀֻ��Ϊ����");
		return;
	    }
	}

	if (args.length > 3) {
	    try {
		max = Integer.parseInt(args[3]);
	    } catch (NumberFormatException e) {
		System.err.println("�����Ŀֻ��Ϊ����");
		return;
	    }
	}

	if (max < num) {
	    System.err.println("��ʼ���������ܴ����������");
	    return;
	}
	
	if (max < min) {
	    System.err.println("��С�������ܴ����������");
	    return;
	}
	
	Thread manager = new Thread(new VManager());
	manager.start();

	Scanner sc = new Scanner(System.in);

	String arg = null;// ָ��
	while (sc.hasNextLine()) {
	    arg = sc.nextLine();// ����ָ��

	    if ("shutdown".equals(arg)) {
		manager.interrupt();
		break;
	    } else {
		System.out.println("δ֪��ָ��");
	    }
	}
    }

    public void run() {
	ExecutorService manager = Executors.newFixedThreadPool(max);// �̳߳ع�����

	// ��ʼ�������ͻ���
	for (int i = 0; i < num; i++) {
	    manager.execute(new VClient(serverHost, port));
	}

	try {
	    int interval=(int)(2*48000.0/min)+1;//�û����߼��ʱ�䷶Χ
	    while (!Thread.interrupted()) {
		TimeUnit.MILLISECONDS.sleep(random.nextInt(interval));// �û����48������ߣ��������������û�����
		manager.execute(new VClient(serverHost, port));
	    }
	} catch (InterruptedException e) {
	} finally {
	    System.out.println("����ֹͣ���пͻ���...");
	    manager.shutdownNow();// �ж����пͻ���
	}
    }
}
