package Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkbox = driver.findElement(By.cssSelector("label[for='benz']"));
		checkbox.findElement(By.id("checkBoxOption2")).click();
		String choice = checkbox.getText();
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(choice);
		driver.findElement(By.id("name")).sendKeys(choice);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText().contains(choice));
		driver.switchTo().alert().accept();
		driver.close();
	}
}
