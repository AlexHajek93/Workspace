import java.util.Random;

public class Engine implements Interface{
	private boolean working;
	private int wear;
	private Random rand;;
	
	public Engine(){
		working = true;
		wear = 0;
		rand = new Random();
	}
	
	public boolean run(){
		int temp;
		temp = rand.nextInt(10);
		if(!working){
			System.out.println("Your engine is still broken");
			return false;
		}
		else if(temp <= wear){
			working = false;
			System.out.println("Your engine has broken");
			return false;
		}
		else if(temp <= (1+wear)){
			wear++;
			System.out.println("Your engine has been worn down a little");
			//Returns true via continuing
		}
		return true;
	}
	
	public void fix(){
		if(!working)
			System.out.println("Your engine has been replaced");
		else
			System.out.println("Your engine has been tuned-up");
		working = true;
		wear = 0;
	}
	
	public void eval(){
		if(!working)
			System.out.println("Engine: Broken");
		else
			System.out.println("Engine: Working with wear level of " + wear + "/10");
	}
}
