package com.denlaku.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

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

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 20; i++) {
			Future<?> submit = es.submit(new MyTask());
			Object x = submit.get();
			System.out.println(x);
		}
		es.shutdown();
	}
}
