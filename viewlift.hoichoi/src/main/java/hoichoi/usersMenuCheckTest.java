package hoichoi;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webTestFunctions.globalDrivers;
import org.testng.Assert;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class usersMenuCheckTest extends globalDrivers {

	@Parameters({ "site" })
	@Test
	public void usersMenuCheck (String site) throws IOException, InterruptedException {

		// YOU NEED TO BE LOG IN
		
		
		//Implicit wait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Open site
		String url = super.globalSite.getSiteUrl(site);
		super.globalDriver.get(url);
		super.globalDriver.manage().window().fullscreen();

		Thread.sleep(500);
		super.globalWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class*='masthead']")));
		WebElement header = driver.findElement(By.cssSelector("div[class*='masthead']"));
		super.globalActions.moveToElement(header.findElement(By.cssSelector("div[class*='user']"))).build().perform();

		String[] expectedArray = new String[] { "Settings", "Watchlist", "History", "Log Out" };

		List<WebElement> elementList = super.globalDriver.findElements(By.cssSelector("div[class='dropdown']"));

		String[] linkText = new String[elementList.size()];

		for (WebElement a : elementList) {
			linkText = a.getText().split("\n");
		}

		ArrayList<String> matchingList = new ArrayList<String>(); // you want to store everything that matches here

//		Compare each element of  array to each element in Website’s array
		for (int k = 0; k < expectedArray.length; k++) {
			for (int j = 0; j < linkText.length; j++) {
				if (expectedArray[k].equals(linkText[j])) {
					matchingList.add(expectedArray[k]);
				}
			}
		}

		Assert.assertEquals(matchingList.size() == expectedArray.length, true);

	}

}
