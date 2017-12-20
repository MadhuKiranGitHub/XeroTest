package com.rest.XeroTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutomationScripts extends ReusableMethods{
	
	public static void LoginScript() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://login.xero.com");
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("username"),"Username");
		
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,prop.getProperty("password"),"Password");
		
		WebElement login= driver.findElement(By.id("submitButton"));
		clickObject(login, "Login");	
		System.out.println("Test case for Xero Login Completed");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Incorrect_Password() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://login.xero.com");
		
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("username"),"Username");
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,prop.getProperty("invalidPswd"),"Password");
		
		WebElement login= driver.findElement(By.id("submitButton"));
		clickObject(login, "Login");	
		System.out.println("Test case for Xero Incorrect_Password Completed");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Incorrect_Email() throws InterruptedException, IOException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://login.xero.com");
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("invalidUser"),"Username");
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,prop.getProperty("password"),"Password");
		
		WebElement login= driver.findElement(By.id("submitButton"));
		clickObject(login, "Login");	
		//To assert displayed msg
//		WebElement msg=driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p"));
//		assertEquals(msg, "Your email or password is incorrect");
		System.out.println("Test case for Xero Incorrect_Email Completed");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Navigate_to_Xero_D() throws IOException, InterruptedException{
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://login.xero.com");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("username"),"Username");
		WebElement forgotPswd=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Forgot your password?"))));
		clickObject(forgotPswd,"forgotPswd");
		
		Thread.sleep(3000);
		WebElement uname=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//input[@name='UserName']"))));
		enterText(uname,prop.getProperty("username"),"Username");	
		WebElement sendlink= driver.findElement(By.linkText("Send link"));
		clickObject(sendlink, "sendlink");	
		System.out.println("Test case for Xero Navigate_to_Xero_D Completed");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Sign_Up_To_XDC_A() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		readProperties();
		WebElement freeTrial=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"))));
		clickObject(freeTrial, "FreeTrial");
		
		WebElement firstName=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//input[@name='FirstName']"))));
		enterText(firstName, prop.getProperty("firstName"), "FirstName");
		
		WebElement lastName=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//input[@name='LastName']"))));
		enterText(firstName, prop.getProperty("lastName"), "FirstName");
		
		WebElement email=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//input[@name='EmailAddress']"))));
		enterText(firstName, prop.getProperty("email"), "FirstName");
		
		WebElement phone=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//input[@name='PhoneNumber']"))));
		enterText(firstName, prop.getProperty("phone"), "FirstName");
		
		WebElement country=driver.findElement(By.xpath(".//select[@name='LocationCode']"));
		dropDownObject(country, prop.getProperty("country"));

		
		WebElement accept=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//input[@name='TermsAccepted']"))));
		clickObject(accept, "TermsAccepted");
		Thread.sleep(10000);
		
		//Check box should be entered manually for--> I am not robot
		try{
			WebElement getStartedButton=driver.findElement(By.xpath(".//button[text()='Get started']"));
			clickObject(getStartedButton, "getStartedButton");
			}catch(Exception e){
				System.out.println(e);
			}
		
//		WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/main/div/div/div/div[1]/div/div/div[1]/h1")));
//		System.out.println("Msg:"+ msg);
		
		System.out.println("Test case for Xero Sign_Up_To_XDC_A Completed");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Sign_Up_To_XDC_B() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us");
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement freeTrial=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"))));
		clickObject(freeTrial, "FreeTrial");
		//Check box is not enabled
		Thread.sleep(10000);
		try{
		WebElement getStartedButton=driver.findElement(By.xpath(".//button[text()='Get started']"));
		clickObject(getStartedButton, "getStartedButton");
		}catch(Exception e){
			System.out.println(e);
		}
		
		

		WebElement email=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//input[@name='EmailAddress']"))));
		enterText(email, prop.getProperty("invalidemail"), "EmailAddress");
		
		Thread.sleep(5000);
		try{
			WebElement getStartedButton=driver.findElement(By.xpath(".//button[text()='Get started']"));
			clickObject(getStartedButton, "getStartedButton");
			}catch(Exception e){
				System.out.println(e);
			}
		
		System.out.println("Test case for Xero Sign_Up_To_XDC_B Completed");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Sign_Up_To_XDC_C() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us");
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement freeTrial=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"))));
		clickObject(freeTrial, "FreeTrial");
		
		WebElement accept=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//input[@name='TermsAccepted']"))));
		clickObject(accept, "TermsAccepted");
		
		WebElement policy=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[text()='privacy policy']"))));
		clickObject(policy, "privacy policy");
		
		System.out.println("Test case for Xero Sign_Up_To_XDC_C Completed");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Sign_Up_To_XDC_D() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us");
		
		WebElement freeTrial=driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
		clickObject(freeTrial, "FreeTrial");
		
		WebElement offerDetails=driver.findElement(By.linkText("offer details"));
		clickObject(offerDetails, "offerDetails");
		System.out.println("Test case for Xero Sign_Up_To_XDC_D Completed");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Sign_Up_To_XDC_E() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us");
		
		WebElement freeTrial=driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
		clickObject(freeTrial, "FreeTrial");
		
		WebElement accountant=driver.findElement(By.linkText("accountant or bookkeeper"));
		clickObject(accountant, "accountant");
		System.out.println("Test case for Xero Sign_Up_To_XDC_E Completed");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Test_All_Tabs_Page() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://login.xero.com");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("username"),"Username");
		
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,prop.getProperty("password"),"Password");
		
		WebElement login= driver.findElement(By.id("submitButton"));
		clickObject(login, "Login");	
		
		WebElement dashboard=driver.findElement(By.xpath(".//*[@id='Dashboard']"));
		clickObject(dashboard,"dashboard");

		WebElement accounts=driver.findElement(By.xpath(".//*[@id='Accounts']"));
		clickObject(accounts,"accounts");

		WebElement reports=driver.findElement(By.xpath(".//*[@id='Reports']"));
		clickObject(reports,"reports");

		WebElement contacts=driver.findElement(By.xpath(".//*[@id='Contacts']"));
		clickObject(contacts,"contacts");

		WebElement settings=driver.findElement(By.xpath(".//*[@id='Settings']"));
		clickObject(settings,"settings");
		
		WebElement quicklaunchTab=driver.findElement(By.xpath(".//*[@id='quicklaunchTab']"));
		clickObject(quicklaunchTab,"quicklaunchTab");
		
//		WebElement files=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//a[@class='files']"))));
//		clickObject(files,"files");
		
		WebElement notifications=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//a[@class='notifications']"))));
		clickObject(notifications,"notifications");
		

		WebElement search=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//a[@class='search']"))));
		clickObject(search,"search");

		WebElement help=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//a[@class='help']"))));
		clickObject(help,"help");
		
		WebElement files=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//a[@class='files']"))));
		clickObject(files,"files");
		
		System.out.println("Test case for Xero Test_All_Tabs_Page Completed");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Test_Logout_Functionality() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://login.xero.com");
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("username"),"Username");
		
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,prop.getProperty("password"),"Password");
		
		WebElement login= driver.findElement(By.id("submitButton"));
		clickObject(login, "Login");	
		

		WebElement user= driver.findElement(By.xpath(".//*[@class='username']"));
		clickObject(user, "UserDropDown");
		
		WebElement logout=driver.findElement(By.xpath(".//*[text()='Logout']"));
		clickObject(logout, "Logout");
		System.out.println("Test case for Xero Test_Logout_Functionality Completed");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Test_Upload_Profile_Image() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://login.xero.com");
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("username"),"Username");
		
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,prop.getProperty("password"),"Password");
		
		WebElement login= driver.findElement(By.id("submitButton"));
		clickObject(login, "Login");	
		

		WebElement user= driver.findElement(By.xpath(".//*[@class='username']"));
		clickObject(user, "UserDropDown");
		WebElement profile= driver.findElement(By.xpath(".//*[text()='Profile']"));
		clickObject(profile, "profile");
//		WebElement uploadImage=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[text()='Upload Image']"))));
//		//WebElement uploadImage= driver.findElement(By.id(".//*[@id='button-1041']"));
//		clickObject(uploadImage, "uploadImage");
//		driver.switchTo().alert();
//		//WebElement browseButton= driver.findElement(By.id(".//*[@id='filefield-1188-button']"));
//		WebElement browseButton=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[text()='Browse']"))));
//		browseButton.click();
//		enterText(browseButton, "/Users/madhu/Desktop/profile.jpg", "browsePhoto");
//		//browseButton.sendKeys("/Users/madhu/Desktop/profile.jpg");
//		WebElement uploadButton= driver.findElement(By.id(".//*[@id='button-1192']"));
//		clickObject(uploadButton, "uploadButton");
		System.out.println("Test_Upload_Profile_Image complete");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Add_Another_Organization_Trail_Version_1() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://login.xero.com");
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("gopalusername"),"Username");
		
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,prop.getProperty("gopalpassword"),"Password");
		
		WebElement login= driver.findElement(By.id("submitButton"));
		clickObject(login, "Login");
		Thread.sleep(3000);
		WebElement myXeroh2= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/h2"))));
		clickObject(myXeroh2, "myXeroh2");
		
		WebElement myXero= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/div/div[1]/a"))));
		clickObject(myXero, "myXero");
		
		WebElement addOrganization= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ext-gen1043']"))));
		clickObject(addOrganization, "addOrganization");
		
		WebElement organizationName= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"))));
		enterText(organizationName, prop.getProperty("organizationName"),"organizationName");
		
		WebElement organizationCountry=driver.findElement(By.xpath(".//*[@id='countryCmb-inputEl']"));
		enterText(organizationCountry, prop.getProperty("organizationCountry"),"organizationCountry");
		
		WebElement organizationWork= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']"))));
		enterText(organizationWork,prop.getProperty("organizationWork"), "organizationWork");
		
		WebElement startTrial= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[text()='Start Trial']"))));
		clickObject(startTrial, "startTrial");
		System.out.println("Add another organization trial version 1 complete");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Add_Another_Organization_Paid_Version_1() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://login.xero.com");
		
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("gopalusername"),"Username");
		
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,prop.getProperty("gopalpassword"),"Password");
		
		WebElement login= driver.findElement(By.id("submitButton"));
		clickObject(login, "Login");
		Thread.sleep(3000);
		WebElement myXeroh2= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/h2"))));
		clickObject(myXeroh2, "myXeroh2");
		
		WebElement myXero= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/div/div[1]/a"))));
		clickObject(myXero, "myXero");
		
		WebElement addOrganization= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ext-gen1043']"))));
		clickObject(addOrganization, "addOrganization");
		
		WebElement organizationName= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"))));
		enterText(organizationName, prop.getProperty("organizationName"),"organizationName");
		
		WebElement organizationCountry=driver.findElement(By.xpath(".//*[@id='countryCmb-inputEl']"));
		enterText(organizationCountry, prop.getProperty("organizationCountry"),"organizationCountry");
		
		WebElement organizationWork= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']"))));
		enterText(organizationWork,prop.getProperty("organizationWork"), "organizationWork");
		
		WebElement buyNow= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[text()='Buy Now']"))));
		clickObject(buyNow, "buyNow");
		System.out.println("Add another organization paid version 1 complete");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Add_Another_Organization_Starter_Plan() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://login.xero.com");
		
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("gopalusername"),"Username");
		
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,prop.getProperty("gopalpassword"),"Password");
		
		WebElement login= driver.findElement(By.id("submitButton"));
		clickObject(login, "Login");
		Thread.sleep(3000);
		WebElement myXeroh2= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/h2"))));
		clickObject(myXeroh2, "myXeroh2");
		
		WebElement myXero= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/div/div[1]/a"))));
		clickObject(myXero, "myXero");
		
		WebElement addOrganization= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ext-gen1043']"))));
		clickObject(addOrganization, "addOrganization");
		
		WebElement organizationName= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"))));
		enterText(organizationName, prop.getProperty("organizationName"),"organizationName");
		
		WebElement organizationCountry=driver.findElement(By.xpath(".//*[@id='countryCmb-inputEl']"));
		enterText(organizationCountry, prop.getProperty("organizationCountry"),"organizationCountry");
		
		WebElement organizationWork= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']"))));
		enterText(organizationWork,prop.getProperty("organizationWork"), "organizationWork");
		
		WebElement buyNow= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[text()='Buy Now']"))));
		clickObject(buyNow, "buyNow");
		
		WebElement starter= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='PRODUCTOPTION/ORG/SOLO']/div[1]/label"))));
		clickObject(starter, "starter");
		
		WebElement continueButton= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/div/main/div[10]/button"))));
		clickObject(continueButton, "continueButton");
		
		WebElement street= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='POAddress']"))));
		enterText(street,prop.getProperty("street"), "street");
		
		WebElement city= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='POCity']"))));
		enterText(city, prop.getProperty("city"), "City");
		
		WebElement state= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='PORegionDropdown']"))));
		dropDownObject(state, prop.getProperty("state"));
		
		WebElement zip= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='POPostalCode']"))));
		enterText(zip, prop.getProperty("zip"), "zip");
		
		WebElement continueToPayButton= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmMain']/div/div/div/main/div[3]/div/div[2]/div/button"))));
		clickObject(continueToPayButton, "continueToPayButton");
		
		//CArd details
		WebElement cardNumber= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='card-element']"))));
		enterText(cardNumber, prop.getProperty("cardNumber"), "cardNumber");
		
		WebElement expDate= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='card-expiry']"))));
		enterText(expDate, prop.getProperty("expDate"), "expDate");
		
		WebElement securityCode= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='card-cvc']"))));
		enterText(securityCode, prop.getProperty("securityCode"), "securityCode");
		
		WebElement nameOnCard= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='cardholder-name']"))));
		enterText(nameOnCard, prop.getProperty("nameOnCard"), "nameOnCard");
		
		WebElement authPayment= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='authoriseStripeButton']"))));
		clickObject(authPayment, "authPayment");
		System.out.println("Add_Another_Organization_Starter_Plan complete");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Add_Another_Organization_Standard_Plan() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://login.xero.com");
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("gopalusername"),"Username");
		
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,prop.getProperty("gopalpassword"),"Password");
		
		WebElement login= driver.findElement(By.id("submitButton"));
		clickObject(login, "Login");
		Thread.sleep(3000);
		WebElement myXeroh2= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/h2"))));
		clickObject(myXeroh2, "myXeroh2");
		
		WebElement myXero= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/div/div[1]/a"))));
		clickObject(myXero, "myXero");
		
		WebElement addOrganization= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ext-gen1043']"))));
		clickObject(addOrganization, "addOrganization");
		
		WebElement organizationName= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"))));
		enterText(organizationName, prop.getProperty("organizationName"),"organizationName");
		
		WebElement organizationCountry=driver.findElement(By.xpath(".//*[@id='countryCmb-inputEl']"));
		enterText(organizationCountry, prop.getProperty("organizationCountry"),"organizationCountry");
		
		WebElement organizationWork= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']"))));
		enterText(organizationWork,prop.getProperty("organizationWork"), "organizationWork");
		
		WebElement buyNow= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[text()='Buy Now']"))));
		clickObject(buyNow, "buyNow");
		
		WebElement standard= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='PRODUCTOPTION/ORG/STANDARD']/div[1]/label"))));
		clickObject(standard, "standard");
		
		WebElement continueButton= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/div/main/div[10]/button"))));
		clickObject(continueButton, "continueButton");
		
		WebElement street= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='POAddress']"))));
		enterText(street,prop.getProperty("street"), "street");
		
		WebElement city= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='POCity']"))));
		enterText(city, prop.getProperty("city"), "City");
		
		WebElement state= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='PORegionDropdown']"))));
		dropDownObject(state, prop.getProperty("state"));
		
		WebElement zip= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='POPostalCode']"))));
		enterText(zip, prop.getProperty("zip"), "zip");
		
		WebElement continueToPayButton= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmMain']/div/div/div/main/div[3]/div/div[2]/div/button"))));
		clickObject(continueToPayButton, "continueToPayButton");
		
		//CArd details
		WebElement cardNumber= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='card-element']"))));
		enterText(cardNumber, prop.getProperty("cardNumber"), "cardNumber");
		
		WebElement expDate= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='card-expiry']"))));
		enterText(expDate, prop.getProperty("expDate"), "expDate");
		
		WebElement securityCode= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='card-cvc']"))));
		enterText(securityCode, prop.getProperty("securityCode"), "securityCode");
		
		WebElement nameOnCard= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='cardholder-name']"))));
		enterText(nameOnCard, prop.getProperty("nameOnCard"), "nameOnCard");
		
		WebElement authPayment= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='authoriseStripeButton']"))));
		clickObject(authPayment, "authPayment");
		
		System.out.println("Add_Another_Organization_Standard_Plan complete");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Add_Another_Organization_Premium_Plan() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://login.xero.com");
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("gopalusername"),"Username");
		
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,prop.getProperty("gopalpassword"),"Password");
		
		WebElement login= driver.findElement(By.id("submitButton"));
		clickObject(login, "Login");
		Thread.sleep(3000);
		WebElement myXeroh2= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/h2"))));
		clickObject(myXeroh2, "myXeroh2");
		
		WebElement myXero= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/div/div[1]/a"))));
		clickObject(myXero, "myXero");
		
		WebElement addOrganization= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ext-gen1043']"))));
		clickObject(addOrganization, "addOrganization");
		
		WebElement organizationName= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"))));
		enterText(organizationName, prop.getProperty("organizationName"),"organizationName");
		
		WebElement organizationCountry=driver.findElement(By.xpath(".//*[@id='countryCmb-inputEl']"));
		enterText(organizationCountry, prop.getProperty("organizationCountry"),"organizationCountry");
		
		WebElement organizationWork= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']"))));
		enterText(organizationWork,prop.getProperty("organizationWork"), "organizationWork");
		
		WebElement buyNow= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[text()='Buy Now']"))));
		clickObject(buyNow, "buyNow");
		
		WebElement premiumPlan= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='PRODUCTOPTION/ORG/PRO']/div[1]/label"))));
		clickObject(premiumPlan, "premiumPlan");
		
		WebElement continueButton= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/div/main/div[10]/button"))));
		clickObject(continueButton, "continueButton");
		
		WebElement street= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='POAddress']"))));
		enterText(street,prop.getProperty("street"), "street");
		
		WebElement city= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='POCity']"))));
		enterText(city, prop.getProperty("city"), "City");
		
		WebElement state= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='PORegionDropdown']"))));
		dropDownObject(state, prop.getProperty("state"));
		
		WebElement zip= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='POPostalCode']"))));
		enterText(zip, prop.getProperty("zip"), "zip");
		
		WebElement continueToPayButton= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='frmMain']/div/div/div/main/div[3]/div/div[2]/div/button"))));
		clickObject(continueToPayButton, "continueToPayButton");
		
		//CArd details
		WebElement cardNumber= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='card-element']"))));
		enterText(cardNumber, prop.getProperty("cardNumber"), "cardNumber");
		
		WebElement expDate= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='card-expiry']"))));
		enterText(expDate, prop.getProperty("expDate"), "expDate");
		
		WebElement securityCode= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='card-cvc']"))));
		enterText(securityCode, prop.getProperty("securityCode"), "securityCode");
		
		WebElement nameOnCard= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='cardholder-name']"))));
		enterText(nameOnCard, prop.getProperty("nameOnCard"), "nameOnCard");
		
		WebElement authPayment= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='authoriseStripeButton']"))));
		clickObject(authPayment, "authPayment");
		
		System.out.println("Add_Another_Organization_Premium_Plan complete");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	}
	
	public static void Add_Another_Organization_With_Current_Quickbooks_User() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://login.xero.com");
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("gopalusername"),"Username");
		
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,prop.getProperty("gopalpassword"),"Password");
		
		WebElement login= driver.findElement(By.id("submitButton"));
		clickObject(login, "Login");
		Thread.sleep(3000);
		WebElement myXeroh2= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/h2"))));
		clickObject(myXeroh2, "myXeroh2");
		
		WebElement myXero= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[1]/div/div/div[1]/a"))));
		clickObject(myXero, "myXero");
		WebElement addOrganization= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ext-gen1043']"))));
		clickObject(addOrganization, "addOrganization");
		
		WebElement organizationName= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"))));
		enterText(organizationName, prop.getProperty("organizationName"),"organizationName");
		
		WebElement organizationCountry=driver.findElement(By.xpath(".//*[@id='countryCmb-inputEl']"));
		enterText(organizationCountry, prop.getProperty("organizationCountry"),"organizationCountry");
		
		WebElement organizationWork= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']"))));
		enterText(organizationWork,prop.getProperty("organizationWork"), "organizationWork");
		
		WebElement moveFromQuickBooksLink= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='conversionLink']"))));
		clickObject(moveFromQuickBooksLink, "moveFromQuickBooksLink");
		
		WebElement convertDataCheckBox= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='conversionCheckbox-inputEl']"))));
		clickObject(convertDataCheckBox, "convertDataCheckBox");
		Thread.sleep(2000);
		WebElement startTrial= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[text()='Start Trial']"))));
		assertFalse(!startTrial.isEnabled());
		
		WebElement continueButton= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[text()='Continue']"))));
		assertTrue(continueButton.isEnabled());
		
		System.out.println("Add_Another_Organization_with current quickbook users complete");
		Thread.sleep(3000);
		bw.close();
		driver.close();
	
	}
	
	public static void Check_Users_Subscription_and_Billing() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://login.xero.com");
		
		readProperties();
		WebElement username= driver.findElement(By.id("email"));
		enterText(username,prop.getProperty("username"),"Username");
		
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,prop.getProperty("password"),"Password");
		
		WebElement login= driver.findElement(By.id("submitButton"));
		clickObject(login, "Login");	
		
		WebElement accounts=driver.findElement(By.xpath(".//*[@id='Accounts']"));
		clickObject(accounts,"accounts");
		
		WebElement purchases=driver.findElement(By.linkText("Purchases"));
		clickObject(purchases,"purchases");
		System.out.println("Check_Users_Subscription_and_Billing complete");
		Thread.sleep(3000);
		bw.close();
		driver.close();

		
	}
}
