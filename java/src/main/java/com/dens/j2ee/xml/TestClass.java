package com.dens.j2ee.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.dens.Constant;

public class TestClass {

	private static final String PATH = Constant.TEMP + "xmls\\person.xml";

	
	@Test
	public void test08() {
		/**
		 * 把XML字符串转换成java对象
		 */
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		sb.append("<person xmlns:tt=\"http://www.xml.com\">");
		sb.append("<name>KKK===111===222</name>");
		sb.append("<address>");
		sb.append("<name>ShenZhen</name>");
		sb.append("<code>SZ</code>");
		sb.append("</address>");
		sb.append("<id>100</id>");
		sb.append("</person>");
		StringReader sr = new StringReader(sb.toString());
		Person unmarshal = JAXB.unmarshal(sr, Person.class);
		System.out.println(unmarshal);
    
	}
	
	
	@Test
	public void test07() {
		/**
		 * 把java对象转换成XML字符串
		 */
		Person person = new Person(100L, "KKK===111===222", new Address("SZ", "ShenZhen"));
		StringWriter sw = new StringWriter();
		JAXB.marshal(person, sw);
		System.out.println(sw.toString());
	}
	
	@Test
	public void test06() {
		/**
		 * 把java对象写成XML文件
		 */
		Person person = new Person(100L, "KKK===111===222", new Address("SZ", "ShenZhen"));
		JAXB.marshal(person, PATH);
	}

	@Test
	public void test05() {
		Person person = JAXB.unmarshal(PATH, Person.class);
		System.out.println(person);
	}

	@Test
	public void test04() {
		try {
			StreamSource ss = new StreamSource(new FileReader(PATH));
			JAXBContext context = JAXBContext.newInstance(Person.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			JAXBElement<Person> unmarshal = unmarshaller.unmarshal(ss, Person.class);
			Person value = unmarshal.getValue();
			System.out.println(value.getName());
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test03() {
		try {
			JAXBContext context = JAXBContext.newInstance(Person.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			File xmlFile = new File(PATH);
			Person person = new Person(100L, "KKK======", new Address("SZ", "ShenZhen"));
			marshaller.marshal(person, xmlFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			File xmlFile = new File(PATH);
			FileInputStream fis = new FileInputStream(xmlFile);
			Document doc = builder.parse(fis);
			Element root = doc.getDocumentElement();
			System.out.println(root);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test01() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.newDocument();
			Element root = doc.createElement("Person");
			doc.appendChild(root);
			Element id = doc.createElement("id");
			id.setTextContent("100");
			root.appendChild(id);
			Element name = doc.createElement("name");
			name.setTextContent("AA");
			root.appendChild(name);

			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			DOMSource source = new DOMSource(doc);
			File xmlFile = new File(PATH);
			FileOutputStream fos = new FileOutputStream(xmlFile);
			StreamResult sr = new StreamResult(fos);
			tf.transform(source, sr);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
