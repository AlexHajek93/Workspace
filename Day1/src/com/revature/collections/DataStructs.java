package com.revature.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class DataStructs {
	int[] arr;
	Animal[] zoo;
	static List<Object> house = new ArrayList<Object>();
	static Set<Animal> house2 = new HashSet<Animal>();
	List<Animal> vic = new Vector<>();
	
	public static void main(String[] args) {
		int x=0;
		Animal a = new Animal();
		house.add(new Animal());
		house.add(new Integer(x));
		house2.add(a);
		house2.add(a);
	}
	
	void wrapper(){
		int x=10;
		//Pre-Java 5
		Integer integer = new Integer(x);
		int y = integer.intValue();
		//Auto-boxing
		int z = 10;
		Integer a = z;
		z = a;
		a = z;
		z = y;
	}
}

class Animal{}