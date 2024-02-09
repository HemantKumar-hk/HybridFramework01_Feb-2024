package com.ots.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ots.base.BaseClass;
import com.ots.pages.HomePage;
import com.ots.pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void loginToApplicationWithValidCredentials()
	{
		LoginPage login = new LoginPage(driver);
		
		HomePage home=login.loginToApplication("admin@email.com","admin@123");
		
		Assert.assertTrue(home.isManageOptionDisplayed());
		
		
		
	}

}
