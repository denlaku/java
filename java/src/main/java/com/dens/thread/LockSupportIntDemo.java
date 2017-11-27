package com.dens.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportIntDemo {
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
				if (Thread.interrupted()) {
					System.out.println(getName() + "±ª÷–∂œ¡À");
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		t1.start();
		TimeUnit.SECONDS.sleep(5);
		t2.start();
		t1.interrupt();
		LockSupport.unpark(t1);
		LockSupport.unpark(t2);
		try {

		} finally {

		}
	}

}
