import java.util.Random;

public class Wheels implements Interface{
	private boolean working;
	private int[] wear_levels = new int[4];//in gallons
	private Random rand;
	
	public Wheels(){
		working = true;
		for(int i = 0; i < 4; i++)
			wear_levels[i] = 0;
		rand = new Random();
	}
	
	public boolean run(){
		int temp;
		if(!working){
			System.out.println("1 of the wheels are not working.");
			return false;
		}
		for(int i = 0; i < 4; i++){
			temp = rand.nextInt(10);
			if(temp <= wear_levels[i]){
				working = false;
				System.out.println("1 of the wheels are now broken.");
				return false;
			}
			else if(temp <= (1+wear_levels[i])){
				wear_levels[i]++;
			}
			else{
				//Do nothing
			}
		}
		return true;
	}
	
	public void fix(){
		if(!working){
			System.out.println("Your wheels have been replaced.");
			working = true;
			for(int i = 0; i < 4; i++)
				wear_levels[i] = 0;
		}
	}
	
	public void eval(){
		if(!working)
			System.out.println("Wheels: Broken");
		else{
			System.out.println("The wear levels on your car are as follows:");
		  System.out.println("FL: " + wear_levels[0] + "/10, FR: " + wear_levels[1] + "/10, RL: "
		  		+ wear_levels[2] + "/10, RR: " + wear_levels[3] + "/10.");
		}
	}
}
