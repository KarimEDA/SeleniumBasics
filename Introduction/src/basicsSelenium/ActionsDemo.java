package basicsSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Actions action = new Actions(driver);
		WebElement searchtab = driver.findElement(By.id("twotabsearchtextbox"));
		WebElement cuenta = driver.findElement(By.id("nav-link-accountList"));
		action.moveToElement(searchtab).click().keyDown(Keys.SHIFT).sendKeys("hola").doubleClick().build().perform();
		action.moveToElement(cuenta).contextClick().build().perform();
	}

}
