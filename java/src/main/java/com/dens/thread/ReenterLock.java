package com.dens.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	public static volatile long i = 0;

	@Override
	public void run() {
		for (int j = 0; j < 200000000; j++) {
			lock.lock();
			i++;
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReenterLock rl = new ReenterLock();
		for (int k = 0; k < 100; k++) {
			Thread t = new Thread(rl);
			t.start();
			t.join();
		}
		System.out.println(i);
	}

}
