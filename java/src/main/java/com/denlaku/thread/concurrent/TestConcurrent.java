package com.denlaku.thread.concurrent;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentSkipListMap;

import com.denlaku.vo.UserVO;

public class TestConcurrent {

	public static void main(String[] args) {
		ConcurrentSkipListMap<Long, UserVO> cslm = new ConcurrentSkipListMap<>();
		UserVO u1 = new UserVO();
		u1.setId(1L);
		UserVO u2 = new UserVO();
		u2.setId(2L);

		UserVO u13 = new UserVO();
		u13.setId(13L);

		UserVO u9 = new UserVO();
		u9.setId(9L);

		cslm.put(u2.getId(), u2);
		cslm.put(u1.getId(), u1);
		cslm.put(u13.getId(), u13);
		cslm.put(u9.getId(), u9);

		for (Entry<Long, UserVO> e : cslm.entrySet()) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}
	}
}
