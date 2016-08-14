package com.revature.enums;

public class TEstClass {
	public static void main(String[] args) {
		RiskProb something = RiskProb.HIGH;
		if(something == RiskProb.HIGH)
			System.out.println("Too High Risk");
	}
}
enum RiskProb{
	LOW,MEDIUM,HIGH;
}
enum RiskImpact{
	LOW,MEDIUM,HIGH;
}