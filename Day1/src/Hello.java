
public class Hello {
	public static void main(String[] args){
		int k=1;
		Vehicle var = new Vehicle();
		var.accelerate(10.5);
		System.out.println(var.speed);
		var.accelerate(-10);
		System.out.println(var.speed);
		System.out.println(var.color);
		k+=(k=4)*(k+2);
		System.out.println(k);
		outer:
		if("String".replace('g', 'G')==new String("String").replace('g', 'G'))
			System.out.println("Valid");
	}
}

class Vehicle{
	//states
	boolean isRunning = false;
	double speed = 0;
	int year = 2000;
	float mileage = 15000;
	short horsepower = 1100;
	char color = 'R';
	byte passengers = 5;
	long serialNumber = 123789456;
	String make = "Chevy";
	String model = "Impala";	
	char[] word = new char[15];
	int[][] arr = new int[3][5];
	int[] stuff = {0,5};
	
	//behavior
	void accelerate(double change){
		speed += change;
		if(speed > 85)
			System.out.println("Stop Speeding");
		else
			System.out.println("Safe Driving");
	}
	
	
}