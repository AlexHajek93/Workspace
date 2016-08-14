package com.revature.patterns;

/*
 * Abstract implementation details - hide complexity/concrete types
 */
public class Factory {
	public static Gun getMachineGun(){
		//Complex logic if needed
		return new AK47();
	}
	public static Gun getHandGun(){
		return new FoFoMagnum();
	}
	public static Gun getRifle(){
		return new Barrett();
	}
}
interface Gun{
	public int fire();
	public boolean reload();
}
class AK47 implements Gun{
	@Override
	public int fire() {return 47;}
	@Override
	public boolean reload() {return false;}}
class FoFoMagnum implements Gun{
	@Override
	public int fire() {return 44;}
	@Override
	public boolean reload() {return false;}}
class Barrett implements Gun{
	@Override
	public int fire() {return 2000;}
	@Override
	public boolean reload() {return false;}}