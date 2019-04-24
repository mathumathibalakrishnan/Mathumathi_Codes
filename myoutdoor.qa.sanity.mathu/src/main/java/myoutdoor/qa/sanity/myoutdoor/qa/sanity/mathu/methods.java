package myoutdoor.qa.sanity.myoutdoor.qa.sanity.mathu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class methods {
static WebDriver driver;

public methods() {
	
}
	WebElement loginpage;
	static WebElement subscribe;
	static WebElement signup;
static WebElement email;
static WebElement name;
static WebElement password ;
static WebElement signupNow;
static WebElement login;

	public static void HomePage() {
		
	WebElement loginpage	= driver.findElement(By.className("login-button navigation-link"));
		WebElement subscribe = driver.findElement(By.className("cta subscribe-button"));
		WebElement signup = driver.findElement(By.className("signup-tab-button tab-button active"));
	}
	
	public static void signupFields() {
		WebElement email = driver.findElement(By.xpath("//input[@type = 'email']"));
		WebElement name = driver.findElement(By.className("input-box collapsible "));
		WebElement password = driver.findElement(By.xpath("//input[@type = 'password']"));
		WebElement signupNow = driver.findElement(By.className("login-button button fat cta "));
	}
	
	public static void loginfields() {
		WebElement login = driver.findElement(By.className("login-tab-button tab-button active"));
		
	}
	
	
}
