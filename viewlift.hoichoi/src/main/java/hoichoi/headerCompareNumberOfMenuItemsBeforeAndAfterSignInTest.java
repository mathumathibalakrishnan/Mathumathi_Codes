package hoichoi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webTestFunctions.globalDrivers;

public class headerCompareNumberOfMenuItemsBeforeAndAfterSignInTest extends globalDrivers {

	@Parameters({ "site" })
	@Test
	public void compareNumberOfItemsInMenuBeforeAndAfterSignin(String site) throws IOException, InterruptedException {

		// Implicit wait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Open Site
		String url = super.globalSite.getSiteUrl(site);
		super.globalDriver.get(url);
		super.globalDriver.manage().window().fullscreen();

		// Number of menu items before sign in
		super.globalSite.numberOfItemsInmenu();

		// Sign in
		String username = super.globalSite.getSiteUsername(site);
		String password = super.globalSite.getSitePassword(site);
		super.globalUser.signInFromHeader(username, password);

		// Number of menu items after sign in
		String numItemsBeforeLogin = super.globalSite.numberOfItemsInmenu();

		// Thread.sleep(500);
		String numItemsAfterLogin = super.globalSite.numberOfItemsInMenuAfterSignIn();

		int before = Integer.parseInt(numItemsBeforeLogin);
		int after = Integer.parseInt(numItemsAfterLogin);

		System.out.println(before);
		System.out.println(after);

		try {
			Assert.assertEquals((((before + 1) == after) || (before == after) || ((before - 1) == after)), true);
		}

		catch (AssertionError e) {
			super.globalDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			throw new RuntimeException("Number of items before sign in is ... " + before
					+ "   Number of items after sign in is ..." + after);
		}
		super.globalUser.signOut();
	}


}
