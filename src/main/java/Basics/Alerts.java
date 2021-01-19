package Basics;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("Nick");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(1000);
		if(driver.switchTo().alert().getText().contains("Nick")) {
			Assert.assertTrue(true);
			System.out.println(driver.switchTo().alert().getText());
		} else {
			Assert.assertTrue(false);
		}
		driver.switchTo().alert().accept(); //accepts alert
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		
		driver.close();
	}

}
