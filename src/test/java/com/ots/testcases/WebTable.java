package com.ots.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTable {
    @Test
	public void verifyTableDemo() throws InterruptedException {
		
		//https://seleniumpractice.blogspot.com/2024/08/webtable-in-html.html
		System.out.println("################################################");
		System.out.println("Verifying table all column headers");
		System.out.println("################################################");
		//WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("admin@email.com");
		
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("admin@123");
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		Thread.sleep(2000);
		
		WebElement eleManage = driver.findElement(By.xpath("//div//span[text()='Manage']"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(eleManage);
		
		WebElement eleManageCourses = driver.findElement(By.xpath("//a[text()='Manage Courses']"));
		
		action.moveToElement(eleManageCourses);
		
		action.click().build().perform();
		
		List<WebElement> allHeaders = driver.findElements(By.xpath("//table[contains(@class,'courses-table')]//th"));
			
		System.out.println("Headers Count : " + allHeaders.size());
		
		Assert.assertEquals(allHeaders.size(), 12, "Number of column Headers does not match");
		
		boolean status = false;
		
		for(WebElement ele: allHeaders)
		{
			String value = ele.getText();
			
			System.out.println(value);
			
			if(value.equalsIgnoreCase("Category"))
			{
				status=true;
				//break;
			}
		}
		
		Assert.assertTrue(status, "Column Header is not present");
		
		System.out.println("################################################");
		System.out.println("Verifying table row");
		System.out.println("################################################");
		
		List<WebElement> numberOfRows = driver.findElements(By.xpath("//table[contains(@class,'courses-table')]//tr"));
		
		System.out.println("Total count of Rows : " + numberOfRows.size());
		
		Assert.assertEquals(numberOfRows.size(), 7,"Table row count mismatched");
		
		System.out.println("################################################");
		System.out.println("Verifying table Data");
		System.out.println("################################################");
		
		List<WebElement> allTableData = driver.findElements(By.xpath("//table[contains(@class,'courses-table')]//td"));
		
		boolean statusTD = false;
		
		for(WebElement eleTD: allTableData)
		{
			String value=eleTD.getText();
			
			System.out.println(value);
			
			if(value.equalsIgnoreCase("Playwright"))
			{
				statusTD = true;
				break;
			}
		}
		
		Assert.assertTrue(statusTD, "Record did not find");
		
		System.out.println("################################################");
		System.out.println("Verifying Course Name Column Data - Only second column data");
		System.out.println("################################################");
		
		List<WebElement> allCourseName = driver.findElements(By.xpath("//table[contains(@class,'courses-table')]//tr//td[2]"));
		
		Assert.assertEquals(allCourseName.size(), 6, "Number of Course Name is more or leass than 6");
		
		boolean statusCN = false;
		
		for(WebElement ele: allCourseName)
		{
			String value = ele.getText();
			
			System.out.println(value);
			
			if(value.equalsIgnoreCase("Playwright"))
			{
				statusCN = true;
				//break;
			}
			
		}
		
		Assert.assertTrue(statusCN, "Course Name not found");
		
		System.out.println("################################################");
		System.out.println("Click on Cypress Download link - following-sibling");
		System.out.println("################################################");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//td[contains(text(),'Cypress')]//following-sibling::td[9]//a//img")).click();
		
		
		driver.quit();
		
	}

}
