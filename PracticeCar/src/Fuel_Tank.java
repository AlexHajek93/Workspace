import java.util.Random;

public class Fuel_Tank implements Interface{
	private boolean working;
	private int fuel_amount;//in gallons
	private Random rand;
	
	public Fuel_Tank(){
		working = true;
		fuel_amount = 20;
		rand = new Random();
	}
	
	public boolean run(){
		if(!working){
			System.out.println("Your fuel tank is still broken.");
			return false;
		}
		else if(rand.nextInt(10) == 0){
			working = false;
			System.out.println("Your fuel tank has become broken.");
			return false;
		} 
		else if(fuel_amount == 0){
			System.out.println("You are out of fuel.");
			return false;
		}
		else if(fuel_amount == 1){
			fuel_amount--;
			System.out.println("You have run out of fuel.");
			working = false;
		}
		else{
			fuel_amount--;
		}
		return true;
	}
	
	public void fix(){
		if(!working){
			System.out.println("Your fuel tank has been replaced and filled.");
			working = true;
			fuel_amount = 20;
		}
		else if(fuel_amount == 0){
			System.out.println("Your fuel tank has been filled.");
			fuel_amount = 20;
		}
	}
	
	public void eval(){
		if(!working)
			System.out.println("Fuel Tank: Broken.");
		else
			System.out.println("Fuel Tank: Working with " + fuel_amount + " gallons left.");
	}
}
