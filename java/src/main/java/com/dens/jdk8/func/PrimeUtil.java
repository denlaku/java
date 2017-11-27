package com.dens.jdk8.func;

import java.util.stream.IntStream;

public class PrimeUtil {

	public static boolean isPrime(int num) {
		int temp = num;
		if (temp < 2) {
			return false;
		}
		double sqrt = Math.sqrt(temp);
		for (int i = 2; sqrt >= i; i++) {
			if (temp % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		long count = IntStream.range(1, 1000).filter(PrimeUtil::isPrime).count();
		System.out.println(count);
		
	}
}
