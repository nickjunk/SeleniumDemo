package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		WebDriverWait w = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath("//a[text()='Click to load get data via Ajax!']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
		System.out.println(driver.findElement(By.id("results")).getText());
		driver.close();
	}

}
