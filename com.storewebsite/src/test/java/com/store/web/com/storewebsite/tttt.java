
package com.store.web.com.storewebsite;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class tttt {
	// Base
		baseSignInClassObjects base = new baseSignInClassObjects();
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(base.driver, 15);
		// Scroll
		JavascriptExecutor scroll = (JavascriptExecutor) base.driver;
		// Actions
		Actions actions = new Actions(base.driver); // Actions

		@Test
		public void signInSignOutSpree() throws IOException, InterruptedException {

			base.driver.get("https://www.moviespree.com");
			String site = "https://www.moviespree.com";
			String expectedUsername = "spree";

			String[] expectedLogoutStrings = { "login", "log in" };

			base.driver.get(site);
			base.driver.manage().window().fullscreen();
			base.coockies();

			// Implicit wait
			base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			// SignIn
			base.signInMenu();
		}
}

			// Chekc sign in

//			String username = base.grabUserName().toLowerCase();
//
//			try {
//				Assert.assertEquals(username.equals(expectedUsername), true);
//			} catch (AssertionError e) {
//				System.out.println(site + " | Username not equal...." + username);
//				throw e;
//			}
//
//			// SignOut
//			base.signout();
//			String login = base.grabLoginTitle().toLowerCase();
//
//			try {
//				boolean logOutPhraseMatches = ArrayUtils.contains(expectedLogoutStrings, login);
//				Assert.assertEquals(logOutPhraseMatches, true);
//			} catch (AssertionError e) {
//				System.out.println(site + " | Login word mismatch....." + login);
//				throw e;
//			}
//		}
