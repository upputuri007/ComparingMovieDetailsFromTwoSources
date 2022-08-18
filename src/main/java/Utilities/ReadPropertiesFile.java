package Utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {
	
	public Properties readTestDataPropertyFile() {
		try {
			InputStream input = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\propertiesFiles\\TestData.properties");
			Properties prop = new Properties();
			prop.load(input);
			return prop;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String readWebsiteURl(String keyName) {
		return readTestDataPropertyFile().getProperty(keyName);
	}
	
	public String readIMDBLandingPageTitle(String keyName) {
		return readTestDataPropertyFile().getProperty(keyName);
	}
	
	public String readIMDBMovieName(String keyName) {
		return readTestDataPropertyFile().getProperty(keyName);
	}
	
	public String readSearchedResultsPageTitle(String keyName) {
		return readTestDataPropertyFile().getProperty(keyName);
	}
	
	public String readWikiLandingPageTitle(String keyName) {
		return readTestDataPropertyFile().getProperty(keyName);
	}

}
