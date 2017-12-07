package com.denlaku.generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestClass {

	@Test
	public void test05() {
		List<String> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		System.out.println();
		System.out.println(list1.getClass() == list2.getClass());
	}

	@Test
	public void test04() {
		go1(new ArrayList<String>());
		go2(new ArrayList<>());
		go3(new ArrayList<>());
		go4(new ArrayList<>());

	}

	private void go1(List<?> list) {

	}

	private <T> T go2(List<?> list) {
		return null;
	}

	private <T> T go3(List<T> list) {
		this.<T>go2(list);
		return null;
	}

	private <T> void go4(T list) {
	}

	public <T> void go5() {
	}

	@SuppressWarnings("unchecked")
	public <T> T go6() {
		return (T) "";
	}

	@Test
	public void test03() {
		// 这种情况 只能添加null
		List<? super SuperGeneral> list = new ArrayList<>();
		list.add(null);
		list.add(new SuperGeneral());
		list.add(new SubGeneral());
	}

	@Test
	public void test02() {
		// 这种情况 只能添加null
		List<? extends SuperGeneral> list = new ArrayList<>();
		list.add(null);
	}

	@Test
	public void test01() {
		// 这种情况 只能添加null
		List<?> list = new ArrayList<>();
		list.add(null);
	}
}
