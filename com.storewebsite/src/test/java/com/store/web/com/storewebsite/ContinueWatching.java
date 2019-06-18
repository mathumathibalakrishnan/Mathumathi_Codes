package com.store.web.com.storewebsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContinueWatching {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	Properties prop=new Properties();
	URL url = ContinueWatching.class.getClassLoader().getResource("url.properties");
	String filesPathAndName = url.getPath(); 
InputStream ip= new FileInputStream(filesPathAndName);
		
		*/
		String file = "/com.storewebsite/url.properties";
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get(prop.getProperty("URL"));
	}

}
