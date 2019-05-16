package mobileweb;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class capabilities {

	public static AndroidDriver<AndroidElement> cap(String device) throws MalformedURLException{
        AndroidDriver<AndroidElement> driver;
        DesiredCapabilities cap = new DesiredCapabilities();
       
        if (device.equals("real")) {
                   cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        }
        else cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
       
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
       
        return driver;
	
        
        
}
}
