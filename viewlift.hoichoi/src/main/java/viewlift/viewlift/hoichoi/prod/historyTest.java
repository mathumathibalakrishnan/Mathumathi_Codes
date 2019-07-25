package viewlift.viewlift.hoichoi.prod;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import webTestFunctions.globalDrivers;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class historyTest extends globalDrivers {

	@Parameters({ "site" })
	@Test(priority = 0)
	public void checkHistoryEmpty(String site) throws InterruptedException, IOException {

		// Implicit wait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Open Site
		String url = super.globalSite.getSiteUrl(site);
		super.globalDriver.get(url);
		super.globalDriver.manage().window().fullscreen();

		// Open history
		super.globalSite.openHistory();
		
		// Clear if needed 
		try {
			Thread.sleep(500);
			super.globalDriver.findElement(By.cssSelector("i[class='link ion-close']")).click();
			super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='list-empty']")));
		} catch (Exception err) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		}

		// Check that History empty
		super.globalSite.checkWatchlistEmpty(); // code same for History
	}

	@Test(priority = 1)
	public void addVideoToHistoryFromSearch() throws InterruptedException {

		// Open search and search for "Art"
		super.globalSite.search();

		// Play video
		super.globalSite.clickVideoFromSearch();

		// Grab title of video
		String videoTitle = super.globalSite.grabVideoName();
		Thread.sleep(31000);

		// Check video in history
		super.globalSite.openHistory();
		String showTitleInWatchlist = super.globalSite.grabTitleOfAddedAssetOnWatchlistPage(); // same code for history

		// Check Added Assets
		try {
			AssertJUnit.assertEquals(videoTitle.toLowerCase(), showTitleInWatchlist.toLowerCase());
			System.out.println(showTitleInWatchlist + videoTitle);
		} catch (Exception err) {
			super.globalDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println(showTitleInWatchlist + videoTitle);
		}

	}

	@Test(priority = 2)
	public void removeVideoFromHistory() throws InterruptedException {

		// SAME CODE AS FOR WATCHLIST
		Thread.sleep(500);
		super.globalDriver.findElement(By.cssSelector("i[class='link ion-close']")).click();
		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='list-empty']")));

		// Check empty list
		super.globalSite.checkWatchlistEmpty();
	}

	@Test(priority = 3)
	public void addVideoToHistoryFromHomePage() throws InterruptedException {

		// Open home
		super.globalSite.openHome();

		// Play video
		super.globalSite.clickVideoFromHomePage();
		

		// Grab title of video
		String videoTitle = super.globalSite.grabVideoName();

		// Scrub
		Thread.sleep(31000);

		// Check video in history
		super.globalSite.openHistory();
		String showTitleInWatchlist = super.globalSite.grabTitleOfAddedAssetOnWatchlistPage(); // same code for history

		// Check Added Assets
		try {
			AssertJUnit.assertEquals(videoTitle.toLowerCase(), showTitleInWatchlist.toLowerCase());
			System.out.println(showTitleInWatchlist + videoTitle);
		} catch (Exception err) {
			super.globalDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println(showTitleInWatchlist + videoTitle);
		}

	}

	@Test(priority = 4)
	public void HistoryClearAllNo() {

		// Watchlist Clear All No
		super.globalSite.WatchlistClearAllNo();

		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='title']")));
		int asset = driver.findElements(By.cssSelector("div[class='title']")).size();
		if (asset == 0) {

			System.out.println("No Assets on this page");
			AssertJUnit.assertEquals(true, false);

		}
	}

	@Test(priority = 5)
	public void HistoryClearAllxxxxX() {

		// WatchlistClearAll"X"
		super.globalSite.WatchlistClearAllxxxX();

		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='title']")));
		int asset = driver.findElements(By.cssSelector("div[class='title']")).size();
		if (asset == 0) {

			System.out.println("No Assets on this page");
			AssertJUnit.assertEquals(true, false);

		}
	}

	@Test(priority = 6)
	public void HistoryClearAllYes() throws InterruptedException {
		// Clear watchlist YES
		super.globalSite.WatchlistClearAllYes();

		// Get text that list empty
		super.globalSite.checkWatchlistEmpty();
	}

}
