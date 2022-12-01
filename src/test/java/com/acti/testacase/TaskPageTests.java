package com.acti.testacase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskPageTests extends BaseTest {
	
	@Test(dataProvider = "actilogin")
	public void testCreateCustomer(String username, String password)
	{
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLogin();
		ep.clickTaskMenu();
		tp.clickAddNewButton();
		tp.clickNewCustomerItem();
		tp.enterCustomerName("TestCustomer");
		tp.enterCustomerDescription("Dummy Customer Created for Testing");
		tp.clickCreateCustomer();
		String successmessage = tp.getSuccessMessage();
		Assert.assertTrue(successmessage.contains("has been created"));
		ep.clickLogout();
	}
	
	@Test(dataProvider = "actilogin")
	public void testDeleteCustomer(String username, String password)
	{
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLogin();
		ep.clickTaskMenu();
		tp.enterSearchCustomer("TestCustomer");
		tp.clickSearchedCustomer();
		tp.clickEditButton();
		tp.clickAction();
		tp.clickDelete();
		tp.clickDeletePermanently();
		String successmessage = tp.getSuccessMessage();
		Assert.assertTrue(successmessage.contains("has been deleted"));
		ep.clickLogout();
		
	}

}
