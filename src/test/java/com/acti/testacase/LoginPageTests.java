package com.acti.testacase;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acti.base.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPage;

public class LoginPageTests extends DriverScript {
	
	@Test(priority = 1)
	public void testLoginPageTitle()
	{
		initApplication();
		LoginPage lp = new LoginPage();
		String expected = "actiTIME - Login";
		String actual = lp.getLoginPageTitle();
		Assert.assertEquals(actual, expected);
		quitDriver();
	}
	
	@Test(priority = 2)
	public void testActiImageIsDisplayed()
	{
		initApplication();
		LoginPage lp = new LoginPage();
		boolean flag = lp.verifyActiLogo();
		Assert.assertTrue(flag);
		quitDriver();
	}
	
	@Test(priority = 3)
	public void testForgotPasswordIsDisplayed()
	{
		initApplication();
		LoginPage lp = new LoginPage();
		boolean flag = lp.verifyForgotPassword();
		Assert.assertTrue(flag);
		quitDriver();
	}
	
	@Test(priority = 4)
	public void testLoginFunction()
	{
		initApplication();
		LoginPage lp = new LoginPage();
		lp.enterUsername("admin");
		lp.enterPassword("manager");
		lp.clickLogin();
		EnterPage ep = new EnterPage();
		String expected = "John Doe";
		String actual = ep.verifyUserLoggedIn();
		Assert.assertEquals(actual, expected);
		ep.clickLogout();
		quitDriver();
	}

}