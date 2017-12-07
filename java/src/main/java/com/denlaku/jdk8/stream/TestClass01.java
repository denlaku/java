package com.denlaku.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class TestClass01 {

	@Test
	public void test04() {
		Random r = new Random();
		/*IntStream.iterate(0, i -> ( i + 1 ) % 2)
		.distinct()
		.limit(10)
		.forEach(System.out::println);*/
		IntStream.iterate(1000, r::nextInt)
		.limit(3)
		.distinct()
		.forEach(System.out::println);
	}
	
	@Test
	public void test03() {
		// 流可能是无限的，需要用limit提供一个合适的大小
		IntStream.iterate(0, i -> i + 1).limit(10)
		.forEach(System.out::println);
	}
	
	@Test
	public void test02() {
		Stream<String> s1 = Stream.of("A", "B");
		System.out.println(s1);
//		Stream<String> map = s1.map(a -> {
//			return a.toLowerCase();
//		});
		Stream<String> map = s1.map(String::toLowerCase);
		System.out.println(Arrays.toString(map.toArray()));
		System.out.println(Arrays.toString(map.toArray()));
	}
	
	@Test
	public void test01() {
		List<String> list = Arrays.asList("A", "BB", "CC");
		list.forEach( e -> {
			System.out.println(e);
		});
		Stream<String> parallelStream = list.parallelStream();
		Stream<String> filter = parallelStream.filter( e -> {
			return "a".equalsIgnoreCase(e);
		});
		
		System.out.println(filter.count());
		System.out.println(list);
	}
}
