package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acti.base.DriverScript;
import com.acti.utils.Helper;

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
	@FindBy(xpath="(//input[@placeholder='Start typing name ...'])[1]") WebElement textboxStartTyping;
	@FindBy(xpath="//div[@class='filteredContainer']//div[@class='title']") WebElement searchedCustomer;
	@FindBy(xpath="//div[@class='titleEditButtonContainer']//div[@class='editButton']") WebElement buttonEdit;
	@FindBy(xpath="//div[@class='editCustomerPanelHeader']//div[@class='action'][normalize-space()='ACTIONS']" )
	WebElement buttonAction;
	@FindBy(xpath="//div[@class='taskManagement_customerPanel']//div[@class='title'][normalize-space()='Delete']")
	WebElement buttonDelete;
	@FindBy(xpath="//span[normalize-space()='Delete permanently']") WebElement buttonDeletePermanently;

//************************************************* Page Initialization *******************************************//

	public TaskPage() {
		PageFactory.initElements(driver, this);
	}

//************************************************* Page Method/Actions *******************************************//	
	
	public void enterSearchCustomer(String custname)
	{
		textboxStartTyping.sendKeys(custname);
	}
	
	public void clickDeletePermanently()
	{
		buttonDeletePermanently.click();
		Helper.sleep();
	}
	
	public void clickDelete()
	{
		buttonDelete.click();
	}
	
	public void clickAction()
	{
		buttonAction.click();
		Helper.sleep();
	}
	
	public void clickEditButton()
	{
		buttonEdit.click();
		Helper.sleep();
	}
	
	public void clickSearchedCustomer()
	{
		searchedCustomer.click();
	}
	
	
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
