package com.practice.com.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class p1 {
@Test
	public void testreport() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Reporter.log("Browser Opened");
		driver.manage().window().maximize();
		Reporter.log("Browser maximized");
		
	}
	
	
	
	
}
