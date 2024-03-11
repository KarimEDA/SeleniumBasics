package assignmentsSelenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "D:\\Drivers\\Browsers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.cleartrip.com/");
		WebElement adults = driver.findElement(By.cssSelector("div[class='mb-4'] select[class='bc-neutral-100 bg-transparent']"));
		Select dropdown = new Select(adults);
		dropdown.selectByIndex(2);
		WebElement children = driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[2]"));
		Select dropdown2 = new Select(children);
		dropdown2.selectByVisibleText("3");
		WebElement infants = driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[3]"));
		Select dropdown3 = new Select(infants);
		dropdown3.selectByValue("1");
		driver.findElement(By.cssSelector("button[class='flex flex-middle flex-between t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900']")).click();
		driver.findElement(By.cssSelector("div[aria-label='Tue Dec 07 2021']")).click();
		driver.findElement(By.linkText("More options: Class of travel, Airline preference")).click();
		driver.findElement(By.cssSelector("input[placeholder='Airline name']")).sendKeys("Volaris");
		driver.findElement(By.xpath("//button[normalize-space()='Search flights']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@class='to-ellipsis o-hidden ws-nowrap fs-3 c-white']")).getText());
	}
}
