package class42_seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {

	public static void main(String[] args) {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("browserName", "Chrome");
		
		Map<String, Object> browserstackOptions = new HashMap<String, Object>();
		
		browserstackOptions.put("os", "Windows");
		
		browserstackOptions.put("osVersion", "10");
		
		cap.setCapability("bstack:options", browserstackOptions);
		
		URL hubUrl = null;
		
		WebDriver driver = null;
		
		try 
		{
			hubUrl = new URL("https://hemantkumar_9mVl1k:KEPF5gu1zfG9E6gwGwmk@hub.browserstack.com/wd/hub");
			
			driver = new RemoteWebDriver(hubUrl, cap);
		} 
		catch (MalformedURLException e) 
		{
			System.out.println("Could not connect to hub :" + e.getMessage());
		}
		
		driver.get("https://www.selenium.dev/");
		
		System.out.println("Page Title : " + driver.getTitle());
		
		driver.quit();

	}

}
