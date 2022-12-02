package com.acti.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.acti.base.DriverScript;

public class Helper extends DriverScript {
	
	// This method is used as a wait statement in some places
	
	public static void sleep()
	{
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{	
			e.printStackTrace();
		}
	}
	
	// This method is used to take the screen shot
	
	public static String captureScreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenpath = "C:\\Users\\User\\git\\com.acti.automation\\atreports\\screens\\screen.png";
		try {
			FileHandler.copy(src, new File(screenpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenpath;
	}

}
