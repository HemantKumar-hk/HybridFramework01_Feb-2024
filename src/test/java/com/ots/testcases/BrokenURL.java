package com.ots.testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class BrokenURL {
	
	/*
	 * GET : To get the response from the server
	 * POST : To create a new resource on the server
	 * PUT : To update/Create a resource on the server
	 * PATCH : To update a resource on the server
	 * DELETE : To delete a record from the server
	 * 
	 *  To use Selenium to make an API call, we use "Apache HTTPClient" library
	 */

	public static void main(String[] args) {
		
		String APIurl = "https://www.google.com";
		
		int code = 0;
		
		try 
		{
			URL url = new URL(APIurl);
			
			HttpURLConnection openConn= (HttpURLConnection)url.openConnection();
			
			openConn.connect();
			
			code = openConn.getResponseCode();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println(code);
		
		if(code<=399 || code==999)
		{
			System.out.println("Link is Ok");
		}
		else
		{
			System.out.println("Link is Broken");
		}

	}

}
