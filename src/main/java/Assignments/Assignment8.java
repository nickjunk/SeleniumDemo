package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;

public class Assignment8 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String text = "United States";
		WebElement autoComplete = driver.findElement(By.id("autocomplete"));
		autoComplete.sendKeys("unit");
		List<WebElement> autoList = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		for(WebElement country : autoList) {
			if(country.findElement(By.cssSelector("div")).getText().contains(text)) {
				country.click();
			}
		}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script = "return document.getElementById(\"autocomplete\").value;";
		Assert.assertEquals("United States (USA)", (String) js.executeScript(script));
		driver.close();
	}

}
