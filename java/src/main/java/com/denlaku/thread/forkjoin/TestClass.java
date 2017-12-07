package com.denlaku.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class TestClass {
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountTask task = new CountTask(0, 2000000000L);
		ForkJoinTask<Long> result = forkJoinPool.submit(task);
		try {
			Long res = result.get();
			System.out.println("sum = " + res);
			long t2 = System.currentTimeMillis();
			System.out.println(t2 - t1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		// 500000000500000000
		long t3 = System.currentTimeMillis();
		long sum = 0;
		for (int i = 0; i <= 2000000000L; i++) {
			sum += i;
		}
		System.out.println("sum = " + sum);
		long t4 = System.currentTimeMillis();
		System.out.println(t4 - t3);
	}
}
