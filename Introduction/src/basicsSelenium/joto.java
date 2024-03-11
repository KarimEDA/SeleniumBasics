package basicsSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class joto {

 
	@Test
	  public void LaunchBrowser() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("PhantomJS Headless Driver launched");
    // Write your script here
    driver.get("https://www.google.com/");
    Thread.sleep(5000);
    System.out.println("Launch Browser is successful");
    System.out.println("Page Title: " + driver.getTitle());
		//Searching for "Fresco Play" in Google search	
		driver.findElement(By.xpath("//div[@class='SDkEP']//input")).sendKeys("Fresco Play");
		driver.findElement(By.xpath("//div[@class='SDkEP']//input")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		System.out.println("Page Title : " + driver.getTitle());		
	}
}

//package launchBrowserTestNG;
//import org.testng.annotations.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//public class LaunchBrowser_TestNG {
//	@Test
//	  public void LaunchBrowser() throws InterruptedException{
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setJavascriptEnabled(true); 
//		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/projects/challenge/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
//		WebDriver driver = new PhantomJSDriver(caps);
//		System.out.println("PhantomJS Headless Driver launched");
//		// Write your script here
//    driver.get("http://google.com");
//		Thread.sleep(5000);
//    System.out.println("Launcher Browser is successful ");
//    System.out.println("Page Title : " + driver.getTitle());
//		//Searching for "Fresco Play" in Google search
//		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Fresco Play");
//		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
//		Thread.sleep(5000);
//		System.out.println("Page Title : " + driver.getTitle());	
//	}
//}



//package crossBrowsers;
//
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.testng.annotations.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//import io.github.bonigarcia.wdm.ChromeDriverManager;
//
//public class googleLaunch {
//
//    public WebDriver driver;
//    
//    @BeforeTest
//    
//    @Parameters("browser")
//    public void SelectBrowser(String browser)
//    {
//    
//        // Write your script here  
//        if(browser.equalsIgnoreCase("ChromeHeadless")){
//          ChromeDriverManager.chromedriver().setup();
//          ChromeOptions chromeOptions = new ChromeOptions();
//          chromeOptions.addArguments("--headless");
//          driver = new ChromeDriver(chromeOptions);
//          System.out.println("Chrome Headless Driver launched");
//        }
//        else if (browser.equalsIgnoreCase("PhantomJS")){
//          DesiredCapabilities caps = new DesiredCapabilities();
//          caps.setJavascriptEnabled(true);
//          caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/projects/challenge/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
//          driver = new PhantomJSDriver(caps);
//          System.out.println("PhantomJS Headless Driver launched");
//        }
//        driver.manage().window().maximize();
//        driver.get("https://www.google.com");
//    }
//    @Test
//    public void GoogleSreach() throws InterruptedException{ 
//        // Searching for "Fresco Play" in Google search.
//        // Find the elementlocators for the below actions.
//        // 1) Find locator for Google Search Box and sendkeys as Fresco Play as below.
//        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Fresco Play");
//        
//        // 2) Find locator for Google Search Box and sendkeys as Enter  as below.
//        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
//        Thread.sleep(6000);
//        System.out.println("Page Title : " + driver.getTitle()); 
//    }
//    @AfterTest
//    public void BroswerQuit(){
//        driver.quit();
//    }    
//}