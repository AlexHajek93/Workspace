package com.revature.threading;

public class Priority {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				int x = 0;
				while(true){
					if(x++%1000 == 0)
						System.out.println(Thread.currentThread().getName() + " : " + x++);
					if(x>1000000)
						break;
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				int x = 0;
				while(true){
					if(x++%1000 == 0)
						System.out.println(Thread.currentThread().getName() + " : " + x++);
					if(x>1000000)
						break;
				}
			}
		});
		t1.setName("First");
		t2.setName("Second              ");
		t1.setPriority(10);
		t2.setPriority(10);
		t1.setDaemon(false);
		t2.setDaemon(true);
		t1.start();
		t2.start();
//		t2.setName("Third              ");
	}
}
