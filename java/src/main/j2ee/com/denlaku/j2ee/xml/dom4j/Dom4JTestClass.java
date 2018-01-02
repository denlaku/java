package com.denlaku.j2ee.xml.dom4j;

import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Dom4JTestClass {

	private static final String PATH = "D:\\denlaku.git\\java-training\\java\\temp\\xml\\person.xml";

	@Test
	public void test02() {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(PATH);
			Element root = doc.getRootElement();
			System.out.println(root.getName());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test01() {
		DocumentFactory df = DocumentFactory.getInstance();
		Document doc = df.createDocument();
		Element root = doc.addElement("Person");
		root.addAttribute("class", "com.dens.xml.Person");
		Element id = root.addElement("id");
		id.setText("10011===1111");
		Element name = root.addElement("name");
		name.setText("BBB");

		Element address = root.addElement("address");
		Element code = address.addElement("code");
		code.setText("SZ");
		Element addressName = address.addElement("name");
		addressName.setText("ShenZhen");

		try {
			FileOutputStream fos = new FileOutputStream(PATH);
			OutputFormat format = new OutputFormat("  ", true);
			format = OutputFormat.createPrettyPrint();
			XMLWriter writer = new XMLWriter(fos, format);
			writer.write(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
