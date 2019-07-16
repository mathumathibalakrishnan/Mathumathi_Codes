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
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class forlooptry {
static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		try {
		    FileInputStream fis = new FileInputStream("/Users/mathumathibalakrishnan/git/repository/CW/TestDataSheet-10.xlsx");
		    XSSFWorkbook wb = new XSSFWorkbook(fis);
		    XSSFSheet sheet = wb.getSheet("Sheet1");
		    
		    for(int count = 7;count<=sheet.getLastRowNum();count++){
		        XSSFRow row = sheet.getRow(count);
		       // System.out.println("Running test case " + row.getCell(0).toString());
		        runTest(row.getCell(0).toString(),row.getCell(1).toString(), row.getCell(2).toString());
		    }
		    fis.close();
		} catch (IOException e3) {
		    System.out.println("Test data file not found");
		}   
		}
		
		public static void runTest(String url, String uName, String pwd) throws Exception {
		//	driver.navigate().to(url);
		//	driver.switchTo().alert().sendKeys("glory");
			driver.get("https://glory:gloryapp@videos.glorykickboxing.com/");
			
			
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
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='logo-container']")).isDisplayed(), "User logged in" +url);
			System.out.println("Logged in " + url);
			System.out.println(driver.getTitle());
			Thread.sleep(1000);
		}
			catch (Exception e) {
				e.getMessage();
			}
 
}

	
}

