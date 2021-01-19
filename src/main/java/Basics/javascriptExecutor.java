package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javascriptExecutor {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.ksrtc.in");
		WebElement from = driver.findElement(By.id("fromPlaceName"));
		from.sendKeys("BENG");
		from.sendKeys(Keys.DOWN);
		from.sendKeys(Keys.DOWN);
		from.sendKeys(Keys.ENTER);
		System.out.println(from.getText());
		//In case of hidden elements, use a simple JavaScripct DOM script to grab values.
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		String response = (String) js.executeScript(script);
		System.out.println(response);
		
	}

}
