package com.dens.thread.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCondition implements Runnable {

	public static final ReentrantLock lock = new ReentrantLock();
	public static final Condition condition = lock.newCondition();

	@Override
	public void run() {
		lock.lock();
		try {
			condition.await();
			System.out.println("Thread is going on");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockCondition r = new ReentrantLockCondition();
		Thread t = new Thread(r);
		t.start();
		TimeUnit.SECONDS.sleep(5);
		lock.lock();
		condition.signal();
		lock.unlock();
	}

}
