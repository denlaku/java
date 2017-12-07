package com.denlaku.thread.concurrent;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReadWriteLockDemo {

	private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	private static ReadLock rLock = rwLock.readLock();
	private static WriteLock wLock = rwLock.writeLock();
//	private static Lock rLock = rwLock.readLock();
//	private static Lock wLock = rwLock.writeLock();
	// private static Lock lock = new ReentrantLock();

	private int value;

	public Object handleRead(Lock lock) throws InterruptedException {
		try {
			lock.lock();
			TimeUnit.SECONDS.sleep(3);
			return value;
		} finally {
			lock.unlock();
		}
	}

	public void handleWrite(Lock lock, int index) throws InterruptedException {
		try {
			lock.lock();
			TimeUnit.SECONDS.sleep(6);
			value = index;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final ReadWriteLockDemo demo = new ReadWriteLockDemo();
		Runnable readRunnable = new Runnable() {

			@Override
			public void run() {
				try {
					demo.handleRead(rLock);
					// demo.handleRead(lock);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};

		Runnable writeRunnable = new Runnable() {

			@Override
			public void run() {
				try {
					demo.handleWrite(wLock, new Random().nextInt());
					// demo.handleWrite(lock, new Random().nextInt());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};
		Thread[] ts = new Thread[2000];
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			ts[i] = new Thread(writeRunnable);
			ts[i].start();
		}
		for (int i = 1; i < 2000; i++) {
			ts[i] = new Thread(readRunnable);
			ts[i].start();
		}
		
		for (Thread t : ts) {
			t.join();
		}
		long t2 = System.currentTimeMillis();
		System.out.println((t2 - t1) / 1000);
	}

}
