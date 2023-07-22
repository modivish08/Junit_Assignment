package com.assignment;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemoJunit {
	
	WebDriver driver = null;
	@Before
	public void LoadBrowser() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\vishal\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test
	public void LoginDemo() throws InterruptedException, IOException {
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(2000);
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"))
		{
			System.out.println("Your Login Test has been passed");
		}else
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("F:\\vishal\\selenium\\Screenshot\\error.png");
			FileUtils.copyFile(src, dest);
			fail("Login Time");
		}
		
	}
	
	@After
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
