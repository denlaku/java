package com.denlaku.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

	public static void main(String[] args) {
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(20);
		Runnable r = new Runnable() {
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + " : start");
					TimeUnit.SECONDS.sleep(2);
					System.out.println(Thread.currentThread().getName() + " : finish");
				} catch (InterruptedException e) {
				}
			}
		};
		//newScheduledThreadPool.scheduleWithFixedDelay(r, 0, 3, TimeUnit.SECONDS);
		newScheduledThreadPool.scheduleAtFixedRate(r, 0, 3, TimeUnit.SECONDS);
		//newScheduledThreadPool.schedule(r, 3, TimeUnit.SECONDS);
		//newScheduledThreadPool.shutdown();
	}
}
