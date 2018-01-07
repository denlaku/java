package com.denlaku.designpattern.templatemethod;

public class TestClass {
	public static void main(String[] args) {
		Student student = new Student();
		student.prepareGotoSchool();

		Teacher teacher = new Teacher();
		teacher.prepareGotoSchool();
	}
}
