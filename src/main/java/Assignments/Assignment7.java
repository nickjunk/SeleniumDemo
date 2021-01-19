package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement table = driver.findElement(By.cssSelector("table[id='product'] tbody"));
		List<WebElement> rows = table.findElements(By.cssSelector("tr"));
		System.out.println(rows.size());
		System.out.println(table.findElements(By.xpath("//tr/th")).size());
		System.out.println(rows.get(2).getText());
		driver.close();
	}

}
