package mathu.motv.CW;



import java.util.concurrent.TimeUnit;

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
 driver = new ChromeDriver();
 driver.get("https://moviespree.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	WebElement element = driver.findElement(By.xpath("//*[@class='login-button navigation-link']"));
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	Actions actions = new Actions(driver);
	actions.click(element).perform();
	driver.findElement(By.xpath("//*[@class='input-box'][1]/input")).click();
	driver.findElement(By.xpath("//*[@class='input-box'][1]/input")).sendKeys("eugene+7@viewlift.com");
	driver.findElement(By.xpath("//*[@class='input-box'][2]/input")).click();
	driver.findElement(By.xpath("//*[@class='input-box'][2]/input")).sendKeys("aaaaaa");
	driver.findElement(By.xpath("//div[@class='forgot-password-button fat']/preceding-sibling::input")).submit();

	driver.findElement(By.xpath("//div[@class='continue-watching '][1]/div/div[2]//a[1]")).click();
	
 
 System.out.println("logged");
 driver.findElement(By.xpath("//*[@class='play-icon-overlay']")).click();
 Thread.sleep(30000);
 //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 
 System.out.println("played");
 
 WebElement logo1 = driver.findElement(By.xpath("//div[@class='logo-container']"));
 Actions actions11 = new Actions(driver);
 actions11.click(logo1).perform();

 
 
}
}

