package com.denlaku.thread.forkjoin;

import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Long> {

	private static final long serialVersionUID = -3685540291028328130L;

	private static final int THRESHOLD = 100000000;
	private long start;
	private long end;

	public CountTask(long start, long end) {
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
			long step = (start + end) / 100;
			ArrayList<CountTask> subTasks = new ArrayList<>();
			long pos = start;
			for (int i = 0; i < 100; i++) {
				long lastOne = pos + step;
				if (lastOne > end) {
					lastOne = end;
				}
				CountTask subTask = new CountTask(pos, lastOne);
				pos += step + 1;
				subTasks.add(subTask);
				subTask.fork();
			}
			for (CountTask t : subTasks) {
				sum += t.join();
			}
		}

		return sum;
	}

}
