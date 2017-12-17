package com.denlaku.thread.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author User
 *
 */
public class TimeLock implements Runnable {
	public static final ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		String currThread = Thread.currentThread().getName();
		try {
			if (lock.tryLock(3, TimeUnit.SECONDS)) {
				TimeUnit.SECONDS.sleep(2);
				System.out.println(currThread + ":  ");
			} else {
				System.out.println(currThread + ": ");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TimeLock r1 = new TimeLock();
		TimeLock r2 = new TimeLock();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}

}
