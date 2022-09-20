package OpenMRS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelDataConfig {
	WebDriver driver;
	XSSFWorkbook workbook;
	public static XSSFSheet sheet; 
	String Excelpath = "C:\\Users\\Admin\\technogeeks\\First_maven_project\\Excel_Data\\TestData.xlsx";
	public static int rowC;
	FileInputStream fs; 
	
/*	public ExcelDataConfig() throws Exception {
	/*	File src = new File(Excelpath);
		fs = new FileInputStream(src);
		workbook = new XSSFWorkbook(fs);
		fs = new FileInputStream(Excelpath);
		workbook = new XSSFWorkbook(fs);
	} */  
	

	public HashMap<String, String> ExcelOperations(int rowno) throws Exception {

		FileInputStream fs = new FileInputStream(Excelpath);
		workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		
		HashMap<String, String> data = new HashMap<String, String>();
		int rowS = sheet.getFirstRowNum();
		int rowL = sheet.getLastRowNum();
		rowC=rowL-rowS;
		
		for(int j=1;j<=rowC;j++) {
			Row key = sheet.getRow(0);
			Row val= sheet.getRow(j);
			int cellC=key.getPhysicalNumberOfCells();
			for(int i =0;i<cellC;i++) {
				String k=key.getCell(i).getStringCellValue();
				String v=val.getCell(i).getStringCellValue();

				System.out.println(k+" "+v);
				data.put(k, v);
			}
		}
		return data;
	}
}







