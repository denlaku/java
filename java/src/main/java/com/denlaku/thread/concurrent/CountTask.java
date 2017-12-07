package com.denlaku.thread.concurrent;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;

	public static final int THRESHOLD = 10000;
	private long start;
	private long end;

	public CountTask(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {

		long sum = 0;
		boolean canCompute = (end - start) < THRESHOLD;
		if (canCompute) {
			for (long i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			long step = (end - start) / 100;
			ArrayList<CountTask> taskList = new ArrayList<>();
			// long pos = start;
			for (int i = 0; i < 100; i++) {
				long firstOne = start + step * i;
				long lashOne = start + step * (i + 1);
				CountTask task = new CountTask(firstOne, lashOne);
				taskList.add(task);
				task.fork();
			}
			for (CountTask task : taskList) {
				sum += task.join();
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		CountTask task = new CountTask(0, 200000);
		ForkJoinTask<Long> result = pool.submit(task);
		try {
			Long res = result.get();
			System.out.println("sum = " + res);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
