package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgetPasswordTest {

	@Test
	public void ForgetPassword() throws InterruptedException, IOException

	{
		BaseJava cm = new BaseJava();
		
		cm.baseMethods();

		cm.driver.findElement(By.cssSelector("button[class*='login']")).click();
		cm.driver.findElement(By.cssSelector("div[class*='forgot']")).click();
		cm.driver.findElement(By.cssSelector("input[type='text']")).sendKeys("bobtest956@gmail.com");
		cm.driver.findElement(By.cssSelector("button[class='button cta submit-button ']")).click();
// Check if user get email was send
		System.out.println("...........");
		System.out
				.println("Case - Open app and ask for FORGOT password, check if you get confiramtion message on web ");
		cm.wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.cssSelector("button[class='button cta submit-button ']")));
		WebElement movie = cm.driver.findElement(By.cssSelector("span[class='intro']"));
		String text = movie.getText();

		if (text.contains("An email has been sent to recover your password.")) {
			System.out.println(" Email confirmation As expected");
		}

		else {

			System.out.println("NOT as expected");

		}
		System.out.println("...........");

		cm.driver.close();

//		//OPEN GMAIL AND SING IN                
//        cm.driver.get("https://accounts.google.com/signin");
//        cm.driver.findElement(By.cssSelector("input[id='identifierId']")).sendKeys("bobtest956@gmail.com");
//        cm.driver.findElement(By.cssSelector("div[id='identifierNext']")).click();
//        cm.driver.findElement(By.name("password")).sendKeys("Linkoln34!",Keys.ENTER);
//     
////Check if user get email for forgot password Moviespree                
//        cm.driver.findElement(By.className("gb_xc")).click();
//        cm.driver.findElement(By.id("gb23")).click();
//       WebElement email = cm.driver.findElement(By.xpath("//td[5]/div[2]/span[1]/span"));
//       String forgot = email.getText();
//       System.out.println("Email from ..." + forgot + " recived, checked in gmail.");
//		System.out.println("...........");

	}

}
