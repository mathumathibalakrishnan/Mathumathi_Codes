package viewlift.viewlift.hoichoi.prod;

import org.testng.annotations.Test;
import webTestFunctions.globalDrivers;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class signUpTest extends globalDrivers {
	Random random = new Random(); // Random
	int randin = random.nextInt(1000);

	@Parameters({ "site" })
	@Test
	public void signUp(String site) throws IOException, InterruptedException {
		//Implicit wait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Open site
		String url = super.globalSite.getSiteUrl(site);
		super.globalDriver.get(url);
		super.globalDriver.manage().window().fullscreen();
		
		Thread.sleep(1000);

		// SignUp
		super.globalUser.signUp();

		// Grab User name
		String username = super.globalUser.grabUserName();
		try {
			Assert.assertEquals(username.equals("AUTOTEST"), true);
		} catch (AssertionError error) {
			super.globalDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			throw new RuntimeException(url + "Not as expected sign in with video....." + username);
		}
	}

}