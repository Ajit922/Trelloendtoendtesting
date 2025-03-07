package com.trello.qspiders.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class help us to read the data from excel workbook.
 * @author QASM6
 *
 */
public class ExcelUtility {
	/**
	 * To read the String data from the excel workbook.
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return String CellData
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String readStringData(String sheetName,int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/trelloworkbookdata.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet(sheetName);
	String cellData = sheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
	workbook.close();
	return cellData;
	
}
/**
 * To read the Numeric data from the excel workbook.
 * @param sheetName
 * @param rowIndex
 * @param cellIndex
 * @return NumericCellfData
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public double readNumericData(String sheetName,int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException  {
	FileInputStream fis = new FileInputStream("./src/test/resources/trelloworkbookdata.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet(sheetName);
	double cellData = sheet.getRow(rowIndex).getCell(cellIndex).getNumericCellValue();
	workbook.close();
	return cellData;
}
}
