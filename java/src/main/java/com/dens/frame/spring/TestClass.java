package com.dens.frame.spring;

import java.net.URL;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.dens.vo.VipUserVO;

public class TestClass {

	@Test
	public void test03() {
		VipUserVO vipUser = new VipUserVO();
		vipUser.toString();
	}
	
	@Test
	public void test02() {
		URL resource = TestClass.class.getResource("spring.xml");
		String path = resource.getPath();
		FileSystemXmlApplicationContext fac = new FileSystemXmlApplicationContext(path);
		fac.close();
	}
	
	@Test
	public void test01() {
		Package pkg = TestClass.class.getPackage();
		String name = pkg.getName();
		String path = (name != null ? name.replace(".", "/") : "") + "/spring.xml";
		ClassPathXmlApplicationContext ctt = new ClassPathXmlApplicationContext(path);
		ctt.close();
	}
	
	
}
