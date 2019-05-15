package com.practice.com.practice;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class EugeneTC {
	
		public static void main(String[] args) throws IOException, InterruptedException {
			// TODO Auto-generated method stub

//			ChromeOptions opt = new ChromeOptions();
//			opt.addArguments("headless");

			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			Actions actions = new Actions(driver); // Actions
			WebDriverWait wait = new WebDriverWait(driver, 30); // Explicit wait
			JavascriptExecutor scroll = (JavascriptExecutor) driver; // Scroll

			
			
			
			driver.get("https://afaplay.viewlift.com/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().fullscreen();
			
//			driver.findElement(By.cssSelector("div[class='search-icon']")).click();
//			driver.findElement(By.cssSelector("input[class='search-container-input']")).sendKeys("s");
//			
//			for (int i=0; i<10; i++) {
//			driver.findElement(By.xpath("(//*[@id=\"root\"]/div/div[3]/div/div[2]/div[1]/div[2]/div/button[2])[1]")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("(//*[@id=\"root\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/button[2])[1]")).click();
//			Thread.sleep(1000);
//			}
//			
//			
//			driver.findElement(By.cssSelector("button[class*='login-button']")).click();
//			driver.findElement(By.cssSelector("input[type='email']")).sendKeys(("shraddhs+3@gmail.com"));
//			driver.findElement(By.cssSelector("input[type='password']")).sendKeys(("test12345"), Keys.ENTER);
//			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='name']")));
//			WebElement text =  driver.findElement(By.cssSelector("span[class='name']"));
//			String name = text.getText();
//			System.out.println("Name of signed in user is ..." + name);
//		//History	
//			actions.moveToElement(driver.findElement(By.cssSelector("div[class='user-buttons']"))).build().perform();
//			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("My Watchlist")));
//			driver.findElement(By.linkText("My Watchlist")).click();
//			Thread.sleep(5000);
//			scroll.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			int count = driver.findElements(By.cssSelector("a[href]")).size();
			System.out.println(count);
		
			HttpURLConnection huc = null;
			int respCode = 200;

			List<WebElement> links = driver.findElements(By.tagName("a"));

			Iterator<WebElement> it = links.iterator();

			while (it.hasNext()) {

				String url = it.next().getAttribute("href");

				if (url == null || url.isEmpty()) {
					System.out.println("URL is either not configured for anchor tag or it is empty");
					continue;
				}

				try {
					huc = (HttpURLConnection) (new URL(url).openConnection());

					huc.setRequestMethod("HEAD");

					huc.connect();

					respCode = huc.getResponseCode();

					if (respCode >= 400) {
						System.out.println(url + " is a broken link");
					}
//	                else{
//	                    System.out.println(url+" is a valid link");
//	                }

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("End of Test");
			driver.quit();

		}
	}

