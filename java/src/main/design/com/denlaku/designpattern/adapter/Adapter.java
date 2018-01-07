package com.denlaku.designpattern.adapter;

/**
 * 适配器类，继承了被适配类，同时实现标准接口
 * 
 * @author User
 *
 */
class Adapter extends Adaptee implements Target {
	public void request() {
		super.specificRequest();
	}
}