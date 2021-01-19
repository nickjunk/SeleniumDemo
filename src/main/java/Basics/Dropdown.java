package Basics;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(3000);
		//Static dropdown
		WebElement currency = driver.findElement(By.xpath("//select[@name='ctl00$mainContent$DropDownListCurrency']"));
		Select currencyDrop = new Select(currency);
		currencyDrop.selectByValue("USD");
		Thread.sleep(1000);
		//Count and click checkbox
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//Click radio button
		//Assert return trip date is enabled
		//Assert.assertFalse(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		//^^ .isEnabled() does not always work for modern websites, depends on UI. Can used style change by taking attribute.
		Thread.sleep(500);
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		//Choosing passenger amount
		Thread.sleep(1500);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		Select passDrop = new Select(driver.findElement(By.xpath("//select[@name='ctl00$mainContent$ddl_Adult']")));
		passDrop.selectByValue("2");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "2 Adult");
		//Dynamic dropdown
		driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@value='COK'])[2]")).click();//grabs second element with same xpath
		//driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='COK']")).click();
		//^^Same thing as line before, but using parent/child instead of index
		Thread.sleep(1000);
		//Calendar UI -> look for specific classes or highlighted components for current date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		Thread.sleep(2000);
		driver.close();
	}
}
