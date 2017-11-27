package com.dens.test;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dens.service.HelloService;

public class TestSpring {

	@Test
	public void test01() {
		try (ClassPathXmlApplicationContext ctt = new ClassPathXmlApplicationContext("spring.xml");) {
			HelloService bean = ctt.getBean("helloService", HelloService.class);
			System.out.println(bean);
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
}
