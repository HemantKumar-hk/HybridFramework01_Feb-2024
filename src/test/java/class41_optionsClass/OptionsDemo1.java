package class41_optionsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsDemo1 {

	public static void main(String[] args) 
	{
		/*
		 * 1. Handle SSL Certificate
		 * 2. --headless=new Headless/Background mode
		 * 3. Add Extension, .CRX file
		 * 4. Proxy server
		 * 5. Download Directory - Setting path for download directory
		 */
		
		//Handle SSL Certificate
		ChromeOptions opt = new ChromeOptions();
		
		opt.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("http://www.cacert.org/");
		
		System.out.println("Page Title :" + driver.getTitle());
		
		System.out.println("Current URL : " + driver.getCurrentUrl());
		
		driver.quit();
	
	}

}
