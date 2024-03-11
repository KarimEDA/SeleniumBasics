package SeleniumBasics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

public class SL_TestCases {
	public void login(WebDriver driver, String username, String pwd, String test, Logger logger)
			throws InterruptedException, IOException {
		StopWatch pageLoad = new StopWatch();
		pageLoad.start();
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		String acturl = driver.getCurrentUrl();
		pageLoad.stop();
		long pageLoadTime = pageLoad.getTime();
		String expurl = "https://www.saucedemo.com/inventory.html";
		if (expurl.equals(acturl)) {
			logger.info("LOGIN Completed");
			String img = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']")).getAttribute("src");
			if (img.equals("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg")) {
				logger.error("***Product image problem found in test #" + test + ". Problem review needed.***");
				screenShot(driver, test);
			}
			if (pageLoadTime > 300) {
				logger.error("***Performance failure in test #" + test + ". Problem review needed.***");
			}
		} else {
			WebElement errorObj = driver.findElement(By.xpath("//h3[@data-test='error']"));
			screenShot(errorObj, test);
			String error = errorObj.getText();
			if (error.equals("Epic sadface: Sorry, this user has been locked out.")) {
				logger.info("LOGIN Failed - User Locked Out");
			} else if (error.equals("Epic sadface: Username and password do not match any user in this service")) {
				logger.info("LOGIN Failed - Wrong Credentials");
			} else if (error.equals("Epic sadface: Username is required")) {
				logger.info("LOGIN Failed - Username is missing");
			} else if (error.equals("Epic sadface: Password is required")) {
				logger.info("LOGIN Failed - Password is missing");
			}
		}
	}
	
	public void login(WebDriver driver, String username, String pwd) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
	}

	@SuppressWarnings("deprecation")
	public void inventory(WebDriver driver, String sorting) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String sort1 = "Name (A to Z)"; String sort2 = "Name (Z to A)"; String sort3 = "Price (low to high)"; String sort4 = "Price (high to low)";
		WebElement sortContainer = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select sortOption = new Select(sortContainer);
		sortOption.selectByVisibleText(sorting);
		if (sorting.equals(sort1) || sorting.equals(sort2)) {
			List<WebElement> beforeSort = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
			List<String> beforeProductSortList = new ArrayList<>();
			for (WebElement p : beforeSort) {
				beforeProductSortList.add(String.valueOf(p.getText()));
			}
			List<WebElement> afterSort = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
			List<String> afterProductSortList = new ArrayList<>();
			for (WebElement p : afterSort) {
				afterProductSortList.add(String.valueOf(p.getText()));
			}
			if (sorting.equals(sort1)) {
				Collections.sort(beforeProductSortList);
				Assert.assertEquals(beforeProductSortList, afterProductSortList);
				
			} else if (sorting.equals(sort2)) {
				Collections.sort(beforeProductSortList, Collections.reverseOrder());
				Assert.assertEquals(beforeProductSortList, afterProductSortList);
			}
		}
		else if (sorting.equals(sort3) || sorting.equals(sort4)) {
			List<WebElement> beforeSort = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
			List<Double> beforeProductSortList = new ArrayList<>();
			for (WebElement p : beforeSort) {
				beforeProductSortList.add(Double.valueOf(p.getText().replace("$","")));
			}
			List<WebElement> afterSort = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
			List<Double> afterProductSortList = new ArrayList<>();
			for (WebElement p : afterSort) {
				afterProductSortList.add(Double.valueOf(p.getText().replace("$","")));
			}
			if (sorting.equals(sort3)) {
				Collections.sort(beforeProductSortList);
				Assert.assertEquals(beforeProductSortList, afterProductSortList);
			} else if (sorting.equals(sort4)) {
				Collections.sort(beforeProductSortList, Collections.reverseOrder());
				Assert.assertEquals(beforeProductSortList, afterProductSortList);
			}
		}
	}
	
	public void addItem(WebDriver driver, List<String> products) {
		for(String p : products) {
			if(p!=null && !p.equals("")) {
				String item = "//div[text()='" + p + "']/ancestor::div[@class='inventory_item_label']/following-sibling::div//button";
				driver.findElement(By.xpath(item)).click();
			}
		}
	}
	
	public void checkout(WebDriver driver, List<String> products) {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Karim");
		driver.findElement(By.id("last-name")).sendKeys("Duran");
		driver.findElement(By.id("postal-code")).sendKeys("82120");
		driver.findElement(By.id("continue")).click();
		List<WebElement> totalItems = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		List<String> itemName = new ArrayList<>();
		for(WebElement p : totalItems) {
			itemName.add(String.valueOf(p.getText()));
		}
		Assert.assertEquals(products, itemName);
	}
	
	public void totalCount(WebDriver driver) {
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		Double totalExp = 0.00;
		for(WebElement p : prices) {
			Double totalPrice = Double.valueOf(p.getText().replace("$", ""));
			totalExp = totalExp+totalPrice;
		}
		Double totalAct = Double.valueOf(driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText().substring(13));
		Assert.assertEquals(totalExp, totalAct);
	}
	
	public void checkoutFinish(WebDriver driver) {
		driver.findElement(By.id("finish")).click();
		String finish = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
		Assert.assertEquals(finish, "THANK YOU FOR YOUR ORDER");
	}
	
	public void screenShot(WebDriver driver, String test) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("Bug reported in test #" + test + ".png"));
	}
	
	public void screenShot(WebElement errorObj, String test) throws IOException {
		File elementSs = errorObj.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(elementSs, new File("Error message - TestCase #" + test + ".png"));
	}
}