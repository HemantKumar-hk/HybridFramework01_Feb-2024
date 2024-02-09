package com.ots.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ots.dataProvider.ConfigReader;

public class Utility {
	
	static WebDriver driver=null;
	
	public static WebElement highLightElement(WebDriver driver, WebElement ele)
	{
		if(ConfigReader.getProperty("elementHighlight").equalsIgnoreCase("true"))
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].setAttribute('style','background:yellow; border: 2px solid red;')", ele);
		    
			try 
		    {
				Thread.sleep(500);
			} 
			catch (InterruptedException e) 
		    {
				
			}
		    
		    js.executeScript("arguments[0].setAttribute('style','border: 2px solid black;')",ele);
		}
		
		return ele;
	}
	

	public static void selectValueFromList(WebDriver driver, By locator, String value) {
		
		System.out.println("LOG:INFO - Finding all Element");
		
		List<WebElement> allElements = driver.findElements(locator);
		
		System.out.println("LOG:INFO - Total Elements fpund" + allElements.size());
		
		for(WebElement element:allElements) {
			String textFromElement=element.getText();
			
			if(textFromElement.contains(value)) {
				element.click();
				break;
			}
		}
	}
	
	
	
	
	
	

}
