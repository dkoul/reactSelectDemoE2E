package utilities;
import org.openqa.selenium.*;
import java.util.List;

/**
 * Models a Chosen dropdown, providing helper methods to select options.
 * Author:dkoul@redhat.com
 * Use getOptions method to chcek the list size.
 * 
 */


public class Chosen {

	private final WebElement element;

	public Chosen(WebElement element) {
		this.element = element;
	}

	public List<WebElement> getOptions() throws InterruptedException {

		element.click();
		Thread.sleep(2000);
		List<WebElement> options = element.findElements(By.className("active-result"));
		for (WebElement e : options) {
			System.out.println(e.getText());
		}
		return options;
	}

	public void selectByIndex(int index) throws InterruptedException {
		element.click();
		Thread.sleep(2000);
		List<WebElement> options = element.findElements(By.className("active-result"));
		System.out.println("Selecting option: " + options.get(index).getText());              
		options.get(index).click();

	}

	public void selectByValue(String value) throws InterruptedException {

		element.click();
		Thread.sleep(2000);
		List<WebElement> options = element.findElements(By.className("active-result"));
		for (WebElement e : options) {
			if (e.getText().equalsIgnoreCase(value)) {
				e.click();
				System.out.println("Selecting option: " + e.getText()); 
				break;
			}
		}

	}

}