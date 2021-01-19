package Basics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class brokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert softAssert = new SoftAssert();
		//Grab url from element as a string
		String url = driver.findElement(By.xpath("//a[@href='https://rahulshettyacademy.com/brokenlink']")).getAttribute("href");
		//Create a connection and call url, retrieving the response code
		/*
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();
		System.out.println(respCode);
		*/
		//Checking response of every link in the footer via for loop
		WebElement footer = driver.findElement(By.cssSelector("div[id='gf-BIG']"));
		List<WebElement> footerLinks = footer.findElements(By.cssSelector("a"));
		for(WebElement link : footerLinks) {
			String href = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(href).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			/*
			if(respCode>=400) {
				System.out.println("The link with text "+link.getText()+" failed with response code: "+respCode);
				Assert.assertTrue(false);
			}
			*/
			//Same using Soft Assert from testNG (Does not stop automatically at 400 code failure)
			softAssert.assertTrue(respCode<=400, "The link with text "+link.getText()+" failed with response code: "+respCode);
		}
		//Always add assertAll at very end, outside of for loop
		softAssert.assertAll();
	}

}
