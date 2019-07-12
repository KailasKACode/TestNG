package TestDemoFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class FirstDemo {
	@AfterSuite
	public void TC_01() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/pazone/ashot");
		System.out.println("This is the @AfterSuite");

	}

	@BeforeSuite
	public void TC_02() {
		System.out.println("This is the @BeforeSuite");
	}
	
	@AfterTest
	public void TC_03() {
		System.out.println("This is after TEst");
	}

	@BeforeTest
	public void TC_04() {
		System.out.println("This is Before Test");
	}
	
	@AfterMethod
	public void TC_05() {
		System.out.println("This After method");
	}
	
	@BeforeMethod
	public void TC_06() {
		System.out.println("This is before method");
	}

	@AfterClass
	public void TC_07() {
		System.out.println("This is after class");
	}

	@BeforeClass
	public void TC_08() {
		System.out.println("This is before class");
	}
	
	@Test
	public void TC_09() {
		System.out.println("This test 09");
	}
	
	@Parameters
	public void TC_10() {
		System.out.println("This is parameters annotationa");
	}

	@Test
	public void toCheckTitle() {
		System.out.println("This tital methhods are sone");
	}

}