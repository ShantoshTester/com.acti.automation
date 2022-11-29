package com.acti.testacase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
	
	@Test
	public void testLoginPageTitle()
	{		
		String expected = "actiTIME - Login";
		String actual = lp.getLoginPageTitle();
		Assert.assertEquals(actual, expected);	
	}
	
	@Test
	public void testActiImageIsDisplayed()
	{	
		boolean flag = lp.verifyActiLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void testForgotPasswordIsDisplayed()
	{		
		boolean flag = lp.verifyForgotPassword();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void testLoginFunction()
	{	
		lp.enterUsername("admin");
		lp.enterPassword("manager");
		lp.clickLogin();
		String expected = "John Doe";
		String actual = ep.verifyUserLoggedIn();
		Assert.assertEquals(actual, expected);
		ep.clickLogout();	
	}

}
