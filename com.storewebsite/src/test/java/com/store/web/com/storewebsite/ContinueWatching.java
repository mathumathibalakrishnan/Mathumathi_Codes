package com.store.web.com.storewebsite;





import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContinueWatching {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {

		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//driver.get("https://app.myoutdoortv.com/");
driver.get("https://www.hoichoi.tv");
driver.manage().window().maximize();

	
    //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    Thread.sleep(500);
    WebDriverWait wait = new WebDriverWait(driver, 15);
   wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='controls ']")));
    driver.findElement(By.cssSelector("button[class*='login-button']")).click();
    WebElement layer = driver.findElement(By.cssSelector("div[class='popup-view']"));
    Thread.sleep(500);

    layer.findElement(By.cssSelector("input[type='email']")).sendKeys("bobtest956@gmail.com");
    layer.findElement(By.cssSelector("input[type='password']")).sendKeys("aaaaaa", Keys.ENTER);

		driver.quit();
		
	
	}
}
