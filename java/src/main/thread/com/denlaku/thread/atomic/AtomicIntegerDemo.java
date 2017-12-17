package com.denlaku.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

	private static AtomicInteger ai = new AtomicInteger(1);

	public static void main(String[] args) {
		// boolean compareAndSet = ai.compareAndSet(3, 2);
		int andIncrement = ai.getAndIncrement();
		ai.addAndGet(1);
		ai.getAndAdd(-1);
		System.out.println(andIncrement);
		System.out.println(ai.get());
		ClassLoader classLoader = String.class.getClassLoader();
		System.out.println(classLoader);
		ClassLoader classLoader2 = AtomicIntegerDemo.class.getClassLoader();
		System.out.println(classLoader2);
		
	}
}
