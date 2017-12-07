package com.denlaku.datainterchange.json;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class TestJson {

	@Test
	public void test01() {
		JsonGroup jgroup = new JsonGroup();
		jgroup.setId(100L);
		jgroup.setName("j-group");
		
		JsonUser juser1 = new JsonUser();
		juser1.setId(11L);
		juser1.setName("j-user1");
		
		JsonUser juser2 = new JsonUser();
		juser2.setId(12L);
		juser2.setName("j-user2");
		
		List<JsonUser> users = Arrays.asList(juser1, juser2);
		jgroup.setUsers(users);
		
		String jsonString = JSON.toJSONString(jgroup);
		System.out.println(jsonString);
		
		JsonGroup parseObject = JSON.parseObject(jsonString, JsonGroup.class);
		System.out.println(parseObject);
	}
}
