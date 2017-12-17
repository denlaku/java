package com.denlaku.thread.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock implements Runnable {
	public static final ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		String currThread = Thread.currentThread().getName();
		try {
			if (lock.tryLock()) {
				System.out.println(currThread + ": �������ɹ���");
			} else {
				System.out.println(currThread + ": ������ʧ�ܣ�");
			}
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TryLock r1 = new TryLock();
		TryLock r2 = new TryLock();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}

}
