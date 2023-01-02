package com.inetbanking.testCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.eventusermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	public static void main (String[]args) throws IOException {
		
		FileInputStream file = new FileInputStream("/Users/mr.gobindachapai/eclipse-workspace/selenium_01_03/src/main/java/data/DemoData.xlsx");
	
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet("user");
	
	int rowcount = sheet.getLastRowNum();
	int columcount= sheet.getRow(0).getLastCellNum();
	System.out.println(rowcount);
	System.out.println(columcount);
	
	
	for(int i=0; i<rowcount;i++ ) {
		XSSFRow currentrow = sheet.getRow(i);
		
		for(int j = 0; j<columcount; j++) {
			String value =currentrow.getCell(j).toString();
			System.out.print(" " + value);
		}
		System.out.println();
	}
	
	
	
	}

}
