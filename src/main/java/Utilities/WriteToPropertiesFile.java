package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WriteToPropertiesFile {
	
	public void writeToPropertyFile(String IMDBReleaseDate, String IMDBCountry, String value1, String value2) {

	try {
		OutputStream output = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\propertiesFiles\\resultsProperties.properties");
		Properties prop = new Properties();
		prop.setProperty(IMDBReleaseDate, value1);
		prop.setProperty(IMDBCountry, value2);
		prop.store(output, null);
		
		System.out.println(prop);
	} catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public void wrtie(String IMDBReleaseDate, String IMDBCountry, String value1, String value2) {
		FileOutputStream fileOut = null;
        FileInputStream fileIn = null;
        try {
            Properties prop = new Properties();

            File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\propertiesFiles\\resultsProperties.properties");
            fileIn = new FileInputStream(file);
            prop.load(fileIn);
            prop.setProperty(IMDBReleaseDate, value1);
    		prop.setProperty(IMDBCountry, value2);
            fileOut = new FileOutputStream(file);
            prop.store(fileOut, null);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            try {
                fileOut.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
	}
	}
}
