package com.denlaku.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TixedThreadPoolDemo {

	public static class MyTask implements Runnable {

		public void run() {
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 0; i< 20; i++) {
			es.submit(new MyTask());
		}
		System.out.println(111111111);
		es.shutdown();
	}
}
