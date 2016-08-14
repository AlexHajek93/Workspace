package com.revature.patterns;

public class SingletonTest {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {}
				Singleton obj = Singleton.getEagerInstance();
				System.out.println(obj);
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {}
				Singleton obj = Singleton.getEagerInstance();
				System.out.println(obj);
			}
		}).start();
new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {}
				Singleton obj = Singleton.getEagerInstance();
				System.out.println(obj);
			}
		}).start();
new Thread(new Runnable() {
	
	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {}
		Singleton obj = Singleton.getEagerInstance();
		System.out.println(obj);
	}
}).start();
new Thread(new Runnable() {
	
	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {}
		Singleton obj = Singleton.getEagerInstance();
		System.out.println(obj);
	}
}).start();
new Thread(new Runnable() {
	
	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {}
		Singleton obj = Singleton.getEagerInstance();
		System.out.println(obj);
	}
}).start();
	}
}
