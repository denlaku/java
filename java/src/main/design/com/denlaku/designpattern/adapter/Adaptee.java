package com.denlaku.designpattern.adapter;

/**
 * 已存在的、具有特殊功能、但不符合我们既有的标准接口的类  
 * @author User
 *
 */
public class Adaptee {
	public void specificRequest() {
		System.out.println("被适配类具有 特殊功能...");
	}
}