package com.denlaku.jdk8.newapi;

import java.util.StringJoiner;
import java.util.StringTokenizer;

import org.junit.Test;

public class StringJoinerTest {
	@Test
	public void test02() {
		StringJoiner sj = new StringJoiner("|");
		sj.add("");
		sj.add("D");
		sj.add("F");
		System.out.println(sj.toString());
		System.out.println(sj.length());
		
		StringJoiner sj2 = new StringJoiner("*");
		sj2.add("1");
		sj2.add("2");
		
		sj.merge(sj2);
		System.out.println(sj.toString());
		System.out.println(sj.length());
		
	}

	@Test
	public void test01() {
		// 字符串拆分
		StringTokenizer st = new StringTokenizer("a,b.g|p", ".,|");
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}
	}
}
