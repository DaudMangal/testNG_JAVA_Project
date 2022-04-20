package com.test;

import org.testng.annotations.Test;

public class TestNGFeature {
	
	// Here we have 4 test cases.
	// the 2nd, 3rd and 4th test cases depends on 1st test case. 
	// for example if the 1st loginTest pass the rest test cases will be executed, 
	// if the 1st test case fails the rest 3 test cases will skipped. 
	
	@Test
	public void loginTest() {
		System.out.println("login test");
		
	}
	@Test(dependsOnMethods="loginTest")
	public void homePageTest() {
		System.out.println("Home Page");
	}
	@Test(dependsOnMethods="loginTest")
	public void searchPageTest() {
		System.out.println("Search page test");
	}
	@Test(dependsOnMethods="loginTest")
	public void registPageTest() {
		System.out.println("Registration page");
	}

}
