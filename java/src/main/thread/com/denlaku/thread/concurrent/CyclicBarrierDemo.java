package com.denlaku.thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {

	static class Soldier implements Runnable {
		private String soldier;
		private final CyclicBarrier cyclic;

		public Soldier(String soldier, CyclicBarrier cyclic) {
			super();
			this.soldier = soldier;
			this.cyclic = cyclic;
		}

		@Override
		public void run() {
			try {
				cyclic.await();
				doWork();
				cyclic.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			} finally {
			}
		}

		void doWork() {
			try {
				TimeUnit.SECONDS.sleep(3);
				System.out.println(soldier + "");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	static class BarrierRun implements Runnable {
		boolean flag;
		int n;

		public BarrierRun(boolean flag, int n) {
			super();
			this.flag = flag;
			this.n = n;
		}

		@Override
		public void run() {
			if (flag) {
				System.out.println("" + n + "");
			} else {
				System.out.println("" + n + "");
				flag = true;
			}
		}

	}

	public static void main(String[] args) {
		final int n = 10;
		boolean flag = false;
		Thread[] allSoldier = new Thread[n];
		CyclicBarrier cyclic = new CyclicBarrier(n, new BarrierRun(flag, n));
		System.out.println("");
		for (int i = 0; i < n; i++) {
			System.out.println("" + i + "");
			allSoldier[i] = new Thread(new Soldier("" + i, cyclic));
			allSoldier[i].start();
		}
	}
}
