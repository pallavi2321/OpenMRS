package OpenMRS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class completeExcelData {
	XSSFWorkbook workbook;
	XSSFSheet sheet; 
	String Excelpath = "C:\\Users\\Admin\\technogeeks\\First_maven_project\\Excel_Data\\TestData.xlsx";
	public static int rowC;

	public HashMap<String, String> ExcelOperations(int rowno) throws Exception {

		FileInputStream fs = new FileInputStream(Excelpath);
		workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		HashMap<String, String> data = new HashMap<String, String>();
		/*	Row key = sheet.getRow(0);
		Row val= sheet.getRow(rowno);*/
		int rowS = sheet.getFirstRowNum();
		int rowL = sheet.getLastRowNum();
		rowC=rowL-rowS;
		int rowval = sheet.getLastRowNum();
		System.out.println("row count "+rowval);
		
		System.out.println("Row count: " +rowC);
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
	public static void main(String[] args) throws Exception {
		completeExcelData excel = new completeExcelData();
		System.out.println("in main method: " +rowC);
		HashMap<String, String> TD= excel.ExcelOperations(2);
	}
}






