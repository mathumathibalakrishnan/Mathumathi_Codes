package viewlift.viewlift.hoichoi.prod;

import org.testng.annotations.Test;
import webTestFunctions.globalDrivers;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class signInWithGoogleTest extends globalDrivers {

	@Parameters("site")
	@Test
	public void GoogleSignInHoichoi(String site) throws InterruptedException, IOException {

		// Implicit wait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Open site
		String url = super.globalSite.getSiteUrl(site);
		super.globalDriver.get(url);
		super.globalDriver.manage().window().fullscreen();

		// SignIn
		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav[class='masthead  ']")));
		super.globalDriver.findElement(By.cssSelector("button[class*='login-button']")).click();
		super.globalDriver.findElement(By.cssSelector("button[class*='google']")).click();

		// Get the list of window handles
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		// Use the list of window handles to switch between windows
		super.globalDriver.switchTo().window(tabs.get(1));
		Thread.sleep(500);
		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
		super.globalDriver.findElement(By.cssSelector("input[type='email']")).sendKeys("bob26914@gmail.com",
				Keys.ENTER);
		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
		super.globalDriver.findElement(By.cssSelector("input[type='password']")).sendKeys("Linkoln34!", Keys.ENTER);

		// Switch back to original window
		super.globalDriver.switchTo().window(tabs.get(0));

		// Grab User name
		String username = super.globalUser.grabUserName();
		try {
			Assert.assertEquals(username.equals("BOB MARK"), true);
		} catch (AssertionError error) {
			throw new RuntimeException("Not as expected sign in with video...." + username);
		}

		super.globalUser.signOut();
	}

}