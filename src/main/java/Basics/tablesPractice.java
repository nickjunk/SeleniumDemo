package Basics;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;

public class tablesPractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/30510/csk-vs-kkr-49th-match-indian-premier-league-2020");
		WebElement parentTable = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		int batsmanCount = parentTable.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
		//Getting the 3rd child of the above element (tagname:nth-child(n))
		int runs = parentTable.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		int sum = 0;
		for(int i=0; i<runs-2; i++) {
			String run = parentTable.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			sum += Integer.parseInt(run);
		}
		//Using xpath to find the following sibling that is a div (following-sibling::tagname)
		sum += Integer.parseInt(parentTable.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText());
		int total = Integer.parseInt(parentTable.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText());
		System.out.println(sum+" = "+total);
		Assert.assertEquals(total, sum);
		driver.close();
	}

}
