package com.dens.frame.apache.common;

public class SubVO extends ParentVO{

	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "SubVO [sex=" + sex + ", getName()=" + getName() + "]";
	}
	
}
