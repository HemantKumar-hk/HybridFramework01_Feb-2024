package class41_optionsClass;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsDemo5 {

	public static void main(String[] args) throws InterruptedException 
	{
		/*
		 * 1. Handle SSL Certificate
		 * 2. --headless = new    Headless/Background mode
		 * 3. Add Extension, .CRX file
		 * 4. Proxy server
		 * 5. Download Directory - Setting path for download directory
		 */
		
		//5. Download directory - Setting path for download directory
		
		File download_directory = new File(System.getProperty("user.dir")+"/downloadedFiles/");
		
		ChromeOptions opt = new ChromeOptions();
		
		//These are the settings that you have to do, to download files in specific directory 
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		
		prefs.put("download.default_directory", System.getProperty("user.dir")+"/downloadedFiles/");
		
	    opt.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(opt);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.get("https://the-internet.herokuapp.com/download");
		
		driver.findElement(By.xpath("//a[normalize-space()='test.txt']")).click();
		
		Thread.sleep(3000);
		
		/* How to perform check
		 * First Check
		 * Before download, Count should be 0
		 * After download, Count should be 1
		 */
		
        File total_files[] = download_directory.listFiles();
		
		System.out.println("Total number of files in downloadedFiles directory : " + total_files.length);
		
		/*
		 * Second Check
		 * Check File exists and File extension
		 */
		
		boolean status = false;
		
		for(File fi : total_files)
		{
			boolean fileExist = fi.exists();
			
			System.out.println("File Exists ? :" + fi.exists());
			
			boolean isValidExtension = fi.getAbsolutePath().endsWith("test.txt");
			
			System.out.println("Verify File Extension :" + isValidExtension);
			
			if(fileExist && isValidExtension)
			{
				status = true;
			}
		}
		
		if(status)
		{
			System.out.println("File downloaded successfully");
		}
		else
		{
			System.out.println("File downloading failed");
		}
		
		driver.quit();
	
	}

}
