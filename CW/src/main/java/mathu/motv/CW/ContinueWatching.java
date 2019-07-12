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

public class ContinueWatching {

static WebDriver driver;
public static void main(String[] args) throws Exception {
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
try {
    FileInputStream fis = new FileInputStream("/Users/mathumathibalakrishnan/git/repository/CW/TestDataSheet-4.xlsx");
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sheet = wb.getSheet("Sheet1");
    
    for(int count = 2;count<=sheet.getLastRowNum();count++){
        XSSFRow row = sheet.getRow(count);
        System.out.println("Running test case " + row.getCell(0).toString());
        runTest(row.getCell(0).toString(),row.getCell(1).toString(), row.getCell(2).toString());
    }
    fis.close();
} catch (IOException e3) {
    System.out.println("Test data file not found");
}   
}
public static void runTest(String url, String uName, String pwd) throws Exception {
//for (int i=0; i<=15; i ++) {
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


//driver.findElement(By.xpath("//div[@class='continue-watching '][1]/div/div[2]//a[1]")).isDisplayed();
if (driver.getPageSource().contains("Continue")) {
	try {
    System.out.println("Continue watching tray available");
    driver.findElement(By.xpath("//div[@class='continue-watching '][1]/div/div[2]//a[1]")).click();
    Boolean isPresent = driver.findElements(By.xpath("//*[@class='play-icon-overlay']")).size() > 0;
    if (isPresent==true) { 
    	  driver.findElement(By.xpath("//*[@class='play-icon-overlay']")).click();
              }
    System.out.println("Video started1");
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    System.out.println("Video is working fine without any issue1"); 
    driver.findElement(By.xpath("//*[@class='vjs-tech']")).click();
    Thread.sleep(1000);
    WebElement logo1 = driver.findElement(By.xpath("//div[@class='logo-container']"));
    Actions actions11 = new Actions(driver);
    actions11.click(logo1).perform();
}
      catch (Exception e3) {
      try {
      String erro1 = driver.findElement(By.cssSelector("h1[class*='fade__content']")).getText();
      if (erro1.contains("404")) 
         {
         System.out.println("Video not working due to " +erro1); 
         }
      driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();  
          }
      catch (Exception e4){
          String erro =  driver.findElement(By.xpath("//div[@class='vjs-modal-dialog-content' and starts-with(text(), 'The media ')]")).getText();
          if (erro.contains("The media could not be loaded")) 
          {
          System.out.println("Video not working due to " +erro);
          }
          }
          }
    }

else {
   
    	System.out.println("Continue watching tray not available");
    }
    

      
               
   }
/*
    catch (Exception e5) { 
                        System.out.println("Continue watching tray not available"); 
                         }
*/

public void teardown() {
	driver.close();
}
}










/*
"https://www.hoichoi.tv"
"https://www.be-at.tv/"
"https://app.myoutdoortv.com"
"http://site-here-tv.viewlift.com"
"https://moviespree.com"
"https://www.monumentalsportsnetwork.com"
"https://afaplay.viewlift.com"
"https://www.laxsportsnetwork.com"
"https://videos.glorykickboxing.com"
"https://www.motoamericaliveplus.com/"
"https://www.theidentitytb.com"
"https://www.kronon.tv"
"https://www.premierlacrosseleague.com/"

"https://www.supercrosslive.tv" --------------------Need vpn
"https://capitalonearena.viewlift.com" --------------- no login
"https://www.neoufitness.com/home" ------------------- different layout
		*/



