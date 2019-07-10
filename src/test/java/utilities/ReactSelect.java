package utilities;

import org.openqa.selenium.*;
import java.util.List;

/**
 * Models a react-select dropdown, providing helper methods to select options.
 * Author:dkoul@redhat.com Use getOptions method to chcek the list size.
 * 
 */

public class ReactSelect {

	private final WebElement element;

	public ReactSelect(WebElement element) {
		this.element = element;
	}

	public List<WebElement> getOptions() throws InterruptedException {

		element.click();
		Thread.sleep(2000);
		List<WebElement> options = element.findElements(By.xpath("//*[contains(@class,'option')]"));
		for (WebElement e : options) {
			System.out.println(e.getText());
		}
		return options;
	}

	public void selectByIndex(int index) throws InterruptedException {
		element.click();
		Thread.sleep(2000);
		List<WebElement> options = element.findElements(By.xpath("//*[contains(@class,'option')]"));
		System.out.println("Selecting option: " + options.get(index).getText());
		options.get(index).click();

	}

	public void selectByValue(String value) throws InterruptedException {

		element.click();
		Thread.sleep(2000);
		List<WebElement> options = element.findElements(By.xpath("//*[contains(@class,'option')]"));
		for (WebElement e : options) {
			if (e.getText().equalsIgnoreCase(value)) {
				System.out.println(e.getText());
				e.click();
				break;
			}
		}

	}

	public void searchAndSelect(String value) throws InterruptedException {

		List<WebElement> inputboxes = element.findElements(By.tagName("input"));
		if (inputboxes.isEmpty()) {
			System.out.println("No text field found");
		}
		inputboxes.get(0).sendKeys(value);
		List<WebElement> options = element.findElements(By.xpath("//*[contains(@class,'option')]"));
		options.get(0).click();
	}
}
