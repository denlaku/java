package com.denlaku.thread;

public class MyRunnable implements Runnable {

	private static int a = 100;
	@Override
	public void run() {
		test();
	}

	public static synchronized void test() {
		try {
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " + name.substring(8));
			MyRunnable.class.wait();
			System.out.println(name);
			a--;
			Thread.sleep(5000);
			System.out.println(a);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
