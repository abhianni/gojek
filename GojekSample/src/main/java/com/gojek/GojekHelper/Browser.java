package com.gojek.GojekHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class Browser {
	
	 WebDriver driver = null;
	

	public static HashMap<String, WebDriver> config = new HashMap<String, WebDriver>();
	public  static ThreadLocal<Map<String, WebDriver>> webdriver= new ThreadLocal<Map<String, WebDriver>>();
	public static String File, screenshotPath, imagepath, importfilepath, OutputPath, home;
	public static String chromedriver, iedriver, chromebinary, locator;
	static Properties prop;
	public static String str;
	static ExcelReader reader ;
	public static HashMap<String, ArrayList<String>> appName = new HashMap<String, ArrayList<String>>();

	/**
	 * setDriver() reads the browser name from xml file and activate the
	 * browser mentioned on test data sheet 
	 * @param browser
	 * @throws IOException
	 */
	@BeforeSuite	
	public void browserSetup() throws IOException {
		
		prop = new Properties();
		prop.setProperty("ws.home", "${basedir}");
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Data\\config.properties");
		prop.load(ip);
		home = prop.getProperty("home");
		File = home + prop.getProperty("File");
		chromedriver = home + prop.getProperty("chromedriver");
		screenshotPath = home + prop.getProperty("screenshotPath");
		locator = home + prop.getProperty("LocatorFile");
		OutputPath = home + prop.getProperty("OutputPath");
		reader = new ExcelReader();
	}
}
