package class41_optionsClass;

import java.io.File;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsDemo4 {

	public static void main(String[] args) 
	{
		/*
		 * 1. Handle SSL Certificate
		 * 2. --headless=new Headless/Background mode
		 * 3. Add Extension, .CRX file
		 * 4. Proxy server
		 * 5. Download directory - Setting path for download directory
		 */
		
		//4. Proxy Server - Currently we will use dummy proxy - please replace host and port with real data
		
		ChromeOptions opt = new ChromeOptions();
		
		Proxy proxy = new Proxy();
		
		//proxy.setAutodetect(true);
		
		//proxy.setHttpProxy("host:port");
		
		proxy.setHttpProxy("http://153.128.56.12:9090");
		
		opt.setCapability("proxy", proxy);
		
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		System.out.println("Page Title :" + driver.getTitle());
		
		System.out.println("Current URL : " + driver.getCurrentUrl());
		
		driver.quit();
	
	}

}
