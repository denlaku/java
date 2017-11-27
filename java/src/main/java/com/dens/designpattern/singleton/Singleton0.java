package com.dens.designpattern.singleton;

import java.io.Serializable;

/**
 * 饿汉式单例
 */
public class Singleton0 implements Serializable {

	private static final long serialVersionUID = 1L;
	private transient static final Singleton0 INSTANCE = new Singleton0();

	private Singleton0() {
		if (INSTANCE != null) {
			throw new UnsupportedOperationException();
		}
	}

	public static Singleton0 getInstance() {
		return INSTANCE;
	}
	
	public Object readResolve() {
		return INSTANCE;
	}
}
