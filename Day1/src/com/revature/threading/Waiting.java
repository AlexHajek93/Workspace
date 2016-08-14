package com.revature.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * wait() wait(1000)
 * method in object class
 * notify() notifyAll()
 * 
 * wait will release any locks... wait() must be in synch method/block
 * 
 */
public class Waiting {
	static Waiting waiting = new Waiting();
	public static void main(String[] args) {
		Thread t1= new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("T1 waiting..");
				synchronized (waiting) {
					try {
						waiting.wait();
					} catch (InterruptedException e) {}
				}
				System.out.println("T1 is done waiting!");
			}
		});
		Thread t2= new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized (waiting) {
					try {
						Thread.sleep(3000);
						System.out.println("T2 notifying.");
						notify();
					} catch (InterruptedException e) {}
				}
				System.out.println("");
			}
		});
		t1.start();
		t2.start();
	}
}
