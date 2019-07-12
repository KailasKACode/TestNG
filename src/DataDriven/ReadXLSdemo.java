package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSdemo {
	public static void main(String[] args) throws IOException {
		try {
			FileInputStream fils = new FileInputStream("C:\\Users\\Kailas\\Desktop\\TestDemo.xlsx");
			XSSFWorkbook book = new XSSFWorkbook(fils);
			XSSFSheet sheet = book.getSheetAt(0);
			int totalrow = sheet.getLastRowNum();
			
			for (int i = 0; i <= totalrow; i++) {
				Row row = sheet.getRow(i);
				int coll = row.getLastCellNum();
				for (int j = 0; j < coll; j++) {
					Cell cell = row.getCell(j);
					System.out.println(cell.toString());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}
