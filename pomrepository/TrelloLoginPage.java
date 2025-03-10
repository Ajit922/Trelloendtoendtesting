package com.trello.qpiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginPage {
	WebDriver driver;

	public TrelloLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user")
	private WebElement emailtextfield;
	@FindBy(id="login")
	private WebElement continuebutton;

	public WebElement getEmailtextfield() {
		return emailtextfield;
	}
	
	public WebElement getContinuebutton() {
		return continuebutton;
	}
}
