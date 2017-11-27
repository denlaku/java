package com.dens.thread.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

/**
 * �Զ����̳߳�
 * 
 * @author User
 *
 */
public class ThreadFactoryDemo {

	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(10), new ThreadFactory() {

					@Override
					public Thread newThread(Runnable r) {
						Thread t = new Thread(r);
						// t.setDaemon(true);
						System.out.println("create" + t);
						return t;
					}

				}, new AbortPolicy());

		for (int i = 0; i < 10; i++) {
			MyTask task = new MyTask("Task--" + i);
			pool.submit(task);
		}

		pool.shutdown();
	}
}
