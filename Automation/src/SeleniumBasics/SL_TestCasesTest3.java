package SeleniumBasics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;
@RunWith(Parameterized.class)
public class SL_TestCasesTest3 {
	private static Logger logger = LogManager.getLogger(SL_TestCasesTest.class);
	static WebDriver driver = null;
	static SL_TestCases product = new SL_TestCases();
	private final String p1; private final String p2; private final String p3; private final String p4; private final String p5; private final String p6;
	private final String username;
	private final String pwd;
	private final String test;
	public SL_TestCasesTest3(String test, String p1, String p2, String p3, String p4, String p5, String p6, String username, String pwd) {
		this.p1 = p1; this.p2 = p2; this.p3 = p3; this.p4 = p4; this.p5 = p5; this.p6 = p6;
		this.test = test;
		this.username = username;
		this.pwd = pwd;
	}
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test
	public void checkoutTest() {
		List<String> products = new ArrayList<>();
		products.add(p1); products.add(p2); products.add(p3); products.add(p4); products.add(p5); products.add(p6);
		products.removeAll(Collections.singleton(""));
		product.login(driver, username, pwd);
		product.addItem(driver, products);
		product.checkout(driver, products);
		logger.info("Products selected and added to the cart are the same - Success");
		product.totalCount(driver);
		logger.info("Price calculated and actual are the same - Success");
		product.checkoutFinish(driver);
		logger.info("Checkout completed");
		logger.info("Successful test #" + test);
	}
	
	@After
	public void endTest() {
		driver.quit();
	}
	@Parameterized.Parameters
    public static Collection<Object[]> data() {
    	Xls_Reader xlsR = new Xls_Reader("C:\\Users\\karim\\OneDrive\\Desktop\\TATA CURSOS\\Assignments Herbalife\\SLTestReport.xlsx");
		String sheetName = "ID&PASSWORD";
		int rowCount = xlsR.getRowCount(sheetName)-6;
        Object[][] credentials = new Object[rowCount][9];
        	for(int i=0;i<rowCount;i++) {
        		credentials[i][0]=xlsR.getCellData(sheetName, 7, i+2);
        		credentials[i][1]=xlsR.getCellData(sheetName, 8, i+2);
    			credentials[i][2]=xlsR.getCellData(sheetName, 9, i+2);	
    			credentials[i][3]=xlsR.getCellData(sheetName, 10, i+2);
    			credentials[i][4]=xlsR.getCellData(sheetName, 11, i+2);
        		credentials[i][5]=xlsR.getCellData(sheetName, 12, i+2);
        		credentials[i][6]=xlsR.getCellData(sheetName, 13, i+2);
        		credentials[i][7]=xlsR.getCellData(sheetName, 1, 2);
        		credentials[i][8]=xlsR.getCellData(sheetName, 2, 2);
    		}
        return Arrays.asList(credentials);
    }
}
