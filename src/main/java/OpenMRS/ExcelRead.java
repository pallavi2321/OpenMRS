package OpenMRS;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public void readTestData() throws IOException {
		FileInputStream fs = new FileInputStream("C:\\Users\\Admin\\technogeeks\\First_maven_project\\Excel_Data\\demo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		//XSSFSheet sheet1 = workbook.getSheet("sheet_name");   // access sheet using sheet name
		
		XSSFSheet sheet1 = workbook.getSheetAt(0);
		Row row = sheet1.getRow(0);
		Cell cell = row.getCell(0);
					
		for(int r=0;r<5;r++){
				for(int i= 0;i<3;i++) {
				String data = sheet1.getRow(r).getCell(i).getStringCellValue();
				
				//sheet1.getRow(r).getCell(i).getStringCellValue();  //returns string
				// sheet1.getRow(r).getCell(i).getNumericCellValue();  //returns double
								
				System.out.println("Data from sheet: " +data);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		ExcelRead obj = new ExcelRead();
		obj.readTestData();

	}
}