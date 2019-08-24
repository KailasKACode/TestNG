package keyword;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * Project name: Test automation Framework
 * Author : Pankaj Devgade
 * Client: Shashank
 * Organisation: testing Shastra
 * 
 */

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keyword {
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties prop;
	public static WebElement element;
	public static Actions takeaction;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static FileReader files;
	public static BufferedReader brd;
	public static Robot bot;
	public static Dimension dia;



	static String DateAndTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());

	/**
	 * Its open specified browser.
	 * 
	 * @param BrowserName : Browsers should be include the 'chrome', firefox and IE.
	 *                    No browsers will accept apart listed above
	 * @return static void
	 */
	public static void selectAndOpenBrowser(String BrowserName) {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--disable-notifications");

		switch (BrowserName) {
		case "chrome":
			// System.setProperty("webdriver.chrome.driver", "E:\\Newjava\\TestNGDemo\\chromedriver.exe");
			driver = new ChromeDriver(option);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
		default:
			System.err.println("Invalid browsers:");
			break;
		}

	}

	/**
	 * Its open the specified Url recently opened browser by Driver instance
	 * 
	 * @param Url({@code String}) to open
	 * @return static void
	 */
	public static void enterUrl(String Url) {
		driver.get(Url);
		System.out.println("Please wait loading url....");

	}

	/**
	 * Delete all cookies from the open browser:
	 * 
	 * @return: static void
	 */
	public static void deleteAllCookies() {
		driver.manage().deleteAllCookies();
		System.out.println("Cookies are deleted: ");
	}

	/**
	 * It will Maximize the screen automatically when call the function.
	 */
	public static void maxiMizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * Needs to enter the :
	 * XPATH,ID,CLASS_NAME,LINK_TEXT,CLASS_NAME,PARTIAL_LINK_TEXT
	 * 
	 * @param locatorType  ({@code })
	 * @param locatorValue
	 * @return
	 */
	private static WebElement getWebElement(String locatorType, String locatorValue) {
		switch (locatorType) {
		case "XPATH":
			element = driver.findElement(By.xpath(locatorValue));
			break;
		case "CSS":
			element = driver.findElement(By.cssSelector(locatorValue));
			break;
		case "ID":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "LINK_TEXT":
			element = driver.findElement(By.linkText(locatorValue));
			break;
		case "PARTIAL_LINK_TEXT":
			element = driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "CLASS_NAME":
			element = driver.findElement(By.className(locatorValue));
			break;

		default:
			System.err.println("Invalid Selector: " + locatorType
					+ "Expected: XPATH,ID,CLASS_NAME,LINK_TEXT,CLASS_NAME,PARTIAL_LINK_TEXT ");
			break;
		}
		return element;

	}

	/**
	 * 
	 * @param LocatorType :It should be accept the listed locatorType.
	 * @param             locatorValue: It is the Xpath or the Locator value should
	 *                    be listed
	 * @param             textToEnter: Which type the data should be enter in the
	 *                    string format.
	 */
	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	/**
	 * It will be click on the entered the given web-elements.
	 * 
	 * @param LocatorType:This will locator
	 * @param locatorValue: pass the value which element need to click
	 * @return static void
	 */
	public static void clickOnElements(String locatorValue, String locatorType) {
		getWebElement(locatorValue, locatorType).click();

	}

	public static void selectFromDropDownList(String locatorType, String locatorValue, String textToEnter) {
		WebElement elemets = getWebElement(locatorValue, locatorType);
		Select select = new Select(elemets);
		select.selectByVisibleText(textToEnter);

	}

	/**
	 * It will be double-click on the perticular WebElement
	 * 
	 * @param LocatorType
	 * @param locatorValue
	 */
	public static void doubleClick(String locatorType, String locatorValue) {
		Actions action = new Actions(driver);
		WebElement elements = getWebElement(locatorType, locatorValue);
		action.doubleClick(elements);
		action.build().perform();

	}

	/**
	 * It will switch the new frame Need to enter the frame index value starting @0
	 * Position
	 * 
	 * @param i
	 */
	public static void doIFrameSwitch(int i) {
		driver.switchTo().frame(i);
		System.out.println("Switched on frame: " + i);
	}

	/***
	 * It will switch the default frame.(Original fram).
	 * 
	 * @return static void
	 */
	public static void doDefultIFrame() {
		driver.switchTo().defaultContent();
	}

	public static void takeCurrentPageScreenShot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File des = new File("E:\\Newjava\\Hybrid FrameWork\\Screenshot\\Img" + DateAndTime + ".png");
		FileUtils.copyFile(src, des);
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			System.err.println("File not found");
		}

	}

	/**
	 * It will close the open Window
	 */
	public static void closeBrowser() {
		driver.close();
	}

	/**
	 * It will close all related browsers are opened
	 */
	public static void quitAllBrowsers() {
		driver.quit();

	}

	public static void takeScreenshotOfElement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue);
		Point point = element.getLocation();
		int ht = element.getSize().getHeight();
		int wt = element.getSize().getWidth();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			BufferedImage fullimage = ImageIO.read(src);
			BufferedImage logo = fullimage.getSubimage(point.getX(), point.getY(), wt, ht);
			ImageIO.write(logo, "png", src);
			FileUtils.copyFile(src, new File("E:\\Newjava\\Hybrid FrameWork\\Screenshot\\Img" + DateAndTime + ".png"));

		} catch (IOException e) {
			System.out.println("File Not found: ");
		}

	}

	/**
	 * It will take full page screenshot top-bottom
	 * 
	 */
	public static void takefullpageScreenshot() {
		AShot shot = new AShot();
		shot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		Screenshot sc = shot.takeScreenshot(driver);
		try {
			ImageIO.write(sc.getImage(), "png",
					new File("E:\\Newjava\\Hybrid FrameWork\\Screenshot\\Img" + DateAndTime + ".png"));
		} catch (IOException e) {

			System.out.println("File not found: ");
		}

	}

	/**
	 * It is also like xpath but it will never fail to do Operation
	 * 
	 * @param jcommand
	 */
	public static void usingJScriptsOperation(String jcommand) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript(jcommand);

	}

	/**
	 * Incomplete method need to improve
	 * 
	 * @param locatorType
	 * @param locatorValue
	 */
	public static void dragAndDrop(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue);
		new Actions(driver);
		takeaction.moveToElement(element);
		takeaction.build().perform();

	}

	/**
	 * 
	 * It will refresh the page
	 */
	public static void refreshPage() {
		driver.navigate().refresh();
	}

	/**
	 * 
	 * It should will show the title of the current open webpage
	 */
	public static void getTitle() {
		System.out.println(driver.getTitle());
		
	}

	/**
	 * It will be mouse-hoer to the particular {@link WebElement}
	 * 
	 * @throws InterruptedException
	 */
	public static Actions getAction()  {
		Actions a = new Actions(driver);
		return a;
	

	}

	/**
	 * This method will be select the the Text box entering the text & it will hit
	 * the enter button also
	 * 
	 * @param locatorType  it should be XPATH,CSS selector etc
	 * @param locatorValue it will contains x-path value
	 * @param EnterText    which type of text you want to enter
	 */
	public static void enterTextHitEnter(String locatorType, String locatorValue, String EnterText) {
		try {
			bot = new Robot();
			getWebElement(locatorType, locatorValue).sendKeys(EnterText);
			bot.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			System.out.println("Webelemenst Not found in robot");
		}

	}

	/**
	 * It will navigate the forward direction
	 */
	public static void navigate_Forward() {
		driver.navigate().forward();
	}

	/**
	 * It will navigate the backword direction
	 */
	public static void navigate_Backward() {
		driver.navigate().forward();
	}

	/**
	 * If find the any acceptAlert alert it will click Alert OK.
	 */
	public static void acceptAlert() {
		Alert alt = driver.switchTo().alert();
		alt.accept();

	}

	/**
	 * If find the any dissmissAlert alert it will click Alert OK.
	 */
	public static void dissmissAlert() {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	public static void clearText(String locatorType,String locatorValue) {
	 getWebElement(locatorType, locatorValue).clear();
	}
	
	/**
	 * It Set the size of the window size as per user Requires 
	 * 
	 * @param hight
	 * @param width
	 */
	public static void setScreenDimesion(int hight,int width) {
		dia=new Dimension(hight, width);
		driver.manage().window().setSize(dia);
	}
	
	public static void handleBroserNotification() {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--disable-notifications");

		
	}
}
