package com.ots.helper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ots.dataProvider.ConfigReader;

public class Utility 
{
	
	public static void waitForSeconds(int seconds)
	{
		try 
		{
			Thread.sleep(seconds*1000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	public static WebElement getElement(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		if(Integer.parseInt(ConfigReader.getProperty("speed"))>0)
		{
	       Utility.waitForSeconds(Integer.parseInt(ConfigReader.getProperty("speed")));
		}
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		if(ConfigReader.getProperty("elementHighlight").equalsIgnoreCase("true"))
		{
			highLightElement(driver, element);
		}
		
		return element;
		
	}
	
	
	public static WebElement highLightElement(WebDriver driver, WebElement element)
	{
		if(ConfigReader.getProperty("elementHighlight").equalsIgnoreCase("true"))
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].setAttribute('style','background:yellow; border: 2px solid red;')", element);
		    
			try 
		    {
				Thread.sleep(500);
			} 
			catch (InterruptedException e) 
		    {
				
			}
		    
		    js.executeScript("arguments[0].setAttribute('style','border: 2px solid black;')",element);
		}
		
		return element;
	}
	

	public static void switchToChildWindow(WebDriver driver)
	{
		
		String parentWindowHandle=driver.getWindowHandle();
		
		Set<String> allWindowHandles= driver.getWindowHandles();
		
		Iterator<String> itr=allWindowHandles.iterator();
		
		while(itr.hasNext())
		{
			String child=itr.next();
			
			if(!parentWindowHandle.equals(child))
			{
				driver.switchTo().window(child);
			
			}
		}
		
	}
	
	
	public static void switchToChildWindow(WebDriver driver, int indexOfTabs)
	{
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		List<String> allWindowHandlesInList = new ArrayList<String>(allWindowHandles);
		
		String childWindow = allWindowHandlesInList.get(indexOfTabs);
		
		driver.switchTo().window(childWindow);
	}
	
	
	public static void selectValueFromList(WebDriver driver, By locator, String value) 
	{
		
		System.out.println("LOG:INFO - Finding all Element");
		
		List<WebElement> allElements = driver.findElements(locator);
		
		System.out.println("LOG:INFO - Total Elements found" + allElements.size());
		
		for(WebElement element:allElements) 
		{
			String textFromElement=element.getText();
			
			if(textFromElement.contains(value)) 
			{
				element.click();
				break;
			}
		}
			
	}
	
	//Broken Links
	
	public static int getResponseCode(String url)
	{
        HttpURLConnection urlConn;  
        
		int code = 0;
		
		try 
		{
			System.out.println("*****************************************************");
			
			urlConn = (HttpURLConnection)(new URL(url).openConnection());
			
			System.out.println("LOG : INFO - Trying to Connect " +url);
			
			urlConn.connect();
			
			System.out.println("LOG : INFO - Connection Done");
			
			if(!url.contains("twitter"))
			{
			    code = urlConn.getResponseCode();
			}
			else
			{
				code=200;
			}
			
		} 
		catch (IOException e) 
		{
			System.out.println("Could not connect to server :" + e.getMessage());
		}
		
		System.out.println("URL : " + url);
		
		System.out.println(code);
		
		if(code<=399 || code==999)
		{
			System.out.println("Link is Ok");
		}
		else
		{
			System.out.println("Link is Broken");
		}
		
		System.out.println("********************************************************");
		
		return code;
	}
	
}
