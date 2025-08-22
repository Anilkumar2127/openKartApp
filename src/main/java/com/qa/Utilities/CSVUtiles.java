package com.qa.Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVUtiles {

	
	private static final String TEST_DATA_CSV_FILE_FOLDER="./src/test/resources/testData/";
	private static List<String[]> rows;
	
	public static Object[][] getCsvData(String csvName){
		String csvfilepath= TEST_DATA_CSV_FILE_FOLDER+csvName+".csv";
		
		CSVReader reader;
		try {
			reader=new CSVReader(new FileReader(csvfilepath));
			rows=reader.readAll();
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
		
		Object [][] data= new Object[rows.size()][];
		for(int i=0;i<rows.size();i++) {
			data[i]=rows.get(i);
		}
		return data;
	}

	
}
