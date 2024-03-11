package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObjectForm {
WebDriver driver;
	
	public pageObjectForm(WebDriver driver) {
		super();
		this.driver = driver;
	}
	 
	/*
	public pageObject(WebDriver driver) {
		this.driver = driver;
	}
	*/
	private By firstName = By.id("first-name");
	private By lastName = By.id("last-name");
	private By jobTitle = By.id("job-title");
	private By education = By.cssSelector("input[value='radio-button-1']");
	private By sex = By.xpath("//input[@value='checkbox-1']");
	private By yearsExp =  By.cssSelector("body div form div div select");
	private By yearsAns = By.xpath("//option[@value='1']");
	private By currDate = By.xpath("//input[@data-provide='datepicker']");
	private By submit = By.cssSelector("a[role='button']");

	public WebElement fillFirstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement fillLastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement fillJobTitle() {
		return driver.findElement(jobTitle);
	}
	
	public WebElement fillEducation() {
		return driver.findElement(education);
	}
	
	public WebElement fillSex() {
		return driver.findElement(sex);
	}
	
	public WebElement fillYearsExp() {
		return driver.findElement(yearsExp);
	}
	
	public WebElement fillYearsAns() {
		return driver.findElement(yearsAns);
	}
	
	public WebElement fillCurrDate() {
		return driver.findElement(currDate);
	}
	
	public WebElement fillSubmit() {
		return driver.findElement(submit);
	}
	
	  
	public void fillForm(String fName,String lName,String jTitle,String date) {
							
		//Write Selenium automation code using JAVA/SELENIUM to fill the form of using Page Object Model Class 
		

		//fill the first name 
		WebElement firstName = fillFirstName();
		firstName.sendKeys(fName);

		//fill the last name 
		WebElement lastName = fillLastName();
		lastName.sendKeys(lName);

		//fill the jobTitle
		WebElement jobTitle = fillJobTitle();
		jobTitle.sendKeys(jTitle);
		
		//fill the education option
		WebElement selecEducation= fillEducation();
		selecEducation.click();
		
//		//fill the sex option
//		WebElement selecSex= fillEducation();
//		selecSex.click();
//		
//		//fill the year option
//		WebElement selecYear= fillYearsExp();
//		selecYear.click();
//		
//		//fill the year answ option
//		WebElement selecYearAns= fillYearsAns();
//		selecYearAns.click();
		
		//fill the current dat option
		WebElement selecDate= fillCurrDate();
		selecDate.sendKeys(date + Keys.ENTER);
		
//		//click submit
//		WebElement selecSubmit= fillSubmit();
//		//selecSubmit.click();
		
	}
}
