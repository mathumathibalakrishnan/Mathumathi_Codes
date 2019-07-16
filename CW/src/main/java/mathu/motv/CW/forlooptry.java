package mathu.motv.CW;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class forlooptry {
static WebDriver driver;

	public static void main(String[] args) throws Exception {
		try {
		    FileInputStream fis = new FileInputStream("/Users/mathumathibalakrishnan/git/repository/CW/TestDataSheet-10.xlsx");
		    XSSFWorkbook wb = new XSSFWorkbook(fis);
		    XSSFSheet sheet = wb.getSheet("Sheet1");
		    
		    for(int count = 5;count<=sheet.getLastRowNum();count++){
		        XSSFRow row = sheet.getRow(count);
		       // System.out.println("Running test case " + row.getCell(0).toString());
		        runTest(row.getCell(0).toString(),row.getCell(1).toString(), row.getCell(2).toString());
		    }
		    fis.close();
		} catch (IOException e3) {
		    System.out.println("Test data file not found");
		}  
 
}

	private static void runTest(String url, String uName, String pwd) {
		// TODO Auto-generated method stub
		System.out.println(url);
		System.out.println(uName);
		System.out.println(pwd);
		
	}
}

