package com.store.web.com.storewebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test {
	static WebDriver driver;
	
	
	@Test()
	public void testEmailGenerator() {
		String email = "feedback@yoursite.com";
		Assert.assertNotNull(email);
		Assert.assertEquals(email, "feedback@yoursite.com");
	}

	@Test()
	public void testURL() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

	
}
