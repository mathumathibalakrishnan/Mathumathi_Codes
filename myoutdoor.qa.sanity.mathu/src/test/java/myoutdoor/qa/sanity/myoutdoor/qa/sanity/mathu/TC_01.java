package myoutdoor.qa.sanity.myoutdoor.qa.sanity.mathu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01 extends methods{

methods test1 = new methods();

	@BeforeTest
	public void beforeTest() {
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.get("https://app.myoutdoortv.com");
	}


	@Test
	//To verify whether user is able to Sign up without subscription
	public void SigupWithoutSub() {
	methods test1 = new methods();
	test1.loginpage.click();
	
		
			
	}
	@Test
	//To verify whether user is able to Sign up with subscription
	public void SigupWithSub() {
	}
	@Test
	//To verify whether user is able to validate all links after login (Menu)
	public void LoginValidateLinks() {

	}
	@Test
	//To verify whether user is able to validate all links without login (Menu)
	public void WithoutLoginValidateLinks() {

	}
	@Test
	//To validate history
	public void History() {

	}
	@Test
	//To validate watch list
	public void Watchlist() {

	}
	@Test
	//To verify whether user is able to reset password
	public void ForgotPassword() {

	}
	@Test
	//To verify whether user is able to play any video
	public void Playvideo() {

	}
	@Test
	//To validate all footer links without login
	public void WithoutLoginfooter() {

	}
	@Test
	//To validate all footer links with login
	public void Loginfooter() {
		
	}
	@Test
	//To verify whether user is able to change the language
	public void language() {

	}
	@Test
	//To verify whether search is working fine after login
	public void LoginSearch() {

	}
	@Test
	//To verify whether search is working fine without login
	public void WithoutLoginSearch() {

	}




	@AfterTest
	public void afterTest() {
	}

}
