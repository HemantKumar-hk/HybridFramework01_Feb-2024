package com.ots.testcases;

import java.util.LinkedHashSet;

public class WelcomeMsg {

	public static void main(String[] args) {
		
		System.out.println("Welcome, write your java program");
		
		String valueWord = "Kobe is Is the The best player In in Basketball basketball game .";
		
		removeDuplicateWords(valueWord);
		
		String valueChar = "Hemanth Kumar Automation Engineer";
		
		removeDuplicateCharacters(valueChar);

	}
	
	public static void removeDuplicateCharacters(String value)
	{
		char[] charArr = value.toCharArray();
		
		LinkedHashSet<Character> noDuplicateChar = new LinkedHashSet<Character>();
		
		StringBuilder strBui = new StringBuilder();
		
		for(int i=charArr.length-1;i>=0;i--)
		{
			if(((!noDuplicateChar.contains(Character.toLowerCase(charArr[i])))&&(!noDuplicateChar.contains(Character.toUpperCase(charArr[i]))))||(charArr[i]==' '))
			{
				noDuplicateChar.add(charArr[i]);
				
				strBui.append(charArr[i]).append("");
			}
		}
		
		System.out.println("String without duplicate characters using LinkedHashSet : " + noDuplicateChar.toString().replace("[", "").replace(",", " ").replace("]", ""));
		
		System.out.println("String without duplicate characters : " + strBui.reverse());
	}
	
	public static void removeDuplicateWords(String value)
	{
		String[] strArr = value.split("\\s+");
		
		LinkedHashSet<String> noDuplicateWords = new LinkedHashSet<>();
		
		StringBuilder strBui = new StringBuilder();
		
		for(String str : strArr)
		{
			if((!noDuplicateWords.contains(str.toLowerCase()))&&(!noDuplicateWords.contains(str.toUpperCase())))
			{
				noDuplicateWords.add(str);
				
				/*if(strBui.indexOf(str) == -1)
				{
				strBui.append(str).append(" ");
				}*/
				if(!strBui.toString().contains(str))
				{
					strBui.append(str).append(" ");
					
					
				}
			}
		}
		
		System.out.println("The output using LinkedHashSet : " + noDuplicateWords.toString().replace("[", "").replace(",", " ").replace("]", ""));
		
		System.out.println("The output using StringBuilder : " + strBui);
	}

}
