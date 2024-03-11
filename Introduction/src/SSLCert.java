import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SSLCert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SSl certificates
		//Desired capabilities=
		//general chrome profile
		//ch.acceptInsecureCerts();
		//Belows to your local browser
		ChromeOptions c = new ChromeOptions();
		c.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		c.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		c.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);
	}

}