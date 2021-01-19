package Basics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footer = driver.findElement(By.cssSelector("div[id='gf-BIG']"));
		//Check count of total links
		System.out.println(driver.findElements(By.cssSelector("a")).size());
		//Check count of links in footer
		System.out.println(footer.findElements(By.cssSelector("a")).size());
		//Check count of links in first column of footer
		WebElement footerFirstCol = footer.findElement(By.xpath("table/tbody/tr/td[1]/ul"));
		System.out.println(footerFirstCol.findElements(By.tagName("a")).size());
		//Loop through first column, selecting links and opening in new tab
		for(int i=1; i<footerFirstCol.findElements(By.tagName("a")).size(); i++) {
			String clickOnLinkTab=Keys.chord(Keys.COMMAND, Keys.ENTER);
			footerFirstCol.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
		}
		Thread.sleep(5000);
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> idsIt = ids.iterator();
		while(idsIt.hasNext()) {
			String nextWindow = idsIt.next();
			driver.switchTo().window(nextWindow);
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}

}
