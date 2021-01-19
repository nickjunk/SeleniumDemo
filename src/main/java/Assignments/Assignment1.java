package Assignments;

import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement check1 = driver.findElement(By.id("checkBoxOption1"));
		check1.click();
		Assert.assertTrue(check1.isSelected());
		check1.click();
		Assert.assertFalse(check1.isSelected());
		
		int checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		Assert.assertEquals(checkboxes, 3);
		
		driver.close();
	}

}
