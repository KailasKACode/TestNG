package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLFileReader {

	@Test
	public void radXl() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Kailas\\Desktop\\Rashan.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("rashnnn");
		int Lastrownum = sheet.getLastRowNum();
		System.out.println(Lastrownum);
		for (int i = 0; i <= Lastrownum; i++) {
			Row row=sheet.getRow(i);
			
		}

	}

}
