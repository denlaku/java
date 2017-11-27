package com.dens.thread.concurrent;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

/**
 * 
 * @author User
 *
 */
public class ExtThreadPool {

	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
				new ThreadFactory() {

					@Override
					public Thread newThread(Runnable r) {
						Thread t = new Thread(r);
						// t.setDaemon(true);
						System.out.println("create" + t);
						return t;
					}

				}, new AbortPolicy()) {
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				System.out.println("" + ((MyTask) r).name);
			}

			@Override
			public void execute(Runnable command) {
				System.out.println("==============" + command);
				super.execute(command);
			}

			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				System.out.println("ִ" + ((MyTask) r).name);
			}

			@Override
			protected void terminated() {
				System.out.println("�̳߳��˳���");
			}
		};

		for (int i = 0; i < 10; i++) {
			MyTask task = new MyTask("Task--" + i);
			pool.execute(task);
		}

		pool.shutdown();
	}
}
