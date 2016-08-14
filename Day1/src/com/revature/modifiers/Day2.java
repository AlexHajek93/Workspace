//Comments only above package
package com.revature.modifiers;

//import com.revature.imports.Utility


public class Day2 {
	//com.revature.modifiers.Day2 object; //fully qualified class name
	//Utility object
}

class FinalKeyword {
	static int counter;
	final int constant = 101;
	
	void method(){counter++;counter = 100;}
	//Invalid
	//constant = 50;
	
	String string = "string";
	//String Pool cuts down on memory
	//Strings are by default final
	
	void compare(){
		String x = "X";
		//Forces new String
		String y = new String("X");
		//Returns false as not the same object
		System.out.println(x == y);
		//Good practice
		//System.out.println(x.equals(y));
		
		//New string created each time modified
		
		//Mutable: seen as char array
		//Use for better mem management
		StringBuilder object = new StringBuilder("String of Words");
		
		StringBuffer buffer;//Synched
	}
}