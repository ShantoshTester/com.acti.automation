package com.acti.testacase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskPageTests extends BaseTest {
	
	@Test(dataProvider = "actilogin")
	public void testCreateCustomer(String username, String password)
	{
		logger=report.createTest("Test Create Customer");
		lp.enterUsername(username);
		logger.pass("entered username");
		lp.enterPassword(password);
		logger.pass("entered password");
		lp.clickLogin();
		logger.pass("clicked login button");
		ep.clickTaskMenu();
		logger.pass("clicked task menu");
		tp.clickAddNewButton();
		logger.pass("clicked add new button");
		tp.clickNewCustomerItem();
		logger.pass("clicked create new customer item");
		tp.enterCustomerName("TestCustomer");
		logger.pass("entered customer name");
		tp.enterCustomerDescription("Dummy Customer Created for Testing");
		logger.pass("entered customer description");
		tp.clickCreateCustomer();
		logger.pass("click create customer button");
		String successmessage = tp.getSuccessMessage();
		Assert.assertTrue(successmessage.contains("has been created"));
		logger.pass("validated customer created successfully");
		ep.clickLogout();
		logger.pass("logged out from application");
	}
	
	@Test(dataProvider = "actilogin")
	public void testDeleteCustomer(String username, String password)
	{
		logger=report.createTest("Test Delete Customer");
		lp.enterUsername(username);
		logger.pass("entered username");
		lp.enterPassword(password);
		logger.pass("entered password");
		lp.clickLogin();
		logger.pass("clicked login button");
		ep.clickTaskMenu();
		logger.pass("clicked task menu");
		tp.enterSearchCustomer("TestCustomer");
		logger.pass("search the created customer");
		tp.clickSearchedCustomer();
		logger.pass("clicked on searched customer");
		tp.clickEditButton();
		logger.pass("clicked edit button");
		tp.clickAction();
		logger.pass("clicked action button");
		tp.clickDelete();
		logger.pass("clicked delete button");
		tp.clickDeletePermanently();
		logger.pass("clicked delete permanently button");
		String successmessage = tp.getSuccessMessage();
		Assert.assertTrue(successmessage.contains("has been deleted"));
		logger.pass("verified customer deleted successully");
		ep.clickLogout();
		logger.pass("logged out from application");
	}
	
	@Test(dataProvider = "actilogin")
	public void testDeleteCustomerFail(String username, String password)
	{
		logger=report.createTest("Test Delete Customer");
		lp.enterUsername(username);
		logger.pass("entered username");
		lp.enterPassword(password);
		logger.pass("entered password");
		lp.clickLogin();
		logger.pass("clicked login button");
		ep.clickTaskMenu();
		logger.pass("clicked task menu");
		tp.enterSearchCustomer("TestCustomer");
		logger.pass("search the created customer");
		tp.clickSearchedCustomer();
		logger.pass("clicked on searched customer");
		tp.clickEditButton();
		logger.pass("clicked edit button");
		tp.clickAction();
		logger.pass("clicked action button");
		tp.clickDelete();
		logger.pass("clicked delete button");
		tp.clickDeletePermanently();
		logger.pass("clicked delete permanently button");
		String successmessage = tp.getSuccessMessage();
		Assert.assertTrue(successmessage.contains("has been deleted"));
		logger.pass("verified customer deleted successully");
		ep.clickLogout();
		logger.pass("logged out from application");
	}

}
