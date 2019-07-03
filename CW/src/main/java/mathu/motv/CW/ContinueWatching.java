package mathu.motv.CW;


import java.util.Iterator;
import java.util.Set;
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
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();

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
//url[13] = "https://capitalonearena.viewlift.com";
url[13] = "https://www.arenafootball.com";
url[14] = "https://www.neoufitness.com/home";

for (int i=0; i<=16; i ++) {
driver.get(url[i]);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
//driver.findElement(By.xpath("//*[@class='login-button navigation-link']")).click();


WebElement element = driver.findElement(By.xpath("//*[@class='login-button navigation-link']"));

if (element.isDisplayed()) {
element.click();

}
else
{
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("document.body.style.zoom='" + "75%" +"'");
element.click();
}

driver.findElement(By.xpath("//*[@class='input-box'][1]/input")).click();
driver.findElement(By.xpath("//*[@class='input-box'][1]/input")).sendKeys("bobtest956@gmail.com");
driver.findElement(By.xpath("//*[@class='input-box'][2]/input")).click();
driver.findElement(By.xpath("//*[@class='input-box'][2]/input")).sendKeys("aaaaaa");
driver.findElement(By.xpath("//div[@class='forgot-password-button fat']/preceding-sibling::input")).submit();
//driver.findElement(By.xpath("(//*[@type='submit'])[2]")).submit();
Thread.sleep(2000);
driver.findElement(By.xpath("//div[@class='logo-container']")).click();
System.out.println("Logged in " + url[i]);
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
"https://www.supercrosslive.tv" --------------------Need vpn
"https://videos.glorykickboxing.com"
"https://www.motoamericaliveplus.com/"
"https://www.theidentitytb.com"
"https://www.kronon.tv"
"https://www.premierlacrosseleague.com/"
"https://capitalonearena.viewlift.com" ---------------able to login but unable to click logo


"https://www.arenafootball.com"
"https://www.neoufitness.com/home"
		*/

/*
WebElement element = driver.findElement(By.id("//*[@class='login-button navigation-link']"));

if (element.isEnabled()) {
	Actions actions = new Actions(driver);
	actions.moveToElement(element).click().build().perform();

}
else
{
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("document.body.style.zoom='" + "75%" +"'");
}
*/
//Thread.sleep(1000);
/*
String MainWindow=driver.getWindowHandle();
Set<String> s1=driver.getWindowHandles();
Iterator<String> i1=s1.iterator();
while(i1.hasNext())			
{
	String ChildWindow=i1.next();		
	
    if(!MainWindow.equalsIgnoreCase(ChildWindow))			
    {    		
    	driver.switchTo().window(ChildWindow);
    	driver.close();	
}
}
driver.switchTo().window(MainWindow);

driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
*/

