package PointOfInterview;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemo {
	@Test
	public void test() {
		System.out.println("Test methods");
	}
	@BeforeClass
	public void beforeclas() {
		System.out.println("Before Class");
	}
	@Test
	public void test26() {
		System.out.println("Test methods 26");
	}

	@Test
	public void test56() {
		System.out.println("Test methods 56");
	}

	
	@BeforeMethod
	public void beforem() {
		System.out.println("Before method");
	}
	
	
	
	@BeforeTest
	public void afterSuite() {
		System.out.println("Before Suite");
	}
	
	@BeforeSuite
	public void beforesuite() {
		System.out.println("Before suite");
	}
	
	@BeforeTest
	public void Before() {
		System.out.println("Before Test");
	}
	
	@AfterMethod
	public void aftermetho() {
		System.out.println("After method");
	}
	
	
	
	@AfterTest
	public void aftre() {
		System.out.println("After Test2");
	}
	
	@AfterClass
	public void aterclass() {
		System.out.println("After Class");
	}
	
	@BeforeTest
	public void afterSuite2() {
		System.out.println("Before Suite 22");
	}

	
	
	
	

}
