package com.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.XL_Utility;



public class DataProvider_from_excelFile {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	
	
	
	}
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pwd, String expected) {
		
		driver.get("https://admin-demo.nopcommerce.com/login");
		WebElement inputEmail = driver.findElement(By.id("Email"));
		inputEmail.clear();
		inputEmail.sendKeys(user);
		
		WebElement inputpwd = driver.findElement(By.id("Password"));
		inputpwd.clear();
		inputpwd.sendKeys(pwd);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // Login button
		
		String expected_title = "Dashboard";
		String actual_title = driver.getTitle();
		
		if(expected.equals("Valid")) {
			if(expected.equals(actual_title)) {
				driver.findElement(By.linkText("Logout")).click();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		
		else if(expected.equals("Invalid")) {
			if(expected_title.equals(actual_title)) {
			driver.findElement(By.linkText("Logout")).click();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
		
	}
	
}
	
	
	
	
	@DataProvider(name = "LoginData")
	public String [] [] getData() throws IOException {
				
		// The following code get the data from excel. 
		String path = ".\\src\\datafiles\\loginData.xlsx";
		XL_Utility excelObje = new XL_Utility(path);
		int totalrows = excelObje.getRowCount("Sheet1");
		int totalcols = excelObje.getCellCount("Sheet1",1);
		
		String loginData[][]= new String[totalrows] [totalcols];
		
		for (int i = 1; i <= totalrows; i++) { // this loop will start from index 1 because our data in excel sheet starts from row number 2. the row number is counted by index. 
			for (int j = 0; j < totalcols; j++) { // this loop will go through the column its index starts from Zero. 
				loginData[i-1] [j] = excelObje.getCellData("Sheet1", i, j);
				// Note :here in the 2 dimension arry we are storing our data 
				// the excel data start from index 1 and we need to make it index Zero to by minus 1. 
				// to store it in our Array, we minus 1 to make it as index 0. and j represent column which is itself Zero. 
			}
			
		}
		
		
		return loginData;
	}	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}  // this is video from Paven in youtube : https://www.youtube.com/watch?v=1nP9UlwzpgU 
