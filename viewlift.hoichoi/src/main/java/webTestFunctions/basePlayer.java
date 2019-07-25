package webTestFunctions;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class basePlayer {
	// ChromeOptions opt = new ChromeOptions();

	WebDriver driver;
	WebDriverWait wait;
	WebDriverWait waitAds;// Explicit wait
	WebDriverWait waitLoader;
	JavascriptExecutor scroll; // Scroll
	Actions actions; // Actions
	Random random; // Random
	int randin;
	JavascriptExecutor js;
	String searchword;

	public basePlayer(WebDriver driver1) {
		driver = driver1;
		wait = new WebDriverWait(driver, 15); // Explicit wait
		waitAds = new WebDriverWait(driver, 20); // Explicit wait
		waitLoader = new WebDriverWait(driver, 3); // Explicit wait
		scroll = (JavascriptExecutor) driver; // Scroll
		actions = new Actions(driver); // Actions
		random = new Random(); // Random
		randin = random.nextInt(1000000);
		js = (JavascriptExecutor) driver;
		searchword = ("series");
	}
	
	public void playerScruber() throws InterruptedException {
		
		int scrubSeconds = 20;
		
//		if (site.equals("kronon")) scrubSeconds = 20;
		
			
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		js.executeScript("videojs('vjs_video_3').currentTime(" + scrubSeconds + ")"); // to seek in seconds

		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		
		js.executeScript("videojs('vjs_video_3').pause()");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		
		Thread.sleep(1000);
		WebElement currenttime = driver.findElement(By.cssSelector("span[class='vjs-current-time-display']"));
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='vjs-current-time-display']")));
		String timer = currenttime.getText();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();

//		try {
//			if (site.equals("kronon")) {
//				actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
//				Assert.assertEquals(timer.equals("0:20"), true);
//				System.out.println("Timer is ... " + timer);
//			} else {
//				actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
//				Assert.assertEquals(timer.equals("1:03"), true);
//				System.out.println("Timer is ... " + timer);
//			}
		try {
				actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
				Assert.assertEquals(timer.equals("0:20"), true);
				System.out.println("Timer is ... " + timer);
		} catch (AssertionError error) {
			actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println("Not as expected ....." + timer);
			throw new RuntimeException("Not as expected ....." + timer);
			
		}
	}

	
	public void playerJustScrub() throws InterruptedException {
		int scrubSeconds = 63;
		
//		if (site.equals("hoichoi")) scrubSeconds = 88;
		
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		//js.executeScript("videojs(‘vjs_video_3’).userActive(true)");
		js.executeScript("videojs('vjs_video_3').currentTime(" + scrubSeconds + ")"); // to seek in seconds
		js.executeScript("videojs('vjs_video_3').pause()");
	}


	public void clickvideo() throws InterruptedException {
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='vjs-control-bar']")));
		WebElement popup = driver.findElement(By.cssSelector("div[class='popup-view']"));
		popup.findElement(By.cssSelector("a[href*='videos'], a[href*='video'], a[href*='films']")).click();
	}

	
	public void checkLoaderPresence () throws InterruptedException {
		Thread.sleep(500);
		try {
			waitLoader.until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='vjs-loading-spinner']")));
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.cssSelector("div[class='vjs-loading-spinner']")));
		} catch (Exception pl) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		}
	}
	
	public void fullscreenOfVideo() throws InterruptedException {
		Thread.sleep(500);
		try {
			waitLoader.until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='vjs-loading-spinner']")));
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.cssSelector("div[class='vjs-loading-spinner']")));
		} catch (Exception pl) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		}
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
		driver.findElement(By.cssSelector("button[title*='Fullscreen']")).click();
		Thread.sleep(300);
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
		WebElement Fullscreen = driver.findElement(By.cssSelector("button[title='Non-Fullscreen']"));
		String FullscreenPlayer = Fullscreen.getText();
		try {
			Assert.assertEquals(FullscreenPlayer.equals("Non-Fullscreen"), true);
			System.out.println("Video fullscreen...." + FullscreenPlayer);
		} catch (AssertionError error) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println("Video fullscreen...." + FullscreenPlayer);
			throw new RuntimeException("Not as expected ....." + FullscreenPlayer);
		}

	}

	public void videoPlaysProve() throws InterruptedException {
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		
		try {
			js.executeScript("videojs('vjs_video_3').play()");

		} catch (AssertionError error) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
		}
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
		WebElement playvideoprove = driver.findElement(By.cssSelector("button[title='Pause']"));
		String playicon = playvideoprove.getText();
		System.out.println("Video plays...." + playicon);

		try {
			Assert.assertEquals(playicon.equals("Pause"), true);

		} catch (AssertionError error) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			throw new RuntimeException("Not as expected ....." + playicon);
		}

	}

	public void videoPausedProve() throws InterruptedException {
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
		
		try {
			js.executeScript("videojs('vjs_video_3').pause()");
			System.out.println("play off");

		}catch (Exception err) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		}
		
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
		WebElement videoPausedProve = driver.findElement(By.cssSelector("button[title='Play']"));
		String playicon = videoPausedProve.getText();
		System.out.println("Video paused ...." + playicon);
		try {
			Assert.assertEquals(playicon.equals("Play"), true);
		} catch (AssertionError error) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			throw new RuntimeException("Not as expected ....." + playicon);
		}
	}

	public void clickTopauseVideo() throws InterruptedException {
		js.executeScript("videojs('vjs_video_3').pause()");
	}
	
	public void clickTopPlayVideo() throws InterruptedException {
		js.executeScript("videojs('vjs_video_3').play()");
	}

	public void muteFuntion() throws InterruptedException {
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='vjs-control-bar']")));
		
		try {
			actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
			driver.findElement(By.cssSelector("button[class='vjs-mute-control vjs-control vjs-button vjs-vol-0']")).click();
		} catch (Exception err) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		}
		
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
		WebElement mutebuttonOFF = driver
				.findElement(By.cssSelector("button[class='vjs-mute-control vjs-control vjs-button vjs-vol-3']"));
		String muteiconOFF = mutebuttonOFF.getText();
		System.out.println("muteiconON...." + muteiconOFF);
		// Check that sound on
		try {
			Assert.assertEquals(muteiconOFF.equals("Mute"), true);
		} catch (AssertionError error) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			throw new RuntimeException("Not as expected ....." + muteiconOFF);
		}

		// Click to mute sound
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		mutebuttonOFF.click();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
		WebElement mutebuttonON = driver
				.findElement(By.cssSelector("button[class='vjs-mute-control vjs-control vjs-button vjs-vol-0']"));
		String muteiconOn = mutebuttonON.getText();
		System.out.println("muteiconOFF...." + muteiconOn);
		// Check that sound off
		Thread.sleep(500);
		try {
			Assert.assertEquals(muteiconOn.equals("Unmute"), true);
		} catch (AssertionError error) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			throw new RuntimeException("Not as expected ....." + muteiconOn);
		}
	}

	public void rendition() throws InterruptedException {
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
		actions.moveToElement(driver.findElement(By.cssSelector("div[class='vjs-control vjs-resolution']"))).build()
				.perform();
		WebElement ren = driver.findElement(By.cssSelector("div[class='vjs-control vjs-resolution']"));
		WebElement firstrendition = ren.findElement(By.cssSelector("ul > li:nth-child(1)"));
		String grabFirstRenditionInList = firstrendition.getText();
		try {
			Thread.sleep(500);
			actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
			actions.moveToElement(driver.findElement(By.cssSelector("div[class='vjs-control vjs-resolution']"))).build()
					.perform();

			WebElement rendition = driver.findElement(By.cssSelector("div[class='vjs-control vjs-resolution']"));
			rendition.findElement(By.cssSelector("ul > li:nth-child(1)")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='vjs-control-bar']")));
			actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
			actions.moveToElement(driver.findElement(By.cssSelector("div[class='vjs-control vjs-resolution']"))).build()
					.perform();

			// Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
			actions.moveToElement(driver.findElement(By.cssSelector("div[class='vjs-control vjs-resolution']"))).build()
			.perform();
			WebElement firstren = rendition.findElement(By.cssSelector("ul > li:nth-child(1)"));
			String renditioncheck = firstren.getText();
			System.out.println("Rendition...." + renditioncheck);

			Assert.assertEquals(renditioncheck.equals(grabFirstRenditionInList), true);
		} catch (AssertionError error) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			throw new RuntimeException("Not as expected... " + grabFirstRenditionInList);
		}
	}

	public void rewind15seconds() throws InterruptedException {
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='vjs-control-bar']")));
		js.executeScript("videojs('vjs_video_3').currentTime(60)"); // to seek in seconds
		js.executeScript("videojs('vjs_video_3').pause()");

		// Rewind 15 seconds
		Thread.sleep(500);
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='vjs-control-bar']")));
		driver.findElement(By.cssSelector("svg[class=' icon icon-rewind']")).click();
		Thread.sleep(500);
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("vjs_video_3_html5_api")));
		Thread.sleep(500);
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		WebElement currenttime = driver.findElement(By.cssSelector("span[class='vjs-current-time-display']"));
		String showcurrenttime = currenttime.getText();

		try {
			Assert.assertEquals(showcurrenttime.equals("0:45"), true);
		} catch (AssertionError error) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			throw new RuntimeException("Not as expected " + showcurrenttime);
		}

	}

	public void regularClosedCaptions() throws InterruptedException {

		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='vjs-control-bar']")));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='vjs-control-bar']")));
			actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
			actions.moveToElement(driver.findElement(By.cssSelector("div[class*='vjs-subs-caps-button']"))).build()
					.perform();
			driver.findElement(By.cssSelector(
					"li[class='vjs-menu-item vjs-subtitles-menu-item'],li[class='vjs-menu-item vjs-captions-menu-item']"))
					.click();
			// Multiple Closed Captions
			// player.driver.findElement(By.cssSelector("ul > li:nth-child(3)")).click();
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[style*='direction']")));
			WebElement cc = driver.findElement(By.cssSelector("div[style*='direction']"));
			String cccheck = cc.getText().toLowerCase();
			System.out.println("Closed captions ..." + cccheck);
			Assert.assertEquals(cccheck.equals("welcome to major league fishing's general tire"), true);
		}

		catch (AssertionError error) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebElement cc = driver.findElement(By.cssSelector("div[style*='direction']"));
			String cccheck = cc.getText().toLowerCase();
			throw new RuntimeException("Not as expected....." + cccheck);
		}
	}

	public void multyClosedCaptions() throws InterruptedException {
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='vjs-control-bar']")));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='vjs-control-bar']")));
			actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
			actions.moveToElement(driver.findElement(By.cssSelector("div[class*='vjs-subs-caps-button']"))).build()
					.perform();

			// Multiple Closed Captions English
			WebElement ccicon = driver.findElement(By.cssSelector("div[class*='vjs-subs-caps-button']"));
			ccicon.findElement(By.cssSelector("ul > li:nth-child(3)")).click();
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[style*='direction']")));
			WebElement cc = driver.findElement(By.cssSelector("div[style*='direction']"));
			String cccheck = cc.getText();
			System.out.println("Closed captions ..." + cccheck);
			Assert.assertEquals(cccheck.equals("and then one pops up."), true);
		}

		catch (AssertionError error) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebElement cc = driver.findElement(By.cssSelector("div[style*='direction']"));
			String cccheck = cc.getText().toLowerCase();
			throw new RuntimeException("Not as expected....." + cccheck);
		}

		Thread.sleep(500);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='vjs-control-bar']")));
			actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
			actions.moveToElement(driver.findElement(By.cssSelector("div[class*='vjs-subs-caps-button']"))).build()
					.perform();

			// Multiple Closed Captions German
			WebElement ccicon = driver.findElement(By.cssSelector("div[class*='vjs-subs-caps-button']"));
			ccicon.findElement(By.cssSelector("ul > li:nth-child(4)")).click();
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[style*='direction']")));
			WebElement cc = driver.findElement(By.cssSelector("div[style*='direction']"));
			String cccheck = cc.getText();
			System.out.println("Closed captions ..." + cccheck);
			Assert.assertEquals(cccheck.equals("obwohl es andere gute Gelegenheiten gibt."), true);
		}

		catch (AssertionError error) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebElement cc = driver.findElement(By.cssSelector("div[style*='direction']"));
			String cccheck = cc.getText().toLowerCase();
			throw new RuntimeException("Not as expected....." + cccheck);
		}
		Thread.sleep(500);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='vjs-control-bar']")));
			actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
			actions.moveToElement(driver.findElement(By.cssSelector("div[class*='vjs-subs-caps-button']"))).build()
					.perform();

			// Multiple Closed Captions French
			WebElement ccicon = driver.findElement(By.cssSelector("div[class*='vjs-subs-caps-button']"));
			ccicon.findElement(By.cssSelector("ul > li:nth-child(5)")).click();
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[style*='direction']")));
			WebElement cc = driver.findElement(By.cssSelector("div[style*='direction']"));
			String cccheck = cc.getText();
			System.out.println("Closed captions ..." + cccheck);
			Assert.assertEquals(cccheck.equals("tandis qu'un autre surgit."), true);
		}

		catch (AssertionError error) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebElement cc = driver.findElement(By.cssSelector("div[style*='direction']"));
			String cccheck = cc.getText().toLowerCase();
			throw new RuntimeException("Not as expected....." + cccheck);
		}

	}

	public void seriesPlay() throws InterruptedException, IOException {

		try {
			Thread.sleep(500);
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

			driver.findElement(By.cssSelector("div[class='close-button']")).click();
		}

		catch (Exception coo) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		}

		// Open search
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='search-icon']")));
		driver.findElement(By.cssSelector("div[class='search-icon']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[class='search-container-input']")));
		driver.findElement(By.cssSelector("input[class='search-container-input']")).sendKeys(searchword);

		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='search-results']")));

		WebElement popup = driver.findElement(By.cssSelector("div[class='popup-view']"));
		popup.findElement(By.cssSelector("a[href*='shows'],a[href*='series'] ")).click();

		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='show__hero']")));
		scroll.executeScript("window.scrollBy(0,400)");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='button cta']")));
		driver.findElement(By.cssSelector("button[class='button cta']")).click();
	}

	public void ads() throws InterruptedException {
		try {
			Thread.sleep(500);

			waitAds.until(ExpectedConditions
					.invisibilityOfElementLocated(By.cssSelector("div[class='videoAdUi imaVideoAdUi']")));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
			Thread.sleep(500);
		} catch (Exception ads) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		}
	}

	public String grabNameOfCurrentEpisode() throws InterruptedException {
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='overlay-episode-details']")));
		WebElement overlayEpisodeDetail = driver.findElement(By.cssSelector("div[class='overlay-episode-details']"));
		Thread.sleep(500);
		try {
			waitLoader.until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='vjs-loading-spinner']")));
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.cssSelector("div[class='vjs-loading-spinner']")));
		} catch (Exception pl) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='overlay-episode-details']")));
		String currentEpisodeName = overlayEpisodeDetail.findElement(By.cssSelector("div > span:nth-child(2)"))
				.getText();
		System.out.println(currentEpisodeName);

		return currentEpisodeName;
	}

	public String grabNameofNextEpisode() throws InterruptedException {
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='overlay-episode-details']")));
			WebElement overlayEpisodeDetail = driver
					.findElement(By.cssSelector("div[class='overlay-episode-details']"));
			String nextEpisodeName = overlayEpisodeDetail.findElement(By.cssSelector("div > p:nth-child(2)")).getText();
			System.out.println(nextEpisodeName);
			return nextEpisodeName;
		}

	}

	public void clickNextEpisode() throws InterruptedException {
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='overlay-episode-details']")));
		WebElement overlayEpisodeDetail = driver.findElement(By.cssSelector("div[class='overlay-episode-details']"));

		overlayEpisodeDetail.findElement(By.cssSelector("div[class='next-episode']")).click();
		Thread.sleep(500);
	}

}