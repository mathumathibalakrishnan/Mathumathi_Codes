package mathu.motv.CW;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POM {
static WebDriver driver;
	public void ContinueWatchingS() {
		try {
		if (driver.getPageSource().contains("Continue Watching")) {
			try {
		    System.out.println("Continue watching tray available");
		    driver.findElement(By.xpath("//div[@class='continue-watching '][1]/div/div[2]//a[1]")).click();
		    
		    if (driver.getTitle().contains("movieSPREE")) {
		    	driver.findElement(By.xpath("//*[@class='play-icon-overlay']")).click();
		    	 Thread.sleep(15000);
		    	    }
		    Thread.sleep(15000);
		    System.out.println("Video is working fine without any issue1"); 

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
		catch (Exception try2){
			System.out.println("Continue watching not working due to login issue");
		}
		    
	}
		
	public void LoginS(String url, String uName, String pwd) throws Exception {
		try {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
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
			try {
				Assert.assertTrue(driver.findElement(By.xpath("//div[@class='logo-container']")).isDisplayed(), "User logged in" +url);
				System.out.println("Logged in " + url);
				Thread.sleep(1000);
			}
				catch (Exception e) {
					e.getMessage();
				}
			Thread.sleep(1000);
			
		}
		catch (Exception try1) {
			
			System.out.println("Login button not available");
			driver.quit();;
		}
		
	}

	public void LogOut() throws InterruptedException {
		try {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//*[@class='navigation-link greeting']"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@href=\"#logout\"])[2]")).click();
		
		System.out.println("Logout successfully");
		driver.close();
		}
		catch (Exception try3){
			System.out.println("Logout not available due to login issue");
		}
	}
	
}

