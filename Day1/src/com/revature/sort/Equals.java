package com.revature.sort;

import java.math.BigDecimal;
import java.util.concurrent.SynchronousQueue;

public class Equals {
	public static void main(String[] args) {
		Trainee a = new Trainee(1, "John Smith", new BigDecimal(90000));
		Trainee b = new Trainee(1, "Jane Smith", new BigDecimal(90000));
		Trainee c = new Trainee(2, "Dan Pickles", new BigDecimal(100000));
		System.out.println(a.equals(b));
		System.out.println(a);
		System.out.println(b);
	}
}
