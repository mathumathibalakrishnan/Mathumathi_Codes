package mobileweb;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class browser extends capabilities{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
	    AndroidDriver<AndroidElement> driver = cap("real");
	    driver.get("http://www.google.com");
	                         
	}

}
