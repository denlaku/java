package com.denlaku.jdk8.func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class FuncMain {

	public static interface IntHandler {
		public int handler(int i);
	}

	public static void main(String[] args) {
		int num = 2;
		Function<Integer, String> fn = (from) -> {
			return from * num + "---";
		};
		String apply = fn.apply(3);
		System.out.println(apply);

		List<String> list = new ArrayList<>();
		Collections.sort(list, (x, y) -> x.hashCode() - y.hashCode());

		int[] arr = { 3, 5, 7 };
		get(arr, i -> {
			System.out.println("i*i: " + i * i);
			return i * i;
		});
		System.out.println(Arrays.toString(arr));

	}

	public static void get(int[] arr, IntHandler h) {
		for (int e : arr) {
			h.handler(e);
		}
	};
}
