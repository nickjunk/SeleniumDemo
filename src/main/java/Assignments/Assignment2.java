package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		Thread.sleep(3000);
		Select adultPassDrop = new Select(driver.findElement(By.xpath("//select[@name='adults']")));
		adultPassDrop.selectByValue("3");
		Thread.sleep(500);
		driver.findElement(By.id("DepartDate")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[id='MoreOptionsLink']")).click();
		Thread.sleep(300);
		driver.findElement(By.name("airline")).sendKeys("aer");
		Thread.sleep(4000);
		List<WebElement> airlines = driver.findElements(By.xpath("//ul[@id='ui-id-3'] //li //a"));
		for(WebElement airline : airlines) {
			if(airline.getText().contains("Aeromexico")) {
				airline.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.findElement(By.id("SearchBtn")).click();
		Thread.sleep(750);
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		driver.close();
	}

}
