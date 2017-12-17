package com.denlaku.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo implements Runnable {

	final Semaphore semaphore = new Semaphore(5);

	@Override
	public void run() {
		try {
			semaphore.acquire();
			TimeUnit.SECONDS.sleep(5);
			System.out.println(Thread.currentThread().getName() + ": done!");
		} catch (Exception e) {
		} finally {
			semaphore.release();
		}
	}

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(10);
		SemaphoreDemo r = new SemaphoreDemo();
		for (int i = 0; i < 20; i++) {
			pool.submit(r);
		}
		pool.shutdown();
	}

}
