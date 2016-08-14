package com.revature.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrency {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		System.out.println(lock.tryLock());
		System.out.println(lock.tryLock());
	}
}