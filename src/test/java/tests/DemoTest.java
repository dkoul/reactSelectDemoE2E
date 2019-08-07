package tests;

import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.Chosen;
import utilities.ReactSelect;

public class DemoTest extends BaseTest {

	@Test

	public void chosenDemo() throws UnexpectedException, MalformedURLException, InterruptedException {
		this.createDriver("chrome");
		WebDriver driver = this.getWebDriver();
		driver.get("http://localhost:3000/");
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='countries_chosen']")));
		Chosen countries = new Chosen(driver.findElement(By.xpath("//div[@id='countries_chosen']")));
		countries.selectByIndex(4);
		Thread.sleep(6000);
		countries.selectByValue("India");
		Thread.sleep(6000);

	}

	@Test

	public void reactSelectDemo() throws UnexpectedException, MalformedURLException, InterruptedException {
		this.createDriver("chrome");
		WebDriver driver = this.getWebDriver();
		driver.get("http://localhost:3000/");
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("select-countries")));
		ReactSelect countries = new ReactSelect(driver.findElement(By.xpath("//div[@id='select-countries']/div")));
		countries.selectByValue("India");
		System.out.println("Count of country list: " +countries.getOptions().size());
		Thread.sleep(6000);
	}

	@Test

	public void htmlSelectDemo() throws UnexpectedException, MalformedURLException, InterruptedException {
		this.createDriver("chrome");
		WebDriver driver = this.getWebDriver();
		driver.get("http://localhost:3000/");
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='html-countries']")));
		Thread.sleep(3000);
		Select countriesList = new Select(driver.findElement(By.xpath("//select[@id='html-countries']")));
		countriesList.selectByIndex(10);
		Thread.sleep(6000);
	}

}
