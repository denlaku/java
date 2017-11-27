package com.dens.thread.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportIntDemo {

	static ChangeObjectThread r1 = new ChangeObjectThread("R1");
	static ChangeObjectThread r2 = new ChangeObjectThread("R2");

	static class ChangeObjectThread implements Runnable {
		ChangeObjectThread(String name) {
			Thread.currentThread().setName(name);
		}

		@Override
		public synchronized void run() {
			System.out.println("in " + Thread.currentThread().getName());
			LockSupport.park();
			if (Thread.interrupted()) {
				System.out.println(Thread.currentThread().getName() + ": ���ж���");
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		TimeUnit.SECONDS.sleep(5);
		t2.start();
		t1.interrupt();
		LockSupport.unpark(t2);
	}
}
