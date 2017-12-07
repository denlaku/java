package com.denlaku.datainterchange.yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

import org.junit.Test;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

public class TestYaml {

	@Test
	public void test01() {
		try {
			URL resource = TestYaml.class.getResource("contact.yml");
			String path = resource.getPath();
			System.err.println(path);
			YamlReader reader = new YamlReader(new FileReader(path));
			Contact contact = reader.read(Contact.class);
			System.out.println(contact);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (YamlException e) {
			e.printStackTrace();
		}
	}
}
