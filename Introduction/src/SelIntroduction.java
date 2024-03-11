import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Browser = Chrome - ChromeDriver // Firefox - FirefoxDriver // Safari - SafariDriver
		//webdriver.chrome.driver -> location path ChromeDriver
		//webdriver.gecko.driver -> location path FirefoxDriver
		//webdriver.edge.driver -> location path EdgeDriver
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\Browsers\\geckodriver.exe");
		WebDriver driver1 = new FirefoxDriver();
		System.setProperty("webdriver.edge.driver", "D:\\Drivers\\Browsers\\msedgedriver.exe");
		WebDriver driver2 = new EdgeDriver();
		driver.get("https://www.facebook.com");
		driver2.get("https://www.facebook.com");
		driver1.get("https://www.facebook.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.close();
	}
}
