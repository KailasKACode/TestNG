package DataDriven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

public class CsvReadDemo {

	public static void main(String[] args) throws IOException {
		CSVReader csv = new CSVReader(new FileReader("C:\\Users\\Kailas\\Desktop\\C2ImportFamRelSample.csv"));
		String[] Csvcell;
		while ((Csvcell = csv.readNext()) != null) {
			for (int i = 0; i < Csvcell.length ; i++) {
				System.out.println(Csvcell[i]);

			}
		}

	}
}
