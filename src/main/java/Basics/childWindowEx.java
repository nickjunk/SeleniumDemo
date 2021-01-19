package Basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class childWindowEx {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Maximizes window
		driver.get("https://accounts.google.com/signin/v2/identifier?hl=en&passive=true&continue=https%3A%2F%2Fwww.google.com%2F&ec=GAZAAQ&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.xpath("//a[text()='Help']")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> idsIt = ids.iterator();
		// Create set and iterator of the window ids (based on the amount of windows that webdriver opened)
		String parentId = idsIt.next();
		//grabs and saves parent windowId
		String childId = idsIt.next();
		//grabs and saves child windowId
		driver.switchTo().window(childId);
		//changes to child window based on the id
		Thread.sleep(3000);
		driver.switchTo().window(parentId);
	}

}
