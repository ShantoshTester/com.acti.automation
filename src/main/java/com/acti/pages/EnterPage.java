package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acti.base.DriverScript;

/*
 * Name: EnterTimePage / Home Page
 * Description: Login Page elements and actions
 * Developed By : Shantosh
 * Date : 11/23/22
 * Reviewed By : Shantosh
 */

public class EnterPage extends DriverScript {

//************************************************* Page Elements ***********************************************//

	@FindBy(xpath = "//a[@class='userProfileLink username ']") WebElement usernameText;
	@FindBy(id = "logoutLink") WebElement logoutLink;

//************************************************* Page Initialization *******************************************//

	public EnterPage() 
	{
		PageFactory.initElements(driver, this);
	}

//************************************************* Page Method/Actions *******************************************//
	
	public String verifyUserLoggedIn()
	{
		return usernameText.getText();
	}
	
	public String getEnterPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickLogout()
	{
		logoutLink.click();
	}

}
