package SeleniumBasics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class seleniumExercise5 {
	public void fields(WebDriver driver, String fname, String lname, String jTitle) {
		driver.findElement(By.id("first-name")).sendKeys(fname);
		driver.findElement(By.id("last-name")).sendKeys(lname);
		driver.findElement(By.id("job-title")).sendKeys(jTitle);
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
	public void checkBox(WebDriver driver, String sex, String fname, String lname) throws IOException {
		if (sex.equalsIgnoreCase("Female")) {
			num = 2;
		} else if (sex.equalsIgnoreCase("Male")) {
			num = 1;
		} else if (sex.equalsIgnoreCase("Prefer")) {
			num = 3;
		}
		String path = "checkbox-" + num;
		driver.findElement(By.id(path)).click();
		WebElement ssObj = driver.findElement(By.xpath("//div[5]"));
		File elementss = ssObj.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(elementss, new File("Sex-"+ fname + "-" +lname+".png"));
	}
	public void dropDown(WebDriver driver, String year, String fname, String lname) throws IOException {
		int years = Integer.parseInt(year);
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
		WebElement exp = driver.findElement(By.xpath(path));
		exp.click();
		WebElement ssObj = driver.findElement(By.xpath("//div[6]"));
		File elementss = ssObj.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(elementss, new File("Experience-"+ fname + "-" +lname+".png"));
	}
	public void datePicker(WebDriver driver, String date, String fname, String lname) throws IOException {
		WebElement calendar = driver.findElement(By.id("datepicker"));
		calendar.sendKeys(date);
		calendar.sendKeys(Keys.ENTER);
		WebElement ssObj = driver.findElement(By.xpath("//div[@class='col-sm-4']"));
		File elementss = ssObj.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(elementss, new File("Date-"+ fname + "-" +lname+".png"));
	}
	public void button(WebDriver driver) {
		driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();
	}
	public void alert(WebDriver driver) {
		String actual = driver.findElement(By.xpath("//div[@role='alert']")).getText().strip();
		String expected = "The form was successfully submitted!";
		Assert.assertEquals(expected, actual);
		if(expected.equals(actual)) {
			System.out.println("Good job!");
		}
	}

}
