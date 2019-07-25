package webTestFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class baseSite {

	WebDriver driver;
	WebDriverWait wait; // Explicit wait
	JavascriptExecutor scroll; // Scroll
	Actions actions; // Actions
	Random random; // Random
	int randin;
	JavascriptExecutor js;
	String searchword;

	public baseSite(WebDriver driver1) {
		driver = driver1;
		wait = new WebDriverWait(driver, 15); // Explicit wait
		scroll = (JavascriptExecutor) driver; // Scroll
		actions = new Actions(driver); // Actions
		random = new Random(); // Random
		randin = random.nextInt(1000000);
		js = (JavascriptExecutor) driver;
		searchword = ("art");
	}

	public String getSiteUrl(String site) throws IOException {
		return this.getconfigfile().getProperty("site" + "." + site);
	}

	public String getSiteUsername(String site) throws IOException {
		return this.getconfigfile().getProperty("username" + "." + site);
	}

	public String getSitePassword(String site) throws IOException {
		return this.getconfigfile().getProperty("password" + "." + site);
	}

	public String getFacebookUsername(String site) throws IOException {
		return this.getconfigfile().getProperty("facebook.username" + "." + site);
	}

	public String getFacebookPassword(String site) throws IOException {
		return this.getconfigfile().getProperty("facebook.password" + "." + site);
	}

	public static String usingBufferedReader(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				contentBuilder.append(sCurrentLine).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentBuilder.toString();
	}

	public Properties getconfigfile() throws IOException {

		Properties prop = new Properties();

		String currentPath = System.getProperty("user.dir");
		String configFileLocation = currentPath + "/src/test/java/webTestFunctions/site_config.txt";

		String data = usingBufferedReader(configFileLocation);

		prop.load(new StringReader(data));

		return prop;
	}

	public void clickEveryLinkInmenu() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav[class='masthead  ']")));
		WebElement menu = driver.findElement(By.cssSelector("nav[class*='navigation']"));
		String clickCommand = Keys.chord(Keys.COMMAND, Keys.LEFT_SHIFT + "t", Keys.ENTER);

		// Hover first
		try {
			actions.moveToElement(
					driver.findElement(By.cssSelector("div[class='menu-dropdown-container sub-menu-items']"))).build()
					.perform();
		} catch (Exception err) {
		}

		List<WebElement> topNavigationMenu = menu.findElements(By.tagName("a"));

		int menuSize = topNavigationMenu.size();

		for (int i = 1; i < menuSize; i++) {

			// 1. Iterate through hovered drop
			// 2. when done clicking all subelements, click the parent of the hover

			if (i + 1 == menuSize) {
				topNavigationMenu.get(0).sendKeys(clickCommand);
			}

			if (!topNavigationMenu.get(i).getText().toLowerCase().equals("shop")) {
				topNavigationMenu.get(i).sendKeys(clickCommand);
			}
		}
	}

	public String numberOfItemsInmenu() {
		// Number of menu items before sign in
		WebElement header = driver.findElement(By.cssSelector("nav[class=navigation]"));
		int intItemsInMenu = header.findElements(By.tagName("a")).size();
		String numberOfMenuItemsBeforeSignIn = Integer.toString(intItemsInMenu);
		return numberOfMenuItemsBeforeSignIn;
	}

	// Number of menu items after sign in

	public String numberOfItemsInMenuAfterSignIn() {
		WebElement header2 = driver.findElement(By.cssSelector("nav[class=navigation]"));
		int intnumberofmenuitems = header2.findElements(By.tagName("a")).size();
		String numberOfMenuItemsAfterSignIn = Integer.toString(intnumberofmenuitems);
		return numberOfMenuItemsAfterSignIn;
	}

	public void footer() {
		WebElement footer = driver
				.findElement(By.cssSelector("div[class='footer02__center'], div[class*='footer01__content footer']"));

		for (int i = 0; i < footer.findElements(By.tagName("a")).size(); i++)

		{

			String click = Keys.chord(Keys.COMMAND, Keys.LEFT_SHIFT + "t", Keys.ENTER);

			if (!footer.findElements(By.tagName("a")).get(i).getText().equals("Contact Us")) {
				footer.findElements(By.tagName("a")).get(i).sendKeys(click);
			} else {

			}

		}
	}

	public void checkLinksFor404() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Set<String> tab = driver.getWindowHandles();
		java.util.Iterator<String> nexttab = tab.iterator();

		while (nexttab.hasNext())

		{

			driver.switchTo().window(nexttab.next());
			String url = driver.getCurrentUrl();
			try {
				WebElement error404 = driver.findElement(By.cssSelector("h1[class='fade__content']"));
				String error = error404.getText();
				System.out.println(url + "..   Error 404");
				Assert.assertEquals(error.equals("404"), false);

			} catch (Exception e) {

				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

			}
		}
	}

	public void checkLinksFor404andEmptyPages() throws InterruptedException {
		Set<String> tab = driver.getWindowHandles();
		java.util.Iterator<String> nexttab = tab.iterator();

		while (nexttab.hasNext())

		{

			driver.switchTo().window(nexttab.next());
			String url = driver.getCurrentUrl();
			Thread.sleep(500);
			int modulesInt = driver.findElements(By.cssSelector("div[class='module ']")).size();

			if (modulesInt == 0) {
				System.out.println("No modules on this page, url is " + url);
				Assert.assertEquals(true, false);
			}

			try {
				// Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[class='logo-image']")));
				WebElement error404 = driver.findElement(By.cssSelector("h1[class='fade__content']"));
				String error = error404.getText();
				System.out.println(url + "..   Error 404");
				Assert.assertEquals(error.equals("404"), false);

			} catch (Exception e) {

				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

			}
		}
	}

	public void search() throws InterruptedException {
		// Open search
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav[class='masthead  ']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='search-icon']")));
		driver.findElement(By.cssSelector("div[class='search-icon']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[class='search-container-input']")));
		driver.findElement(By.cssSelector("input[class='search-container-input']")).sendKeys(searchword);

		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='search-results']")));
	}

	public void clickSeriesFromSearch() throws InterruptedException {
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='search-results']")));

		WebElement popup = driver.findElement(By.cssSelector("div[class='popup-view']"));
		popup.findElement(By.cssSelector("a[href*='shows'],a[href*='series'] ")).click();

		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='show__hero']")));
	}

	public void clickVideoFromSearch() throws InterruptedException {
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='search-results']")));

		WebElement popup = driver.findElement(By.cssSelector("div[class='popup-view']"));
		popup.findElement(By.cssSelector("a[href*='videos'],a[href*='video'],a[href*='films']")).click();

		try {
			js.executeScript("videojs('vjs_video_3').play()");
		} catch (Exception err) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		}

		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));

	}

	public void cookies() throws IOException {

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

			driver.findElement(By.cssSelector("div[class='close-button']")).click();
		}

		catch (Exception coo) {

		}
	}

	public void clickVODforSigninWithPreview() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='videos'],a[href*='films'], a[href*='films']")));
		driver.findElement(By.cssSelector("a[href*='videos'],a[href*='films'],a[href*='films']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
		Thread.sleep(500);
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector("button[class='vjs-big-play-button']")).click();
		} catch (Exception p) {

		}
		actions.moveToElement(driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));

		WebElement slider = driver
				.findElement(By.cssSelector("div[class='vjs-progress-holder vjs-slider vjs-slider-horizontal']"));
		actions.dragAndDropBy(slider, 300, 0).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='cta login-btn']")));
		driver.findElement(By.cssSelector("button[class='cta login-btn']")).click();

	}

	public void clickVODforSignin() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='videos'],a[href*='films']")));
		driver.findElement(By.cssSelector("a[href*='videos'],a[href*='films']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='cta login-btn']")));
		driver.findElement(By.cssSelector("button[class='cta login-btn']")).click();

	}

	public void watchNowSignIn() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='button cta']")));
		driver.findElement(By.cssSelector("button[class='button cta']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='cta login-btn']")));
		driver.findElement(By.cssSelector("button[class='cta login-btn']")).click();

	}

	public void close() {
		driver.quit();
	}

	// Open History
	public void openHistory() throws InterruptedException {
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav[class='masthead  ']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='user-buttons']")));
		actions.moveToElement(driver.findElement(By.cssSelector("div[class='user-buttons']"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("History")));
		driver.findElement(By.linkText("History")).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
	}

	// Open Watchlist
	public void openWatchlist() throws InterruptedException {
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav[class='masthead  ']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='user-buttons']")));
		actions.moveToElement(driver.findElement(By.cssSelector("div[class='user-buttons']"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Watchlist")));
		driver.findElement(By.partialLinkText("Watchlist")).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
	}

	public void checkWatchlistEmpty() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='list-empty']")));
		WebElement watchlistPage = driver.findElement(By.cssSelector("div[class='list-empty']"));
		String watchlistEmpty = watchlistPage.getText();

		try {
			Assert.assertEquals(watchlistEmpty, "Your list is Empty!");
			System.out.println(watchlistEmpty);
		} catch (Exception err) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			System.out.println(watchlistEmpty);
		}

	}

	public String grabShowname() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='title']")));
		WebElement showName = driver.findElement(By.cssSelector("span[class='title']"));
		String showTitle = showName.getText();
		return showTitle;
	}

	public String grabVideoName() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("h1[class*='header']")));
		WebElement videoName = driver.findElement(By.cssSelector("h1[class*='header']"));
		String videoTitle = videoName.getText();
		return videoTitle;
	}

	public void openSeriesFromMainCarousel() throws InterruptedException {
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class*='carousel ']")));
		driver.findElement(By.cssSelector("div[class*='carousel ']")).click();
	}

	public void addToWarchlistFromShowPage() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='desktop-share']")));
		WebElement add = driver.findElement(By.cssSelector("div[class='desktop-share']"));
		add.findElement(By.cssSelector("div[class='add-watchlist site-color']")).click();
	}

	public void removeFromWarchlistShowPage() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='desktop-share']")));
		WebElement add = driver.findElement(By.cssSelector("div[class='desktop-share']"));
		add.findElement(By.cssSelector("div[class='remove-watchlist site-color']")).click();
	}

	public void removeFromWarchlistThumbnail() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='search-results']")));
		WebElement popup = driver.findElement(By.cssSelector("div[class='popup-view']"));
		actions.moveToElement(popup.findElement(By.cssSelector("a[href*='video'],a[href*='videos'],a[href*='films']"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='remove']")));
		driver.findElement(By.cssSelector("div[class='remove']")).click();
	}

	public String grabTitleOfAddedAssetOnWatchlistPage() {
		// Grab titles of added assets
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a/div[2]/div[1][@class='title'])[1]")));
		WebElement watchlistAsset = driver.findElement(By.xpath("(//a/div[2]/div[1][@class='title'])[1]"));
		String showTitleInWatchlist = watchlistAsset.getText();
		return showTitleInWatchlist;
	}

	public String grabNameOfVideoThatWillBeAdded() {
		// Grab name of video that will be added
		WebElement popup = driver.findElement(By.cssSelector("div[class='popup-view']"));
		actions.moveToElement(popup.findElement(By.cssSelector("a[href*='video'],a[href*='videos'],a[href*='films']"))).build().perform();
		WebElement video = popup.findElement(By.cssSelector("a[href*='video'],a[href*='videos'],a[href*='films']"));
		WebElement videoName = video.findElement(By.cssSelector("div[class='title-container']"));
		String NameOfVideo = videoName.getText();
		return NameOfVideo;
	}

	public void clickOnAddButtonOnVideoThumbnail() {
		WebElement popup = driver.findElement(By.cssSelector("div[class='popup-view']"));
		actions.moveToElement(popup.findElement(By.cssSelector("a[href*='video'],a[href*='videos'],a[href*='films']"))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='add']")));
		driver.findElement(By.cssSelector("div[class='add']")).click();
	}

	public void WatchlistClearAllNo() {
		driver.findElement(By.cssSelector("div[class='clear-list']")).click();
		driver.findElement(By.cssSelector("button[class='button button-no cta']")).click();
	}

	public void WatchlistClearAllxxxX() {
		driver.findElement(By.cssSelector("div[class='clear-list']")).click();
		driver.findElement(By.cssSelector("div[class='close-button']")).click();
	}

	public void WatchlistClearAllYes() {
		driver.findElement(By.cssSelector("div[class='clear-list']")).click();
		driver.findElement(By.cssSelector("button[class='button button-yes cta']")).click();
	}

	public void openHome() {
		driver.findElement(By.cssSelector("div[class='logo-container']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav[class='masthead  ']")));
	}

	public void clickVideoFromHomePage() {
		driver.findElement(By.cssSelector("a[href*='videos'],a[href*='films']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vjs_video_3_html5_api")));
	}

}
