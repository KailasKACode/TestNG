package OpneDiffBrowsers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class ParametersBase {
	static WebDriver driver;
	@Parameters({"browserName"})
	@BeforeTest
	public static void launchBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "/Volumes/BOOTCAMP/JARs/Drivers/chromedriver");
			driver = new ChromeDriver();
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "/Volumes/BOOTCAMP/JARs/Drivers/geckodriver");
			driver = new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", "/Volumes/BOOTCAMP/JARs/Drivers/iedriver");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.err.println("Invalid browser name: " + browserName);
		}

	}

	public static void openUrl(String url) {
		// TODO Auto-generated method stub
		driver.get(url);

	}

}
