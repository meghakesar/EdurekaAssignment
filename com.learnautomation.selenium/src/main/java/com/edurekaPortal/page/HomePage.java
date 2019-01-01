package com.edurekaPortal.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseOperation{
	@FindBy(linkText= "Log In")
	private WebElement loginLink;
	@FindBy(id = "si_popup_email")
	private WebElement userName;
	@FindBy(id = "si_popup_passwd")
	private WebElement password;
	@FindBy(xpath = "//button[text() = 'Login']")
	private WebElement loginButton;
	@FindBy(xpath="//span[@class='webinar-profile-name']")
	private WebElement profileName;
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
  }
	public void userLogin(String sUserEmailId, String sUserPassword) throws Exception {
		Thread.sleep(3000);
		elementcommon.setText(userName, sUserEmailId);
		elementcommon.setText(password, sUserPassword);

		elementcommon.clickElement(loginButton);
	}
	public String getProfileNameText() throws Exception{
		return elementcommon.getText(profileName);
	}

}
