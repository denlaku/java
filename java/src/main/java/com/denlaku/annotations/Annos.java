package com.denlaku.annotations;

public class Annos extends Anno{
	@Value("123")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
