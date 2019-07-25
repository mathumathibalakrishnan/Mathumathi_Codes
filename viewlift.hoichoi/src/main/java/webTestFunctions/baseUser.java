package webTestFunctions;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseUser {
	// ChromeOptions opt = new ChromeOptions();

	WebDriver driver;
	WebDriverWait wait; // Explicit wait
	JavascriptExecutor scroll; // Scroll
	Actions actions; // Actions
	Random random; // Random
	int randin;
	JavascriptExecutor js;
	String searchword;
	baseSite site;

	public baseUser(WebDriver driver1) {
		driver = driver1;
		site = new baseSite(driver);
		wait = new WebDriverWait(driver, 15); // Explicit wait
		scroll = (JavascriptExecutor) driver; // Scroll
		actions = new Actions(driver); // Actions
		random = new Random(); // Random
		randin = random.nextInt(1000000);
		js = (JavascriptExecutor) driver;
		searchword = ("episodes");
	}

	public void signIn(String username, String password) throws IOException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
		WebElement layer = driver.findElement(By.cssSelector("div[class='popup-view']"));
		layer.findElement(By.cssSelector("input[type='email']")).sendKeys(username);
		layer.findElement(By.cssSelector("input[type='password']")).sendKeys(password, Keys.ENTER);
	}

	public void signInFB() throws IOException, InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav[class='masthead  ']")));
		driver.findElement(By.cssSelector("button[class*='login-button']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='facebook']")));
		WebElement layer = driver.findElement(By.cssSelector("div[class='popup-view']"));
		layer.findElement(By.cssSelector("button[class*='facebook']")).click();
	}

	public void signUp() throws IOException, InterruptedException {
		driver.navigate().refresh();
		// SignUp
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav[class='masthead  ']")));
		driver.findElement(By.cssSelector("button[class*='login-button']")).click();
		WebElement layer = driver.findElement(By.cssSelector("div[class='popup-view']"));
		layer.findElement(By.cssSelector("div[class*='signup']")).click();

		Thread.sleep(500);
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			layer.findElement(By.cssSelector("div[class='ageCheck']")).click();

		} catch (Exception ss) {
			// System.out.println("not appeard when was trying to click");
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder*='Email']")));
		layer.findElement(By.cssSelector("input[placeholder*='Email']")).sendKeys("autotest" + randin + "@viewlift.com",
				Keys.TAB);
		layer.findElement(By.cssSelector("input[placeholder*='Name']")).sendKeys("AutoTest", Keys.TAB);
		layer.findElement(By.cssSelector("input[type='password']")).sendKeys("aaaaaa", Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='user-buttons']")));
	}

	public void signInFromHeader(String username, String password) throws IOException, InterruptedException {
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().refresh();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav[class='masthead  ']")));
		driver.findElement(By.cssSelector("button[class*='login-button']")).click();
		WebElement layer = driver.findElement(By.cssSelector("div[class='popup-view']"));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
		layer.findElement(By.cssSelector("input[type='email']")).sendKeys(username);
		layer.findElement(By.cssSelector("input[type='password']")).sendKeys(password, Keys.ENTER);
	}

	public void signOut() throws IOException, InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav[class='masthead  ']")));
		actions.moveToElement(
				driver.findElement(By.cssSelector("div[class='user-buttons'],div[class='user-greeting-container']")))
				.build().perform();
		WebElement dropdown = driver.findElement(By.cssSelector("div[class='dropdown']"));
		dropdown.findElement(By.cssSelector("a[href='#logout']")).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("button[class*='login'],a[class='navigation-link']")));
	}

	public String grabUserName() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Thread.sleep(700);
		WebElement header = driver.findElement(By.cssSelector("div[class='controls '], div[style='display: flex;']"));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("div[class='controls '], div[style='display: flex;']")));
		WebElement log = header.findElement(By.cssSelector("span[class='name'],div[class='greeting']"));
		return log.getText();
	}

	public String grabLoginTitle() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Thread.sleep(600);
		WebElement header = driver.findElement(By.cssSelector("div[class='controls ']"));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='controls ']")));
		WebElement log = header.findElement(By.cssSelector("button[class='login-button navigation-link']"));
		return log.getText();
	}

	public String grabLoginTitleNEOU() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Thread.sleep(600);
		WebElement header = driver.findElement(By.cssSelector("div[class='controls '], div[style='display: flex;']"));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("div[class='controls '], div[style='display: flex;']")));
		WebElement log = header
				.findElement(By.cssSelector("span[class='name'],div[class='greeting'],a[class='navigation-link']"));
		return log.getText();
	}

	public void signInToFB(String userFB, String passwordFB) throws IOException {
		driver.get("https://www.facebook.com/login");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		driver.findElement(By.id("email")).sendKeys(userFB, Keys.TAB);
		driver.findElement(By.id("pass")).sendKeys(passwordFB, Keys.ENTER);
		driver.manage().window().fullscreen();
	}

}
