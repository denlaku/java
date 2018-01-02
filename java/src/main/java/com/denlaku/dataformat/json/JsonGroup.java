package com.denlaku.dataformat.json;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class JsonGroup {
	private Long id;
	private String name;
	private List<JsonUser> users = new ArrayList<JsonUser>();
}
