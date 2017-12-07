package com.denlaku.thread.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo implements Runnable {

	private static final CountDownLatch latch = new CountDownLatch(10);

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(5);
			System.out.println(Thread.currentThread().getName() + ": check complete!");
			latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatchDemo demo = new CountDownLatchDemo();
		ExecutorService pool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			pool.submit(demo);
		}
		latch.await();
		System.out.println("fire");
		pool.shutdown();
	}

}
