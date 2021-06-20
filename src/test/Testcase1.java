package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 {
	
	
	@BeforeTest
	public void BeforeTestMethod()
	{
		System.out.println("inside before test");
	}
	
	
	@BeforeMethod
	public void Setup() {
		
		System.out.println("Inside before methos");
	}

	@Test
	public void LoginTest() {
		
		System.out.println("Inside Login Test");
		
	}
	
	@Test
public void SignupTest() {
		
System.out.println("Inside signup Test");
		
	}
	
	@AfterMethod
	public void Aftermeth()
	{
		System.out.println("inside after method");
	}
	
	@AfterTest
	public void Aftertest()
	{
		System.out.println("inside after test");
	}
	

}
