package hoichoi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webTestFunctions.globalDrivers;

public class headerCheckLinksTest extends globalDrivers {

	@Parameters ({"site"})
	@Test
	public void openAllItemesInMenuCheckPages(String site) throws IOException, InterruptedException {
		
		// Implicit wait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Open site
		String url = super.globalSite.getSiteUrl(site);
		super.globalDriver.get(url);
		super.globalDriver.manage().window().fullscreen();

		// Open all links
		super.globalSite.clickEveryLinkInmenu();

		// Check links for 404 and modules number
		super.globalSite.checkLinksFor404andEmptyPages();

	}

}
