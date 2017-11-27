package com.dens.thread.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	public static int i = 0;

	@Override
	public void run() {
		lock.lock();
		lock.lock();
		for (int j = 0; j < 20000; j++) {
			try {
				i++;
			} finally {
				
			}
		}
		lock.unlock();
		lock.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockDemo rl = new ReentrantLockDemo();
		Thread t1 = new Thread(rl);
		Thread t2 = new Thread(rl);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}

}
