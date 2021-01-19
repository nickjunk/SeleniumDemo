package Basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class seleniumGrid {

	public static void main(String[] args) throws MalformedURLException {
		//Make sure you have hub and node set up, along with proper jars and java settings
		
		//DesiredCapabilities -> Telling test which browser and operating system
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("Chrome");
		dc.setPlatform(Platform.WIN10);
		
		//For remote running, require different driver taking in Server and DesiredCapabilities
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.9:4444/wd/hub"), dc);
		driver.get("https://www.google.com");
	}

}
