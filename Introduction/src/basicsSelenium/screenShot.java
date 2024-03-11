package basicsSelenium;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Date day = new Date();
		String screenshotfilename = day.toString().replace(":", "-").replace(" ", "-");
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Browsers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement element = driver.findElement(By.className("logoClass"));
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotfilename+".png"));
		File elementss = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(elementss, new File("logo.png"));
		driver.quit();
	}

}
