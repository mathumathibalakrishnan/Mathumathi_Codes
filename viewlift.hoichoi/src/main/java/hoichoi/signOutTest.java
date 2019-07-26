package hoichoi;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import webTestFunctions.globalDrivers;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class signOutTest extends globalDrivers {

	@Test
	public void SignOut() throws IOException, InterruptedException {

		// Implicit wait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		String expectedLogoutStrings = "login";
		
		// SignOut
		super.globalUser.signOut();
		
		String login = super.globalUser.grabLoginTitle().toLowerCase();

		try {
			AssertJUnit.assertEquals(login.equals(expectedLogoutStrings), true);
		} catch (AssertionError e) {
			super.globalDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println(" Username not equal...." + login);
			throw e;
		}

	}
	

}
