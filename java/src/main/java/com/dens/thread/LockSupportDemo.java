package com.dens.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

	public static Object o = new Object();
	static ChangeObjectThread t1 = new ChangeObjectThread("t1");
	static ChangeObjectThread t2 = new ChangeObjectThread("t2");

	public static class ChangeObjectThread extends Thread {
		public ChangeObjectThread(String name) {
			super.setName(name);
		}

		public void run() {
			synchronized (o) {
				System.out.println("in " + getName());
				LockSupport.park();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		t1.start();
		TimeUnit.SECONDS.sleep(5);
		t2.start();
		System.out.println("t1: " + t1.getState());
		System.out.println("t2: " + t2.getState());
		LockSupport.unpark(t1);
		System.out.println("t1: " + t1.getState());
		System.out.println("t2: " + t2.getState());
		LockSupport.unpark(t2);
		System.out.println("t1: " + t1.getState());
		System.out.println("t2: " + t2.getState());
		t1.join();
		t2.join();
		System.out.println("t1: " + t1.getState());
		System.out.println("t2: " + t2.getState());
	}
}
