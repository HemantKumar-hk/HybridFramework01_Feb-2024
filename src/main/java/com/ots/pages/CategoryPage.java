package com.ots.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ots.helper.Utility;

public class CategoryPage 
{
	
	WebDriver driver;
	
	public CategoryPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By addNewCategory = By.xpath("//button[normalize-space()='Add New Category']");
	
	private By deleteCategoryButton = By.xpath("//div[normalize-space()='Delete Category']//following::button[normalize-space()='Delete']");
	
	public boolean enterCategoryName(String categoryName)
	{
		//Utility.getElement(driver, addNewCategory).click();
		
		driver.findElement(addNewCategory).click();
		
		Alert alt = driver.switchTo().alert();
		
		alt.sendKeys(categoryName);
		
		alt.accept();
		
		Utility.waitForSeconds(2);
		
		boolean status = driver.findElement(By.xpath("//td[normalize-space()='" + categoryName + "']")).isDisplayed();
		
		return status;
		
		
	}
	
	
	public boolean updateCategory(String categoryName, String newCategoryName)
	{
		Utility.getElement(driver, By.xpath("//td[normalize-space()='"+categoryName+"']//following::button[normalize-space()='Update']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		Alert alt = wait.until(ExpectedConditions.alertIsPresent());
		
		alt.sendKeys(newCategoryName);
		
		alt.accept();
		
		boolean status = Utility.getElement(driver, By.xpath("//td[normalize-space()='"+newCategoryName+"']")).isDisplayed();
		
		return status;
	}
	
	
	public boolean deleteCategory(String newCategoryName)
	{
		Utility.getElement(driver, By.xpath("//td[normalize-space()='"+newCategoryName+"']//following::button[normalize-space()='Delete']")).click();
		
		Utility.getElement(driver, deleteCategoryButton).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		boolean status = wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//td[normalize-space()='"+newCategoryName+"']"))));
		
		return status;
		
	}

}
