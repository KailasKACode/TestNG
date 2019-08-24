package DataProviderDemo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DummyDataProvider {

	
	@DataProvider(name="xlsx")
	public static void getDataFromXl() throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Kailas\\Desktop\\XXF.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet=book.getSheet("Sheet1");
		int row=sheet.getLastRowNum()+1;
		int col = sheet.getRow(0).getLastCellNum();
		Object [][] obj = new Object[row][col];
		for (int i = 0; i <=row; i++) {
			XSSFRow _row = sheet.getRow(i);
			for (int j = 0; j <=col; j++) {
				XSSFCell cell = _row.getCell(j);
				try {
				if (cell.getCellType().name().equals("STRING")) {
					System.out.println(obj[i][j]=_row.getCell(j).getStringCellValue());
				}
				else if (cell.getCellType().name().equals("NUMERIC")) {
					System.out.println(obj[i][j]=_row.getCell(j).getNumericCellValue());
					
				}
				}
				catch(NullPointerException e) {
					System.out.println("handled");
				}
			}
			
		}
		

}

	
	public static void main(String[] args) throws IOException {
		DummyDataProvider.getDataFromXl();

	}

}
