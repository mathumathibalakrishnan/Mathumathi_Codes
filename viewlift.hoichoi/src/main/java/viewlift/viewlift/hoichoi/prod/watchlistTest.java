package viewlift.viewlift.hoichoi.prod;

import org.testng.annotations.Test;
import webTestFunctions.globalDrivers;

import org.testng.Assert;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class watchlistTest extends globalDrivers {

	@Test(priority = 0)
	public void checkWatchlistEmpty() throws InterruptedException, IOException {

		// Open watchlist
		super.globalSite.openWatchlist();

		Thread.sleep(500);
		// Check watchlist
		super.globalSite.checkWatchlistEmpty();

	}

	@Test(priority = 1)
	public void checkRemoveIconOnShowDetailPage() throws InterruptedException, IOException

	{
		// Back to home page
		super.globalDriver.findElement(By.cssSelector("div[class='logo-container']")).click();

		// Open video tab
		super.globalDriver.findElement(By.cssSelector("a[href*='/videos/'],a[href*='films']")).click();

		// Wait
		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='add-watchlist site-color']")));

		// Grab Show name
		String showTitle = super.globalSite.grabVideoName();

		// Add to watchlist from show page
		super.globalDriver.findElement(By.cssSelector("div[class='add-watchlist site-color']")).click();

		// Open watchlist
		super.globalSite.openWatchlist();

		// Grab titles of added assets
		String showTitleInWatchlist = super.globalSite.grabTitleOfAddedAssetOnWatchlistPage();
		Thread.sleep(500);
		// Check Added Assets
		try {
			Assert.assertEquals(showTitle.toLowerCase(), showTitleInWatchlist.toLowerCase());
			System.out.println(showTitleInWatchlist + showTitle);
		} catch (Exception err) {
			super.globalDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println(showTitleInWatchlist + showTitle);
		}

		// Navigate back to show page
		super.globalDriver.findElement(By.cssSelector("a[class='logo']")).click();

		// Open video tab
		super.globalDriver.findElement(By.cssSelector("a[href*='/videos/'],a[href*='films']")).click();

		// Wait
		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='remove-watchlist site-color']")));

		// Click Remove icon
		super.globalDriver.findElement(By.cssSelector("div[class='remove-watchlist site-color']")).click();

		// Open Watchlsit
		super.globalSite.openWatchlist();
		Thread.sleep(500);
		// Check Watchlist Empty
		super.globalSite.checkWatchlistEmpty();

	}

	@Test(priority = 2)
	public void checkRemoveIconOnThumbnail() throws InterruptedException, IOException {

		// Open search
		super.globalSite.search();

		// Grab name of video that will be added
		String NameOfVideo = super.globalSite.grabNameOfVideoThatWillBeAdded();

		// Click on add button on video Thumbnail
		super.globalSite.clickOnAddButtonOnVideoThumbnail();

		// Open home
		super.globalDriver.findElement(By.cssSelector("button[class='close ']")).click();
		super.globalSite.openHome();
		super.globalSite.openWatchlist();

		// Grab titles of added assets
		String showTitleInWatchlist = super.globalSite.grabTitleOfAddedAssetOnWatchlistPage();
		Thread.sleep(500);
		// Check Added Assets
		try {
			Assert.assertEquals(NameOfVideo, showTitleInWatchlist);
			System.out.println("As expected  .." + showTitleInWatchlist + NameOfVideo);
		} catch (Exception err) {
			super.globalDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println("Not As expected  .." + showTitleInWatchlist + "...." + NameOfVideo);
		}

		// Navigate back to search page
		super.globalSite.search();

		// Open series tab
		super.globalSite.removeFromWarchlistThumbnail();

		// Open home
		super.globalDriver.findElement(By.cssSelector("button[class='close ']")).click();
		super.globalSite.openHome();
		super.globalSite.openWatchlist();

		// Check Watchlist Empty
		super.globalSite.checkWatchlistEmpty();

	}

	@Test(priority = 3)
	public void addToWatchlistFromDetailPage() throws InterruptedException, IOException

	{

		// Back to home page
		super.globalDriver.findElement(By.cssSelector("div[class='logo-container']")).click();

		// Open video tab
		super.globalDriver.findElement(By.cssSelector("a[href*='/videos/'],a[href*='films']")).click();

		// Wait
		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='add-watchlist site-color']")));

		// Grab Show name
		String showTitle = super.globalSite.grabVideoName();

		// Add to watchlist from show page
		super.globalDriver.findElement(By.cssSelector("div[class='add-watchlist site-color']")).click();

		// Open watchlist
		super.globalSite.openWatchlist();

		// Grab titles of added assets
		String showTitleInWatchlist = super.globalSite.grabTitleOfAddedAssetOnWatchlistPage();
		Thread.sleep(500);
		// Check Added Assets
		try {
			Assert.assertEquals(showTitle.toLowerCase(), showTitleInWatchlist.toLowerCase());
			System.out.println(showTitleInWatchlist + showTitle);
		} catch (Exception err) {
			super.globalDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println(showTitleInWatchlist + showTitle);
		}

	}

	@Test(priority = 4)
	public void removeAssetFromWatchlist() throws InterruptedException, IOException

	{
		Thread.sleep(500);
		super.globalDriver.findElement(By.cssSelector("i[class='link ion-close']")).click();
		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='list-empty']")));
		Thread.sleep(500);
		// Check empty list
		super.globalSite.checkWatchlistEmpty();

	}

	@Test(priority = 5)
	public void addToWatchlistFromVideoThumbnail() throws InterruptedException, IOException {

		// Open search
		super.globalSite.search();

		// Grab name of video that will be added
		String NameOfVideo = super.globalSite.grabNameOfVideoThatWillBeAdded();

		// Click on add button on video Thumbnail
		super.globalSite.clickOnAddButtonOnVideoThumbnail();

		super.globalDriver.findElement(By.cssSelector("button[class='close ']")).click();

		// Open watchlist
		super.globalSite.openWatchlist();

		// Grab titles of added assets
		String showTitleInWatchlist = super.globalSite.grabTitleOfAddedAssetOnWatchlistPage();
		Thread.sleep(500);
		// Check Added Assets
		try {
			Assert.assertEquals(NameOfVideo, showTitleInWatchlist);
			System.out.println("As expected  .." + showTitleInWatchlist + NameOfVideo);
		} catch (Exception err) {
			super.globalDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println("Not As expected  .." + showTitleInWatchlist + "...." + NameOfVideo);
		}

	}

	@Test(priority = 6)
	public void WatchlistClearAllNo() {

		// Watchlist Clear All No
		super.globalSite.WatchlistClearAllNo();

		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='title']")));
		int asset = driver.findElements(By.cssSelector("div[class='title']")).size();
		if (asset == 0) {

			System.out.println("No Assets on this page");
			Assert.assertEquals(true, false);

		}
	}

	@Test(priority = 7)
	public void WatchlistClearAllxxxxX() {

		// WatchlistClearAll"X"
		super.globalSite.WatchlistClearAllxxxX();

		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='title']")));
		int asset = driver.findElements(By.cssSelector("div[class='title']")).size();
		if (asset == 0) {

			System.out.println("No Assets on this page");
			Assert.assertEquals(true, false);

		}
	}

	@Test(priority = 8)
	public void WatchlistClearAllYes() throws InterruptedException {

		// Clear watchlist YES
		super.globalSite.WatchlistClearAllYes();

		// Get text that list empty
		super.globalSite.checkWatchlistEmpty();
	}

}
