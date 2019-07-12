package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXlsx {
	public static void main(String[] args) throws IOException {
		try {
			FileInputStream files = new FileInputStream("C:\\Users\\Kailas\\Desktop\\TestDemo.xlsx\\");
			XSSFWorkbook book = new XSSFWorkbook(files);
			XSSFSheet sheet = book.getSheet("Sheet1");
			int rows = sheet.getLastRowNum();
			Row row;
			for (int i = 0; i <= rows; i++) {
				row = sheet.getRow(i);
				int colms = row.getLastCellNum();
				for (int j = 0; j < colms; j++) {
					Cell cells = row.getCell(j);
					if (cells.getCellType().name().equals("NUMERIC")) {
						System.out.print(cells.getNumericCellValue() + "\t\t");
					} else if (cells.getCellType().name().equals("STRING")) {
						System.out.print(cells.getStringCellValue() + "\t\t");
					}
				}

				System.out.println();
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

}
