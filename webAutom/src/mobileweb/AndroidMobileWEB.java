package mobileweb;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AndroidMobileWEB {
   
	public static void main(String[] args) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Galaxy Tab A");
      // capabilities.setCapability("deviceName", "Galaxy J7");
		//capabilities.setCapability("deviceName", "Pixel C");
		capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("platformName", "Android");
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);                    
        driver.navigate().to("https://app.myoutdoortv.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(2000);

driver.findElement(By.xpath("//*[@class='close-button']")).click();
 if (driver.findElement(By.xpath("//*[@class='navigation-link ion-navicon']")).isDisplayed()) {
	 driver.findElement(By.xpath("//*[@class='navigation-link ion-navicon']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[contains (text(), 'Log In')]")).click();

 }else 
 {
	 driver.findElement(By.xpath("//button[contains(text(),' Login')]")).click();
 }
Thread.sleep(1000);

//driver.findElement(By.xpath("//*[@class='close-button']")).click();
Thread.sleep(1000);
driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
driver.findElement(By.xpath("//div[@class='input-box']//input[@type='email']")).sendKeys("arul@viewlift.com");
driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
driver.findElement(By.xpath("//*[@class='input-box']//input[@type='password']")).sendKeys("test1");
driver.findElement(By.xpath("//input[@type='submit']")).click();
driver.findElement(By.xpath("//*[@class='navigation-link ion-navicon']")).click();

if (driver.findElement(By.xpath("(//a[@class='navigation-link'])[3]")).isDisplayed()) {
System.out.println(" logged in");                             
}
else
{
System.out.println(" User not logged in");     
}

driver.findElement(By.xpath("//i[@class='navigation-link ion-close']")).click();

driver.findElement(By.xpath("//a[contains(@href,'/shows/brotherhood-outdoors')]")).click();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
Actions action = new Actions(driver);
if (driver.findElement(By.xpath("//*[@class='play-icon site-color']")).isDisplayed()){
WebElement elm1 = driver.findElement(By.xpath("//*[@class='play-icon site-color']"));
action.click(elm1).perform();
}
else {
	JavascriptExecutor jsx = (JavascriptExecutor)driver;
	jsx.executeScript("window.scrollBy(0,450)", "");
	WebElement elm1 = driver.findElement(By.xpath("(//i[@class='ion-ios-play site-color'])[1]"));
	action.click(elm1).perform();

}
	
Thread.sleep(30000);
System.out.println("Video started");
driver.manage().timeouts().implicitlyWait(31, TimeUnit.SECONDS);
             
driver.findElement(By.xpath("//button[@class='close ']")).click();
                   
driver.findElement(By.xpath("//div[@class='logo']")).click();
                   }
 
}



