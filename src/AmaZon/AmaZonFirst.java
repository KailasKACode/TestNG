package AmaZon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmaZonFirst {
	WebDriver driver=new ChromeDriver();
	@Test
	public void openWebsite() {
		driver.get("https://www.amazon.com/");
	}
	public void deteCokieMaxWindow() {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	
@Test
public void searchProduct() throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Fastrck watches for men");
	driver.findElement(By.xpath("//input[@type='submit']")).click();


}	
public void scrollDemo() throws InterruptedException {
	JavascriptExecutor jave=(JavascriptExecutor)driver;
	Thread.sleep(5000);
	jave.executeAsyncScript("window.scrollBy(0,900)");

}

}
