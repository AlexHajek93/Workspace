package com.revature.collections;

import java.util.HashMap;
import java.util.Map;

public class Maps {
	public static void main(String[] args) {
		Map<String, Account> accounts = new HashMap<String, Account>();
		accounts.put("bobby", new Account());
		accounts.put("dan", new Account());
		
		//Account a = (Account) accounts.get("dan");
		for(Object o : accounts.values())
			System.out.println(o);
	}
}
class Account{
	int acctNum;
	double balance;
	
//	public String toString(){
//		return " "+balance;
//	}
}