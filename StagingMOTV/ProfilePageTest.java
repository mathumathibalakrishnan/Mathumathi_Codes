package com.motv;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ProfilePageTest {
	

	@Test
	public void profile() throws InterruptedException, IOException

	{
		BaseJava cm = new BaseJava ();
		
		System.out.println("....................");
		System.out.println("Test case for Profile Page ");
		
		cm.baseMethods();
		cm.signIn();
		WebElement oldtext =  cm.driver.findElement(By.cssSelector("span[class='name']"));
		String oldname = oldtext.getText();
		System.out.println("Old name..." + oldname);
		
		cm.actions.moveToElement(cm.driver.findElement(By.cssSelector("div[class='user-buttons']"))).build().perform();
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"root\"]/div/div[1]/div[1]/nav/div/header/div[3]/div[2]/div[2]/a[1][@href='/user/library']")));
		cm.driver.findElement(By.linkText("Settings")).click();
		// Edit Your Profile
		cm.driver.findElement(By.xpath("(//section[1]/div[2]/div[3]/div[@class='button'])[1]")).click();
		cm.driver.findElement(By.cssSelector("input[type='email']")).clear();
		cm.driver.findElement(By.cssSelector("input[type='email']")).sendKeys("change@yandex.com", Keys.TAB);
		cm.driver.findElement(By.cssSelector("input[placeholder='NAME']")).clear();
		cm.driver.findElement(By.cssSelector("input[placeholder='NAME']")).sendKeys("changed name", Keys.TAB);
		cm.driver.findElement(By.cssSelector("input[type='password']")).sendKeys("aaaaaa", Keys.ENTER);
		WebElement text = cm.driver.findElement(By.cssSelector("div[class*='change']"));
		String message = text.getText();
		System.out.println(message);	
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.className("close")));
		cm.driver.findElement(By.className("close")).click();
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class*='name']")));
		
		WebElement changename = cm.driver.findElement(By.cssSelector("span[class='name']"));
		String newname = changename.getText();
		System.out.println("New Name...." + newname);
// Email and Name changed ^^^ 
		cm.driver.findElement(By.xpath("(//section[1]/div[2]/div[3]/div[@class='button'])[1]")).click();
		cm.driver.findElement(By.cssSelector("input[type='email']")).clear();
		cm.driver.findElement(By.cssSelector("input[type='email']")).sendKeys("bobtest956@gmail.com", Keys.TAB);
		cm.driver.findElement(By.cssSelector("input[placeholder='NAME']")).clear();
		cm.driver.findElement(By.cssSelector("input[placeholder='NAME']")).sendKeys("Eugene.Account.For.Test", Keys.TAB);
		cm.driver.findElement(By.cssSelector("input[type='password']")).sendKeys("aaaaaa", Keys.ENTER);
		System.out.println(message);	
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.className("close")));
		cm.driver.findElement(By.className("close")).click();
		
		
// Email and Name changed back ^^^ 
		cm.driver.findElement(By.xpath("(//section[1]/div[3]/div[3]/div[@class='button'])[1]")).click();
		cm.driver.findElement(By.cssSelector("input[placeholder*='CURRENT']")).sendKeys("aaaaaa", Keys.TAB);
		cm.driver.findElement(By.cssSelector("input[placeholder*='NEW']")).sendKeys("bbbbbb", Keys.TAB);
		cm.driver.findElement(By.cssSelector("input[placeholder*='CONFIRM']")).sendKeys("bbbbbb", Keys.ENTER);
		System.out.println(message + "To New password bbbbbb");	
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.className("close")));
		cm.driver.findElement(By.className("close")).click();
// New password ^^	
		cm.driver.findElement(By.xpath("(//section[1]/div[3]/div[3]/div[@class='button'])[1]")).click();
		cm.driver.findElement(By.cssSelector("input[placeholder*='CURRENT']")).sendKeys("bbbbbb", Keys.TAB);
		cm.driver.findElement(By.cssSelector("input[placeholder*='NEW']")).sendKeys("aaaaaa", Keys.TAB);
		cm.driver.findElement(By.cssSelector("input[placeholder*='CONFIRM']")).sendKeys("aaaaaa", Keys.ENTER);
		System.out.println(message + "To Old password aaaaaa");	
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.className("close")));
		cm.driver.findElement(By.className("close")).click();
		
// Back to Old password ^^	
			WebElement sub = cm.driver.findElement(By.xpath("(//section[2]/div[3]/div[2][@class='main'])[1]"));
			String subtext = sub.getText();
			System.out.println("Card number is ..." + subtext);
			
		
		cm.driver.findElement(By.xpath("(//section[2]/div[3]/div[3]/div[@class='button'])[1]")).click();
//Credit card form 		
		cm.purchase();		
		
		
				
				WebElement newsub = cm.driver.findElement(By.xpath("(//section[2]/div[3]/div[2][@class='main'])[1]"));
				String newsubtext = newsub.getText();
				System.out.println("NEW Card number is ..." + newsubtext);
				
			
				cm.driver.close();

		
		
		

		

	}
}
