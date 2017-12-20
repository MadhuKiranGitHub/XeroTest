package properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class TestDataFile {
  public static void main(String[] args) {

	Properties prop = new Properties();
	OutputStream output = null;

//	try {
//
//		output = new FileOutputStream("config.properties");
//
//		// set the properties value
//		prop.setProperty("username", "user1");
//		prop.setProperty("password", "password1");
//		prop.setProperty("invalidUser", "abc");
//		prop.setProperty("invalidPswd", "1234");
//		// save properties to project root folder
//		prop.store(output, null);
//
//	} catch (IOException io) {
//		io.printStackTrace();
//	} finally {
//		if (output != null) {
//			try {
//				output.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//	
//public static Properties prop = new Properties();
//	
//	
//	public static void readProperties(){

		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
		
			System.out.println("From property file: Username-->"+prop.getProperty("username"));
			System.out.println("From property file:Password-->"+prop.getProperty("password"));
			System.out.println("From property file: Username-->"+prop.getProperty("invalidUser"));
			System.out.println("From property file:Password-->"+prop.getProperty("invalidPswd"));
			System.out.println("Street"+prop.getProperty("street "));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	
  }
}