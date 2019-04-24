package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PurchasingFullSeasonTest {

	@Test
	public void BuySeries() throws InterruptedException, IOException {

		BaseJava cm = new BaseJava();
		cm.baseMethods();

		System.out.println("..................");
		System.out.println(
				"Test case - 1) App opened, 2) Account created, 3) Added creadit card, 4) FULL-SEASON bought, 5) Verifyed that it bought ");

//Open series tab
		cm.driver.findElement(By.cssSelector("a[href='/series']")).click();
//Open specific series		
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='video-tray-item '])[6]")));
		cm.driver.findElement(By.xpath("(//a[@class='video-tray-item '])[6]")).click();

//Scroll page 400 pixels 		
		JavascriptExecutor jss = (JavascriptExecutor) cm.driver;
		jss.executeScript("window.scrollBy(0,400)");
//	Open specific video asset 	
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class*='purchase-season-cta']")));
		cm.driver.findElement(By.cssSelector("div[class*='purchase-season-cta']")).click();
//Count number of videos that can be bought
		System.out.println("Count number of videos that can be bought ");
		int xpathCount = cm.driver.findElements(By.cssSelector("div[class*='purchase-episode']")).size();
		System.out.println(xpathCount);
//Sign up        
		cm.signUp();
//Credit card form 		
		cm.purchase();
//Buy button 		
		cm.buyButton();
//Print name of show that was bought 		
		cm.printNameWhatBougth();

//	Open library and see assets that you bought
		System.out.println("Test case open library and see assets that you bought");
		cm.titleFromLibrary();
//Count number of videos in library
		System.out.println("Count number of videos that in library ");
		int Count = cm.driver.findElements(By.cssSelector("a[class*='list']")).size();
		System.out.println(Count);
		System.out.println("..................");
		cm.driver.close();

	}
}
