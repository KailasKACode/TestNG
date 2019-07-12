package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class ToReadxls {
	public static void main(String[] args) throws IOException {
		try {
			FileInputStream files = new FileInputStream("C:\\Users\\Kailas\\Desktop\\tests-example.xls");
			HSSFWorkbook book = new HSSFWorkbook(files);
			HSSFSheet sheet = book.getSheet("Example Test");
			int rows = sheet.getLastRowNum();
			System.out.println("Total rows: " + rows);
			for (int i = 0; i <= rows; i++) {
				Row row = sheet.getRow(i);
				int cells = row.getLastCellNum();
				for (int j = 0; j < cells; j++) {
					Cell cell = row.getCell(j);
					if(cell.getCellType().name().equals("NUMERIC")) {
						System.out.print(cell.getNumericCellValue()+"\t");
					}
					else
						if(cell.getCellType().name().equals("STRING"))
								{
							System.out.print(cell.getStringCellValue()+"\t");
								}

				}
				System.out.println();

			}

		} catch (FileNotFoundException e) {
			System.err.println("File not found: ");
		}

	}

}
