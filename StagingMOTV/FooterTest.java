package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class FooterTest {


	
	@Test
	public void Footer() throws IOException {
		BaseJava cm = new BaseJava();
		cm.baseMethods();
		cm.scroll.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement footer = cm.driver.findElement(By.cssSelector("div[class='links']"));
		footer.findElement(By.cssSelector("a[href='/about-us']")).sendKeys(Keys.COMMAND, Keys.SHIFT, Keys.ENTER);
		footer.findElement(By.cssSelector("a[href='/tos']")).sendKeys(Keys.COMMAND, Keys.SHIFT, Keys.ENTER);
		footer.findElement(By.cssSelector("a[href='/privacy-policy']")).sendKeys(Keys.COMMAND, Keys.SHIFT, Keys.ENTER);

		System.out.println("Case - Open app and check if Footer links can be oppened and grab titles of this pages ");

		cm.openNextWindowGetTitle();

		System.out.println("...........");

		cm.driver.quit();

	}

}
