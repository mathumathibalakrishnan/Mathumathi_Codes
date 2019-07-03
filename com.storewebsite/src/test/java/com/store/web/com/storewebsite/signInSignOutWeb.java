package com.store.web.com.storewebsite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class signInSignOutWeb {
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

			// Chekc sign in

			String username = base.grabUserName().toLowerCase();

			try {
				Assert.assertEquals(username.equals(expectedUsername), true);
			} catch (AssertionError e) {
				System.out.println(site + " | Username not equal...." + username);
				throw e;
			}

			// SignOut
			base.signout();
			String login = base.grabLoginTitle().toLowerCase();

			try {
				boolean logOutPhraseMatches = ArrayUtils.contains(expectedLogoutStrings, login);
				Assert.assertEquals(logOutPhraseMatches, true);
			} catch (AssertionError e) {
				System.out.println(site + " | Login word mismatch....." + login);
				throw e;
			}
		}

//		@Test
//		public void signinSignOutKronon() throws IOException, InterruptedException {
//
//			String site = "https://www.kronon.tv";
//			String expectedUsername = "kronon";
//
//			String[] expectedLogoutStrings = { "login", "log in" };
//
//			base.driver.get(site);
//			base.driver.manage().window().fullscreen();
//			base.coockies();
//
//			// Implicit wait
//			base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//			// SignIn
//			base.signInMenu();
//
//			// Chekc sign in
//
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
//
//		@Test
//		public void signinSignOutMotv() throws IOException, InterruptedException {
//
//			String site = "https://app.myoutdoortv.com";
//			String expectedUsername = "motv";
//
//			String[] expectedLogoutStrings = { "login", "log in" };
//
//			base.driver.get(site);
//			base.driver.manage().window().fullscreen();
//			base.coockies();
//
//			// Implicit wait
//			base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//			// SignIn
//			base.signInMenu();
//
//			// Chekc sign in
//
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
//
//		@Test
//		public void signinSignOutHoichoi() throws IOException, InterruptedException {
//
//			String site = "https://www.hoichoi.tv";
//			String expectedUsername = "hoichoi";
//
//			String[] expectedLogoutStrings = { "login", "log in" };
//
//			base.driver.get(site);
//			base.driver.manage().window().fullscreen();
//			base.coockies();
//
//			// Implicit wait
//			base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//			// SignIn
//			base.signInMenu();
//
//			// Chekc sign in
//
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
//
//		@Test
//		public void signinSignOutPfl() throws IOException, InterruptedException {
//
//			String site = "https://www.pflmma.com";
//			String expectedUsername = "pfl";
//
//			String[] expectedLogoutStrings = { "login", "log in" };
//
//			base.driver.get(site);
//			base.driver.manage().window().fullscreen();
//			base.coockies();
//
//			// Implicit wait
//			base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//			// SignIn
//			base.signInMenu();
//
//			// Chekc sign in
//
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
//
//		@Test
//		public void signinSignOutTampaBay() throws IOException, InterruptedException {
//
//			String site = "https://www.theidentitytb.com";
//			String expectedUsername = "tampabay";
//
//			String[] expectedLogoutStrings = { "login", "log in" };
//
//			base.driver.get(site);
//			base.driver.manage().window().fullscreen();
//			base.coockies();
//
//			// Implicit wait
//			base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//			// SignIn
//			base.signInMenu();
//
//			// Chekc sign in
//
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
//
//		@Test
//		public void signinSignOutMse() throws IOException, InterruptedException {
//
//			String site = "https://www.monumentalsportsnetwork.com";
//			String expectedUsername = "monumentalsport";
//
//			String[] expectedLogoutStrings = { "login", "log in" };
//
//			base.driver.get(site);
//			base.driver.manage().window().fullscreen();
//			base.coockies();
//
//			// Implicit wait
//			base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//			// SignIn
//			base.signInMenu();
//
//			// Chekc sign in
//
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
//
//		@Test
//		public void signinSignOutHereTv() throws IOException, InterruptedException {
//
//			String site = "https://www.here.tv";
//			String expectedUsername = "bobtest956";
//
//			String[] expectedLogoutStrings = { "login", "log in" };
//
//			base.driver.get(site);
//			base.driver.manage().window().fullscreen();
//			base.coockies();
//
//			// Implicit wait
//			base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//			// SignIn
//			base.signInMenu();
//
//			// Chekc sign in
//
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
//
//		@Test
//		public void signinSignOutBeatTv() throws IOException, InterruptedException {
//
//			String site = "https://www.be-at.tv";
//			String expectedUsername = "beattv";
//
//			String[] expectedLogoutStrings = { "login", "log in" };
//
//			base.driver.get(site);
//			base.driver.manage().window().fullscreen();
//			// base.coockies();
//
//			// Implicit wait
//			base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//			// SignIn
//			base.signInMenu();
//
//			// Chekc sign in
//
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
//
//		@Test
//		public void signinSignOutPll() throws IOException, InterruptedException {
//
//			String site = "https://www.premierlacrosseleague.com";
//			String expectedUsername = "pll";
//
//			String[] expectedLogoutStrings = { "login", "log in" };
//
//			base.driver.get(site);
//			base.driver.manage().window().fullscreen();
//			base.coockies();
//
//			// Implicit wait
//			base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//			// SignIn
//			base.signInMenu();
//
//			// Chekc sign in
//
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
//
//		@Test
//		public void signinSignOutMotoAmerica() throws IOException, InterruptedException {
//
//			base.driver.get("https://www.motoamericaliveplus.com/");
//			String site = "https://www.motoamericaliveplus.com";
//			String expectedUsername = "motoamerica";
//
//			String[] expectedLogoutStrings = { "login", "log in" };
//
//			base.driver.get(site);
//			base.driver.manage().window().fullscreen();
//			base.coockies();
//
//			// Implicit wait
//			base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//			// SignIn
//			base.signInMenu();
//
//			// Chekc sign in
//
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
//
//		@Test
//		public void signinNeou() throws IOException, InterruptedException {
//
//			String site = "https://www.neoufitness.com/";
//			String expectedUsername = "hello, bobtest956+8";
//
//			String[] expectedLogoutStrings = { "login", "log in", "sign in" };
//
//			base.driver.get(site);
//			base.driver.manage().window().fullscreen();
//			base.coockies();
//
//			// Implicit wait
//			base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//			// SignIn
//			scroll.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//			base.driver.findElement(By.cssSelector("a[class*='grayButton']")).click();
//
//			try {
//				base.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//				base.driver.findElement(By.cssSelector("div[class='sub-ctas']")).click();
//			}
//
//			catch (Exception signin) {
//				base.driver.findElement(By.cssSelector("a[class='navigation-link']")).click();
//			}
//
//			base.driver.findElement(By.cssSelector("input[name='email']")).sendKeys("bobtest956+8@gmail.com", Keys.ENTER);
//			base.driver.findElement(By.cssSelector("input[name='password']")).sendKeys("aaaaaa", Keys.ENTER);
//
//			// Chekc sign in
//
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
//			String login = base.grabLoginTitleNEOU().toLowerCase();
//
//			try {
//				boolean logOutPhraseMatches = ArrayUtils.contains(expectedLogoutStrings, login);
//				Assert.assertEquals(logOutPhraseMatches, true);
//			} catch (AssertionError e) {
//				System.out.println(site + " | Login word mismatch....." + login);
//				throw e;
//			}
//		}

		@AfterTest
		public void close() {
			base.driver.close();
		}

	}



