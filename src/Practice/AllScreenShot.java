package Practice;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AllScreenShot {
	public static void usingRobot() throws HeadlessException, AWTException, IOException {
		BufferedImage img = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(img, "png", new File("C:\\Users\\Kailas\\Desktop\\Screenshot\\robot" + datefromate() + ".png"));
		System.out.println("Screenshot saved");
	}

	public static void usingAshotFullPage() throws IOException {
		AShot shot = new AShot();
		shot.shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
		Screenshot sc = shot.takeScreenshot(driver);
		ImageIO.write(sc.getImage(), "PNG",
				new File("C:\\Users\\Kailas\\Desktop\\Screenshot\\Ashot" + datefromate() + ".png"));

	}

	public static void usingSeleniumScreenshot() throws IOException {
		File fis = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fis, new File("C:\\Users\\Kailas\\Desktop\\Screenshot\\Selenium" + datefromate() + ".png"));
	}

	public static WebDriver driver;

	public static String datefromate() {
		String DateAndTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		return DateAndTime;

	}

	public static void main(String[] args) throws HeadlessException, AWTException, IOException {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		usingRobot();
		usingAshotFullPage();
		usingSeleniumScreenshot();

	}

}
