package class41_optionsClass;

import java.io.File;

public class CheckFiles 
{

	public static void main(String[] args) 
	{
		// How to deal with Files
		//Whenever you deal with a path, you will always use a File class
		
		File src = new File(System.getProperty("user.dir")+"/downloadedFiles/");
		
		/* First Check
		 * Before download, count should be 0
		 * After download, count should be 1
		 */
		
		File total_files[] = src.listFiles();
		
		//Now, i want to check number of files in this particular folder
		
		System.out.println("Total number of files in downloadedFiles directory : " + total_files.length);
		
		/* Second Check
		 * Check file exists and file extension
		 */
		
		boolean status = false;
		
		for(File fi: total_files)
		{
			boolean fileExist = fi.exists();
			
			System.out.println("File Exists ? :" + fi.exists());
			
			boolean isValidExtension = fi.getAbsolutePath().endsWith("test.txt");
			
			System.out.println("Verify file extension :" + isValidExtension);
			
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

	}

}
