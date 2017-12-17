package com.denlaku.thread.concurrent;

import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable {

	public String name;

	public MyTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(System.currentTimeMillis() + " : Thread ID : " + Thread.currentThread().getId());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
