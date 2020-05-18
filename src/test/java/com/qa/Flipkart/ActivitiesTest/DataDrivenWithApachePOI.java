package com.qa.Flipkart.ActivitiesTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenWithApachePOI {
	
	
	public static Workbook getWorkBook() throws Exception
	{
		Workbook wb;
	
		try {			
			String filePath=System.getProperty("user.dir")+"/Test Data/TestData.xlsx";
			File file=new File(filePath);
			FileInputStream fis=new FileInputStream(file);
			if(filePath.endsWith(".xlsx"))
			{
				wb=new XSSFWorkbook(fis);
			}
			else
			{
				wb=new HSSFWorkbook(fis);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return wb;
	}
	
	public static void readData(String sheetName) throws Exception
	{
		Workbook wb;
		Sheet sheet;
		Row row;
		Cell cell;
		int rowCount;
		int cellCount;
		try {
			wb=getWorkBook();
			sheet=wb.getSheet(sheetName);
			rowCount=sheet.getLastRowNum();
			
			for(int i=2;i<rowCount;i++)
			{
				row=sheet.getRow(i);
				cellCount=row.getLastCellNum();
				
				for(int j=0;j<cellCount;j++)
				{
					String value=row.getCell(j).getStringCellValue();
					System.out.println(value);
				}
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		DataDrivenWithApachePOI.readData("Sheet1");
	}

}
