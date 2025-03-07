package com.trello.qpiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloUserCreatedBoardpage {
WebDriver driver;

public TrelloUserCreatedBoardpage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(tagName = "h2")
private WebElement addCardOption;


@FindBy(xpath = "//a[@class='open-add-list js-open-add-list']")
private WebElement addListOption;

@FindBy(xpath = "//button[@aria-label='Show menu']")
private WebElement showmenuoption;

@FindBy(xpath = "//a[contains(.,'More')]")
private WebElement moreoption;
@FindBy(xpath = "//a[contains(.,'Close board')]")
private WebElement closeboardoption;
@FindBy(xpath = "//input[@value='Close']")
private WebElement closebutton;
@FindBy(xpath = "//button[text()='Permanently delete board']")
private WebElement deleteboardbutton;
@FindBy(xpath = "//button[text()='Delete']")
private WebElement deletebutton;
@FindBy(xpath = "//input[@class='list-name-input']")
private WebElement listTitleTextField;

@FindBy(xpath = "//button[@aria-label='Open member menu']")
private WebElement menuoption;

@FindBy(xpath = "//span[text()='Log out']")
WebElement logoutoption;
@FindBy(xpath = "//span[text()='Dates']")
private WebElement datesOption;
@FindBy(xpath = "//span[@aria-label='Next month']")
private WebElement nextMonthOption;
@FindBy(xpath = "//div[@class='css-126sv']")
private WebElement month;
@FindBy (xpath = "//div[@class='css-mt8akf']")
private WebElement day;

@FindBy(xpath = "//button[@class='css-1o0bik5']")
private WebElement date;
public WebElement getDay() {
	return day;
}

public WebElement getDate() {
	return date;
}



public WebElement getMonth() {
	return month;
}

public WebElement getNextMonthOption() {
	return nextMonthOption;
}

public WebElement getDatesOption() {
	return datesOption;
}

public WebElement getListTitleTextField() {
	return listTitleTextField;
}

public WebElement getAddListOption() {
	return addListOption;
}

public WebElement getShowmenuoption() {
	return showmenuoption;
}
public WebElement getMoreoption() {
	return moreoption;
}

public WebElement getCloseboardoption() {
	return closeboardoption;
}

public WebElement getClosebutton() {
	return closebutton;
}

public WebElement getDeleteboardbutton() {
	return deleteboardbutton;
}

public WebElement getDeletebutton() {
	return deletebutton;
}
public WebElement getAddCardOption() {
	return addCardOption;
}
public WebElement getMenuoption() {
	return menuoption;
}

public WebElement getLogoutoption() {
	return logoutoption;
}

}
