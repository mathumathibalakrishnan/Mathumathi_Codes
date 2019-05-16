package mobileweb;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidMobileAPP {

	public static void main(String[] args) throws Exception {
		 File appDir = new File("src");
         File app = new File(appDir, "NEOU-PROD-2.1.2-99-mobile-nonkiswe-release.apk");
         DesiredCapabilities capabilities = new DesiredCapabilities();
         capabilities.setCapability("deviceName", "Redmi");
         capabilities.setCapability("platformName", "Android");
         capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
         AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);                    
         driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
         driver.launchApp();
         Thread.sleep(30000);
        // driver.findElement(By.className("android.widget.ImageButton")).click();
         driver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys("mathumathi+14android@viewlift.com");
         driver.findElement(By.xpath("//android.widget.EditText[@text='PASSWORD']")).sendKeys("123456");
         driver.findElement(By.xpath("//android.widget.Button[@text='LOG IN' and @index='7']")).click();
	}
}


