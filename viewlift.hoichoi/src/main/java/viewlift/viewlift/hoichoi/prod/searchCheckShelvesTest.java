package viewlift.viewlift.hoichoi.prod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webTestFunctions.globalDrivers;

public class searchCheckShelvesTest extends globalDrivers {

	@Parameters({ "site" })
	@Test (priority = 0)
	public void searchCheckShelvesNames(String site) throws IOException, InterruptedException {

		// Implicit wait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Open site
		String url = super.globalSite.getSiteUrl(site);
		super.globalDriver.get(url);
		super.globalDriver.manage().window().fullscreen();

		// Search
		super.globalSite.search();

		WebElement search = driver.findElement(By.cssSelector("div[class='search']"));
		WebElement searchResults = search.findElement(By.cssSelector("div[class='search-results']"));
		List<WebElement> carouselTitles = searchResults
				.findElements(By.cssSelector("div[class='BlockTitle site-color']"));

		ArrayList<String> matchingList = new ArrayList<String>();

		String[] expectedArray = new String[] { "VIDEOS", "SERIES" };

		for (int k = 0; k < expectedArray.length; k++) {
			for (int j = 0; j < carouselTitles.size(); j++) {
				String Name = carouselTitles.get(j).getText();
				if (expectedArray[k].equals(Name)) {
					matchingList.add(expectedArray[k]);
				}
			}
		}

		Assert.assertEquals(matchingList.size() == expectedArray.length, true);
		System.out.println(matchingList);

	}

	@Test (priority = 1)
	public void assertMalformedData() throws InterruptedException {
		// Check if something went wrong message presented.

		try {
	
			List<WebElement> somethingWentWrong = super.globalDriver.findElements(By.cssSelector("div[class='search-results']>h1"));

			String malformedString = "Something went wrong.";
			
			Boolean hasMalformedString = true;
			
			if (somethingWentWrong.size() > 0) {
				for (int i = 0; i < somethingWentWrong.size(); i++) {
					String somethingWentWrongText = somethingWentWrong.get(i).getText();
					System.out.print(somethingWentWrongText + ' ' + somethingWentWrongText.equals(malformedString));
					if (somethingWentWrongText.equals(malformedString)) {
						hasMalformedString = false;
						break;
					}
				}
			} else {
				hasMalformedString = true;
			}
			
			Assert.assertEquals(hasMalformedString.booleanValue(), true);
		} catch (Exception err) {
			System.out.println("All good" + err);
		}
	}

}
