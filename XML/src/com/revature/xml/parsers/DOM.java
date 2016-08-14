package com.revature.xml.parsers;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * Tree-based parser
 * 1. Load the entire XML into Java memory (object of Document class)
 *		a. 1 MB in xml --> 10 MB in java
 * 2. Read/Writevfrom/into Document Object Model
 * 3. Works best for deeply nested XML documents
 * 4. Traverse DOM tree
 */
public class DOM {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(DOM.class.getClassLoader().getResourceAsStream("playlist.xml"));
		document.normalize();
		System.out.println(document.getDocumentElement());
		Node root = document.getDocumentElement();
		NodeList children = root.getChildNodes();
		for(int i=0; i<children.getLength();i++)
			if(children.item(i).getNodeType()==Node.ELEMENT_NODE)
				if(children.item(i).hasChildNodes())
					for(int j=0;j<children.item(i).getChildNodes().getLength();j++)
						System.out.println(children.item(i).getChildNodes().item(j).getTextContent().trim());
	}
}
