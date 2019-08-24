import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipcart {
	WebDriver driver=new ChromeDriver();
	
	
	@Test
	public void openbrowser() {
		
		System.out.println("Open broswer");
	}
	@Test
	public void OpenUrl() {
		driver.get("https:://www.flicart.com");

	}
	
	
	 
	

}
