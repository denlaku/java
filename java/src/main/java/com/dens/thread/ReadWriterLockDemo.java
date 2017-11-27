package com.dens.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriterLockDemo {

	// private static Lock lock = new ReentrantLock();
	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private static Lock readLock = readWriteLock.readLock();
	private static Lock writeLock = readWriteLock.writeLock();
	private int value;

	public Object handleRead(Lock lock) {
		try {
			lock.lock();
			TimeUnit.SECONDS.sleep(1);
			return value;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return null;
	}

	public void handleWrite(Lock lock, int index) {
		try {
			lock.lock();
			TimeUnit.SECONDS.sleep(1);
			value = index;
		} catch (InterruptedException e) {
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		ReadWriterLockDemo demo = new ReadWriterLockDemo();
		Runnable readRunnable = new Runnable() {
			@Override
			public void run() {
				demo.handleRead(readLock);
				//demo.handleRead(lock);
			}
		};

		Runnable writeRunnable = new Runnable() {
			@Override
			public void run() {
				demo.handleWrite(writeLock, 1000);
				//demo.handleRead(lock);
			}
		};

		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 18; i++) {
			new Thread(readRunnable).start();
		}
		long t2 = System.currentTimeMillis();
		for (int i = 18; i < 20; i++) {
			new Thread(writeRunnable).start();
		}
		long t3 = System.currentTimeMillis();
		System.out.println(t2 - t1);
		System.out.println(t3 - t2);
	}

}
