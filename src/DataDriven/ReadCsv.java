package DataDriven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;

import au.com.bytecode.opencsv.CSVReader;

public class ReadCsv {
	public static void main(String[] args) throws IOException {
		try {
			CSVReader csv = new CSVReader(new FileReader("C:\\Users\\Kailas\\Desktop\\C2ImportFamRelSample.csv"));
			String[] csvCell;// Delare String to pass all value in the file that in separed by comma
			while ((csvCell = csv.readNext()) != null) {
				for (int i = 0; i < csvCell.length - 1; i += 2) {
					String username = csvCell[i];
					String pass = csvCell[i + 1];
					System.out.print("username : " + username + " password : " + pass);
					System.out.println();

				}

			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		}
	}
}
