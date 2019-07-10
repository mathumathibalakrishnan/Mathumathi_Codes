package mathu.motv.CW;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
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
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		try {
		  FileInputStream fis = new FileInputStream("/Users/mathumathibalakrishnan/git/repository/CW/testtry-3.xlsx");
		    XSSFWorkbook wb = new XSSFWorkbook(fis);
		    XSSFSheet sheet = wb.getSheet("Sheet1");
		    
		    for(int count = 1;count<=sheet.getLastRowNum();count++){
		        XSSFRow row = sheet.getRow(count);
		        System.out.println("Running test case " + row.getCell(0).toString());
		        runTest(row.getCell(0).toString(),row.getCell(1).toString(), row.getCell(2).toString());
		    }
		  
		    
		    fis.close();
		} catch (IOException e) {
		    System.out.println("Test data file not found");
		
	}
	}
	

	private static String runTest(String url, String uName, String pwd) throws Exception {
		 
		System.out.println(url);
		System.out.println(uName);
		System.out.println(pwd);
		  // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.get(url);
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//*[@class='login-button navigation-link']"));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		actions.click(element).perform();
		driver.findElement(By.xpath("//*[@class='input-box'][1]/input")).click();
		driver.findElement(By.xpath("//*[@class='input-box'][1]/input")).sendKeys(uName);
		driver.findElement(By.xpath("//*[@class='input-box'][2]/input")).click();
		driver.findElement(By.xpath("//*[@class='input-box'][2]/input")).sendKeys(pwd);
		driver.findElement(By.xpath("//div[@class='forgot-password-button fat']/preceding-sibling::input")).submit();
		Thread.sleep(2000);
		System.out.println("Logged in " + url);
		Thread.sleep(1000);
		return null;
		
		
	}

}
