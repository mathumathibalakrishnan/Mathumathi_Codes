package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Add_ToWatchlistTest {
	

	@Test
	public void Add_toWatchlist() throws InterruptedException, IOException

	{
		BaseJava cm = new BaseJava();
		
		cm.baseMethods();
		cm.signIn();

//Open movies tab
		Thread.sleep(2000);
		cm.driver.findElement(By.cssSelector("a[href='/movies']")).click();

// Hover action , Add to watchlist
		cm.actions.moveToElement(cm.driver.findElement(By.xpath("(//a[@class='video-tray-item '])[6]"))).build().perform();
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='add']")));
		cm.driver.findElement(By.cssSelector("div[class='add']")).click();

//Open bundles tab
		cm.driver.findElement(By.cssSelector("a[href='/bundles']")).click();

//Open specific bundle		
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='video-tray-item '])[7]")));
		cm.driver.findElement(By.xpath("(//a[@class='video-tray-item '])[7]")).click();

//Scroll page 400 mixels 		
		cm.scroll.executeScript("window.scrollBy(0,400)");

// Hover action , Add to watchlist

		cm.actions.moveToElement(cm.driver.findElement(By.xpath("(//a[@class='video-tray-item '])[4]"))).build().perform();
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='add']")));
		cm.driver.findElement(By.cssSelector("div[class='add']")).click();

// Open series tab
		cm.driver.findElement(By.cssSelector("a[href='/series']")).click();

// Open specific series
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='video-tray-item '])[7]")));
		cm.driver.findElement(By.xpath("(//a[@class='video-tray-item '])[7]")).click();

// Scroll page 400 mixels
		cm.scroll.executeScript("window.scrollBy(0,400)");

// Add to watchlist

		cm.driver.findElement(By.cssSelector("div[class='add-watchlist site-color']")).click();

//Open watchlist
		cm.actions.moveToElement(cm.driver.findElement(By.cssSelector("div[class='user-buttons']"))).build().perform();
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"root\"]/div/div[1]/div[1]/nav/div/header/div[3]/div[2]/div[2]/a[2][@href='/user/watchlist']")));
		cm.driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[1]/div[1]/nav/div/header/div[3]/div[2]/div[2]/a[2][@href='/user/watchlist']"))
				.click();
//Grab titles of added assets		
		System.out.println("Test case to check Watchlist");
		System.out.println(".................");
		WebElement title1 = cm.driver.findElement(By.xpath("(//a/div[2]/div[1][@class='title'])[1]"));
		System.out.println(title1.getText());
		WebElement title2 = cm.driver.findElement(By.xpath("(//a/div[2]/div[1][@class='title'])[2]"));
		System.out.println(title2.getText());
		WebElement title3 = cm.driver.findElement(By.xpath("(//a/div[2]/div[1][@class='title'])[3]"));
		String text = title3.getText();
		System.out.println(title3.getText());
		 Thread.sleep(2000);
//Remove one asset 		 
		cm.driver.findElement(By.xpath(
				"(//*[@id=\"root\"]/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div/div/i[@class='link ion-close'])[1]"))
				.click();
		 Thread.sleep(2000);
		System.out.println(".................");
		System.out.println("AFTER REMOVING SECOND ASSET ");
//Verify dynamically what 2 assets left in list		
		WebElement title4 = cm.driver.findElement(By.xpath("(//a/div[2]/div[1][@class='title'])[2]"));
		String text2 = title4.getText();
		System.out.println(title1.getText());
		if (text2.contains(text))

		{

			System.out.println("As expected ...." + text);
		}

		else {

			System.out.println("Not as expected " + text);
		}
		
// Check Clear all button
		//Close message about clear all with "X" sign  
		cm.driver.findElement(By.cssSelector("div[class='clear-list']")).click();
		cm.driver.findElement(By.cssSelector("div[class='close-button']")).click();
		System.out.println("Check for close clear all mesage with 'X' icon ");
		//Close message about clear all with "no" button
		cm.driver.findElement(By.cssSelector("div[class='clear-list']")).click();
		cm.driver.findElement(By.cssSelector("button[class='button button-no cta']")).click();
		System.out.println("Check for close clear all mesage with 'NO' button ");
		//Clear watchlist 
		cm.driver.findElement(By.cssSelector("div[class='clear-list']")).click();
		cm.driver.findElement(By.cssSelector("button[class='button button-yes cta']")).click();
		//Get text that list empty 
		WebElement clearwatch = cm.driver.findElement(By.cssSelector("div[class='list-empty']"));
		System.out.println(clearwatch.getText());
		System.out.println(".....................");
		
		cm.driver.close();

	}


		
	}


