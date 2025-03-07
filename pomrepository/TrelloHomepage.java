package com.trello.qpiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloHomepage  {
	WebDriver driver;

	public TrelloHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Get Trello for free']/preceding-sibling::a[text()='Log in']")
	private WebElement loginoption;

	public WebElement getLoginoption() {
		return loginoption;
	}
}
