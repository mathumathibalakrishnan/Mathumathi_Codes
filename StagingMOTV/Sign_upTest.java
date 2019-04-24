package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Sign_upTest {

	@Test
	public void sign_Up() throws IOException

	{

		BaseJava cm = new BaseJava();
		cm.baseMethods();
		
		Random ran = new Random();
		int randin = ran.nextInt(10000000);
		cm.driver.findElement(By.cssSelector("button[class*='login-button']")).click();
		cm.driver.findElement(By.cssSelector("div[class*='signup']")).click();
		cm.driver.findElement(By.id("ageCheck")).click();
		cm.driver.findElement(By.cssSelector("input[type='email']")).sendKeys("test" + randin + "@yandex.com", Keys.TAB);
		cm.driver.findElement(By.cssSelector("input[placeholder*='NAME']")).sendKeys("SignUp Test", Keys.TAB);
		cm.driver.findElement(By.cssSelector("input[type='password']")).sendKeys("aaaaaa", Keys.ENTER);

		
		// Grab Hello
		WebElement name = cm.driver.findElement(By.cssSelector("span[class='name']"));
		System.out.println("..................");
		System.out.println("Case - Open app and sign UP with email on Setitngs page ");
		String text = name.getText();
		System.out.println("Account name..." + text);
		System.out.println("..................");
		cm.driver.close();
	}

}