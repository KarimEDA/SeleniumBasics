package SeleniumBasics;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

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
public class seleniumExercise5Test {
	static WebDriver driver = null;
		private final String fname;
		private final String lname;
		private final String jTitle;
		private final String edu;
		private final String sex;
		private final String years;
		private final String date;
    
		public seleniumExercise5Test(String fname, String lname, String jTitle, String edu, String sex, String years, String date) {
			this.fname = fname;
			this.lname = lname;
			this.jTitle = jTitle;
			this.date = date;
			this.sex = sex;
			this.edu = edu;
			this.years = years;
		}
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/form");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void formTest() throws IOException {
		seleniumExercise5 formy = new seleniumExercise5();
		formy.fields(driver, fname, lname, jTitle);
		formy.radioButton(driver, edu);
		formy.checkBox(driver, sex, fname, lname);
		formy.dropDown(driver, years, fname, lname);
		formy.datePicker(driver, date, fname, lname);
		formy.button(driver);
		formy.alert(driver);
	}
	@After
	public void endTest() {
		driver.quit();
	}
	@Parameterized.Parameters
    public static Collection<Object[]> data() {
    	Xls_Reader xlsR = new Xls_Reader("C:\\Users\\karim\\OneDrive\\Documentos\\SeleniumTraining\\Automation\\src\\SeleniumBasics\\ID and Passwords.xlsx");
		String sheetName = "ID&P";
		int rowCount = xlsR.getRowCount(sheetName)-1;
        Object[][] credentials = new Object[rowCount][7];
        	for(int i=0;i<rowCount;i++) {
    			credentials[i][0]=xlsR.getCellData(sheetName, 0, i+2);
    			credentials[i][1]=xlsR.getCellData(sheetName, 1, i+2);
    			credentials[i][2]=xlsR.getCellData(sheetName, 2, i+2);
    			credentials[i][3]=xlsR.getCellData(sheetName, 3, i+2);
    			credentials[i][4]=xlsR.getCellData(sheetName, 4, i+2);
    			credentials[i][5]=xlsR.getCellData(sheetName, 5, i+2);
    			credentials[i][6]=xlsR.getCellData(sheetName, 6, i+2);
    		}
        return Arrays.asList(credentials);
        }
    }
