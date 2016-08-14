package com.revature.garbage;

public class Collection {
	void setNull(){
		Trash trash = new Trash();
		//code
		trash = null;// eligible
	}
	void outOfScope(){
		{Trash abc = new Trash();}
	}
	void reference(){
		Trash abc = new Trash();
		//
		abc = new Trash();
	}
	public static void main(String[] args) {
		
		System.gc(); //never can be forced to garbage collect, just request
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
	}
}
class Trash{
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
}
/*
 * Obejects eligible for garbage collection:
 * 1. Set a reference to null;
 * 2. Object goes out of scope
 * 3. Re-reference an object
 */