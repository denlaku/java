package com.dens.security;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Principal;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;

import org.junit.Test;

public class TestClass1 {

	
	@Test
	public void test03() {
		Subject subject = new Subject();
		Set<Principal> principals = subject.getPrincipals();
		System.out.println(principals.size());
		
	}
	
	@Test
	public void test02() {
		AccessControlContext context = AccessController.getContext();
		Subject subject = Subject.getSubject(context);
		System.out.println(subject);
	}
	
	@Test
	public void test01() {
		Map<String, String> env = System.getenv();
		System.out.println(env.get("USERNAME"));
	}
}
