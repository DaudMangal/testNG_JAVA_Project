package com.test;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
	
	// it is just example, we never write this kind of loop infinit loop in real job. 
	
//	@Test(timeOut=2000)
//	public void infinitLoopTest() {
//		int i = 1;
//		while( i ==1) {
//			System.out.println(i);
//		}
//	}

	
	@Test(expectedExceptions=NumberFormatException.class)
	public void test1() {
		String x = "100A";
		Integer.parseInt(x);
		
	}
}
