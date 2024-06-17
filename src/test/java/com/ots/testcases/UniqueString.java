package com.ots.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UniqueString {

	public static void main(String[] args) {
		
		System.out.println("In main method.........");
		
		removeDuplicateWords();
		
		String valueint = "Hem123ant456kqa789@gmail.com";
		
		removeIntFromString(valueint);

	}
	
	//Removing duplicate characters from string in reverse order(from starting)
	public static void removeDuplicateCharacters() {
		
		String value = "Hemanth Kumar Automation Engineer";

		Map<Character, Integer> exists = new HashMap<Character, Integer>();
				
		String strVal = "";
				
		boolean flag, flag1;

		char[] chArr = value.toCharArray();

		for(int i=chArr.length-1;i>=0;i--)
		{

			//System.out.println(chArr);
					
			if(!exists.containsKey(chArr[i])|| (chArr[i]==' '))
			{
				flag = exists.containsKey(Character.toLowerCase(chArr[i]));
					
				flag1 = exists.containsKey(Character.toUpperCase(chArr[i]));
					
				if((!flag && !flag1) || (chArr[i]==' '))
				{
					strVal += chArr[i];
					
					//strVal = strVal.concat(String.valueOf(chArr[i])); 
						
					exists.put(chArr[i], 1);
				}
					
			}
				
		//setChr.add(chArr[i]);
		}
				
				
		//char[] finalChArr = strVal.toCharArray();
				
		StringBuilder strBui = new StringBuilder();
				
		strBui.append(strVal);

		System.out.println("Output :" + strBui.reverse());

		/*for(i=steChr.size();i>=0;i--)
		{
			System.out.println(Character.parsechr(elements.index(i)));
		}
		*/
		
	}
	
	//Remove duplicate words from a string
	public static void removeDuplicateWords() {
		
		System.out.println("");
		
		System.out.println("Remove duplicate words from a string");
		
		String value = "Kobe is Is the The best player In in Basketball basketball game .";
		
		String[] strArr = value.split("\\s+");
		
		List<String> strList1 = Arrays.asList(value.split("\\s"));
		
		Set<String> strSet2 = new LinkedHashSet<String>();
		
		StringBuilder strBui = new StringBuilder();
		
		/*for(int i=0;i<strList1.size();i++)
		{
			if((!strSet2.contains(strList1.get(i).toLowerCase()))&&(!strSet2.contains(strList1.get(i).toUpperCase())))
			{
				strSet2.add(strList1.get(i).toLowerCase());
				
				strBui.append(strList1.get(i)).append(" ");
			}
		}*/
		
		for(String str : strArr)
		{
			if((!strSet2.contains(str.toLowerCase()))&&(!strSet2.contains(str.toUpperCase())))
			{
				strSet2.add(str.toLowerCase());
				
				strBui.append(str).append(" ");
			}
		}
		
		System.out.println("After removing duplicate value from string : " + strSet2.toString().replace(","," ").replace("["," ").replace("]", " ").trim());
		
		String nonDuplicateString = strBui.toString().trim();
		
		System.out.println("After removing duplicate words from string using StringBuilder : " + nonDuplicateString);
		
		
		
		
		/*String fullString = "lol lol";
		String[] words = fullString.split("\\W+");
		StringBuilder stringBuilder = new StringBuilder();
		Set<String> wordsHashSet = new HashSet<>();

		for (String word : words) {
		    // Check for duplicates
		    if (wordsHashSet.contains(word.toLowerCase())) continue;

		    wordsHashSet.add(word.toLowerCase());
		    stringBuilder.append(word).append(" ");
		}
		String nonDuplicateString = stringBuilder.toString().trim();
		
		String newl = temp.toString()
          .replace("[","")
          .replace("]","")
          .replace(",","");*/

		
	}
	
	//Remove digits from your email
	public static void removeIntFromString(String value) {
		
		char[] chArr = value.toCharArray();
		
		System.out.println("String after removing digits : " + value.replaceAll("[^A-Za-z@]", ""));
		
	}

}
