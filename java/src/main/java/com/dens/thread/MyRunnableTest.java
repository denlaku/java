package com.dens.thread;

import java.util.ArrayList;
import java.util.List;

public class MyRunnableTest {

	public static void main(String[] args) {
		Runnable mr = new Runnable() {

			@Override
			public void run() {
				test();
			}

			public synchronized void test() {
				try {
					String name = Thread.currentThread().getName();
					System.out.println(name + " : " + name.substring(7));
					wait();
					System.out.println(name);
					// a--;
					// Thread.sleep(5000);
					// System.out.println(a);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};

		List<Thread> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(mr, "thread-" + i);
			list.add(t);
		}

		for (Thread t : list) {
			System.out.println(t);
			t.start();
		}

		try {
			Thread.sleep(5000);
			synchronized (mr) {
				mr.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
