package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
public class Sign_In_FB_Test {
	BaseJava cm = new BaseJava();


	@Test
	public void sign_In_With_FB() throws IOException

	{

		cm.baseMethods();
		
		// Sign in on FB Web
		cm.driver.get("https://www.facebook.com/login");
		cm.driver.findElement(By.id("email")).sendKeys("testsnag.sri@gmail.com", Keys.TAB);
		cm.driver.findElement(By.id("pass")).sendKeys("Snagpassword@21", Keys.ENTER);
		cm.driver.get("https://new.moviespree.com/home");
		cm.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Sign in with FB on MovieSpree
		cm.driver.findElement(By.xpath("//button[@class='login-button navigation-link']")).click();
		cm.driver.findElement(By.className("social-logins")).click();
		
		WebElement fb = cm.driver.findElement(By.cssSelector("span[class='name']"));
		String textfb = fb.getText();
		System.out.println("..................");
		System.out.println("Case - Open app and sign in with Facebook on Settings page");
		System.out.println("FB account " + textfb);
		System.out.println("..................");

		cm.driver.close();
	}

}
