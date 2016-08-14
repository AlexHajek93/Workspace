package com.revature.abstraction;

public class Day2 {
	public static void main(String[] args) {
		//Cannot create Interfaces or Abstracts
		//Animal a = new Tiger();
	}
}


abstract class Animal{
	
}
interface Predator{
	void hunt();
	void stalk();
	void attack();
}
interface Prey{
	void run();
	void hide();
}
final class Tiger extends Animal implements Predator{
	Tiger(){
		System.out.println("Tiger");
	}
	public final void hunt(){System.out.println("Hunting");}
	public final void stalk(){System.out.println("Stalking");}
	public final void attack(){System.out.println("Attacking");}
}