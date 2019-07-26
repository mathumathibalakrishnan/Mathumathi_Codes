package hoichoi;

import org.testng.annotations.Test;
import webTestFunctions.globalDrivers;
import org.testng.annotations.Parameters;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class footerTest extends globalDrivers {

	@Parameters({ "site" })
	@Test
	public void footerLinksTest(String site) throws IOException, InterruptedException {

		// Implicit wait
		super.globalDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//Open site
		String url = super.globalSite.getSiteUrl(site);
		super.globalDriver.get(url);
		super.globalDriver.manage().window().fullscreen();

		// Footer
		super.globalSite.footer();

		// Check links for 404 and for empty pages
		super.globalSite.checkLinksFor404();
		

	}

}