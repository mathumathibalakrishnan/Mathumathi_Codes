package com.practice.com.practice;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class breakloop {
	static WebDriver driver;
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://demo.openmrs.org/openmrs/login.htm");
	driver.findElement(By.id("username")).click();
	driver.findElement(By.id("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("Admin123");
	driver.findElement(By.id("Inpatient Ward")).click();
	driver.findElement(By.xpath("//input[@id='loginButton']")).submit();
	driver.findElement(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
	driver.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app")).click();
	//boolean result = VerifyService("Urology");
	//System.out.println(result);
}
	

	
	/*
	public static boolean VerifyService(String s)  throws InterruptedException 
	{
		boolean result = false;
		
	List<WebElement> pagelist = driver.findElements(By.xpath("//*[@id='appointmentTypesTable_paginate']/span/a"));
	
	List<WebElement> tdlist = driver.findElements(By.xpath("//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
	
	outerloop:
		for (int i = 1; i< pagelist.size(); i++) {
			for (int j = 0; j<tdlist.size(); j++) {
				if (tdlist.get(j).getText().contains(s)){
					System.out.println("Service type is found");
					result = true;
					break outerloop;
					
				}
			}
			pagelist = driver.findElements(By.xpath("//*[@id='appointmentTypesTable_paginate']/span/a"));
			pagelist.get(i).click();
			tdlist = driver.findElements(By.xpath("//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
			
		}
	
	
	
		return result;
	
		}
	*/
	
}

	

