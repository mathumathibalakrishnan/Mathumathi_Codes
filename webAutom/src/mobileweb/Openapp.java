package mobileweb;

import org.openqa.selenium.WebDriver;

public class Openapp {

	WebDriver driver = null;
	public void open() {

		BaseMethods menu = new BaseMethods ();
				
					menu.header();
					driver.quit();
					
			//menu.driver.quit();
			
					
			}
	
}
