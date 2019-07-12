package DataProviderDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderDemoFirst {
WebDriver driver=new ChromeDriver();

@Test
public void openUrl() {
	//driver.get("https://www.faceboook.com");
	System.out.println("Url Not found");
}

@DataProvider(name="Loginpage")
public Object[][] y2() {
	Object [][] value= {{"email1","pass1"},{"email2","pass2"},{"email3","pass3"}}; 
	
	
	return value;

}

@Test(dataProvider="Loginpage")
public void test(String uname,String pass) {
System.out.println("Uname:   "+uname +"  passwors:  "+pass);
}

}
