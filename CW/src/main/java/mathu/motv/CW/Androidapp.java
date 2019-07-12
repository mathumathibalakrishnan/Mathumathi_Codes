package mathu.motv.CW;


import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Androidapp {

	public static void main(String[] args) throws Exception {
		

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Tab A");
		capabilities.setCapability("appPackage", "com.sports.lnp");
		capabilities.setCapability("appActivity", "com.viewlift.mobile.AppCMSLaunchActivity");
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		driver.launchApp();
		
		
	}

}
