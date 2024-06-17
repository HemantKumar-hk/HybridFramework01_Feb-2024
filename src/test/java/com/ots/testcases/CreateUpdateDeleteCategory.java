package com.ots.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ots.base.BaseClass;
import com.ots.dataProvider.CustomDataProvider;
import com.ots.pages.CategoryPage;
import com.ots.pages.HomePage;
import com.ots.pages.LoginPage;

public class CreateUpdateDeleteCategory extends BaseClass 
{
	CategoryPage category;
	
	//@Test(priority = 0)
	@Test(dataProvider = "loginCredentialsExcel", dataProviderClass = CustomDataProvider.class, priority = 0)
	public void createCategory(String username, String password)
	{
		LoginPage login= new LoginPage(driver);
		
		HomePage home=login.loginToApplication(username, password);
		
		//HomePage home=login.loginToApplication("admin@email.com", "admin@123");
		
		category = home.createCategory();
		
		boolean status = category.enterCategoryName("nightWatch");
		
		Assert.assertTrue(status, "Category Creation Failed");
		
	}
	
	@Test(priority=1, dependsOnMethods = "createCategory")
	public void updateCategory()
	{
		boolean status = category.updateCategory("nightWatch", "Cypress");
		
		Assert.assertTrue(status, "Could not update the category");
		
		
	}
	
	@Test(priority=2, dependsOnMethods = "updateCategory")
	public void deleteCategory()
	{
		boolean status = category.deleteCategory("Cypress");
		
		Assert.assertTrue(status, "Could not delete the category");
	}
	

}
