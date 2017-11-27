package com.dens.thread;

public class NoVisibility{

	private volatile static int number;
	private volatile static boolean ready;

	private static class ReaderThread implements Runnable {
		@Override
		public void run() {
			while (!ready) {
				System.out.println(number);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReaderThread rt = new ReaderThread();
		Thread t = new Thread(rt);
		Thread.currentThread().getThreadGroup().getName();
		t.start();
		Thread.sleep(2000);
		number = 1000;
		ready = true;
		Thread.sleep(10000);
		boolean daemon = Thread.currentThread().isDaemon();
		System.out.println(daemon);
	}

}
