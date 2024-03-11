package SeleniumBasics;

import com.excel.lib.util.Xls_Reader;

public class xd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xls_Reader xlsR = new Xls_Reader("C:\\Users\\karim\\OneDrive\\Documentos\\SeleniumTraining\\Automation\\src\\SeleniumBasics\\ID and Passwords.xlsx");
		String sheetName = "ID&P";
		String data = xlsR.getCellData(sheetName, 0, 1);
		System.out.println(data);
	}

}
