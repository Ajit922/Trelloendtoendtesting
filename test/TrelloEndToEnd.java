package com.trello.qspiders.trelloendtoend;

import java.io.IOException;



import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import com.trello.qpiders.pomrepository.TrelloHomepage;
import com.trello.qspiders.genericutility.BaseClass;

public class TrelloEndToEnd extends BaseClass {
	@Test(priority = 1)
	public void loginToTrello() throws IOException, InterruptedException {
		webDriverUtils.implicitWait(driver);
		System.out.println(trelloLoginoption.getLoginoption().getText());
		trelloLoginoption.getLoginoption().click();
		trelloLogin.getEmailtextfield().sendKeys(fileUtils.readDataFromPropertyFile("username"));
		trelloLogin.getContinuebutton().submit();
		//webDriverUtils.waitForElementVisibility(driver, "password");
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofMillis(200));
		wait.withTimeout(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(continueToLogin.getPasswordTextField()));
		continueToLogin.getPasswordTextField().sendKeys(fileUtils.readDataFromPropertyFile("password"));
		continueToLogin.getLoginbutton().submit();
		Thread.sleep(5000);

	}

	@Test(priority = 7)
	public void logoutFromTrello() {
		logOut.getLogoutButton().click();
	}

	@Test(priority = 2)

	public void createBoardInTrello() throws  Throwable {
		Actions actions = new Actions(driver);
		// actions.moveToElement(boardPage.getCreatenewboard()).click().perform();
		//webDriverUtils.visibilityOfElemnt(driver, boardPage.getCreatedBoard());
		boardPage.getCreatenewboard().click();
		boardPage.getBoardTitle().sendKeys(fileUtils.readDataFromPropertyFile("boardtitle"));
		actions.scrollToElement(boardPage.getCreatebutton()).click(boardPage.getCreatebutton()).perform();
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	public void createListInTrelloBoard() throws EncryptedDocumentException, IOException {
		Actions actions = new Actions(driver);
		//actions.moveToElement(driver.switchTo().activeElement()).click().perform();
		actions.moveToElement(userPage.getListTitleTextField())
				.sendKeys(userPage.getListTitleTextField(), excelUtils.readStringData("trello", 0, 1))
				.sendKeys(Keys.ENTER).build().perform();
		actions.moveToElement(driver.switchTo().activeElement())
				.sendKeys(driver.switchTo().activeElement(), excelUtils.readStringData("trello", 0, 2))
				.sendKeys(Keys.ENTER).build().perform();
	}

	@Test(priority = 4)
	public void createCardsListInBoardspage() throws EncryptedDocumentException, IOException, InterruptedException {
		List<WebElement> listTitles = driver.findElements(By.tagName("textarea"));
		Actions actions = new Actions(driver);
		for (WebElement Title : listTitles) {

			if (Title.getText().equals(excelUtils.readStringData("trello", 0, 1))) {
				System.out.println(Title.getText());
				actions.moveToElement(Title, 0, 28).click().perform();
				WebElement cardTitle = driver
						.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']"));
				actions.moveToElement(cardTitle).sendKeys(cardTitle, excelUtils.readStringData("trello", 1, 1))
						.sendKeys(Keys.ENTER).build().perform();
				actions.moveToElement(driver.switchTo().activeElement()).sendKeys(driver.switchTo().activeElement(), "Yash").sendKeys(Keys.ENTER).build().perform();
			} else if (Title.getText().equals(excelUtils.readStringData("trello", 0, 2))) {
				actions.moveToElement(Title, 0, 28).click().perform();
				WebElement cardTitle = driver
						.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']"));
				actions.moveToElement(cardTitle).sendKeys(cardTitle, excelUtils.readStringData("trello", 1, 2))
				.sendKeys(Keys.ENTER).build().perform();
			}

			Thread.sleep(4000);

		}
	}
	@Test(priority = 5)
	public void dragAndDrop() throws InterruptedException, EncryptedDocumentException, IOException {
		Actions actions = new Actions(driver);
		List<WebElement> listTitles = driver.findElements(By.tagName("textarea"));
		for (WebElement Title : listTitles) {
			if (Title.getText().equals(excelUtils.readStringData("trello", 0, 1))) {
				System.out.println(Title.getText());
				WebElement card = driver.findElement(By.xpath("//span[@class='list-card-title js-card-name']"));
				actions.clickAndHold(card).pause(1000).dragAndDropBy(card, 264, 0).perform();
			}
			
		}
		
		Thread.sleep(4000);
	}

	@Test(priority = 6)
	public void deleteBoardInTrello() throws InterruptedException {
		webDriverUtils.visibilityOfElemnt(driver, userPage.getShowmenuoption());
		Thread.sleep(5000);
		userPage.getShowmenuoption().click();
		userPage.getMoreoption().click();
		userPage.getCloseboardoption().click();
		userPage.getClosebutton().click();
		userPage.getDeleteboardbutton().click();
		userPage.getDeletebutton().click();
		boardPage.getMenuoption().click();
		boardPage.getLogoutoption().click();

	}
}
