package com.revature.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Traffic {
	public static void main(String[] args){
		File file = new File("something.txt");
		try{
			System.out.println("Try to open");
			//risky behavior
			FileInputStream fis = new FileInputStream(file);
		}
		catch(FileNotFoundException e){
			System.out.println("File does not exist.");
		}
		System.out.println("App Complete");
	}
}
