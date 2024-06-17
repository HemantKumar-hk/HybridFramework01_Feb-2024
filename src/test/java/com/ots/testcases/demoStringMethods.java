package com.ots.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class demoStringMethods {

	public static void main(String[] args) {
		// https://www.geeksforgeeks.org/reverse-a-string-in-java/
		
		System.out.println("In main() method");
		
		//reverseStringBySwappingVariable();
		
		//reverseStringByChar();
		
		//demoListIterator();
		
		reverseStringUsingStringBuffer();
		
	}
	
	//Reverse a string using swapping of variables
	
	public static void reverseStringBySwappingVariable()
	{
		System.out.println("");
		
		System.out.println("Reverse a string using swapping of variables");
		
		String value = "Hello World";

		//convert String to character array
		//by using toCharArray

		char[] ch = value.toCharArray();
		
		int left, right=0;
		
		right = ch.length-1;
		
		for(left=0;left<right;left++,right--)
		{
			char ch1 = ch[left];
			
			ch[left] = ch[right];
			
			ch[right] = ch1;
		}
		
		System.out.print("Printing string in reverse order using swapping of variable : ");
		
		for(char ch2: ch)
		{
			System.out.print(ch2);
		}
		
	}
	
	//Reverse a string by converting string to characters one by one
	
	public static void reverseStringByChar()
	{
		System.out.println("Reverse a string by converting string to characters one by one");
				
		String value = "Hello World";

		//convert String to character array
		//by using toCharArray

		char[] ch = value.toCharArray();

		String str = "";

		for(int i=value.length()-1;i>=0;i--)
		{
				
			str = str+ch[i];

			System.out.print(ch[i]);

		}

		System.out.println(" ");
				
		System.out.println("Reverse String is : " + str);
		
	}
	
	//Reverse a string using ListIterator(Using ArrayList object)
	
	public static void demoListIterator()
	{
		System.out.println("");
		
		System.out.println("Reverse a string using ListIterator(Using ArrayList object)");
		
		String value = "Hello World";
		
		char[] chArr = value.toCharArray();
		
		List<Character> chrList = new ArrayList<Character>();
		
		for(char ch1:chArr)
		{
			chrList.add(ch1);
		}
		
		Collections.reverse(chrList);
		
		ListIterator lItr = chrList.listIterator();
		
		while(lItr.hasNext())
		{
			System.out.print(lItr.next());
		}
		
	}
	
	//Conversion from String to StringBuffer and reverse of String
	
	public static void reverseStringUsingStringBuffer()
	{
		System.out.println("");
		
		System.out.println("Conversion from String to StringBuffer and reverse of String");
		
		String value = "Hello World";
		
		//conversion from String object to StringBuffer
		
		StringBuffer sbuf = new StringBuffer(value);
		
		//To reverse the String
		sbuf.reverse();
		
		System.out.println("String in reverse order using StringBuffer : " + sbuf);
		
		
	}

}
