package com.denlaku.assemblyline;

import java.util.concurrent.LinkedBlockingDeque;

public class PStreamMain {

	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingDeque<Msg> plus = new LinkedBlockingDeque<Msg>();
		LinkedBlockingDeque<Msg> multi = new LinkedBlockingDeque<Msg>();
		LinkedBlockingDeque<Msg> div = new LinkedBlockingDeque<Msg>();

		new Thread(new Plus(plus, multi)).start();
		new Thread(new Multiply(multi, div)).start();
		new Thread(new Div(div)).start();

		for (int i = 0; i < 10; i++) {
			Msg msg = new Msg();
			msg.i = i + 1;
			msg.j = 2 * i + 1;
			plus.add(msg);
		}

		System.out.println("plus-size: " + plus.size());
	}
}
