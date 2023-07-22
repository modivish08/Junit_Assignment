package com.ng1;

import org.testng.annotations.Test;

public class TestNG_Group {
  
	@Test(groups = {"red"})
	  public void red1() 
	  {
		  System.out.println("This is red1");
	  }
	@Test(groups = {"red"})
	  public void red2() 
	  {
		  System.out.println("This is red2");
	  }
 
	@Test(groups = {"red"})
	  public void red3() 
	  {
		  System.out.println("This is red3");
	  }
	
	@Test(groups= {"Green"})
	public void green1() 
	{
		System.out.println("Thid id geen1");
	}
	
	@Test(groups= {"Green"})
	public void green2() 
	{
		System.out.println("Thid id geen2");
	}
	
	@Test(groups= {"Green"})
	public void green3() 
	{
		System.out.println("Thid id geen3");
	}
	
	@Test(groups= {"red","Green"})
	public void red_green() 
	{
		System.out.println("Thid id red_green");
	}
}
