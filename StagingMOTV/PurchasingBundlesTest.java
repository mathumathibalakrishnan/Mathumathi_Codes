package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class PurchasingBundlesTest {

	@Test
	public void cmBundles() throws InterruptedException, IOException

	{
// Class object for BaseMethods		
		BaseJava cm = new BaseJava();
		cm.baseMethods();

		System.out.println("...........................");
		System.out.println("Test case to check Purchasing for BUNDLES ");

//Open bundle tab
		cm.driver.findElement(By.cssSelector("a[href='/bundles']")).click();
//Open specific bundle		
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='video-tray-item '])[7]")));
		cm.driver.findElement(By.xpath("(//a[@class='video-tray-item '])[7]")).click();
//	Click Buy button 
		cm.scroll.executeScript("window.scrollBy(0,400)");
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='play-icon site-color']")));
		cm.driver.findElement(By.cssSelector("div[class='play-icon site-color']")).click();

//Sign UP		
		cm.signUp();

//Fill up credit form		
		cm.purchase();
//Buy button 		
		cm.buyButton();

//Print name of show that was bought 		
		cm.printNameWhatBougth();
		System.out.println(
				"Test case - 1) App opened, 2) Account created, 3) Added creadit card, 4) BUNDLES bought, 5) Verifyed that it bought ");

//Open library and see assets that you bought
		System.out.println("Test case open library and see assets that you bought");

		cm.titleFromLibrary();
		System.out.println("..................");

		cm.driver.close();

	}

}
