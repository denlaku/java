package com.dens.jvm.stack;

public class Overload {

	/*
	 * public static void sayHello(char arg) {
	 * System.out.println("Overload.sayHello(char arg)"); }
	 */

	/*
	 * public static void sayHello(int arg) {
	 * System.out.println("Overload.sayHello(int arg)"); }
	 */

	/*
	 * public static void sayHello(long arg) {
	 * System.out.println("Overload.sayHello(long arg)"); }
	 */

	/*
	 * public static void sayHello(float arg) {
	 * System.out.println("Overload.sayHello(float arg)"); }
	 */

	/*
	 * public static void sayHello(double arg) {
	 * System.out.println("Overload.sayHello(double arg)"); }
	 */

	/*public static void sayHello(Character arg) {
		System.out.println("Overload.sayHello(Character arg)");
	}*/

	/*public static void sayHello(Serializable arg) {
		System.out.println("Overload.sayHello(Serializable arg)");
	}*/

	public static void sayHello(Comparable<Character> arg) {
		System.out.println("Overload.sayHello(Comparable arg)");
	}

	/*
	 * public static void sayHello(Object arg) {
	 * System.out.println("Overload.sayHello(Object arg)"); }
	 */

	/*
	 * public static void sayHello(char... arg) {
	 * System.out.println("Overload.sayHello(char ...arg)"); }
	 */
	/*
	 * public static void sayHello(int... arg) {
	 * System.out.println("Overload.sayHello(int ...arg)"); }
	 */

	/*
	 * public static void sayHello(long... arg) {
	 * System.out.println("Overload.sayHello(long ...arg)"); }
	 * 
	 * public static void sayHello(float... arg) {
	 * System.out.println("Overload.sayHello(float ...arg)"); }
	 * 
	 * public static void sayHello(double... arg) {
	 * System.out.println("Overload.sayHello(double ...arg)"); }
	 * 
	 * public static void sayHello(Character... arg) {
	 * System.out.println("Overload.sayHello(Character ...arg)"); }
	 * 
	 * public static void sayHello(Comparable<Character>... arg) {
	 * System.out.println("Overload.sayHello(Comparable ...arg)"); }
	 * 
	 * public static void sayHello(Object... arg) {
	 * System.out.println("Overload.sayHello(Object ...arg)"); }
	 */

	public static void main(String[] args) {
		Overload.sayHello('a');
	}

}
