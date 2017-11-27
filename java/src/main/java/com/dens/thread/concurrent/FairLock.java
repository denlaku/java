package com.dens.thread.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��ƽ��
 * @author User
 *
 */
public class FairLock implements Runnable {

	/**
	 * 
	 */
	public static ReentrantLock lock = new ReentrantLock(true);

	@Override
	public void run() {
		while (true) {
			try {
				lock.lock();
				TimeUnit.SECONDS.sleep(2);
				System.out.println(Thread.currentThread().getName() + ": �������");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}
	}
	
	public static void main(String[] args) {
		FairLock r1 = new FairLock();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		Thread t3 = new Thread(r1);
		Thread t4 = new Thread(r1);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
