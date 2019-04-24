package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchTest {

	@Test
	public void Search() throws InterruptedException, IOException {
		
		BaseJava cm = new BaseJava();
		cm.baseMethods();
		
		System.out.println("..................");
		System.out.println("Test Case - Open search and open any video ");
		cm.driver.findElement(By.cssSelector("div[class='search-icon']")).click();
		cm.driver.findElement(By.cssSelector("input[class='search-container-input']")).sendKeys("series");
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='video-tray-item '])[last()-5]")));
		cm.driver.findElement(By.xpath("(//a[@class='video-tray-item '])[last()-5]")).click();
		WebElement title = cm.driver.findElement(By.cssSelector("h1[class='header-title']"));
		String text = title.getText();
		System.out.println("Video detail page oppened " + text);
		System.out.println("..................");
		cm.driver.close();

	}

}
