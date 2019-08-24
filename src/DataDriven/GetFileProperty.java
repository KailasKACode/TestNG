package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetFileProperty {
	public String getProperty(String key) throws IOException {
		String value = null;
		FileInputStream fis = new FileInputStream("E:\\Newjava\\TestNGDemo\\Fileproperty");
		Properties prop = new Properties();
		prop.load(fis);
		return value = prop.getProperty(key);

	}
}
