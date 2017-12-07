package com.denlaku.assemblyline;

import java.util.concurrent.LinkedBlockingDeque;

public class Plus implements Runnable {

	private LinkedBlockingDeque<Msg> in;
	private LinkedBlockingDeque<Msg> out;

	public Plus(LinkedBlockingDeque<Msg> in, LinkedBlockingDeque<Msg> out) {
		this.out = out;
		this.in = in;
	}

	@Override
	public void run() {
		while (true) {
			Msg msg;
			try {
				msg = in.take();
				msg.i = msg.i + msg.j;
				out.add(msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
