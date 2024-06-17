package com.ots.testcases;

import java.util.Scanner;

public class permutationString {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
        printPermutation(str, "");
        sc.close();
	}
	
	public static void printPermutation(String ques, String asf)
	{
		if(ques.length()==0)
		{
			System.out.println(asf);
			return;
		}
		
		for(int i=0;i<ques.length();i++)
		{
			char ch = ques.charAt(i);
			String qLPart = ques.substring(0, i);
			String qRPart = ques.substring(i+1);
			String roq = qLPart+qRPart;
			printPermutation(roq, asf+ch);
					
		}
	}

}
