//Author: Alexander Hajek
//System: Car Simulator
//Date: 6/21/2016
//Version: 1
//Known Bugs:
// None
//To-Do List:
// Swap conditionals: should return false in case if/else cases skipped
// Selective fixings as optional implementation
// Change breaking numbers
// Switch from interface to abstract class to put working and rand in one place
//  and use inheritance
// Include things like start car, ignition variable, and more functions to
//  better simulate car

//Thoughts on the following questions
//
//Should each component inherit any behaviors or states from a superclass? 
// Should that superclass be abstract?
//It would have been easier to inherit the working variable than to have declared each one.
//
//Should you use an interface for the components, to guarantee they share behavior?
//I did go with this method as each part needs a run, fix, and eval for the system
//
//Should a car class have an instance of each component, or a collection of component objects?
//I used an instance for each, while the wheels were put in a collection

import java.io.IOException;

public class Simulator {
	
	private static final int EXIT = 0;
	private static final int RUN_CAR = 1;
	private static final int FIX_CAR = 2;
	private static final int EVALUATE = 3;
	private static final int HELP = 4;
	
	private static Car car = new Car();
	
	private static int prompt(){
		//System.out.println("Please enter an operation number: ");
		try{
			return System.in.read()- 48;
		} catch (IOException ioe) {
			return -1;
		}
	}
	
	private static void display_help(){
		System.out.println("Welcome to Car Simulator.");
		System.out.println("Press " + EXIT + " to exit the system.");
		System.out.println("Press " + RUN_CAR + " to run the car.");
		System.out.println("Press " + FIX_CAR + " to fix the car.");
		System.out.println("Press " + EVALUATE + " to view the car's properties.");
	}
	
	public static void run(){
		if(car.run())
			System.out.println("Car went 30 miles");
		else
			System.out.println("Car broken down");
	}
	
	public static void main(String[] args) {
		int command;
		display_help();
		command = prompt();
		while(command != EXIT){
			switch(command){
			case RUN_CAR:run();break;
			case FIX_CAR:car.fix();break;
			case EVALUATE:car.eval();break;
			case HELP:display_help();break;
			default:break;
			}
			command = prompt();
		}
		System.out.println("Thank you for simulating.");
	}
}
