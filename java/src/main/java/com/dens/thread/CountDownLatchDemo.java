package com.dens.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo implements Runnable {

	static final CountDownLatch latch = new CountDownLatch(20);

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(3);

			System.out.println(Thread.currentThread().getName() + ": check complete");
			latch.countDown();
			System.out.println("count: " + latch.getCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatchDemo demo = new CountDownLatchDemo();
		ExecutorService es = Executors.newFixedThreadPool(7);
		for (int i = 0; i < 18; i++) {
			es.submit(demo);
		}
		latch.await();
		System.out.println("fire");
		es.shutdown();
	}

}
