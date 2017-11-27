package com.dens;

import java.lang.reflect.Array;

public abstract class ArrayUtil {

	/**
	 * 根据指定的类型 创建数组
	 * 
	 * @param cls
	 * @param len
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] newArray(Class<T> cls, int... len) {
		return (T[])Array.newInstance(cls, len);
	}
	
	private ArrayUtil() {}
}
