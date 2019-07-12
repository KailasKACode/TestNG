package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLXSFile {
	public static void main(String[] args) throws IOException {
		ReadXLXSFil();
	}

	public static void ReadXLXSFil() throws IOException {
		try {
			FileInputStream files = new FileInputStream("C:\\Users\\Kailas\\Desktop\\TestDemo.xlsx");
			XSSFWorkbook book = new XSSFWorkbook(files);
			XSSFSheet sheet = book.getSheet("Sheet1");
			int lastrow = sheet.getLastRowNum();
			for (int i = 0; i <= lastrow; i++) {
				Row row = sheet.getRow(i);
				int col = row.getLastCellNum();
				for (int j = 0; j < col; j++) {
					Cell cell = row.getCell(j);
					if (cell.getCellType().name().equals("STRING")) {
						System.out.print(cell.getStringCellValue()+"\t");
					} else if (cell.getCellType().name().equals("NUMERIC")) {
						System.out.print(cell.getNumericCellValue()+"\t");
					} else if (cell.getCellType().name().equals("BOOLEAN")) {
						System.out.print(cell.getBooleanCellValue()+"\t");
					} else {
						System.out.print(cell.getErrorCellValue()+"\t");
					}
				}

				System.out.println();
			}

		} catch (FileNotFoundException e) {

			System.out.println("File not found: ");
		}

	}

}
