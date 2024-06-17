package com.ots.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.ots.dataProvider.ConfigReader;

public class SampleGrid {
	
	@Test
	public void testMethod() throws MalformedURLException, InterruptedException {
		
		ChromeOptions opt= new ChromeOptions();
		
		System.out.println("Starting....");
		
		//String hubUrl= ConfigReader.getProperty("gridURL")+":"+ConfigReader.getProperty("gridPort")+"/wd/hub";
		
		WebDriver driver = new RemoteWebDriver(new URL("http://13.126.75.237:4444/wd/hub"), opt);
		
		
		System.out.println("Opening the browser....");
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		
		System.out.println("Getting the title....");
		
		System.out.println(driver.getTitle());
		
		System.out.println("Hello");
		
		driver.quit();
		
	}

}
