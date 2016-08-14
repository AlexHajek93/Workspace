package com.revature.sort;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

public class Sorted {
	public static void main(String[] args) {
		Set<Trainee> tree = new TreeSet();
		Trainee a = new Trainee(1, "John Smith", new BigDecimal(90000));
		Trainee b = new Trainee(1, "Jane Smith", new BigDecimal(90000));
		Trainee c = new Trainee(2, "Dan Pickles", new BigDecimal(100000));
		tree.add(a);
		tree.add(b);
		tree.add(c);
		
		for(Trainee t:tree)
			System.out.println(t);
	}
}
