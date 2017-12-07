package com.denlaku.generic;

/**
 * @author User
 *
 * @param <T>
 */
// 子类的类型参数必须包含父类所有的类型参数
public class MyListImpl<Y, T> implements MyList<T> {
	public static void main(String[] args) {
		MyListImpl<String, Integer> ml = new MyListImpl<>();
		ml.toString();
		System.out.println(ml);
	}
	
	private int name;

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}
	
}
