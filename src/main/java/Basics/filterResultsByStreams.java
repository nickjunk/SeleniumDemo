package Basics;


import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class filterResultsByStreams {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String product = "Rice";
		driver.findElement(By.id("search-field")).sendKeys(product);
		
		List<WebElement> productList = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> stringProductsList = productList.stream().map(p->p.getText()).collect(Collectors.toList());
		List<String> filteredProducts = productList.stream().filter(p->p.getText().contains(product))
				.map(p->p.getText()).collect(Collectors.toList());
		Assert.assertEquals(productList.size(), filteredProducts.size());
		Assert.assertTrue(stringProductsList.equals(filteredProducts));
		
		driver.close();
	}

}
