package SeleniumBasics;
import java.time.Duration;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumExercise4Test {
	
	static WebDriver driver = null;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Browsers\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	}

	@Test
	public void testForm() {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://formy-project.herokuapp.com/form");
		seleniumExercise4 form = new seleniumExercise4();
		form.editableField(driver);
		form.radioButton(driver, "college");
		form.checkBox(driver, "male");
		form.dropDown(driver, w, 1);
		form.datePicker(driver, w, "12/09/1999");
		form.button(driver);
		form.alert(driver,w);
	}
	
	@AfterClass
	public static void endTest() {
		driver.quit();
	}
}
