package com.trello.qspiders.genericutility;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public boolean waitForCompleteTitle(WebDriver driver, String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		boolean validation=wait.until(ExpectedConditions.titleIs(expectedTitle));
		return validation;
	}
	public WebElement waitForElementVisibility(WebDriver driver,String elementTd) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement visibility = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementTd)));
		return visibility;
	}
	public WebElement visibilityOfElemnt(WebDriver driver,WebElement webelement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webelement));
		return element;
	}
	
	public void switchToImmediateFrameByIndex (WebDriver driver, int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
}
