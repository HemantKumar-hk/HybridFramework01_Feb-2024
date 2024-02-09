package com.ots.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ots.dataProvider.ConfigReader;

public class BrowserFactory {
	
public static WebDriver startBrowser(String url) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	public static WebDriver startBrowser(String browserName, String url) {
		
		WebDriver driver=null;
		
		if(browserName.contains("chrome") || browserName.contains("google chrome") || browserName.contains("GC")) 
		{
			
			ChromeOptions opt=new ChromeOptions();
			
			if(ConfigReader.getProperty("headless").equalsIgnoreCase("true"))
			{
				System.out.println("LOG :INFO - Test will be running in headless mode");
				
				opt.addArguments("--headless=new");
			}
			
			if(ConfigReader.getProperty("acceptSSLCertificate").equalsIgnoreCase("true"))
			{
				opt.setAcceptInsecureCerts(true);
				
			}
							
			driver= new ChromeDriver(opt);
			
		}
		else if(browserName.contains("firefox") || browserName.contains("mozilla firfox") || browserName.contains("mf")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.contains("edge") || browserName.contains("microsoft edge") || browserName.contains("me")) {
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Please use either chrome, firefox, edge");
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoadTimeOut"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("scriptTimeOut"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		return driver;
	}
	
	//For executing test cases in Cloud. "local" will tell on which environment to execute.
	
    public static WebDriver startBrowser(String browserName, String url, boolean local) {
		
    	WebDriver driver=null;
    	
		if(browserName.contains("chrome") || browserName.contains("google chrome") || browserName.contains("GC")) {
			driver= new ChromeDriver();
		}
		else if(browserName.contains("firefox") || browserName.contains("mozilla firfox") || browserName.contains("mf")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.contains("edge") || browserName.contains("microsoft edge") || browserName.contains("me")) {
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Please use either chrome, firefox, edge");
		}
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
        driver.get(url);
		
		driver.manage().window().maximize();
		
		return driver;
	}

}
