package com.denlaku.util.test;

import java.util.ArrayList;

public class ListMain {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("AAA");
		for(String ele: list) {
			System.out.println(ele);
		}
	}
}
