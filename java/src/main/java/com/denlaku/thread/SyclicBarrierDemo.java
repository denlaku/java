package com.denlaku.thread;

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
			System.out.println(soldier + ": ������ɣ�");
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
				System.out.println("˾���ʿ��" + N + "����������񣡡�");
			} else {
				System.out.println("˾���ʿ��" + N + "����������ϣ���");
				flag = true;
			}
		}

	}

	public static void main(String[] args) {
		final int N = 10;
		Thread[] allSoldier = new Thread[N];
		boolean flag = false;
		CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
		System.out.println("���϶���!");
		for (int i = 0; i < N; i++) {
			System.out.println("ʿ�� " + i + "������");
			allSoldier[i] = new Thread(new Soldier(cyclic, "ʿ��" + i));
			allSoldier[i].start();
		}
	}

}
