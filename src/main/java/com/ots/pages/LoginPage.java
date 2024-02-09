/**
 * 
 */
package com.ots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ots.helper.Utility;

/**
 * This class will store all the locators and methods of the Login page
 */
public class LoginPage 
{
	
	WebDriver driver;
	
	private By username=By.id("email1");
	
	private By password=By.id("password1");
	
	private By loginButton=By.xpath("//button[normalize-space()='Sign in']");
	
	private By newUserLink=By.xpath("//a[normalize-space()='new user? Signup']");
	
	public LoginPage(WebDriver driver) 
	{
		
	    this.driver=driver;	
	}
	
	public HomePage loginToApplication(String user, String pass) 
	{
		
		Utility.highLightElement(driver, driver.findElement(username)).sendKeys(user);
		Utility.highLightElement(driver, driver.findElement(password)).sendKeys(pass);
		Utility.highLightElement(driver, driver.findElement(loginButton)).click();
		
		HomePage page=new HomePage(driver);
		
		return page;
	}
	
	public boolean isNewUserLinkVisible(String uid) 
	{
		
		return driver.findElement(newUserLink).isDisplayed();
	}
	
	
}
