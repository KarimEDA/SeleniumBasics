package assignmentsSelenium;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int index = 1;
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
//		System.out.println(driver.findElement(By.cssSelector("ins.adsbygoogle.adsbygoogle-noablate")).isDisplayed());
//		System.out.println(driver.findElements(By.tagName("iframe")).size());
//		while(driver.findElement(By.cssSelector("ins.adsbygoogle.adsbygoogle-noablate")).isDisplayed()) {
//			driver.switchTo().frame("aswift_0");
//			
//			driver.switchTo().defaultContent();
////			driver.findElement(By.cssSelector("ins#aswift_0")).click();
//		}
		WebElement scope1 = driver.findElement(By.id("checkbox-example"));
		System.out.println(scope1.findElements(By.tagName("label")).size());
		String option = getOption(scope1, index);
		WebElement opcion = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(opcion);
		dropdown.selectByValue(option);
		driver.findElement(By.id("name")).sendKeys(option);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("fieldset input#alertbtn")));
		driver.findElement(By.cssSelector("fieldset input#alertbtn")).click();
		String alertmsg = driver.switchTo().alert().getText().split(" ")[1].trim().split(",")[0];
		System.out.println(alertmsg);
		Assert.assertEquals(option,alertmsg);
		driver.switchTo().alert().accept();
	}

	public static String getOption(WebElement scope1, int index) {
		for (int i = 1; i < scope1.findElements(By.tagName("label")).size(); i++) {
			scope1.findElements(By.tagName("label")).get(i);
			if (i == index) {
				String option = scope1.findElements(By.tagName("label")).get(i).getText().toLowerCase();
				String opcioon = "input[value='" + option + "']";
//				System.out.println(option);
				scope1.findElement(By.cssSelector(opcioon)).click();
				return option;
			}
		}
		return null;
	}
}
