package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignOutTest {

	@Test
	public void Logout() throws IOException
	{
		BaseJava cm = new BaseJava ();
		cm.baseMethods();
		cm.signIn();
		
		cm.actions.moveToElement(cm.driver.findElement(By.cssSelector("div[class='user-buttons']"))).build().perform();
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//*[@id=\"root\"]/div/div[1]/div[1]/nav/div/header/div[3]/div[2]/div[2]/a[5][@href='#logout'])[1]")));
		cm.driver.findElement(By.xpath(
				"(//*[@id=\"root\"]/div/div[1]/div[1]/nav/div/header/div[3]/div[2]/div[2]/a[5][@href='#logout'])[1]"))
				.click();
		WebElement name = cm.driver.findElement(By.cssSelector("button[class*='login']"));
		String text = name.getText();
		System.out.println("..................");
		System.out.println("Test Case that user can Log out...");
		System.out.println("Account name..." + text);
		System.out.println("..................");
		cm.driver.close();
		
		
	}
	
}
