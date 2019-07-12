package AcessSecure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import bsh.Capabilities;

public class CaCertDemo {
	@Test
	public void openUrl() {
	 DesiredCapabilities cap=new DesiredCapabilities();
	 cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	 WebDriver driver = new ChromeDriver(cap);
	 driver.get("https://www.cacert.org/");
	 

	}
}