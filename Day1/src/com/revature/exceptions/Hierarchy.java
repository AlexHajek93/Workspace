package com.revature.exceptions;

public class Hierarchy {
	public static void main(String[] args){
		try{
			throw new B();
		}
		catch(C c){
			System.out.println("C");
		}
		catch(B b){
			System.out.println("B");
		}
		catch(A a){
			System.out.println("A");
		}
	}
}

class A extends Exception{}
class B extends A{}
class C extends B{}

//Throwable
//	Error
//	Exception(check)
//		RuntimeException(unchecked)