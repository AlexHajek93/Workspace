package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInteraction {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner parser = new Scanner(new File("data.csv"));
		parser.useDelimiter(",");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String userInput = scanner.next();
		System.out.println("Thanks, " + userInput);
		System.out.println("How old are you?");
		int age = Integer.parseInt(scanner.next());
		System.out.println("Cool, you're " + age);
	}
}
