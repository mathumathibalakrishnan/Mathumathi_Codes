package hoichoi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webTestFunctions.globalDrivers;

public class signInPlayerTest extends globalDrivers {

	@Parameters({ "site" })
	@Test
	public void signInPlayer(String site) throws IOException, InterruptedException {

		// Implicit wait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Open Site
		String url = super.globalSite.getSiteUrl(site);
		super.globalDriver.get(url);
		super.globalDriver.manage().window().fullscreen();

		// SignIn
		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav[class='masthead  ']")));
		String username = super.globalSite.getSiteUsername(site);
		String password = super.globalSite.getSitePassword(site);
		
//Click VOD for sign in
		super.globalSite.openSeriesFromMainCarousel();
		
		//Click video
		super.globalSite.clickVODforSignin();

//SignIN	
		super.globalUser.signIn(username, password);

//Grab User name

		String userName = super.globalUser.grabUserName();

		try {
			Assert.assertEquals(userName.toLowerCase().equals("hoichoi"), true);
		} catch (AssertionError error) {
			throw new RuntimeException("Not as expected sign in with video" + userName);
		}
		
		//Sign out
		super.globalUser.signOut();
	}
	
}
