package Basics;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;

public class certificationsAndMore {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/nicholas/Documents/QA/WebDrivers/chromedriver");
		
		//SSL Certifications
		//Desired Capabilities -> General chrome profile
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		//ch.acceptInsecureCerts(); -> or the below line
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//Merge to local browser
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		//Add ChromeOptions to driver initialization
		WebDriver driver = new ChromeDriver(c);
		//Maximize window and delete cookies
		driver.manage().deleteCookieNamed("cookieName");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http://www.google.com");
		
		//Taking a screenshot and returning as File, and saving to output folder
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("/Users/nicholas/Documents/QA/screenshot.png"));
		//Make sure to add Apache Commons IO to POM for copying and adding new files
		
	}

}
