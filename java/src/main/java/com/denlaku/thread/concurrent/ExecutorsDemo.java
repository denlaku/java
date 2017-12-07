package com.denlaku.thread.concurrent;

import java.util.concurrent.Executors;

public class ExecutorsDemo {

	public static void main(String[] args) {
		Executors.newCachedThreadPool();
		
		Executors.newFixedThreadPool(20);
		
		Executors.newSingleThreadExecutor();
		
		Executors.newSingleThreadScheduledExecutor();
		
		Executors.newScheduledThreadPool(20);
	}
}
