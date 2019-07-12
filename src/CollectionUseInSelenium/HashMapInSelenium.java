package CollectionUseInSelenium;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class HashMapInSelenium {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		// credintialMap();
		//String test = (credintialMap().get(0));
		driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")).sendKeys(getUserName("kailas"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(getPassword("kailas"));
		// driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	
	
		driver.quit();

	}

	public static HashMap<String, String> credintialMap() {
		HashMap<String, String> hp = new HashMap<String, String>();
		hp.put("pankaj", "pankaj:pankaj1010");
		hp.put("kailas", "7040007049:mom$123");
		hp.put("shashi", "shashirao:Item0101");
		hp.put("kail5as", "deepka:deepka105");
		hp.put("suhit", "sandip:sandeep132");
		hp.put("ka5ilas", "avinash:java1523");

		return hp;
	}

	public static String getUserName(String key) {
		String cred = credintialMap().get(key);
		return cred.split(":")[0];

	}
	
	public static String getPassword(String key) {
		String cred = credintialMap().get(key);
		return cred.split(":")[1];

	}

}
