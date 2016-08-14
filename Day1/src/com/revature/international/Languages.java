package com.revature.international;

import java.util.Locale;
import java.util.ResourceBundle;

public class Languages {
//your location
	public static void main(String[] args) {
		Locale.setDefault(new Locale("sp","US"));
		Locale locale = Locale.getDefault();
		ResourceBundle messages = ResourceBundle.getBundle("MessageResources",locale);
		System.out.println(messages.getObject("hello"));
	}
}
