package com.dens.service;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class Address implements Serializable, Closeable {

	private static final long serialVersionUID = 1L;
	private String code;
	private String name;

	public Address() {
		super();
	}

	public Address(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub

	}
}
