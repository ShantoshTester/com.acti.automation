package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
 * Name: DriverScript
 * Description: This class is responsible for loading the properties file and loading the application
 * Developed By : Sandeep
 * Date : 11/23/22
 * Reviewed By : Shantosh
 */

public class DriverScript {
	
	public static WebDriver driver;
	static Properties prop;
	
	public DriverScript()
	{
		try
		{
			File file = new File("./atconfig/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("unable to load the properties file please check "+e.getMessage());
		}
	}
	
	
	public void initApplication()
	{
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./atbrowser/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./atbrowser/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "./atbrowser/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else
		{
			System.err.println("The browser paramerter is not supported please check the config file");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		getURL();

	}
	
	public static void getURL()
	{
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	public void quitDriver()
	{
		driver.close();
	}

}


