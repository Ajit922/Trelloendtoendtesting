package com.trello.qspiders.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class will facilitate file handling to fetch the data from different files.
 * @author Ajit
 *
 */
public class FileUtility {
	/**
	 * We can read the data from property file in the Form of Key and Value.
	 * @author QASM6
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/trellocommondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}
