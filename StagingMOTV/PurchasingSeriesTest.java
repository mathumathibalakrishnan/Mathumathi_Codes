package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class PurchasingSeriesTest {

	@Test
	public void BuySeries() throws InterruptedException, IOException {
		BaseJava cm = new BaseJava();
		cm.baseMethods();

		System.out.println("..................");
		System.out.println(
				"Test case - 1) App opened, 2) Account created, 3) Added creadit card, 4) SERIES bought, 5) Verifyed that it bought ");
//Open series tab
		cm.driver.findElement(By.cssSelector("a[href='/series']")).click();
//Open specific series		
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='video-tray-item '])[7]")));
		cm.driver.findElement(By.xpath("(//a[@class='video-tray-item '])[7]")).click();

//Scroll page 400 mixels 		
		cm.scroll.executeScript("window.scrollBy(0,400)");
//	Open specific video asset 	
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='video-tray-item '])[2]")));
		cm.driver.findElement(By.xpath("(//a[@class='video-tray-item '])[2]")).click();
//Sign up        
		cm.signUp();
//Credit card form 		
		cm.purchase();
//Buy button 		
		cm.buyButton();
//Print name of show that was bought 		
		System.out.println(
				"Test case - App opened, account created, added creadit card, SERIES bought, Verifyed that it bought ");
		cm.printNameWhatBougth();
		System.out.println("Test case open library and see assets that you bought");
//Library		
		cm.titleFromLibrary();
		System.out.println("..................");
		cm.driver.close();

	}
}
