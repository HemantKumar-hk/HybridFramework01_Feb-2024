package class43_seleniumGridContinue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridContinue {

	public static void main(String[] args) {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName", "android");
		
		cap.setCapability("platformVersion", "13.0");
		
		cap.setCapability("deviceName", "Samsung Galaxy S23");
		
		cap.setCapability("browserstack.local", "true");
		
		cap.setCapability("browserstack.debug", "true");
		
		Map<String, Object> browserstackOptions = new HashMap<String, Object>();
		
		browserstackOptions.put("debug", "true");
		
		browserstackOptions.put("networkProfile", "4g-lte-good");
		
		browserstackOptions.put("deviceOrientation", "landscape");
		
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
