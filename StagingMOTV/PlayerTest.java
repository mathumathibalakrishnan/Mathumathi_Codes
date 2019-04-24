package com.motv;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlayerTest {

	@Test
	public void Player() throws InterruptedException, IOException

	{
		BaseJava cm = new BaseJava();

		cm.baseMethods();
		cm.signIn();
		
		cm.openHistory();
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='container']")));
		cm.driver.findElement(By.cssSelector("div[class='container']")).click();
		

// Test for player 

		System.out.println("Test for Player ");
		System.out.println("...........");
//Player Launched
		cm.driver.findElement(By.cssSelector("div[class='play-icon-overlay']")).click();
		System.out.println("Player Launched  ");
		cm.actions.moveToElement(cm.driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		cm.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Fullscreen']")));
//Player FullScreen
		cm.driver.findElement(By.cssSelector("button[title='Fullscreen']")).click();
		System.out.println("Player FullScreen  ");
		WebElement Pause = cm.driver.findElement(By.xpath("(//button/span[2][@class='vjs-control-text'])[2]"));
		String textt = Pause.getText();
		System.out.println("Click to  " + textt);
		cm.actions.moveToElement(cm.driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		cm.driver.findElement(By.cssSelector("button[title='Pause']")).click();
//Player Paused
		System.out.println("Player Paused  ");
		cm.wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button/span[2][@class='vjs-control-text'])[2]")));
		cm.actions.moveToElement(cm.driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		WebElement Play = cm.driver.findElement(By.xpath("(//button/span[2][@class='vjs-control-text'])[2]"));
		String text0 = Play.getText();
		System.out.println("Click to  " + text0);
		cm.driver.findElement(By.cssSelector("button[title='Play']")).click();
//Player Launched
		System.out.println("Player Launched  ");
		System.out.println("Right now Sounds ON  ");
//Mute Sounds 
		cm.actions.moveToElement(cm.driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		WebElement mute = cm.driver.findElement(By.xpath("(//button/span[2][@class='vjs-control-text'])[3]"));
		String text1 = mute.getText();
		System.out.println("Click to  " + text1);
		cm.driver.findElement(By.cssSelector("button[title='Mute']")).click();
		System.out.println("Right Now Sound OFF  ");
// Unmute
		WebElement unmute = cm.driver.findElement(By.xpath("(//button/span[2][@class='vjs-control-text'])[3]"));
		String text = unmute.getText();
		System.out.println("Click to  " + text);
		cm.driver.findElement(By.cssSelector("button[title='Unmute']")).click();
		System.out.println("Sounds ON again  ");

//Get Current timer
		cm.actions.moveToElement(cm.driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		WebElement timer = cm.driver.findElement(By.cssSelector("span[class='vjs-current-time-display']"));
		String tex = timer.getText();
		System.out.println("Timer  " + tex);
//Rewind 15 seconds 
		cm.actions.moveToElement(cm.driver.findElement(By.id("vjs_video_3_html5_api"))).build().perform();
		cm.driver.findElement(By.cssSelector("svg[class=' icon icon-rewind']")).click();
		cm.driver.findElement(By.cssSelector("button[title='Pause']")).click();
		WebElement timerafter = cm.driver.findElement(By.cssSelector("span[class='vjs-current-time-display']"));
		String textafter = timerafter.getText();
		System.out.println("Timer  " + textafter);
		System.out.println("...........");
		cm.driver.close();

		// cm.actions.moveToElement(cm.driver.findElement(By.cssSelector("div[class='current-resolution']")));

//				 int x = 220;
//					WebElement slider = cm.driver.findElement(By.cssSelector("div[class='vjs-play-progress vjs-slider-bar']"));
//				    int width=slider.getSize().getWidth();
//				    Actions move = new Actions(cm.driver);
//				    move.moveToElement(slider, ((width*x)/100), 0).click();
//				    move.build().perform();
//				

	}
}
