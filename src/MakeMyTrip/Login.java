package MakeMyTrip;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;

	@Test(priority = 0)
	public void login() {
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com");
	}

	@Test(priority = 1)
	public void doubleTrip() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='tabsCircle appendRight5'])[2]")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
		from.sendKeys("Mumbai");
		from.sendKeys(Keys.DOWN);
		from.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement to = driver.findElement(By.xpath("//input[@placeholder='To']"));
		to.sendKeys("delhi");
		to.sendKeys(Keys.DOWN);
		to.sendKeys(Keys.ENTER);
	}
	@Test(priority=2)
	public void calender() {
		int days=driver.findElements(By.xpath("//div[@aria-disabled='false']")).size();
		System.out.println(days);
		
	}

}
