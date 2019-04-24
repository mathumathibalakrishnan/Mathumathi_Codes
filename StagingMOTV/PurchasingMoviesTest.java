package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class PurchasingMoviesTest {
	@Test
	public void BuyMovies() throws InterruptedException, IOException

	{
		BaseJava cm = new BaseJava();
		cm.baseMethods();
		// Random
		System.out.println("..................");
		System.out.println(
				"Test case - 1) App opened, 2) Account created, 3) Added creadit card, 4) Movies bought, 5) Verifyed that it bought ");
//Open movie tab
		cm.driver.findElement(By.cssSelector("a[href='/movies']")).click();
//Open specific movie		
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='video-tray-item '])[5]")));
		cm.driver.findElement(By.xpath("(//a[@class='video-tray-item '])[5]")).click();
//	Click buy button 	
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class*='overlay-button']")));
		cm.driver.findElement(By.cssSelector("div[class*='overlay-button']")).click();
//Sign up        
		cm.signUp();
//Credit card form 		
		cm.purchase();
//Buy button 		
		cm.buyButton();

//Print name of show that was bought 		
		cm.printNameWhatBougth();
		System.out.println("Test case open library and see assets that you bought");
//Library page 		
		cm.titleFromLibrary();
		System.out.println("..................");
		cm.driver.close();

	}
}
