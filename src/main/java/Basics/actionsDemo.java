package Basics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Maximizes window
		driver.get("https://www.amazon.com/");
		Actions a = new Actions(driver);
		// Need to create Actions object based on the driver
		WebElement hover = driver.findElement(By.cssSelector("a[data-nav-role='signin']"));
		a.moveToElement(hover).build().perform();
		// Move to cursor to specific element and hover
		// Don't forget the .build().perform(); else will not execute
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		// Holds down SHIFT key and enters 'hello' (HELLO), then selects text
		a.moveToElement(hover).contextClick().build().perform();
		//To right-click
	}
}
