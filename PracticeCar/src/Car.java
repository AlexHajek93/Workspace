
public class Car implements Interface{
	private Engine engine = new Engine();
	private Fuel_Tank fuel_tank = new Fuel_Tank();
	private Wheels wheels = new Wheels();
	private Transmission transmission = new Transmission();
	private Coolant coolant = new Coolant();
	private boolean working;
	
	public Car(){
		working = true;
	}
	
	// Run the car
	public boolean run(){
		if(working && engine.run() && fuel_tank.run() && wheels.run() &&
		transmission.run() && coolant.run())
			return true;
		working = false;
		return false;
	}
	
	// Fix the car
	public void fix(){
		engine.fix();
		fuel_tank.fix();
		wheels.fix();
		transmission.fix();
		coolant.fix();
		working = true;
		System.out.println("Car has been fixed");
	}
	
	// Evaluate parts
	public void eval(){
		if(working)
			System.out.println("Your car is currently working.");
		else
			System.out.println("You car is currently broken.");
		engine.eval();
		fuel_tank.eval();
		wheels.eval();
		transmission.eval();
		coolant.eval();
	}
}
