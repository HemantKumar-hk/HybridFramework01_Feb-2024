package class41_optionsClass;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsDemo3 {

	public static void main(String[] args) 
	{
		/*
		 * 1. Handle SSL Certificate
		 * 2. --headless=new Headless/Background mode
		 * 3. Add Extension, .CRX file
		 * 4. Proxy server
		 * 5. Download directory - Setting path for download directory
		 */
		
		/*1. Add "GETCRX" extension, to download any plugin from Chrome web store (https://chromewebstore.google.com/detail/get-crx/dijpllakibenlejkbajahncialkbdkjc)
		 *2. Download CRX file of any extension which you want to use 
		 */
		
		//Add Extension
		ChromeOptions opt = new ChromeOptions();
		
		opt.addExtensions(new File("./plugins/SelectorsHub 5.2.8.0.crx"));
		
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		System.out.println("Page Title :" + driver.getTitle());
		
		System.out.println("Current URL : " + driver.getCurrentUrl());
		
		//driver.quit();
	
	}

}
