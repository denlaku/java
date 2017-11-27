package com.dens.jdk7.closeable;

import java.io.Closeable;
import java.io.IOException;

public class CloseableResource implements Closeable {

	@Override
	public void close() throws IOException {
		System.out.println("CloseableResource.close()");
	}

}
