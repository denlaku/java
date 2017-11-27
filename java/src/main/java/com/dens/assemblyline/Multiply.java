package com.dens.assemblyline;

import java.util.concurrent.LinkedBlockingDeque;

public class Multiply implements Runnable {
	private LinkedBlockingDeque<Msg> in;
	private LinkedBlockingDeque<Msg> out;

	public Multiply(LinkedBlockingDeque<Msg> in, LinkedBlockingDeque<Msg> out) {
		super();
		this.in = in;
		this.out = out;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Msg msg = in.take();
				msg.i = msg.i * msg.j;
				out.add(msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
