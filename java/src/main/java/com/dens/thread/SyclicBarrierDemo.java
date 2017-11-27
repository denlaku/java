package com.dens.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class SyclicBarrierDemo {

	public static class Soldier implements Runnable {

		private String soldier;
		private final CyclicBarrier cyclic;

		public Soldier(CyclicBarrier cyclic, String soldier) {
			this.cyclic = cyclic;
			this.soldier = soldier;
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
			}
		}

		void doWork() {
			try {
				TimeUnit.SECONDS.sleep(6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(soldier + ": 任务完成！");
		}

	}

	public static class BarrierRun implements Runnable {

		boolean flag;
		int N;

		public BarrierRun(boolean flag, int N) {
			this.flag = flag;
			this.N = N;
		}

		@Override
		public void run() {
			if (flag) {
				System.out.println("司令：【士兵" + N + "个，完成任务！】");
			} else {
				System.out.println("司令：【士兵" + N + "个，集合完毕！】");
				flag = true;
			}
		}

	}

	public static void main(String[] args) {
		final int N = 10;
		Thread[] allSoldier = new Thread[N];
		boolean flag = false;
		CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
		System.out.println("集合队伍!");
		for (int i = 0; i < N; i++) {
			System.out.println("士兵 " + i + "报道！");
			allSoldier[i] = new Thread(new Soldier(cyclic, "士兵" + i));
			allSoldier[i].start();
		}
	}

}
