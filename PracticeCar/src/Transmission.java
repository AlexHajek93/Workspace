import java.util.Random;

public class Transmission implements Interface{
	private boolean working;
	private int wear;
	private Random rand;;
	
	public Transmission(){
		working = true;
		wear = 0;
		rand = new Random();
	}
	
	public boolean run(){
		int temp;
		temp = rand.nextInt(10);
		if(!working){
			System.out.println("Your transmission is still broken");
			return false;
		}
		else if(temp <= wear){
			working = false;
			System.out.println("Your transmission has broken");
			return false;
		}
		else if(temp <= (1+wear)){
			wear++;
			System.out.println("Your transmission has been worn down a little");
			//Returns true via continuing
		}
		return true;
	}
	
	public void fix(){
		if(!working){
			System.out.println("Your transmission has been replaced");
			working = true;
			wear = 0;
		}
	}
	
	public void eval(){
		if(!working)
			System.out.println("Transmission: Broken");
		else
			System.out.println("Transmission: Working with wear level of " + wear + "/10");
	}
}
