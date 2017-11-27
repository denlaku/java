package com.dens.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class RealData implements Callable<String> {

	private String para;

	public RealData(String para) {
		this.para = para;
	}

	@Override
	public String call() throws Exception {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(para);
			TimeUnit.SECONDS.sleep(1);
		}
		return sb.toString();
	}

}
