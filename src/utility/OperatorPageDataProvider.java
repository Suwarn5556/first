package com.jbk.utility;

import java.io.FileInputStream;
import java.util.List;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class OperatorPageDataProvider {
	Workbook wb;
	Sheet sh;
	@DataProvider
	public String[][] getHeaderData() throws Exception {
		String data[][] = null;
		String path = "C:\\Users\\OC\\eclipse-workspace\\FinalPro\\src\\main\\resources\\utility\\OperatorPage.xls";
		String fn="headerList";
		int s = 0;
		int   b = 6;
		data = new String[s][b];
		List<String> data1 = ExcelUtilty.excelData(path,fn);
		for(int i=0;i<data1.size();i++) {
			data[s][b]=data1.get(i);
			b++;
		}
		return data;
	}
	@DataProvider
	public String[][] getTableData() throws Exception {
		String data[][] = null;
		FileInputStream fis = new FileInputStream("C:\\Users\\OC\\eclipse-workspace\\FinalPro\\src\\main\\resources\\resources\\OperatorPage.xls");
		wb = Workbook.getWorkbook(fis);
		sh = wb.getSheet("tableData");
		int row = sh.getRows();
		int col = sh.getColumns();
		data = new String[row][col];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Cell cell = sh.getCell(j, i);
				data[i][j] = cell.getContents();
			}
		}
		return data;
	}
}
