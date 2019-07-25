package webTestFunctions;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class globalDrivers {
	protected Actions globalActions;
	protected basePlayer globalPlayer;
	protected baseSite globalSite;
	protected baseUser globalUser;
	protected WebDriver globalDriver;
	protected WebDriverWait globalWait;
	protected JavascriptExecutor globalJs;

	public static WebDriver driver = new ChromeDriver();

	public globalDrivers() {
		globalDriver = driver;
		globalActions = new Actions(driver);
		globalPlayer = new basePlayer(driver);
		globalSite = new baseSite(driver);
		globalUser = new baseUser(driver);
		globalWait = new WebDriverWait(driver, 15);
		globalJs = (JavascriptExecutor) driver; // Scroll
	}

	public WebDriver getdriver() {
		return globalDriver;
	}
}
