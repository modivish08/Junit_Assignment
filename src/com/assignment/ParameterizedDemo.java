package com.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class ParameterizedDemo {
	
	String username,password;
	WebDriver driver = null;
	
	public ParameterizedDemo(String username,String password) 
	{
		this.username=username;
		this.password=password;
	}
		
	
	@Before
	public void before() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\vishal\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][] {{"abc","bcd"},{"standard_user","secret_sauce"}});
		
	}
	@Test
	public void test() throws InterruptedException, IOException {
		driver.findElement(By.id("user-name")).sendKeys(username);
		Thread.sleep(2000);
		
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);
		
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"))
		{
			System.out.println("Your Login Test has been passed");
			assertEquals("https://www.saucedemo.com/inventory.html", "driver.getCurrentUrl()");
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
