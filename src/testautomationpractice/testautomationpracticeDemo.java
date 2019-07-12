package testautomationpractice;

import static org.testng.Assert.expectThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testautomationpracticeDemo {
	WebDriver driver = new ChromeDriver();
	Actions takeAction = new Actions(driver);

	@Test
	public void openUrl() {
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com");
		System.out.println("Browser open with entered URL");
	}

	@BeforeTest
	public void toDoble_Click() throws InterruptedException {
		WebElement to_Click = driver.findElement(By.xpath("//button[@ondblclick='myFunction1()']"));
		takeAction.moveToElement(to_Click);
		takeAction.doubleClick().build().perform();

	}

	@AfterTest
	public void aftremethodTest() {
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		takeAction.dragAndDrop(source, target);
		takeAction.doubleClick().build().perform();
		System.out.println("After method run");
		FluentWait waitt = new FluentWait(driver);
		waitt.ignoring(NoSuchElementException.class);
		waitt.withTimeout(10, TimeUnit.SECONDS);
		waitt.until(ExpectedConditions.elementToBeSelected(source));

	}

}
