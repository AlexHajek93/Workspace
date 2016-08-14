package generics;

import java.util.ArrayList;

public class Example {
	public static void main(String[] args) {
		for(int i = 0,j=10;i<10;++i,--j){}
		Jar<Food> jar = new Jar<>();
		String j;
//		j.re
//		jar.add(new Pickle());
		//Jar<RatPoison> jar2 = new Jar<>();
	}
}
interface Food{}
class Pickle implements Food{}
class Apple implements Food{}
class RatPoison{}
class Jar<T extends Food>{//type
	ArrayList<T> list = new ArrayList<T>();
	public void add(T food){list.add(food);}
	public T eat(){
		return list.get((int)(Math.random()*list.size()));
	}
}
