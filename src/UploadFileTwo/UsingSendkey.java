package UploadFileTwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingSendkey {
	static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
		WebElement file=driver.findElement(By.id("Upload file"));
		file.sendKeys("\"C:\\Users\\Kailas\\Desktop\\New Text Document.txt");
	}

}
