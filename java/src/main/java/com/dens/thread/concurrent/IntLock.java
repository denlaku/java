package com.dens.thread.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable {

	public static final ReentrantLock lock1 = new ReentrantLock();
	public static final ReentrantLock lock2 = new ReentrantLock();
	int lock;

	public IntLock(int lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			if (lock == 1) {
				lock1.lockInterruptibly();
				TimeUnit.SECONDS.sleep(2);
				lock2.lockInterruptibly();

			} else {
				lock2.lockInterruptibly();
				TimeUnit.SECONDS.sleep(2);
				lock1.lockInterruptibly();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (lock1.isHeldByCurrentThread()) {
				lock1.unlock();
			}
			if (lock2.isHeldByCurrentThread()) {
				lock2.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		IntLock r1 = new IntLock(1);
		IntLock r2 = new IntLock(2);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		TimeUnit.SECONDS.sleep(5);
		t2.interrupt();
	}
}
