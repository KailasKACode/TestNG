package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readxmsls {
	public static void main(String[] args) throws IOException {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Kailas\\Desktop\\TestDemo.xlsx");
			XSSFWorkbook book=new XSSFWorkbook(fis);
			XSSFSheet sheet=book.getSheetAt(0);
			int lastrownum=sheet.getLastRowNum();
			System.out.println("Last row number: "+lastrownum);
			for (int i = 0; i <=lastrownum ; i++) {
				Row row=sheet.getRow(i);
				System.out.println(row);
				int getlasCell=row.getLastCellNum();
				for (int j = 0; j <=getlasCell; j++) {
					Cell cell=row.getCell(j);
					
					System.out.println(cell.toString());
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found :");
		}
		

	}
}
