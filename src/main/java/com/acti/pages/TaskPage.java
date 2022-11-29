package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acti.base.DriverScript;

/*
 * Name: TaskPage 
 * Description: Task Page elements and actions
 * Developed By : Padma
 * Date : 11/29/22
 * Reviewed By : Shantosh
 */

public class TaskPage extends DriverScript {

//************************************************* Page Elements ***********************************************//

	@FindBy(xpath = "//div[text()='Add New']") WebElement addNewButton;
	@FindBy(xpath = "//div[text()='+ New Customer']") WebElement newCustomerItem;
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]") WebElement customernameTextbox;
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']") WebElement customerdescriptionTextarea;
	@FindBy(xpath = "//div[text()='Create Customer']") WebElement createcustomerButton;
	@FindBy(xpath = "//span[@class='innerHtml']") WebElement successMessage;

//************************************************* Page Initialization *******************************************//

	public TaskPage() {
		PageFactory.initElements(driver, this);
	}

//************************************************* Page Method/Actions *******************************************//	

	public void clickAddNewButton()
	{
		addNewButton.click();
	}
	
	public void clickNewCustomerItem()
	{
		newCustomerItem.click();
	}
	
	public void enterCustomerName(String custname)
	{
		customernameTextbox.sendKeys(custname);
	}
	
	public void enterCustomerDescription(String custdesc)
	{
		customerdescriptionTextarea.sendKeys(custdesc);
	}
	
	public void clickCreateCustomer()
	{
		createcustomerButton.click();
	}
	
	public String getSuccessMessage()
	{
		return successMessage.getText();
	}
	
	
}
