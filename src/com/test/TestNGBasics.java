
package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	// testNG is available in the form of Jar file. This structure we created is the form of Jar file. 
	
	// Every annotation must be associated with method. we can not write annotation without method. 
	// we have 3 sections of 
	// Pre- condition annotations starts with @Before
	// test cases annotation starts with @Test
	// post condition start with @After

	/* The sequence of test case execution is in pair as bellow. 
	 * @BeforeMethod
	 * @Test -1
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test -2
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test -3
	 * @AfterMethod
	 * 
	 */
	
	// Note : in the real time program we don't use all these number of annotations. 
	// The maximum annotations we use are the @BeforClass @BeforeMethod @Test
	//                                        @AfterMethod @AfterClass
	
	
	@BeforeSuite  //1
	public void setUp() {
		System.out.println("setup system property for chrome");
	}
	
	@BeforeTest  //2
	public void launchBrowser() {
		System.out.println("Launch Chrome browser");
	}
	@BeforeClass  //3
	public void login() {
		System.out.println("Login to app");	
	}
	
	@BeforeMethod //4
	public void enterURL() {
	System.out.println("Enter URL");
	
	}
	
	@Test //5
	public void googleTitleTest() {
		System.out.println("Google Title Test");
		
	}
	@Test
	public void searchTest() {
		System.out.println("search test");
	}
	@Test
	public void googleLogoTest() {
		System.out.println("google log test");
	}
	
	@AfterMethod //6
	public void logOut() {
		System.out.println("LogOut from app");
	
	}
	@AfterClass  //7
	public void closeBrowser() {
		System.out.println("Close the browser");
		
	}
	@AfterTest  //8
	public void deleteAllcookies() {
		System.out.println("delete all cookies");
	}
    @AfterSuite //9
    public void generateTestReport() {
    	System.out.println("generate test report");
    }
}
