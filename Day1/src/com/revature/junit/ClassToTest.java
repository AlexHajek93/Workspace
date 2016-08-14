package com.revature.junit;

public class ClassToTest {
	/**
	 * Adds all number in an array and returns sum
	 * @param numbers
	 * @return
	 */
	public int add(int[] numbers){
		int sum = 0;
		for(int i:numbers)
			sum+=i;
		return sum;
	}
	
	public int subtract(int[] numbers){
		int sum = 2*numbers[0];
		for(int i:numbers)
			sum-=i;
		return sum;
	}
}
