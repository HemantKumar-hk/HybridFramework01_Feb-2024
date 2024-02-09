package com.ots.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static Object [][] getDataFromExcel(String sheetName)
	{
		XSSFWorkbook wb=null;
		try 
		{
			wb = new XSSFWorkbook(new FileInputStream(new File("./TestData/SampleExcel.xlsx")));
		} catch (FileNotFoundException e) 
		{
			System.out.println("LOG : FAIL - Could not located the excel file");
		} catch (IOException e) 
		{
			System.out.println("LOG : FAIL - Could not read the excel file");
		}
		
		XSSFSheet sh1=wb.getSheet(sheetName);
		
		int rowCount=sh1.getPhysicalNumberOfRows();
		
		int cellCount=sh1.getRow(0).getPhysicalNumberOfCells();
		
		Object arr[][]= new Object[rowCount-1][cellCount];
		
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<=cellCount;j++)
			{
				if(sh1.getRow(i).getCell(j).getCellType().equalsIgnoreCase("String"))
				{
					arr[i-1][j]= sh1.getRow(i).getCell(j).getStringCellValue();
				}
				else if(sh1.getRow(i).getCell(j).getCellType().equalsIgnoreCase("int"))
				{
					arr[i-1][j]= sh1.getRow(i).getCell(j).getNumericCellValue();
				}
				else if (sh1.getRow(i).getCell(j).getCellType().equalsIgnoreCase("boolean"))
				{
					arr[i-1][j]= sh1.getRow(i).getCell(j).getBooleanCellValue();
				}
				else if(sh1.getRow(i).getCell(j).getCellType().equalsIgnoreCase("Null"))
				{
					arr[i-1][j]= "";
				}
			}
		}
		
		
		
	}

}  
