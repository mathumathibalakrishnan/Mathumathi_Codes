package viewlift.viewlift.hoichoi.prod;

import org.testng.annotations.Test;
import webTestFunctions.globalDrivers;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class signInFBTest extends globalDrivers {

	@Parameters({ "site" })
	@Test
	public void signInWithFB(String site) throws IOException, InterruptedException {

		// Implicit wait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Sign-in To FB site
		String userFB = super.globalSite.getFacebookUsername(site);
		String passwordFB = super.globalSite.getFacebookPassword(site);

		super.globalUser.signInToFB(userFB, passwordFB);

//		System.out.println(super.globalSite.getconfigfile().getProperty("facebook.username.beatTV"));

		Thread.sleep(1000);
		// Open site
		String url = super.globalSite.getSiteUrl(site);
		super.globalDriver.get(url);
		super.globalDriver.manage().window().fullscreen();

		// Sign in with FB on MovieSpree
		super.globalUser.signInFB();

		// Grab user name
		String username = super.globalUser.grabUserName();
		try {
			Assert.assertEquals(username.equals("SHRI SNAG"), true);
		} catch (AssertionError error) {
			super.globalDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			throw new RuntimeException(url + ".....Not as expected sign in with video....." + username);
		}

		super.globalUser.signOut();
		super.globalDriver.manage().deleteAllCookies();

	}

}