package com.test;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	// invocationCount is used to executed the same test case a number of times. 
	
	@Test(invocationCount=10)
	public void sum() {
		int a = 10;
		int b = 20;
		int c = a+b;
		System.out.println("Sum is ==" + c);
	}

}