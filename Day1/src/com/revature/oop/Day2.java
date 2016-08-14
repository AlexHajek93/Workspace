package com.revature.oop;

public class Day2 {
	public static void main(String[] args) {
		//Invalid
		//Vehicle v = new Vehicle();
		Vehicle v = new Car();
		//v.maintain();
		Vehicle t = new Truck();
		Vehicle[] carLot = new Vehicle[2];
		carLot[0] = v;
		carLot[1] = t;
		for(Vehicle obj : carLot){
			if(obj instanceof Car)
				((Car) obj).maintain();
		}
	}
}

abstract class Vehicle{
	int numberOfWheels;
	//Adding final would not allow overriding
	void move(){
		System.out.println("Vehicle is Moving");//pre-define behaviors
	}
}

//Adding final class would not allow extension
class Car extends Vehicle{
	Car(){
		numberOfWheels = 4;
	}
	void move(){
		System.out.println("Car is Moving");
	}
	void move(int speed){}
	void move(int speed, int time){}
	void maintain(){
		move();
		numberOfWheels = -1;
		//Bad Practice
		//Truck t = new Truck();
		//t.make = "Ford";
		//
	}
}
//Car Is-a Vehicle
class Truck extends Vehicle{
	private String make;//protection from unwanted access
	public void setMake(String make){
		this.make = make;
	}
	void move(){
		System.out.println("Truck is Moving");
	}
}