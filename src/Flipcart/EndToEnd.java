package Flipcart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EndToEnd {
	WebDriver driver;
	SearchContext fire;
	@Test(priority = 0)
	public void openUrl() {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
	}

	// using by parameter0
	@Parameters({ "user", "pass" })
	@Test(priority = 1,  enabled= false)
	public void loginFirst(String user, String pass) {
		driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();

	}

	// using dataprovider
	@Test(priority = 1, dataProvider = "xlsx")
	public void loginByData(String user, String pass) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();

	}

	@DataProvider(name = "getData")
	public Object[][] dataGet() {
		Object[][] value = { { "9767732728", "kai$1234" } };

		return value;

	}

	// Using XLSX data
	@DataProvider(name="xlsx")
		public Object[][] getDataFromXl() throws IOException {
			FileInputStream fis=new FileInputStream("C:\\Users\\Kailas\\Desktop\\XXF.xlsx");
			XSSFWorkbook book=new XSSFWorkbook(fis);
			XSSFSheet sheet=book.getSheet("Sheet1");
			int row=sheet.getLastRowNum()+1;
			int col = sheet.getRow(0).getLastCellNum();
			Object [][] obj = new Object[row][col];
			for (int i = 0; i <row; i++) {
				XSSFRow _row = sheet.getRow(i);
				for (int j = 0; j <=col; j++) {
					XSSFCell cell = _row.getCell(j);
					if (cell.getCellType()==cell.getCellType().STRING) {
						System.out.println(obj[i][j]=_row.getCell(j).getStringCellValue());
					}
					else if (cell.getCellType()==cell.getCellType().NUMERIC) {
						System.out.println(obj[i][j]=_row.getCell(j).getNumericCellValue());
						
					}
				}
				
			}
			return obj;

	}

	@Test(priority = 1, enabled = false)
	public void clickCancel() {
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
	}

	@Test(priority = 2)
	public void SearchProduct() {

		WebElement serach = driver.findElement(By.xpath("//input[@class='LM6RPg']"));
		while(true) {
		try {
			serach.sendKeys("Oppo");
			serach.sendKeys(Keys.ENTER);
			break;

		} catch (Exception e) {
			serach.sendKeys("Oppo");
			serach.sendKeys(Keys.ENTER);
		}
		}

	}

	@Test(priority = 3)
	public void getAllPhonePriceWithAvg() throws InterruptedException {
		Thread.sleep(4000);
		int sizeof = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']")).size();
		System.out.println(sizeof);
		int sum = 0;
		for (int i = 1; i <= sizeof; i++) {
			String price = driver.findElement(By.xpath("(//div[@class='_1vC4OE _2rQ-NK'])[" + i + "]")).getText();
			System.out.println(price.replaceAll("[\\D]", ""));
			sum += Integer.parseInt(price.replaceAll("[\\D]", ""));

		}
		System.out.println("Sum= " + sum);

		System.out.println("Avergaes: " + sum / sizeof);
	}

	@Test(priority = 4)
	public void byPrduct() throws InterruptedException {
		driver.findElement(By.xpath("//div[contains(text(),'OPPO A3s (Red, 16 GB)')]")).click();
		String parent = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		Thread.sleep(7000);
		for (String child : allwindow) {
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				driver.findElement(By.xpath("//li[@class='col col-6-12']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='_2AkmmA iwYpF9 _7UHT_c']")).click();

			}
		}
	}

	@Test(priority = 5)
	public void purchseProduct() {
		WebElement el = driver.findElement(By.xpath("//div[@class='_39M2dM _2ZvOfP']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(el));
		el.sendKeys("9767732728");
		driver.findElement(By.xpath("//button[@class='_2AkmmA _1poQZq _7UHT_c']")).click();
	}

}
