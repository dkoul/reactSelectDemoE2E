package tests;

import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;


public class BaseTest {

	public static By locator;

	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	public WebDriver getWebDriver() {
		return webDriver.get();
	}

	protected void createDriver(String browser) throws MalformedURLException, UnexpectedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
		//webDriver.set(
		//		new RemoteWebDriver(new URL(utilities.Env.getSeleniumHostURL()), capabilities));
        webDriver.set(new ChromeDriver()); 
	}
	  	
 
	@AfterMethod
	public void teardown() {
		webDriver.get().quit();
	}
}
