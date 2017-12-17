package com.denlaku.thread.concurrent;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
		map.put("AA", 11);
		map.putIfAbsent("AA", 22);

		System.out.println(map);

		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("AAA", 11);
		hm.putIfAbsent("AAA", 22);

		System.out.println(hm);
	}
}
