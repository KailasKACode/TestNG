package PointOfInterview;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ToursLogin {
	WebDriver driver;

	@Test(priority = 0)
	public void loginTours() {
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
	}

	@Parameters({ "xpath", "key" })
	@Test(priority = 1)
	public void clickOnLogin(String xpath, String key) {
		driver.findElement(By.xpath(xpath)).sendKeys(key);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("batman");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		driver.findElement(By.xpath("(//input[@name='tripType'])[2]")).click();
	}
	@Test(priority=2)
	public void secondPage() {
		WebElement passenger = driver.findElement(By.xpath("//select[@name='passCount'] "));
		Select select = new Select(passenger);
		select.selectByIndex(2);

		WebElement departing = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select select2 = new Select(departing);
		select2.selectByIndex(2);
	}
	
	@Test(priority=3)
	public void selectAllTags() {
		WebElement month=driver.findElement(By.xpath("//select[@name='fromMonth']"));
		Select sele3=new Select(month);
		sele3.selectByIndex(11);
		WebElement day=driver.findElement(By.xpath("//select[@name='fromDay']"));
		Select sele4=new Select(day);
		sele4.selectByIndex(5);
		driver.findElement(By.xpath("//input[@name='findFlights']")).click();
		selectAllTags();

		
	}


	@Test(priority = 4)
	public void handleWindwo() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.pollingEvery(2000, TimeUnit.NANOSECONDS);
		String parentwindow = driver.getWindowHandle();
		System.out.println("parent hamdle: " + parentwindow);
		Set<String> allwindow = driver.getWindowHandles();
		Thread.sleep(5000);
		for (String child : allwindow) {
			if (!parentwindow.equals(child)) {
				driver.switchTo().window(child);
			}
		}
	}

}
