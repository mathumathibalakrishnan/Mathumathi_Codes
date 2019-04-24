package com.motv;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class BaseJava  {
	//ChromeOptions opt = new ChromeOptions();
	WebDriver driver = new ChromeDriver ();

    
	WebDriverWait wait = new WebDriverWait(driver, 30); // Explicit wait
	JavascriptExecutor scroll = (JavascriptExecutor) driver; // Scroll
	Actions actions = new Actions(driver); // Actions
	Random random = new Random(); // Random
	int randin = random.nextInt(1000000);

	

	public void baseMethods() throws IOException {
	
		
		
		Properties prop = new Properties();
		FileInputStream data = new FileInputStream(
				"/Users/viewlift/Desktop/Automation/apache-maven-3.6.0/viewlift/src/test/java/com/motv/Global test data");
		prop.load(data);

		driver.get(prop.getProperty("url"));
		driver.manage().window().fullscreen();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
//Close message about cookies 		
		driver.findElement(By.cssSelector("div[class='close-button']")).click();

//Full screen
		driver.manage().window().fullscreen();
//Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

//Purchasing form	
	
	
	public void purchase() // Credit card Form
	{
		// Credit card form
		WebElement form = driver.findElement(By.cssSelector("form[class='popup-stripe-cc-form']"));
		form.findElement(By.cssSelector("input[placeholder*='Name']")).sendKeys("hgg@fdf.com", Keys.TAB);
		form.findElement(By.cssSelector("input[placeholder='Street Address']")).sendKeys("hgg@fdf.com", Keys.TAB);
		// Frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[name='__privateStripeFrame5']")));

		actions.sendKeys("10001").build().perform();
		// Back to main frame
		driver.switchTo().defaultContent();

		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[name='__privateStripeFrame6']")));
		driver.findElement(By.xpath("(//*[@id='root']/form[@dir='ltr'])[1]")).click();
		actions.sendKeys("4111111111111111", Keys.TAB).build().perform();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[name='__privateStripeFrame7']")));
		driver.findElement(By.xpath("(//*[@id='root']/form[@dir='ltr'])[1]")).click();
		actions.sendKeys("2424", Keys.TAB).build().perform();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[name='__privateStripeFrame8']")));
		driver.findElement(By.xpath("(//*[@id='root']/form[@dir='ltr'])[1]")).click();
		actions.sendKeys("2424", Keys.ENTER).build().perform();
		driver.switchTo().defaultContent();
	}

//Sign IN
	public void signIn() throws IOException {
		Properties prop = new Properties();
		FileInputStream data = new FileInputStream(
				"/Users/viewlift/Desktop/Automation/apache-maven-3.6.0/viewlift/src/test/java/com/motv/Global test data");
		prop.load(data);
		driver.findElement(By.cssSelector("button[class*='login-button']")).click();
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(prop.getProperty("password"), Keys.ENTER);
	}

//Sign UP	
	public void signUp() // Sign up

	{
		driver.findElement(By.id("ageCheck")).click();
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("test" + randin + "@yandex.com", Keys.TAB);
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("hgg@fdf.com", Keys.TAB);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("aaaaaa", Keys.ENTER);
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.cssSelector("form[class='popup-stripe-cc-form']")));
	}

//Print name what was bought 	
	public void printNameWhatBougth() // Print name of show that was bought

	{
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class*='watch-now-button']")));
		WebElement bar = driver.findElement(By.cssSelector("body[class=overflow-hide]"));
		WebElement vtitle = bar.findElement(By.cssSelector("p[class='top']"));
		String name = vtitle.getText();
		System.out.println("Succses message " + '"' + name + '"');
		driver.findElement(By.cssSelector("button[class*='close']")).click();
	}

//Buy Button click
	public void buyButton() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class*='verify-button']")));
		driver.findElement(By.cssSelector("div[class*='verify-button']")).click();
	}

// Grab title from Library 
	public void titleFromLibrary()

	{
		actions.moveToElement(driver.findElement(By.cssSelector("div[class='user-buttons']"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"root\"]/div/div[1]/div[1]/nav/div/header/div[3]/div[2]/div[2]/a[1][@href='/user/library']")));
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[1]/div[1]/nav/div/header/div[3]/div[2]/div[2]/a[1][@href='/user/library']"))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a/div[2]/div[1][@class='title'])[1]")));
		WebElement title = driver.findElement(By.xpath("(//*[@id=\"root\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/div/a/div/div)[1]"));
		System.out.println("Video in library  " + title.getText());
	}

//Grab 3 Title from History 
	public void titleFromHistory() throws InterruptedException

	{
		WebElement title1 = driver.findElement(By.xpath("(//a/div[2]/div[1][@class='title'])[1]"));
		System.out.println(title1.getText());
		WebElement title2 = driver.findElement(By.xpath("(//a/div[2]/div[1][@class='title'])[2]"));
		System.out.println(title2.getText());
		WebElement title3 = driver.findElement(By.xpath("(//a/div[2]/div[1][@class='title'])[3]"));
		String text = title3.getText();
		System.out.println(title3.getText());
		Thread.sleep(2000);
		// Remove one asset
		driver.findElement(By.xpath(
				"(//div/div/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/i[@class='link ion-close'])[1]"))
				.click();
		Thread.sleep(2000);
		System.out.println("AFTER REMOVING SECOND ASSET ");
		// Verify dynamically what 2 assets left in list
		WebElement title4 = driver.findElement(By.xpath("(//a/div[2]/div[1][@class='title'])[2]"));
		String text2 = title4.getText();
		System.out.println(title1.getText());
		if (text2.contains(text))

		{

			System.out.println("As expected ... " + text);
		}

		else {

			System.out.println("Not as expected ..." + text);
		}
	}

//Open History 
	public void openHistory() {
		actions.moveToElement(driver.findElement(By.cssSelector("div[class='user-buttons']"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"root\"]/div/div[1]/div[1]/nav/div/header/div[3]/div[2]/div[2]/a[3][@href='/user/history']")));
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[1]/div[1]/nav/div/header/div[3]/div[2]/div[2]/a[3][@href='/user/history']"))
				.click();
	}

//Open Next Window and grab Title 
	public void openNextWindowGetTitle() {
		String MainWindow = driver.getWindowHandle();

		Set<String> tab = driver.getWindowHandles();
		java.util.Iterator<String> nt = tab.iterator();
		
		while (nt.hasNext())

		{

			driver.switchTo().window(nt.next());
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());

			

		}
		driver.switchTo().window(MainWindow);
	}

//Clear History or Watchlist
	public void clearHistoryWatchlist() {
		// Close message about clear all with "X" sign
		driver.findElement(By.cssSelector("div[class='clear-list']")).click();
		driver.findElement(By.cssSelector("div[class='close-button']")).click();
		System.out.println("Check for close clear all mesage with 'X' icon ");
		// Close message about clear all with "no" button
		System.out.println("Test case : Close message about -clear all- with -NO- Button ");
		driver.findElement(By.cssSelector("div[class='clear-list']")).click();
		driver.findElement(By.cssSelector("button[class='button button-no cta']")).click();
		System.out.println("Check for close clear all mesage with 'NO' button ");
		// Clear watchlist
		driver.findElement(By.cssSelector("div[class='clear-list']")).click();
		driver.findElement(By.cssSelector("button[class='button button-yes cta']")).click();
		System.out.println("Test case : Clear Watchlist ");
		// Get text that list empty
		WebElement clear = driver.findElement(By.cssSelector("div[class='list-empty']"));
		System.out.println(clear.getText());
	}
}

