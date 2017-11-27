package com.dens.thread.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

	static ChangeObjectThread r1 = new ChangeObjectThread("R1");
	static ChangeObjectThread r2 = new ChangeObjectThread("R2");

	static class ChangeObjectThread implements Runnable {
		ChangeObjectThread(String name) {
			Thread.currentThread().setName(name);
		}

		@Override
		public void run() {
			System.out.println("in " + Thread.currentThread().getName());
			LockSupport.park();
		}

	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		TimeUnit.SECONDS.sleep(5);
		t2.start();
		LockSupport.unpark(t1);
		LockSupport.unpark(t2);
		t1.join();
		t2.join();
	}
}
