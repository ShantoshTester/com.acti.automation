package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*
 * Name: LoginPage
 * Description: Login Page elements and actions
 * Developed By : Shantosh
 * Date : 11/23/22
 * Reviewed By : Shantosh
 */

public class LoginPage extends DriverScript {

//************************************************* Page Elements ***********************************************//

	@FindBy(id = "username") WebElement usernameTextbox;
	@FindBy(name = "pwd") WebElement passwordTextbox;
	@FindBy(xpath = "//div[text()='Login ']") WebElement loginButton;
	@FindBy(linkText = "Forgot your password?") WebElement forgotPasswordLink;
	@FindBy(className = "atLogoImg") WebElement actiImg;
	
//************************************************* Page Initialization *******************************************//
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
//************************************************* Page Method/Actions *******************************************//
	
	public void enterUsername(String username)
	{
		usernameTextbox.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passwordTextbox.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public boolean verifyForgotPassword()
	{
		return forgotPasswordLink.isDisplayed();
	}
	
	public boolean verifyActiLogo()
	{
		return actiImg.isDisplayed();
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}

}
