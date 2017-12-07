package com.denlaku.assemblyline;

import java.util.concurrent.LinkedBlockingDeque;

public class Div implements Runnable {

	private LinkedBlockingDeque<Msg> in;

	public Div(LinkedBlockingDeque<Msg> in) {
		super();
		this.in = in;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Msg msg = in.take();
				msg.i = msg.i / msg.j;
				System.out.println(msg.i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
