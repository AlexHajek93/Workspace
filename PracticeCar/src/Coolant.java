import java.util.Random;

public class Coolant implements Interface{
	private boolean working;
	private int coolant_amount;//in pints
	private Random rand;
	
	public Coolant(){
		working = true;
		coolant_amount = 4;
		rand = new Random();
	}
	
	public boolean run(){
		if(!working){
			System.out.println("Your coolant system is still broken.");
			return false;
		}
		else if(rand.nextInt(10) == 0){
			working = false;
			System.out.println("Your coolant system has become broken.");
			return false;
		} 
		else if(coolant_amount == 0){
			System.out.println("You are out of coolant.");
			return false;
		}
		//50% chance of car heating to the point of using coolant
		else if(rand.nextInt(2) == 0){
			coolant_amount--;
			if(coolant_amount == 0){
				System.out.println("You have run out of coolant.");
				working = false;
				return false;
			}
		}
		return true;
	}
	
	public void fix(){
		if(!working){
			System.out.println("Your coolant system has been replaced and filled.");
			working = true;
			coolant_amount = 4;
		}
		else if(coolant_amount == 0){
			System.out.println("Your coolant system has been filled.");
			coolant_amount = 4;
		}
	}
	
	public void eval(){
		if(!working)
			System.out.println("Coolant System: Broken.");
		else
			System.out.println("Coolant System: Working with " + coolant_amount + " pints left.");
	}
}
