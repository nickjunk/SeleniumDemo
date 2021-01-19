package Basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");
		//Finding October 31
		Thread.sleep(10000);
		driver.findElement(By.name("travel_date")).click();
		//Finding October 31
		/*
		List<WebElement> days = driver.findElements(By.className("day"));
		for(WebElement day : days) {
			if(day.getText().equals("31")) {
				day.click();
				break;
			}
		}
		*/
		//Finding date in the future (Sept 20, 2021)

		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().equalsIgnoreCase("September 2021")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
		}
		List<WebElement> days = driver.findElements(By.className("day"));
		for(WebElement day : days) {
			if(day.getText().equals("20")) {
				day.click();
				break;
			}
		}
		
	}

}
