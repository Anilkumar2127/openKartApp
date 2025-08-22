package com.qa.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtiles {

	private static final String TEST_DATA_EXCEL_PATH="./src/test/resources/testData/openkartTestData.xlsx";
	private static Workbook wb;
	private static Sheet sheet;
	public static Object[][] getDataFromExcel(String sheetName) {
		try {
			FileInputStream fs=new FileInputStream(TEST_DATA_EXCEL_PATH);
			wb=WorkbookFactory.create(fs);//creates a workbook
			sheet=wb.getSheet(sheetName);// returns worksheet
			
			Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(i).getLastCellNum();j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			return data;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
