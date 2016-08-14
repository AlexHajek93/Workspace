package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClassToTestTest {

	//TDD
	@Test
	public void testNewFeature(){
		int[] testData = {10,6,4,1};
		int expected = -1;
		int actual = new ClassToTest().subtract(testData);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAdd() {
		int[] testDData = {5,21,7,3,9};
		int expected = 45;
		int actual = new ClassToTest().add(testDData);
		
		assertEquals(expected, actual);
	}

}
