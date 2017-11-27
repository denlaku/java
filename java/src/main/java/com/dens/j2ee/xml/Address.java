package com.dens.j2ee.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "code" })
public class Address implements Serializable, IAddress {

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
	public String toString() {
		return "Address [code=" + code + ", name=" + name + "]";
	}

}
