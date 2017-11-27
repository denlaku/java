package com.dens.designpattern.singleton;

public enum Singleton {
	INSTANCE("Singleton");
	private String name;
	// 枚举的构造函数 访问权限只能是 默认或者private
	private Singleton(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
