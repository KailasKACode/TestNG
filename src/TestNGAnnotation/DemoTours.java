package TestNGAnnotation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTours {
	WebDriver driver;

	@Test(priority = 0)
	public void loginTours() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("batman");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("batman");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		driver.findElement(By.xpath("(//input[@name='tripType'])[2]")).click();

		
		String parentwindow = driver.getWindowHandle();
		System.out.println("parent hamdle: "+parentwindow);
		Set<String> allwindow = driver.getWindowHandles();
		Thread.sleep(5000);
		for(String old:allwindow)
		{
			if(!parentwindow.equals(old))
			{
				driver.switchTo().window(old);
				Thread.sleep(2000);

				driver.findElement(By.xpath("(//input[@name='tripType'])[2]")).click();
			}
		}
	}


}
