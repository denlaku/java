package com.denlaku.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockCondition implements Runnable {

	private static ReentrantLock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();

	@Override
	public void run() {
		try {
			lock.lock();
			condition.await();
			System.out.println("Thread is going on");
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReenterLockCondition rc = new ReenterLockCondition();
		Thread t1 = new Thread(rc);
		t1.start();
		TimeUnit.SECONDS.sleep(6);
		lock.lock();
		condition.signalAll();
		lock.unlock();
	}

}
