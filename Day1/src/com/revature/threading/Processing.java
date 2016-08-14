package com.revature.threading;

public class Processing {
	static Account acct = new Account();
	public static void main(String[] args) throws InterruptedException {
		PaymentCalculator t1 = new PaymentCalculator(acct);
		Thread t2 = new Thread(new DepositCalculator(acct));
		t1.start();
		t2.start();
		System.out.println(acct);
		System.out.println(acct);
		System.out.println(acct);
		t1.join();
		System.out.println(acct);
		t2.join();
		System.out.println(acct);
	}
}
class Account{
	static double balance = 1000;

	public Account() {
		super();
	}

	public Account(double balance) {
		super();
		Account.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}

	public synchronized static double getBalance() {
		return balance;
	}

	public synchronized static void setBalance(double balance) {
		Account.balance = balance;
	}
	
}
/**
 * 
 * Calculates any deposits I need to make
 */
class PaymentCalculator extends Thread{
	Account funds;
	
	public PaymentCalculator(Account funds) {
		super();
		this.funds = funds;
	}

	public void run(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Account.balance -=100;
		Account.balance -=100;
		Account.balance -=200;
	}
	
}
class DepositCalculator implements Runnable{
	Account funds;
	
	public DepositCalculator(Account funds) {
		super();
		this.funds = funds;
	}

	@Override
	public void run() {
		Account.balance +=100;
		Account.balance +=100;
		Account.balance +=200;	
	}
	
}