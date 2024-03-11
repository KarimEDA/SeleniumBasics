package SeleniumBasics;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumExercise4 {
	public void editableField(WebDriver driver) {
		driver.findElement(By.id("first-name")).sendKeys("Karim Emiliano");
		driver.findElement(By.id("last-name")).sendKeys("Duran Ayala");
		driver.findElement(By.id("job-title")).sendKeys("Mechatronics Engineer");
	}
	public int num;
	public void radioButton(WebDriver driver, String edu) {
		if (edu.equalsIgnoreCase("College")) {
			num = 2;
		} else if (edu.equalsIgnoreCase("High")) {
			num = 1;
		} else if (edu.equalsIgnoreCase("Grad")) {
			num = 3;
		}
		String path = "radio-button-" + num;
		driver.findElement(By.id(path)).click();
	}
	public void checkBox(WebDriver driver, String sex) {
		if (sex.equalsIgnoreCase("Female")) {
			num = 2;
		} else if (sex.equalsIgnoreCase("Male")) {
			num = 1;
		} else if (sex.equalsIgnoreCase("Prefer")) {
			num = 3;
		}
		String path = "checkbox-" + num;
		driver.findElement(By.id(path)).click();
	}
	public void dropDown(WebDriver driver, WebDriverWait w, int years) {
		driver.findElement(By.id("select-menu")).click();
		if(years <= 1) {
			num = 1;
		}
		else if(years > 1 && years < 5) {
			num = 2;
		}
		else if(years > 4 && years < 10) {
			num = 3;
		}
		else if(years >= 10) {
			num = 4;
		}
		String path = "//option[@value='" + num + "']";
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
		driver.findElement(By.xpath(path)).click();
	}
	public void datePicker(WebDriver driver, WebDriverWait w, String date) {
		driver.findElement(By.id("datepicker")).sendKeys(date);
	}
	public void button(WebDriver driver) {
		driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();
	}
	public void alert(WebDriver driver, WebDriverWait w) {
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		String actual = driver.findElement(By.xpath("//div[@role='alert']")).getText().strip();
		String expected = "The form was successfully submitted!";
		Assert.assertEquals(expected, actual);
	}
}
