package com.revature.xml.parsers;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * Event-Based parser
 * 1. Does NOT load the entire document into memory
 * 		a. "Scan" the document for an event to occur
 * 2. Read only SAX
 * 3. Works best for querying or simple reading
 * 4. Do NOT use with deeply-nester documents
 */
public class SAX {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(SAX.class.getClassLoader().getResourceAsStream("playlist.xml"),new MyParser());
	}
}

class MyParser extends DefaultHandler{

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// event is an xml opening tag
		System.out.print("<");
		System.out.print(qName);
		System.out.println(">");
		super.endElement(uri, localName, qName);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// event is an xml closing tag
//		System.out.print("</");
//		System.out.print(qName);
//		System.out.println(">");
//		super.startElement(uri, localName, qName, attributes);
		for(int i=0;i<attributes.getLength();i++)
			System.out.println(attributes.getValue(i));
		System.out.println(attributes.getValue("id"));
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// event: parser find text content inside an element
		System.out.println(new String(ch,start,length));
		super.characters(ch, start, length);
	}
}