package com.denlaku.nio.api;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

	public static void main(String[] args) throws IOException {
		File file = new File("D:/denlaku.git/java-training/java/src/main/net/com/denlaku/nio/api/text.txt");
		System.out.println(file);
		RandomAccessFile raFile = new RandomAccessFile(file, "rw");
		FileChannel inChannel = raFile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(8);
		System.out.println(buf);

		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {
			System.out.println("Read: " + bytesRead);
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.print((char)buf.get());
			}
			// buf.rewind();
			while (buf.hasRemaining()) {
				System.out.print(buf.getChar());
			}
			System.out.println();
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		raFile.close();
	}
}
