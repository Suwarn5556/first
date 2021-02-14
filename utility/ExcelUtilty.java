package com.jbk.utility;

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelUtilty {
	
	public static List<String> excelData(String filePath,String sheetName) throws Exception {
		String data = null;
		List<String> expData = new ArrayList<String>();
		FileInputStream f=new FileInputStream(filePath);
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh = wb.getSheet(sheetName);
		int rows = sh.getRows();
		int cols = sh.getColumns();
		Cell cell = null;
		data=new String();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				 cell= sh.getCell(j, i);
				 data=cell.getContents();
				 expData.add(data);
				}
		}
		return expData;
		}
	public static String data(String filePath,String sheetName,int col,int row) throws Exception {
		String data = null;
		FileInputStream f=new FileInputStream(filePath);
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh = wb.getSheet(sheetName);
		data=sh.getCell(col, row).getContents();
		return data;
		
		
	}
	public static List<String> excelDataByRowNo(String filePath,String sheetName,int row) throws Exception {
		String data = null;
		List<String> expData = new ArrayList<String>();
		FileInputStream f=new FileInputStream(filePath);
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh = wb.getSheet(sheetName);
		//int rows = sh.getRows();
		int cols = sh.getColumns();
		Cell cell = null;
		data=new String();
	     for (int j = 0; j < cols; j++) {
				 cell= sh.getCell(j, row);
				 data=cell.getContents();
				 expData.add(data);
				 
				}
		return expData;
	}
	public static List<String> excelDataByColNo(String filePath,String sheetName,int col) throws Exception {
		String data = null;
		List<String> expData = new ArrayList<String>();
		FileInputStream f=new FileInputStream(filePath);
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh = wb.getSheet(sheetName);
		int rows = sh.getRows();
		//int cols = sh.getColumns();
		Cell cell = null;
		data=new String();
	     for (int j = 0; j < rows; j++) {
				 cell= sh.getCell( col,j);
				 data=cell.getContents();
				 expData.add(data);
				 
				}
		return expData;
	}
}