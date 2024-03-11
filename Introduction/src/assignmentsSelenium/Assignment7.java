package assignmentsSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int filadeseada = 2;
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,600)");
		int row = driver.findElements(By.xpath("(//table[@name='courses'])//tr")).size();
		int column = driver.findElements(By.xpath("(//table[@name='courses'])//tr[1]/th")).size();
		System.out.println(row);
		System.out.println(column);
		for(int i = 0; i<row  ;i++) {
			if(i==filadeseada) {
				String fila2 = driver.findElements(By.xpath("(//table[@name='courses'])//tr")).get(i).getText();
				System.out.println(fila2);	
				break;
			}
		}
	}
}
