package com.dens.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo implements Runnable {

	final Semaphore semaphore = new Semaphore(5);
	@Override
	public void run() {
		try {
			semaphore.acquire(5);
			TimeUnit.SECONDS.sleep(2);
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("release:  " + Thread.currentThread().getName());
			semaphore.release(5);
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(20);
		SemaphoreDemo s = new SemaphoreDemo();
		for (int i = 0; i < 20; i++) {
			exec.submit(s);
		}
	}

}
