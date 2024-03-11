package SeleniumBasics;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class search {
	public static void Search(WebDriver driver) {
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("key");
		WebElement object = driver.findElement(By.xpath("//span[contains(text(),'stand')]"));
		object.click();
	}
}
//driver.findElement(By.id("radio-button-2"));
//driver.findElement(By.id("checkbox-1"));
//driver.findElement(By.id("select-menu"));
//driver.findElement(By.xpath("//option[@value='1']"));
//driver.findElement(By.id("datepicker"));
//driver.findElement(By.xpath("//a[contains(text(),'Submit')]"));
