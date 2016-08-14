package com.revature.excercises;

import java.util.Vector;

public class Excercises {
	public static void main(String[] args) {
		int[] array1 = {15,3};
		int[] array2 = {9,4,7,5,8,6,3,2,1};
		int[] array3 = {1,1,2,3,3,4,5,5,5,5,6,7};
		System.out.println(isEven(7));
		System.out.println(isEven2(3));
		swap(array1);
		sort(array2);
		for(int i : array2){
			System.out.print(i+" ");
		}
		elimDuplicates(array3);
	}
	//Q1
	static boolean isEven(int n){
		if(n%2 == 0)
			return true;
		return false;
	}
	//Q2
	static boolean isEven2(int n){
		if(n/2 == (n+1)/2)
			return true;
		return false;
	}
	//Q3
	static void swap(int[] arr){
		arr[0] ^= arr[1];
		arr[1] ^= arr[0];
		arr[0] ^= arr[1];
		System.out.println(arr[0] + " " +arr[1]);
	}
	//Q4
	static void swap(int[] arr,int startIndex){
		arr[startIndex] ^= arr[startIndex+1];
		arr[startIndex+1] ^= arr[startIndex];
		arr[startIndex] ^= arr[startIndex+1];
	}
	static int[] sort(int[] arr){
		for(int i = 0; i < arr.length - 1; i++){
			for(int j = 0; j < arr.length - 1 -i; j++){
				if(arr[j] > arr[j+1]){
					swap(arr,j);
				}
			}
		}
		return arr;
	}
	//Q5
	static int[] elimDuplicates(int[] arr){
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		return arr;
	}
}
