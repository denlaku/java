package com.dens.j2ee.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestClass2 {

	@Test
	public void test01() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
//			dbf.setIgnoringElementContentWhitespace(true);
			dbf.setIgnoringComments(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			InputStream is = TestClass2.class.getResourceAsStream("test.xml");
			Document doc = db.parse(is);
			
			Element root = doc.getDocumentElement();
			NodeList childNodes = root.getChildNodes();
			
			System.out.println(childNodes.getLength());
			
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node item = childNodes.item(i);
//				System.out.println(item);
				if (item instanceof Element) {
					Element ele = (Element)item;
					NamedNodeMap attributes = ele.getAttributes();
					for (int j = 0; j < attributes.getLength(); j++) {
						Node node = attributes.item(j);
						String nodeName = node.getNodeName();
						String localName = node.getLocalName();
						String nodeValue = node.getNodeValue();
						
						System.out.println(nodeName + ": " + localName + ": " + nodeValue);
					}
				}
			}
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
