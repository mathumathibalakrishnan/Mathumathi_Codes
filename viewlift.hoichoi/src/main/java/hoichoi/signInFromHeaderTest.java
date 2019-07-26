package hoichoi;

import org.testng.annotations.Test;
import webTestFunctions.globalDrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class signInFromHeaderTest extends globalDrivers {

	@Parameters({ "site" })
	@Test
	public void signInFromHeader(String site) throws IOException, InterruptedException {

		// Implicit wait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Open Site
		String url = super.globalSite.getSiteUrl(site);
		super.globalDriver.get(url);
		super.globalDriver.manage().window().fullscreen();
		String expectedUsername = "victor";
		
		//Cookies
		super.globalSite.cookies();

		// SignIn
		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav[class='masthead  ']")));
		String username = super.globalSite.getSiteUsername(site);
		String password = super.globalSite.getSitePassword(site);
		super.globalUser.signInFromHeader(username, password);

		// Check sign in
		String usernameFromMenu = super.globalUser.grabUserName().toLowerCase();

		try {
			Assert.assertEquals(usernameFromMenu.toLowerCase().equals(expectedUsername), true);
			System.out.println(site + " | Username not equal...." + usernameFromMenu);
		} catch (AssertionError e) {
			super.globalDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println(site + " | Username not equal...." + usernameFromMenu);
			throw e;
		}
	}
}
