package com.denlaku.thread;

import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable{
	
	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();
	
	int lock;
	public IntLock(int lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			if (lock == 1) {
				lock1.lockInterruptibly();
				Thread.sleep(5000);
				lock2.lockInterruptibly();
				System.out.println("lock1");
			} else {
				lock2.lockInterruptibly();
				Thread.sleep(5000);
				lock1.lockInterruptibly();
				System.out.println("lock2");
			}
		} catch (InterruptedException e) {
		} finally {
			if (lock1.isHeldByCurrentThread()) {
				lock1.unlock();
			}
			if (lock2.isHeldByCurrentThread()) {
				lock2.unlock();
			}
		}
			
	}
	
	public static void main(String[] args) {
		IntLock i1 = new IntLock(1);
		IntLock i2 = new IntLock(2);
		Thread t1 = new Thread(i1);
		Thread t2 = new Thread(i2);
		t1.start();
		t2.start();
		try {
			Thread.sleep(6000);
			t2.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
