package com.acti.testacase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.acti.base.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPage;

public class BaseTest extends DriverScript {
	
	LoginPage lp;
	EnterPage ep;
	
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		lp = new LoginPage();
		ep = new EnterPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		quitDriver();
	}

}
