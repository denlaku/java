package com.denlaku.designpattern.adapter;

public class ConcreteTarget implements Target {
	public void request() {
		System.out.println("普通类 具有 普通功能...");
	}
}