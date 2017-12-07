package com.denlaku.thread.lockfree;
/*package com.dens.thread.lockfree;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class LockFreeVector<E> {

	private final AtomicReferenceArray<AtomicReferenceArray<E>> buckets;
	private final AtomicReference<Descriptor<E>> descriptor;
	private static final int N_BUCKET = 30;
	private static final int FIRST_BUCKET_SIZE = 20;

	static class WriterDescriptor<E> {
		public E oldV;
		public E newV;
		public AtomicReferenceArray<E> addr;
		public int addrInd;

		public WriterDescriptor(E oldV, E newV, AtomicReferenceArray<E> addr, int addrInd) {
			super();
			this.oldV = oldV;
			this.newV = newV;
			this.addr = addr;
			this.addrInd = addrInd;
		}

		public void doIt() {
			addr.compareAndSet(addrInd, oldV, newV);
		}

	}

	static class Descriptor<E> {
		public int size;
		public volatile WriterDescriptor<E> writeop;

		public Descriptor(int size, WriterDescriptor<E> writeop) {
			super();
			this.size = size;
			this.writeop = writeop;
		}

		public void completeWrite() {
			WriterDescriptor<E> tempOp = writeop;
			if (tempOp != null) {
				tempOp.doIt();
				writeop = null;
			}
		}

	}

	public LockFreeVector() {
		buckets = new AtomicReferenceArray<>(N_BUCKET);
		buckets.set(0, new AtomicReferenceArray<>(FIRST_BUCKET_SIZE));
		descriptor = new AtomicReference<>(new Descriptor<>(0, null));

	}

	public void pushBack(E e) {
		Descriptor<E> desc;
		Descriptor<E> newD = null;
		do {
			desc = descriptor.get();
			desc.completeWrite();

			int pos = desc.size + FIRST_BUCKET_SIZE;
			int zeroNumPos = Integer.numberOfLeadingZeros(pos);
			int bucketInd = zeroNumPos;

			if (buckets.get(bucketInd) == null) {
				int newLen = 2 * buckets.get(bucketInd - 1).length();
				buckets.compareAndSet(bucketInd, null, new AtomicReferenceArray<>(newLen));
			}

			int index = (0x800000 >>> zeroNumPos) ^ pos;
			//newD = new Descriptor<>(e, e, buckets.get(bucketInd), 2);
		} while (!descriptor.compareAndSet(desc, newD));
	}
}
*/