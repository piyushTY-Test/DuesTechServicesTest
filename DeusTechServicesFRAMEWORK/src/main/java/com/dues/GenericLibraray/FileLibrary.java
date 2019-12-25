package com.dues.GenericLibraray;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {
	/**
	 * Author:Piyush Singh
	 * Description: To read the basic environment settings data
	 * based on Property file value
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String getPropertyKeyValue(String key) throws IOException{
	
	String value=null;
	Properties pobj=new Properties();
	try {
		 FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties.txt");
		 pobj.load(fis);
		value=pobj.getProperty(key);
	} catch (Exception e) {
		// TODO: handle exception
	}
		
		 return value; 
	}	
	/**
	 * Author:Piyush Singh
	 * Description: To read the testScript data from ExcelSheet using Apache Poi
	 * @param SheetName
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws IOException
	 */
	public String getExcelData(String SheetName,int rowNum,int colNum) throws IOException
	{ 
		String data=null;
		try {
			
			FileInputStream fis=new FileInputStream("./src/test/resources/TestScriptData.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(SheetName);
			Row row=sh.getRow(rowNum);
			data=row.getCell(colNum).getStringCellValue();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return data;
	}
   
}

