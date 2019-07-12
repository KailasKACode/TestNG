package UploadFileTwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadAutoIt {
public static void main(String[] args) throws Exception {
	readFile();
}
	public static void readFile() throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.tinyupload.com/");
		driver.findElement(By.name("uploaded_file")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\Kailas\\Desktop\\TestAuto.exe");

	}
	
	
	

}
