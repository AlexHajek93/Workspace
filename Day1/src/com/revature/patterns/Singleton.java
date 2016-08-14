package com.revature.patterns;

/**
 * Only 1 can exist
 */
public class Singleton {
	//LAZY loaded singleton
	//  Only load once asked for
	//private static Singleton instance
	//+commented lines below
	//EAGER loaded at work
	//  Load at start
	private static Singleton lazyInstance;
	private static Singleton eagerInstance = new Singleton();
	//Restricted access necessary
	private Singleton(){}
	//Can also add keyword synchronized in LAZY
	public static Singleton getLazyInstance(){
		if(lazyInstance == null)
			lazyInstance = new Singleton();
		return lazyInstance;
	}
	public static Singleton getEagerInstance(){
		return eagerInstance;
	}
}