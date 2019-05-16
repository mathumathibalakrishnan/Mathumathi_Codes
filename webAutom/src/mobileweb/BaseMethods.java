package mobileweb;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseMethods {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor scroll;
	Actions actions;
	Random random;
	int randint;
	//ChromeOptions options;
	
	@BeforeClass
	public void Basemethods () throws IOException
	{
//		options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("window-size=1200x600");
		Properties	prop = new Properties();
		FileInputStream data = new FileInputStream ("/Users/viewlift/Desktop/Automation/apache-maven-3.6.0/viewlift/src/test/java/com/motv/Global test data");
		prop.load(data);
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().fullscreen();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
//Close message about cookies 		
		driver.findElement(By.cssSelector("div[class='close-button']")).click();		
		
// Scroll
		 scroll = (JavascriptExecutor) driver;

//Full screen

		driver.manage().window().fullscreen();

//Explicit wait

		 wait = new WebDriverWait(driver, 30);

//Implicit wait

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//Random integer 
			 random = new Random();
//Actions
			actions = new Actions(driver);
	}
	
	@Test
			public void header ()
			
			{
				WebElement menu = driver.findElement(By.cssSelector("nav[class*='navigation']"));

				for (int i = 0; i < menu.findElements(By.tagName("a")).size(); i++) {
					String click = Keys.chord(Keys.COMMAND, Keys.LEFT_SHIFT + "t", Keys.ENTER);
					menu.findElements(By.tagName("a")).get(i).sendKeys(click);
				}
				System.out.println("...........");
				System.out.println("Test case for menu, open all tabs (not dropdown) and get title ");

				Set<String> tab = driver.getWindowHandles();
				java.util.Iterator<String> it = tab.iterator();

				while (it.hasNext())

				{

					driver.switchTo().window(it.next());
					System.out.println(driver.getTitle());

				}
				System.out.println("...........");
				
			}
			
		
	
	
	@AfterClass
	public void Close()
	{
		driver.quit();
	}
}
