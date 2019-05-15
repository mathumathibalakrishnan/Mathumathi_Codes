package com.practice.com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MSE_IDE {
@Test
	public void ourteams() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://release-mse.viewlift.com/");
	    driver.manage().window().setSize(new Dimension(1440, 900));
	    driver.findElement(By.cssSelector(".team:nth-child(1) img")).click();
	    driver.findElement(By.cssSelector(".tabs-list > .unselected:nth-child(1)")).click();
	    String a = driver.findElement(By.cssSelector(".selected .label")).getText();
	   if (a.equals("VIDEOS")){
		   System.out.println("Videos page is displayed");
	   }
	    driver.findElement(By.cssSelector(".unselected:nth-child(2) .label")).click();
	    
	    
	}
	
}
