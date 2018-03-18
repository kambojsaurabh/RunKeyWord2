package Run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Generic {
	public int getExcelRowCount(String xlPath, String sheetName) {
		try {
			FileInputStream file = new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheet(sheetName);
			int lastRowCount = sheet.getLastRowNum();
			return lastRowCount;
			
		} catch (Exception e) {
			return -1;
		}
	}
	
	public String getExcelCellValue(String xlPath, String sheetName,int row,int cell) {
		try {
		FileInputStream file= new FileInputStream(xlPath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		Cell cellObj = sheet.getRow(row).getCell(cell);
		cellObj.setCellType(CellType.STRING);
		String cellValue = cellObj.getStringCellValue();
		return cellValue;
		} 
		catch (Exception e) {
		return "";
		}
		
		
		
	}
	
}
