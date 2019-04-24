package com.motv;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SharingLinksTest {

	@Test
	public void Sharing() throws IOException

	{
		BaseJava cm = new BaseJava ();
		cm.baseMethods();
		cm.driver.findElement(By.cssSelector("div[class='search-icon']")).click();
		cm.driver.findElement(By.cssSelector("input[class='search-container-input']")).sendKeys("video");
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='video-tray-item '])[last()-5]")));
		cm.driver.findElement(By.xpath("(//a[@class='video-tray-item '])[last()-5]")).click();
		//cm.scroll.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement share = cm.driver.findElement(By.cssSelector("div[class*='sharing']"));
		share.findElement(By.cssSelector("i[class*='facebook']")).click();
		share.findElement(By.cssSelector("i[class*='twitter']")).click();
		share.findElement(By.cssSelector("i[class*='email']")).click();
		cm.openNextWindowGetTitle();
		cm.driver.quit();
	}

}
