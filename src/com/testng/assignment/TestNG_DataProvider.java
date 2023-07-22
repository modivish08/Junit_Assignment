package com.testng.assignment;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProvider {


	
	WebDriver driver = null;
	
	@DataProvider(name="credential")
	public Object[][] input()
	{
		return new Object[][] {{"standard_user","secret_sauce"},{"abc","bcd"},{"problem_user","secret_sauce"}};
	}
	
	@Test(dataProvider = "credential")	
	public void Login(String username, String password) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "F:\\vishal\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.id("user-name")).sendKeys(username);
		Thread.sleep(2000);

		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);

		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"))
		{
			System.out.println("Your Login Test has been passed");

			driver.findElement(By.id("react-burger-menu-btn")).click();
			Thread.sleep(2000);

			driver.findElement(By.id("logout_sidebar_link")).click();
			Thread.sleep(2000);
		}else
		{
			System.out.println("Your Login Test has been failed");
			fail("login failed");
		}
		
		Thread.sleep(2000);
		driver.close();
		
	}





}
