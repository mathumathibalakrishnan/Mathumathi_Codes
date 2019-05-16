package mobileweb;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class iOSMobileWEB {

	public static void main(String[] args) throws MalformedURLException {
	
		//setup the web driver and launch the webview app.
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, "05326429b47b2f4d4503f204b920e8938332dd75");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
		desiredCapabilities.setCapability("xcodeSigningId", "iPhone Developer");
		desiredCapabilities.setCapability("xcodeOrgId", "57Q5P998M5");
	//	URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AppiumDriver<WebElement> driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);		
		
		// Navigate to the page and interact with the elements on the guinea-pig page using id.
		driver.get("https://app.myoutdoortv.com/");
	}
	
	
	
	
}
