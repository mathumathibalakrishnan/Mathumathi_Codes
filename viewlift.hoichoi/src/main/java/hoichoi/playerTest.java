package hoichoi;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webTestFunctions.globalDrivers;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class playerTest extends globalDrivers {

	@Parameters("site")
	@Test(priority = 0)
	public void fullscreenTest() throws IOException, InterruptedException {

		// Base player
		super.globalSite.search();
		super.globalSite.clickSeriesFromSearch();
		super.globalJs.executeScript("window.scrollBy(0,600)");
		super.globalDriver.findElement(By.cssSelector("button[class='button cta']")).click();

		// Full screen
		super.globalPlayer.fullscreenOfVideo();

	}

	@Test(priority = 2)
	public void checkScruberPlayerFunction() throws IOException, InterruptedException {

		// Implicit super.globalWait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Pause
		super.globalPlayer.clickTopauseVideo();

		// Scrub forward
		super.globalPlayer.playerScruber();
	}

	@Test(priority = 3)
	public void checkMutePlayerFunction() throws IOException, InterruptedException {

		// Implicit super.globalWait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Pause
		super.globalPlayer.clickTopauseVideo();

		// Sound test
		super.globalPlayer.muteFuntion();

	}

	@Test(priority = 4)
	public void checkRenditonPlayerFunction() throws IOException, InterruptedException {

		// Implicit super.globalWait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		super.globalPlayer.checkLoaderPresence();

		// Rendition
		super.globalPlayer.rendition();

	}

	@Test(priority = 5)
	public void checkPausePlayerIconFunction() throws IOException, InterruptedException {

		// Implicit super.globalWait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Check if video plays by verifying that play icon enabled
		super.globalPlayer.videoPlaysProve();

		// Pause video
		super.globalPlayer.clickTopauseVideo();

		// Check if video paused by verifying that pause icon enabled
		super.globalPlayer.videoPausedProve();

	}

	@Test(priority = 6)
	public void checkScruberRewind15SecondsFunction() throws IOException, InterruptedException {

		// Implicit super.globalWait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		super.globalPlayer.checkLoaderPresence();

		// Get Current timer
		super.globalPlayer.rewind15seconds();
	}

	@Test(priority = 7)
	public void closeVideoPlayerFullscreen() throws IOException, InterruptedException {

		// Implicit super.globalWait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Get Current timer
		super.globalDriver.findElement(By.cssSelector("button[class='vjs-fullscreen-control vjs-control vjs-button']"))
				.click();
	}

	@Test(priority = 8)
	public void closedCaptionsTest() throws InterruptedException, IOException {
		// Implicit super.globalWait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		super.globalDriver.get("https://www.hoichoi.tv/show/title/byomkesh-web-series");
		Thread.sleep(500);
		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='show__hero']")));
		super.globalJs.executeScript("window.scrollBy(0,400)");
		super.globalDriver.findElement(By.cssSelector("button[class='button cta']")).click();

		super.globalPlayer.checkLoaderPresence();

		// Fast-forward
		super.globalPlayer.playerJustScrub();

		super.globalJs.executeScript("videojs('vjs_video_3').pause()");

		// Regular closed Captions
		Thread.sleep(500);
		try {
			super.globalWait.until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='vjs-loading-spinner']")));
			super.globalWait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.cssSelector("div[class='vjs-loading-spinner']")));
		} catch (Exception pl) {

		}

		try {
			super.globalActions.moveToElement(super.globalDriver.findElement(By.id("vjs_video_3_html5_api"))).build()
					.perform();
			super.globalWait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));

			super.globalActions.moveToElement(super.globalDriver.findElement(By.id("vjs_video_3_html5_api"))).build()
					.perform();
			super.globalActions
					.moveToElement(super.globalDriver.findElement(By.cssSelector("div[class*='vjs-subs-caps-button']")))
					.build().perform();
			super.globalDriver.findElement(By.cssSelector(
					"li[class='vjs-menu-item vjs-subtitles-menu-item'],li[class='vjs-menu-item vjs-captions-menu-item']"))
					.click();
			Thread.sleep(500);
			super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[style*='direction']")));
			WebElement cc = super.globalDriver.findElement(By.cssSelector("div[style*='direction']"));
			String cccheck = cc.getText().toLowerCase();
			System.out.println("Closed captions ..." + cccheck);
			Assert.assertEquals(cccheck.equals("suppose we belong to\n" + "a primitive barbarian tribe."), true);
		}

		catch (AssertionError error) {
			WebElement cc = super.globalDriver.findElement(By.cssSelector("div[style*='direction']"));
			String cccheck = cc.getText().toLowerCase();
			throw new RuntimeException("Not as expected....." + cccheck);
		}
	}

	@Test(priority = 9)
	public void nextEpisodeTest() throws InterruptedException, IOException {
		// Implicit super.globalWait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Grab name of next episode
		String nextEpisodeName = super.globalPlayer.grabNameofNextEpisode();

		// Click next episode
		super.globalPlayer.clickNextEpisode();

		// Grab name of current episode
		String currentEpisodeName = super.globalPlayer.grabNameOfCurrentEpisode();

		try {
			Assert.assertEquals(nextEpisodeName.equals(currentEpisodeName), true);
		}

		catch (AssertionError error) {
			throw new RuntimeException(nextEpisodeName + "Not as expected....." + currentEpisodeName);
		}

	}

	@Test(priority = 10)
	public void autoplayTest() throws InterruptedException, IOException {
		// Implicit super.globalWait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Grab name of next episode
		String nextEpisodeName = super.globalPlayer.grabNameofNextEpisode();

		// Grab time of current episode
		try {
			super.globalWait.until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='vjs-loading-spinner']")));
			super.globalWait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.cssSelector("div[class='vjs-loading-spinner']")));
		} catch (Exception pl) {

		}
		super.globalActions.moveToElement(super.globalDriver.findElement(By.id("vjs_video_3_html5_api"))).build()
				.perform();
		super.globalActions.moveToElement(super.globalDriver.findElement(By.id("vjs_video_3_html5_api"))).build()
				.perform();
		super.globalWait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='vjs-duration-display']")));
		String totalVideoTime = super.globalDriver.findElement(By.cssSelector("span[class='vjs-duration-display']"))
				.getText();

		String[] durationArray = totalVideoTime.split(":");

		int hours = 0;
		int minutes = 0;
		int seconds = 0;

		// mm:ss
		if (durationArray.length == 2) {
			minutes = Integer.parseInt(durationArray[0]) * 60;
			seconds = Integer.parseInt(durationArray[1]);
		}
		// hh:mm:ss
		if (durationArray.length == 3) {
			hours = Integer.parseInt(durationArray[0]) * 60 * 60;
			minutes = Integer.parseInt(durationArray[1]) * 60;
			seconds = Integer.parseInt(durationArray[2]);
		}

		int totalVideoDurationSeconds = hours + minutes + seconds;

		int scrubSeconds = totalVideoDurationSeconds;
		Thread.sleep(500);
		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
		super.globalJs.executeScript("videojs('vjs_video_3').currentTime(" + scrubSeconds + ")"); // to seek in seconds
		Thread.sleep(500);
		try {
			super.globalWait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.cssSelector("div[class='vjs-loading-spinner']")));
		} catch (Exception pl) {

		}

		// Grab name of current episode
		String currentEpisodeName = super.globalPlayer.grabNameOfCurrentEpisode();

		try {
			Assert.assertEquals(nextEpisodeName.equals(currentEpisodeName), true);
		}

		catch (AssertionError error) {
			throw new RuntimeException(nextEpisodeName + "Not as expected....." + currentEpisodeName);
		}

	}

	@Test(priority = 99)
	public void signOut() throws InterruptedException, IOException {
		
		try {
			super.globalDriver.findElement(By.cssSelector("button[class='close ']")).click();
		} catch (Exception err) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println("No close button...");
		}
		
		super.globalUser.signOut();
	}

}