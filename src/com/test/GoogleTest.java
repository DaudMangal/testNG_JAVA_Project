package com.test;



import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://www.google.com");
		
		
	}
	@Test(priority=1, groups="Title")
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	@Test(priority=2, groups="Logo")
	public void googleLogoTest() {
		boolean logo = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		System.out.println(logo);
		
	}
	@Test(priority=3)
	public void gmailLinkTest() {
		boolean gmail = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println(gmail);
	}
		
	@Test(priority=4, groups="Test")
	public void test1() {
		System.out.println("test1");
	}
	
	@Test(priority=6, groups="Test")
	public void test2() {
		System.out.println("test2");
	}
	@Test(priority=7, groups="Test")
	public void test3() {
		System.out.println("test3");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
