package mathu.motv.CW;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ContinueWatching {
public static void main(String[] args) throws Exception {
		
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
/*
String url[] = new String[15];
url[0] = "https://www.hoichoi.tv";
url[1] = "https://www.be-at.tv/";
url[2] = "https://app.myoutdoortv.com";
url[3] = "http://site-here-tv.viewlift.com";
url[4] = "https://moviespree.com";
url[5] = "https://www.monumentalsportsnetwork.com";
url[6] = "https://afaplay.viewlift.com";
url[7] = "https://www.laxsportsnetwork.com";
url[8] = "https://videos.glorykickboxing.com";
url[9] = "https://www.motoamericaliveplus.com/";
url[10] = "https://www.theidentitytb.com";
url[11] = "https://www.kronon.tv";
url[12] = "https://www.premierlacrosseleague.com/";
url[13] = "https://www.arenafootball.com";
url[14] = "https://capitalonearena.viewlift.com";
*/
//for (int i=0; i<=15; i ++) {


String url[] = new String[2];
url[0] = "https://app.myoutdoortv.com";
url[1] = "https://www.be-at.tv/";
String uname[] = new String[2];
uname[0] = "arul@viewlift.com";
uname[1] = "bobtest956@gmail.com";
String pwd[] = new String[2];
pwd[0] = "test1";
pwd[1] = "aaaaaa";
for (int i=0; i<=3; i ++) {
driver.get(url[i]);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
WebElement element = driver.findElement(By.xpath("//*[@class='login-button navigation-link']"));
driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
Actions actions = new Actions(driver);
actions.click(element).perform();
	//}
driver.findElement(By.xpath("//*[@class='input-box'][1]/input")).click();
driver.findElement(By.xpath("//*[@class='input-box'][1]/input")).sendKeys(uname[i]);
driver.findElement(By.xpath("//*[@class='input-box'][2]/input")).click();
driver.findElement(By.xpath("//*[@class='input-box'][2]/input")).sendKeys(pwd[i]);
driver.findElement(By.xpath("//div[@class='forgot-password-button fat']/preceding-sibling::input")).submit();
Thread.sleep(2000);
System.out.println("Logged in " + url[i]);
Thread.sleep(1000);
WebElement CW = driver.findElement(By.xpath("//div[@class='continue-watching ']"));
if (CW.isDisplayed()) {
	WebElement cw = driver.findElement(By.xpath("//*[text() = 'Continue Watching']"));
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView();", cw);
driver.findElement(By.xpath("(//div[@class='image'])[1]")).click();
System.out.println("Video started");
driver.manage().timeouts().implicitlyWait(31, TimeUnit.SECONDS);
try {                       
           String erro1 = driver.findElement(By.cssSelector("h1[class*='fade__content']")).getText();
           if (erro1.contains("404")) {
                     System.out.println("Video not working due to " +erro1); }
                                 driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
           }catch(Exception e) {
                      try {
                      String erro =  driver.findElement(By.xpath("//div[@class='vjs-modal-dialog-content' and starts-with(text(), 'The media ')]")).getText();
                      if (erro.contains("The media could not be loaded")) {
                                System.out.println("Video not working due to " +erro);
                            }
                      }catch(Exception e1 ) {
                      System.out.println("Video is working fine without any issue");         
                       }                 
driver.findElement(By.xpath("//*[@class='vjs-tech']")).click();
           }
Thread.sleep(10000);
}
else {
	System.out.println("Continue watching tray not available");
}
WebElement logo = driver.findElement(By.xpath("//div[@class='logo-container']"));
Actions actions1 = new Actions(driver);
actions1.click(logo).perform();
}
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



