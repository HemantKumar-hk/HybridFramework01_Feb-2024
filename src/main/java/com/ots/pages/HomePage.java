/**
 * 
 */
package com.ots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.ots.helper.Utility;

/**
 * This class will store all the locators and methods of the Login page
 */
public class HomePage 
{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		
	    this.driver=driver;	
	}
	
	private By manageOption=By.xpath("//span[normalize-space()='Manage']");
	
	private By manageCategories = By.xpath("//a[normalize-space()='Manage Categories']");	
	
	private By menuIcon=By.xpath("//img[@alt='menu']");
	
	private By signOut=By.xpath("//button[normalize-space()='Sign out']");
	
	
	public boolean isManageOptionDisplayed()
	{
		return driver.findElement(manageOption).isDisplayed();
	}
	
	
    public void logoutFromApplication() 
    {
		
		driver.findElement(menuIcon).click();
		driver.findElement(signOut).click();
			
	}
    
    public CategoryPage createCategory()
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(Utility.getElement(driver, manageOption)).perform();
		
		Utility.getElement(driver, manageCategories).click();
		
		Utility.switchToChildWindow(driver);
		
		CategoryPage category = new CategoryPage(driver);
		
		return category;
	}
    
}
