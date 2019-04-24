package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HistoryTest {

	@Test
	public void History() throws InterruptedException, IOException {

//Open Library
		BaseJava cm = new BaseJava();

		cm.baseMethods();
		cm.signIn();

		System.out.println("....................");
		System.out.println("Test case for History page");
		cm.actions.moveToElement(cm.driver.findElement(By.cssSelector("div[class='user-buttons']"))).build().perform();
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"root\"]/div/div[1]/div[1]/nav/div/header/div[3]/div[2]/div[2]/a[1][@href='/user/library']")));
		cm.driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[1]/div[1]/nav/div/header/div[3]/div[2]/div[2]/a[1][@href='/user/library']"))
				.click();
// Play 3 assets
		Thread.sleep(1000);
		cm.driver.findElement(By.xpath("(//*[@id=\"root\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1][@class='list__item__container'])[1]")).click();
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='play-icon-overlay']")));
		cm.driver.findElement(By.cssSelector("div[class='play-icon-overlay']")).click();
		Thread.sleep(35000);
		cm.driver.navigate().back();
		Thread.sleep(1000);
		cm.driver.findElement(By.xpath("(//*[@id=\"root\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2][@class='list__item__container'])[1]")).click();
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='play-icon-overlay']")));
		cm.driver.findElement(By.cssSelector("div[class='play-icon-overlay']")).click();
		Thread.sleep(35000);
		cm.driver.navigate().back();
		Thread.sleep(1000);
		cm.driver.findElement(By.xpath("(//*[@id=\"root\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/div[3][@class='list__item__container'])[1]")).click();
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='play-icon-overlay']")));
		cm.driver.findElement(By.cssSelector("div[class='play-icon-overlay']")).click();
		Thread.sleep(35000);
		cm.driver.navigate().back();

// Open history page
		cm.openHistory();

// Grab titles of added assets
		System.out.println("Open history page and grab titles of watched videos...");
		cm.titleFromHistory();
// Check Clear all button
		System.out.println("Test case : Close message about -clear all- with -X- sign ");
		cm.clearHistoryWatchlist();

		System.out.println(".....................");
		cm.driver.close();

	}

}
