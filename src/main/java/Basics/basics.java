package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basics {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		System.out.println(driver.getCurrentUrl());
		driver.navigate().to("https://yahoo.com");
		driver.navigate().back();  //navigates back to Google
		//driver.navigate().forward(); //samsies but forward
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("King Charles Cavalier");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Google Search']")).click();
		Thread.sleep(2000);
		//use //tagName[contains(@attribute, 'value')] for xpath regex
		//if no unique tag for element, use parent element ex. //div['@class=lst-c']/div/div[2]/div/input
		//for text based xpath use //*[text()='Value']
		driver.findElement(By.cssSelector("input[aria-label='Search']")).clear();
		driver.findElement(By.cssSelector("input[aria-label='Search']")).sendKeys("cheese", Keys.ENTER);
		//use tagName[attribute*='value'] for css regex
		//Use following-sibling[1] to get next sibling in xpath
		//Use //parent::tagName to refer to that elements parent
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[data-sc='I']")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
