package Basics;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;

public class WaitSyncronization {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//Implicit Wait beginning and settings -> now applied to each line of test (global)
		String[] itemsNeeded = {"Brocolli", "Cucumber", "Beetroot"};
		addItems(driver, itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//^^Text not dynamic so okay to use
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		WebDriverWait w = new WebDriverWait(driver, 5);
		//Explicit wait setting and class creation -> can place towards beginning of code, but here for example reason
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		//Pointing to specific element via locator and expectation
		String applied = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		Assert.assertEquals("Code applied ..!", applied);
	}
	
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<products.size(); i++) {
			String productName = products.get(i).getText().split("-")[0].trim();
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			if(itemsNeededList.contains(productName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
				//Loops through itemsNeededList to see if productName is present
				//Will click on correct button due to being at specific index of 'Cucumber' using .findElements and .get(i)
				//Be careful of dynamic elements like 'Add To Cart' changing to 'Added'
				if(j==itemsNeeded.length) {
					break;
				}
			}
		}
	}

}
