package com.store.web.com.storewebsite;

import java.io.IOException;
import java.util.Random;
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



public class baseSignInClassObjects {
	// ChromeOptions opt = new ChromeOptions();
	//WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

	WebDriverWait wait = new WebDriverWait(driver, 30); // Explicit wait
	JavascriptExecutor scroll = (JavascriptExecutor) driver; // Scroll
	Actions actions = new Actions(driver); // Actions
	Random random = new Random(); // Random
	int randin = random.nextInt(1000000);

	public void signIn() throws IOException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
		WebElement layer = driver.findElement(By.cssSelector("div[class='popup-view']"));
		layer.findElement(By.cssSelector("input[type='email']")).sendKeys("bobtest956@gmail.com");
		layer.findElement(By.cssSelector("input[type='password']")).sendKeys("aaaaaa", Keys.ENTER);
	}

	public void signInFB() throws IOException, InterruptedException {

		// Sign in with FB on MovieSpree
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='controls ']")));
		driver.findElement(By.cssSelector("button[class*='login-button']")).click();
		WebElement layer = driver.findElement(By.cssSelector("div[class='popup-view']"));
		layer.findElement(By.cssSelector("button[class*='facebook']")).click();
	}

	public void signUp() throws IOException, InterruptedException {

		// SignUp
		driver.findElement(By.cssSelector("button[class*='login-button']")).click();
		driver.findElement(By.cssSelector("div[class*='signup']")).click();
		driver.findElement(By.cssSelector("input[placeholder*='Email']"))
				.sendKeys("autotest" + randin + "@viewlift.com", Keys.TAB);
		driver.findElement(By.cssSelector("input[placeholder*='Name']")).sendKeys("AutoTest", Keys.TAB);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("aaaaaa", Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='user-buttons']")));
	}

	public void signInMenu() throws IOException, InterruptedException {
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='controls ']")));
		driver.findElement(By.cssSelector("button[class*='login-button']")).click();
		WebElement layer = driver.findElement(By.cssSelector("div[class='popup-view']"));
		layer.findElement(By.cssSelector("input[type='email']")).sendKeys("bobtest956@gmail.com");
		layer.findElement(By.cssSelector("input[type='password']")).sendKeys("aaaaaa", Keys.ENTER);
	}

	public void signout() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		actions.moveToElement(
				driver.findElement(By.cssSelector("div[class='user-buttons'],div[class='user-greeting-container']")))
				.build().perform();
		WebElement dropdown = driver.findElement(By.cssSelector("div[class='dropdown']"));
		dropdown.findElement(By.cssSelector("a[href='#logout']")).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("button[class*='login'],a[class='navigation-link']")));
	}

	public void coockies() throws IOException {

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

			driver.findElement(By.cssSelector("div[class='close-button']")).click();
		}

		catch (Exception coo) {

		}
	}

	public String grabUserName() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Thread.sleep(700);
		WebElement header = driver.findElement(By.cssSelector("div[class='controls '], div[style='display: flex;']"));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("div[class='controls '], div[style='display: flex;']")));
		WebElement log = header.findElement(By.cssSelector("span[class='name'],div[class='greeting']"));
		return log.getText();
	}

	public String grabLoginTitle() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Thread.sleep(600);
		WebElement header = driver.findElement(By.cssSelector("div[class='controls ']"));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='controls ']")));
		WebElement log = header.findElement(By.cssSelector("button[class='login-button navigation-link']"));
		return log.getText();
	}

	public String grabLoginTitleNEOU() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Thread.sleep(600);
		WebElement header = driver.findElement(By.cssSelector("div[class='controls '], div[style='display: flex;']"));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("div[class='controls '], div[style='display: flex;']")));
		WebElement log = header
				.findElement(By.cssSelector("span[class='name'],div[class='greeting'],a[class='navigation-link']"));
		return log.getText();
	}

	public void clickVODforSigninWithPreview() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='videos'],a[href*='films']")));
		driver.findElement(By.cssSelector("a[href*='videos'],a[href*='films']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("div[class='vjs-progress-holder vjs-slider vjs-slider-horizontal']")));

		WebElement slider = driver
				.findElement(By.cssSelector("div[class='vjs-progress-holder vjs-slider vjs-slider-horizontal']"));
		actions.dragAndDropBy(slider, 300, 0).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='cta login-btn']")));
		driver.findElement(By.cssSelector("button[class='cta login-btn']")).click();

	}

	public void clickVODforSignin() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='videos'],a[href*='films']")));
		driver.findElement(By.cssSelector("a[href*='videos'],a[href*='films']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='cta login-btn']")));
		driver.findElement(By.cssSelector("button[class='cta login-btn']")).click();

	}

	public void watchNowSignIn() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='button cta']")));
		driver.findElement(By.cssSelector("button[class='button cta']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='cta login-btn']")));
		driver.findElement(By.cssSelector("button[class='cta login-btn']")).click();

	}

}
	
	
	

