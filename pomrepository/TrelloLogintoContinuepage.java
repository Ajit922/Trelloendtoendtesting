package com.trello.qpiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLogintoContinuepage {
	WebDriver driver;

	public TrelloLogintoContinuepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "password")
	private WebElement passwordTextField;

	@FindBy(id = "login-submit")
	private WebElement loginbutton;

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

}
