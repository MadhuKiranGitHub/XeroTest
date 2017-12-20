package com.rest.XeroTest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.rest.XeroTest.AutomationScripts;
import com.rest.XeroTest.ReusableMethods;

public class DriverTest {
	static WebDriver driver;
	@Test
	public void tests() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
	//public static void main(String[] args) throws InterruptedException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//AutomationScripts.LoginScript();
		
		
		
		String suitePath= "/Volumes/New Backups/QA Training docs/XeroTestSuit.xls";
		String[][] recData=ReusableMethods.readExcel(suitePath, "Sheet1");
	
		
		String testCase, flag,firefox,chrome;
		for(int i=1;i<recData.length;i++){
			
			flag=recData[i][1];
			
			if(flag.equalsIgnoreCase("Y")){ //If flag is set to Y
				//To execute in firefox browser if it is set to Y
				firefox=recData[i][3];
				if(firefox.equalsIgnoreCase("Y")){
					testCase=recData[i][2];
					ReusableMethods.startReport(testCase, "/Users/madhu/Desktop/xeroTest_Report/");
					System.setProperty("webdriver.gecko.driver", "/Users/madhu/Downloads/geckodriver");
					//System.setProperty("webdriver.chrome.driver", "/Volumes/New Backups/QA Training docs/chromedriver");
					driver =new FirefoxDriver();
					//driver=new ChromeDriver();
					
					
					Method tc=AutomationScripts.class.getMethod(testCase);
					tc.invoke(tc);
					//driver.quit(); // closes all browsers opened by selenium-->  closed at script level-> so commented
					ReusableMethods.bw.close();
					
				}
				
				chrome=recData[i][4];
				if(chrome.equalsIgnoreCase("Y")){
					testCase=recData[i][2];
					ReusableMethods.startReport(testCase, "/Users/madhu/Documents/workspace/report/");
					//System.setProperty("webdriver.gecko.driver", "/Users/madhu/Downloads/geckodriver");
					System.setProperty("webdriver.chrome.driver", "/Volumes/New Backups/QA Training docs/chromedriver");
					//driver =new FirefoxDriver();
					driver=new ChromeDriver();
				
					Method tc=AutomationScripts.class.getMethod(testCase);
					tc.invoke(tc);
					driver.quit(); // closes all browsers opened by selenium-->  closed at script level-> so commented
					ReusableMethods.bw.close();
					
				}
				
			}
			
		}
		
	}

}
