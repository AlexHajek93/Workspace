package com.revature.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Queues {
	public static void main(String[] args) {
		Queue<Customer> que = new ArrayBlockingQueue<Customer>(10);
		que.add(new Customer("dan"));
		que.add(new Customer("howard"));
		que.add(new Customer("randolph"));
		Deque<Customer> dqu = new ArrayDeque<Customer>(10);
		dqu.add(new Customer("dan"));
		dqu.add(new Customer("howard"));
		dqu.add(new Customer("randolph"));
		Customer nowServing;
		nowServing = que.poll();
		System.out.println(nowServing);
		nowServing = que.poll();
		System.out.println(nowServing);
		nowServing = que.poll();
		System.out.println(nowServing);
		nowServing = dqu.pop();
		System.out.println(nowServing);
		nowServing = dqu.pop();
		System.out.println(nowServing);
		nowServing = dqu.pop();
		System.out.println(nowServing);
	}
}
class Customer{
	private String name;
	public Customer(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + "]";
	}
}