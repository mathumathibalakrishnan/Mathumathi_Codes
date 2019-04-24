package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class MenuTest {

	@Test
	public void Menu() throws IOException

	{
		BaseJava cm = new BaseJava();
		cm.baseMethods();

		WebElement menu = cm.driver.findElement(By.cssSelector("nav[class*='navigation']"));

		for (int i = 0; i < menu.findElements(By.tagName("a")).size(); i++) {
			String click = Keys.chord(Keys.COMMAND, Keys.LEFT_SHIFT + "t", Keys.ENTER);
			menu.findElements(By.tagName("a")).get(i).sendKeys(click);
		}
		System.out.println("...........");
		System.out.println("Test case for menu, open all tabs (not dropdown) and get title ");

		cm.openNextWindowGetTitle();
		
		
		System.out.println("...........");
		cm.driver.quit();

	}

}
