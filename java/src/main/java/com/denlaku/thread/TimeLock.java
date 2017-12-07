package com.denlaku.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	
	@Override
	public void run() {
		try {
			if (lock.tryLock(6, TimeUnit.SECONDS)) {
				//Thread.sleep(5000);
				TimeUnit.SECONDS.sleep(5);
				System.out.println(Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
		} finally {
			if(lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		TimeLock tl = new TimeLock();
		Thread t1 = new Thread(tl);
		t1.setName("t1..");
		Thread t2 = new Thread(tl);
		t2.setName("t2..");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}
