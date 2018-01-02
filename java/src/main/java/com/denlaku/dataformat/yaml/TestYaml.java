package com.denlaku.dataformat.yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;

import com.denlaku.Constant;
import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;

public class TestYaml {

	public static <T> T readYaml(String path, Class<T> cls) {
		try {
			System.err.println(path);
			YamlReader reader = new YamlReader(new FileReader(path));
			T read = reader.read(cls);
			return read;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (YamlException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	public void test03() {
		URL resource = TestYaml.class.getResource("contact.yml");
		String path = resource.getPath();
		Contact contact = readYaml(path, Contact.class);
		System.out.println(contact);
	}
	
	@Test
	public void test02() {
		String path = Constant.TEMP + "yaml/out";
		Contact contact = readYaml(path, Contact.class);
		System.out.println(contact);
	}
	
	@Test
	public void test01() {
		FileWriter fw = null;
		try {
			String path = Constant.TEMP + "yaml/out";
			fw = new FileWriter(path);
			YamlWriter writer = new YamlWriter(fw);
			Contact contact = new Contact();
			contact.setAge(100);
			contact.setName("contact-name");
			writer.write(contact);
			//writer.clearAnchors();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
