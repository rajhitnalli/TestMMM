package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	public String getDataFromExcel(String sheetName, int rowNum,int celNum) throws Throwable
	{
		FileInputStream fes=new FileInputStream("./src/main/resources/ExcelFeb.xlsx");
		Workbook book=WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cel = row.getCell(celNum);
		String data = cel.getStringCellValue();
		return data;
	}
	
	public String getDataByUsingDataFormatter(String sheetName, int rowNum, int celNum) throws Throwable
	{
		FileInputStream fes=new FileInputStream("./src/main/resources/ExcelFeb.xlsx");
		Workbook book=WorkbookFactory.create(fes);
		DataFormatter format=new DataFormatter();
		String data = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(celNum));
		return data;
	}
}
