package Parrallesim;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
public class TestDemoParallal {
	static WebDriver driver;
	@Parameters({ "browserName" })
	@BeforeTest
	public void lanuchBrowser(String browserName) {
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();

		case "IE":
			driver = new InternetExplorerDriver();
		default:
			break;
		}
	}

	public void openUrl(String url) {
		driver.get(url);
	}
}
