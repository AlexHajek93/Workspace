package com.revature.vararg;

public class VarArgs {
	public static void main(String[] args) {
		//Var args : any number of a single type as argument
		print(1,2,3,4,5,6,7,8,9,0,1,2,4,5,8,8,5,4);
		print2("Test",1,2,4,5,6,7,8,7,5,4,2,8);
	}
	public static void print(int... args){
		int[] values = args;
		for(int i : values)
			System.out.println(i);
	}
	public static void print2(String s,int... args){
		System.out.println(s);
		int[] values = args;
		for(int i : values)
			System.out.println(i);
	}
}
