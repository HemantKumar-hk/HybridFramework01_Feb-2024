package com.ots.testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ots.factory.BrowserFactory;

public class BrokenURL2 
{
	
	public static void main(String[] args) 
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "https://in.linkedin.com/");
		
		//List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("Number of links found to check :" + allLinks.size());
		
		List<String> brokenLinks = new ArrayList<String>();
		
		for(WebElement ele:allLinks)
		{
			String url = ele.getAttribute("href");
			
			int code = getResponseCode(url);
			
			if(code>399 || code!=999)
			{
				brokenLinks.add(url);
			}
		}
		
		System.out.println("Number of broken links found :" + brokenLinks.size());
		
		System.out.println("The Links which are broken are :" + brokenLinks);
		
		driver.quit();
		
	}
	
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
		
		System.out.println("Code :" + code);
		
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
