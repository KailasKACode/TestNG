package AmaZon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmaZonFirst {
	WebDriver driver = new ChromeDriver();

	@Test(priority = 0)
	public void openWebsite() {
		driver.get("https://www.amazon.com");
	}

	@Test(priority = 1)
	public void deteCokieMaxWindow() {
		System.out.println(driver.manage().getCookies());
		driver.navigate().forward();
		driver.manage().window().maximize();
	}
	
	@Parameters({"user","pass"})
	@Test(priority=2)
	public void searchProduct(String user,String pass) throws SkipException {
		driver.findElement(By.xpath("(//span[@class='nav-line-1'])[3]")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Fastrck watches for men");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		throw new SkipException("Skip");

	}

	public void scrollDemo() throws InterruptedException {
		JavascriptExecutor jave = (JavascriptExecutor) driver;
		Thread.sleep(5000);
		jave.executeAsyncScript("window.scrollBy(0,900)");

	}

}
