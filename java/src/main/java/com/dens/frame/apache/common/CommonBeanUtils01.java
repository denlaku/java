package com.dens.frame.apache.common;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class CommonBeanUtils01 {
	
	
	
	@Test
	public void test02() {
		SubVO sub = new SubVO();
		sub.setName("tom");
		sub.setSex("G");
		BeanMap beanMap = new BeanMap(sub);
		Object object = beanMap.get("name");
		Object remove = beanMap.remove("tom");
		System.out.println(object);
		System.out.println(remove);
		System.out.println(sub);
	}
	

	@Test
	public void test01() {
		Map<String, Object> props = new HashMap<>();
		props.put("name1", "zhangsan");
//		props.put("age", 1000);
		SubVO sub = new SubVO();
		try {
			BeanUtils.populate(sub, props);
			System.out.println(sub);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
