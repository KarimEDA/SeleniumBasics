package assignmentsSelenium;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		List <WebElement> countries = driver.findElements(By.cssSelector("#ui-id-1 li"));
		for(WebElement option:countries) {
			if(option.getText().equals("India")){
				option.click();
				System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
			}
		}
	}
}
