package com.acti.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Name: ExcelLib 
 * Description: This class is responsible for fetching the data from excel sheet
 * Developed By : Padma
 * Date : 11/29/22
 * Reviewed By : Shantosh
 */

public class ExcelLib {
	
	XSSFWorkbook wb;
	
	public ExcelLib(String excelPath)
	{
		try
		{
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			System.out.println("unable to load the excel file "+e.getMessage());
		}
	}
	
	public int getRowCount(int sheetnum)
	{
		int count = wb.getSheetAt(sheetnum).getLastRowNum()+1;
		return count;
	}
	
	public int getRowCount(String sheetName)
	{
		int count = wb.getSheet(sheetName).getLastRowNum()+1;
		return count;
	}
	
	public String getCellData(int sheetnum, int row, int col)
	{
		String data = wb.getSheetAt(sheetnum).getRow(row).getCell(col).toString();
		return data;
	}
	
	public String getCellData(String sheetName, int row, int col)
	{
		String data = wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		return data;
	}

}
