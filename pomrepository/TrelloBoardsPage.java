package com.trello.qpiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {
	WebDriver driver;

	public TrelloBoardsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		

	@FindBy(xpath = "//div[.='Create new board']")
	private WebElement createnewboard;
	@FindBy(css = "input[data-testid='create-board-title-input']")
	private WebElement boardTitle;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createbutton;

	@FindBy(xpath = "//button[@aria-label='Open member menu']")
	private WebElement menuoption;

	@FindBy(xpath = "//span[text()='Log out']")
	WebElement logoutoption;
	@FindBy(xpath = "//div[@title='QASM6']")
	private WebElement usercreatedBoard;

	public WebElement getUsercreatedBoard() {
		return usercreatedBoard;
	}

	public WebElement getCreatenewboard() {
		return createnewboard;
	}

	public WebElement getBoardTitle() {
		return boardTitle;
	}

	public WebElement getCreatebutton() {
		return createbutton;
	}

	public WebElement getMenuoption() {
		return menuoption;
	}

	public WebElement getLogoutoption() {
		return logoutoption;
	}
	


}
