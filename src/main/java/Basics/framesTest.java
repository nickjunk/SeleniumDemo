package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class framesTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		//Switch to frame based on WebElement
		WebElement drags = driver.findElement(By.id("draggable"));
		drags.isDisplayed();
		Actions a = new Actions(driver);
		a.dragAndDrop(drags, driver.findElement(By.id("droppable"))).build().perform();
		driver.switchTo().defaultContent();
		//Switch out of frame
	}

}
