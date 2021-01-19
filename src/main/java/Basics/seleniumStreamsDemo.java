package Basics;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class seleniumStreamsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Click on column to sort by this.column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//Capture all WebElements into list
		List<WebElement> products = driver.findElements(By.xpath("//tr/td[1]"));
		
		//Capture text with streams and sort as new list
		List<String> stringProducts = products.stream().map(product->product.getText()).collect(Collectors.toList());
		List<String> sortedProducts = stringProducts.stream().sorted().collect(Collectors.toList());
		
		//Assert that both lists are equal. Best to use assertTrue instead of assertEquals for lists
		Assert.assertTrue(stringProducts.equals(sortedProducts));
		
		//Scan the name column with getText(), once encountering specific product, print the price
		//Using a do/while loop for pagenation style items
		//Don't forget to place products('stuff') in do/while loop since it needs to reinitialize after each loop, else you get stuck
		List<String> prices;
		do {
			List<WebElement> stuff = driver.findElements(By.xpath("//tr/td[1]"));
			prices = stuff.stream().filter(product->product.getText().contains("Rice")).
				map(product->getVeggiePrice(product)).collect(Collectors.toList());
			prices.forEach(price->System.out.println(price));
			if(prices.size()==0) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		}while(prices.size()==0);
		
		
		driver.close();
	}
	
	public static String getVeggiePrice(WebElement product) {
		return product.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
