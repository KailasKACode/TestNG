package TestPracticeAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestAutomationPractice {
	public static WebDriver driver;
	public static String date = "20";
	public static String date2 = "15";

	@Test(priority = 0)
	public void performCalenderAction() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.get("https://www.cleartrip.com/");
		System.out.println("Url open");
		driver.findElement(By.xpath("(//a[@href='/hotels'])[2]")).click();
		WebElement pune= driver.findElement(By.xpath("//input[@placeholder='Enter Locality, Landmark, City or Hotel']"));
		Select slect=Select(pune);
		
		driver.findElement(By.xpath("(//i[@class='calendarIcon datePicker'])[1]")).click();
		Thread.sleep(10000);
		int calenderSize = driver
				.findElements(By.xpath("//td[@data-handler='selectDay' and @data-month='7' and @data-year='2019']"))
				.size();
		System.out.println(calenderSize);

	}

	private Select Select(WebElement pune) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test(priority = 1)
	public void clcikFirstCalender() throws InterruptedException {
		int calenderSize = driver
				.findElements(By.xpath("//td[@data-handler='selectDay' and @data-month='7' and @data-year='2019']"))
				.size();

		for (int i = 1; i <= calenderSize; i++) {
			WebElement element = driver.findElement(
					By.xpath("(//td[@data-handler='selectDay' and @data-month='7' and @data-year='2019'])[" + i + "]"));
			String alldate = element.getText();
			System.out.print(" " + alldate);
			if (alldate.equals(date)) {
				Thread.sleep(2000);
				element.click();
				break;
			}
		}
		System.out.println();
	}

	@Test(priority = 2)
	public void clickSecondCalender() throws InterruptedException {
		int calenderSize = driver.findElements(By.xpath("//td[@data-handler='selectDay' and @data-month='8' and @data-year='2019']")).size();

		try {
			for (int i = 1; i <= calenderSize; i++) {

				WebElement element = driver.findElement(By.xpath("(//td[@data-handler='selectDay' and @data-month='8' and @data-year='2019'])[" + i + "]"));
				String alldate = element.getText();
				System.out.print(" " + alldate);
				if (alldate.equals(date2)) {
					Thread.sleep(2000);

					element.click();
					break;
				}
			}
			System.out.println();
		} catch (StaleElementReferenceException e) {
			for (int i = 1; i <= calenderSize; i++) {

				WebElement element = driver.findElement(By.xpath("(//td[@data-handler='selectDay' and @data-month='8' and @data-year='2019'])[" + i + "]"));
				String alldate = element.getText();
				if (alldate.equals(date2)) {
					Thread.sleep(2000);

					element.click();
					break;
				}
			}
			System.out.println();

		}

		catch (Exception e) {
			for (int i = 1; i <= calenderSize; i++) {

				WebElement element = driver.findElement(By.xpath("(//td[@data-handler='selectDay' and @data-month='8' and @data-year='2019'])[" + i + "]"));
				String alldate = element.getText();
				System.out.print(" " + alldate);
				if (alldate.equals(date2)) {
					Thread.sleep(2000);

					element.click();
					break;
				}
			}
			System.out.println();

		}
	}
	
	@Test(priority=3)
	public void selectTraveler() {
		WebElement ele= driver.findElement(By.xpath("//select[@class='span span22']"));
		Select select=new Select(ele);
		select.selectByIndex(2);
		
		
	}
}
