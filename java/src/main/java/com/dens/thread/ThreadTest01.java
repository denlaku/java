package com.dens.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest01 {

	public static long a = 1000;
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized (Object.class) {
					System.out.println("t1 start: " + a);
					long temp = a;
					try {
						System.out.println("wait");
						Object.class.wait();
						System.out.println("t1: " + temp);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run(){
				synchronized (Object.class) {
					a--;
					System.out.println("t2 start: " + a);
					try {
						
						TimeUnit.SECONDS.sleep(5);
						a--;
						TimeUnit.SECONDS.sleep(1);
						a--;
						TimeUnit.SECONDS.sleep(1);
						a--;
						TimeUnit.SECONDS.sleep(1);
						a--;
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t2 end: " + a);
					Object.class.notifyAll();
				}
			}
			
		});
		
		
		t2.start();
		t1.start();
		
		ReentrantLock lock = new ReentrantLock();
		lock.tryLock();
		try {
			lock.tryLock(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			lock.lockInterruptibly();
		} catch (InterruptedException e) {
		}
		
		Condition newCondition = lock.newCondition();
		System.out.println(newCondition);
	}
}
