package basicsSelenium;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//Xpath -> 	//tagname[@attribute='value']
//Para xpath se puede agregar index, dependiendo que valor requieras y cuantos haya igual -> //tagname[@attribute='value'][#index]
//tagname[@attribute='value'][1] -> SIN () SIBLINGS && CON () OTRO PARENT|| parent child -> //parenttagname/childtagname[index] || //tagname
//Para xpath tambien se pude utilizar -> //tagname[text()='value'] || //*[text()='value'] 
//*=All se puede utilizar en cualquier funcion con tagname || Para ir al parent /parent::tagname 
//Para cambiar de index puede ser igual con la linea /following-sibling::tagname[index]


//CSS SELECTOR -> CLASS = tagname.classname || ID = tagname#id || OTHERS = tagname[attribute='value'] // tagname
//Para CSSSELECTOR se puede hacer lo mismo del index como -> tagname[attribute='value']:nth-child(#index)
//	o parent child -> parenttagname childtagname[index]


//*= encuentra partial string incompletos cssSelector && xpath requiere todos los nombres de la clase -> contains //tagname[contains(@attribute,'value')]
public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("karimduran99@gmail.com");
		driver.findElement(By.className("_9npi")).sendKeys("elmorrillo_2");
		driver.findElement(By.name("login")).click();
		System.out.println(driver.findElement(By.cssSelector("div._9ay7")).getText());
		driver.findElement(By.linkText("Forgot Password?")).click();
		driver.findElement(By.xpath("//input[@id='send_email']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[dir='ltr']:nth-child(1)")).sendKeys("karimduran99@gmail.com");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("elmorrillo_1");
		driver.findElement(By.xpath("//div[contains(@aria-label,'Acces')]")).click();
//		driver.findElement(By.cssSelector("div[aria-label*='Acc']")).click();
		}

}
