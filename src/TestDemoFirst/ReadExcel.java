package TestDemoFirst;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) {
		try {
			XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\Kailas\\Desktop\\Rashan.xlsx");
			XSSFSheet sheet = book.getSheet("rashnnn");
			int rows = sheet.getLastRowNum();
			Row rowdata;
			for (int i = 0; i <= rows; i++) {
				rowdata = sheet.getRow(i);
				int colsnum = rowdata.getLastCellNum();
				for (int j = 0; j < colsnum; j++) {
					Cell cell = rowdata.getCell(j);
					if (cell.getCellType().name().equals("STRING")) {
						System.out.print(cell.getStringCellValue());
					} 	else
						if(cell.getCellType().name().equals("NUMERIC"))
						{
							System.out.print(cell.getNumericCellValue());
						}
					System.out.print("  ");

				}
				System.out.println();


			}

		} catch (IOException e) {
			System.out.println("file not found");
		}

	}

}
