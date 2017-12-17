package com.denlaku.thread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> ft = new FutureTask<>(new RealData("a"));
		ExecutorService pool = Executors.newFixedThreadPool(1);
		pool.execute(ft);
		pool.submit(ft);

		System.out.println("start: =====");

		TimeUnit.SECONDS.sleep(2);

		System.out.println("end = " + ft.get());

	}
}
