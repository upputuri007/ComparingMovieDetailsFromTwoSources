package Utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadResultsPropertiesFile {
	
	public Properties readResultsPropertyFile() {
		try {
			InputStream input = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\propertiesFiles\\resultsProperties.properties");
			Properties prop = new Properties();
			prop.load(input);
			return prop;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String readIMDBReleaseDate(String keyName) {
		System.out.println(readResultsPropertyFile().getProperty("IMDBurl"));
		return readResultsPropertyFile().getProperty(keyName);
	}
	
	public String readIMDBCountry(String keyName) {
		return readResultsPropertyFile().getProperty(keyName);
	}
	
	public String readIWikipediaReleaseDate(String keyName) {
		return readResultsPropertyFile().getProperty(keyName);
	}
	
	public String readWikipediaCountry(String keyName) {
		return readResultsPropertyFile().getProperty(keyName);
	}

}
