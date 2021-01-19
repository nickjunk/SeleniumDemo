package Basics;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement suggest = driver.findElement(By.id("autosuggest"));
		suggest.sendKeys("Unit");
		Thread.sleep(2000);
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option:options) {
			if(option.getText().contains("United States")) {
				option.click();
				break; //make sure to add break to stop code from continuing loop after condition is met.
			}
		}
		Thread.sleep(2000);
		driver.close();
	}

}
