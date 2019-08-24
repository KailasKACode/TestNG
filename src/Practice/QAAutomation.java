package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.seleniumhq.jetty9.util.thread.Sweeper.Sweepable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QAAutomation {

	WebDriver driver;

	@Test(priority = 0)
	public void login() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void doubleclick() throws InterruptedException {
		System.out.println(driver.getTitle());
		WebElement doubleclick = driver.findElement(By.xpath("//button[@ondblclick='myFunction1()']"));
		Actions Dclick = new Actions(driver);
		Thread.sleep(2000);
		Dclick.doubleClick(doubleclick).perform();

	}

	@Test(priority = 2)
	public void dragAndDrop() throws InterruptedException {
		Actions takeaction = new Actions(driver);
		WebElement src = driver
				.findElement(By.xpath("//div[@class='ui-widget-content ui-draggable ui-draggable-handle']"));
		WebElement desc = driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable']"));
		Thread.sleep(2000);
		takeaction.dragAndDrop(src, desc).perform();
		takeaction.release();

	}
	@Test(priority=3)
	public void moveJonAndMerry() {
		Actions action=new Actions(driver);
		WebElement jon=driver.findElement(By.xpath("//h5[contains(text(),'Mr John')]"));
		WebElement merry=driver.findElement(By.xpath("//h5[contains(text(),'Mary')]"));
		WebElement trash=driver.findElement(By.xpath("//div[@id='trash']"));
		action.dragAndDrop(jon, trash).build().perform();
		action.dragAndDrop(merry, trash).build().perform();
		
	}

	public void selectTags() {
		
	}
	public void closeDriver() {
		driver.close();
	}

}
