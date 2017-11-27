package com.dens.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo {

	public static class Candidate {
		int id;
		volatile int score;
	}

	public final static AtomicIntegerFieldUpdater<Candidate> updater = AtomicIntegerFieldUpdater
			.newUpdater(Candidate.class, "score");
	public final static AtomicInteger ai = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		Candidate candidate = new Candidate();
		Thread[] ts = new Thread[1000];
		for (int i = 0; i < 1000; i++) {
			ts[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					if (Math.random() > 0.4) {
						updater.incrementAndGet(candidate);
						ai.incrementAndGet();
					}
				}

			});
			ts[i].start();
		}
		for (int i = 0; i < 1000; i++) {
			ts[i].join();
		}
		System.out.println(candidate.score);
		System.out.println(ai);
	}

}
