package com.denlaku.base;

/**
 * 可以将一个类、接口以及方法声明为strictfp，但是不允许对接口中的方法以及构造函数声明strictfp关键字
 * @author User
 *
 */
public class TestStrictfp {

	public static void main(String[] args) {
		// calc1();
		// calc2();
		 calc3();
	}

	static void calc1() {
		System.out.println("--------------TestClass.calc1()--------------");
		float aFloat = 0.6710339f;
		double aDouble = 0.04150553411984792d;
		double sum = aFloat + aDouble;
		float quotient = (float) (aFloat / aDouble);
		System.out.println("float: " + aFloat);
		System.out.println("double: " + aDouble);
		System.out.println("sum: " + sum);
		System.out.println("quotient: " + quotient);
	}

	static strictfp void calc2() {
		System.out.println("--------------TestClass.calc2()--------------");
		float aFloat = 0.6710339f;
		double aDouble = 0.04150553411984792d;
		double sum = aFloat + aDouble;
		float quotient = (float) (aFloat / aDouble);
		System.out.println("float: " + aFloat);
		System.out.println("double: " + aDouble);
		System.out.println("sum: " + sum);
		System.out.println("quotient: " + quotient);
	}

	static strictfp void calc3() {
		System.out.println("--------------TestClass.calc3()--------------");
		System.out.println(0.05 + 0.01); // 0.060000000000000005
	}

}
