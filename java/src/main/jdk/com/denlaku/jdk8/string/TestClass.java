package com.denlaku.jdk8.string;

import java.util.StringJoiner;
import java.util.StringTokenizer;

import org.junit.Test;

public class TestClass {

	@Test
	public void test02() {
		StringJoiner sj = new StringJoiner("|");
		sj.add("");
		sj.add("D");
		sj.add("F");
		System.out.println(sj.toString());
		System.out.println(sj.length());
	}
	
	@Test
	public void test01() {
		StringTokenizer st = new StringTokenizer("a,b.g|p", ".,|");
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}
	}
}
