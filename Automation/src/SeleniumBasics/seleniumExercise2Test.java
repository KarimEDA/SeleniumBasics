package SeleniumBasics;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumExercise2Test {
	
	static WebDriver driver = null;
	
	@BeforeClass
	public static void setup() {
	System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Browsers\\chromedriver.exe");
	driver = new ChromeDriver();
	}
	
	@Test
	public void testForm() {
		driver.get("https://formy-project.herokuapp.com/form");
		driver.findElement(By.id("first-name")).sendKeys("Karim Emiliano");
		driver.findElement(By.id("last-name")).sendKeys("Duran Ayala");
		driver.findElement(By.id("job-title")).sendKeys("Mechatronics Engineer");
		driver.findElement(By.id("radio-button-2")).click();
		driver.findElement(By.id("checkbox-1")).click();
		driver.findElement(By.id("select-menu")).click();
		driver.findElement(By.cssSelector("option[value='1']")).click();
		driver.findElement(By.id("datepicker")).sendKeys("01/07/2022");
	}
	
	@After
	public void testEnd() {
		driver.findElement(By.cssSelector("a[role='button']")).click();
	}
	
	@AfterClass
	public static void quiting() {
		driver.quit();
	}
}
