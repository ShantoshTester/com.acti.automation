package com.acti.testacase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.acti.base.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPage;
import com.acti.pages.TaskPage;
import com.acti.utils.ExcelLib;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest extends DriverScript {
	
	protected static ExtentTest logger;
	protected static ExtentReports report;
	LoginPage lp;
	EnterPage ep;
	TaskPage tp;
	
	@BeforeSuite
	public void setupReport()
	{
		ExtentHtmlReporter extent = new ExtentHtmlReporter("./atreports/atreport.html");
		ExtentReports report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		lp = new LoginPage();
		ep = new EnterPage();
		tp = new TaskPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		report.flush();
		quitDriver();
	}
	
	@DataProvider(name = "actilogin")
	public Object[][] testData()
	{
		ExcelLib excel = new ExcelLib("./attestdata/actidata.xlsx");
		int rows = excel.getRowCount(0);
		
		Object[][] data = new Object[rows][2];
		
		for(int i=0;i<rows;i++)
		{
			data[i][0]=excel.getCellData(0, i, 0);
			data[i][1]=excel.getCellData(0, i, 1);
		}
		
		return data;
	}

}
