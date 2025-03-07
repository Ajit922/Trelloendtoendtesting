package com.trello.qspiders.genericutility;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.trello.qpiders.pomrepository.TrelloBoardsPage;
import com.trello.qpiders.pomrepository.TrelloHomepage;
import com.trello.qpiders.pomrepository.TrelloLoginPage;
import com.trello.qpiders.pomrepository.TrelloLogintoContinuepage;
import com.trello.qpiders.pomrepository.TrelloLogoutPage;
import com.trello.qpiders.pomrepository.TrelloUserCreatedBoardpage;

public class BaseClass {
	public WebDriver driver;
	
	public FileUtility fileUtils = new FileUtility();
	public ExcelUtility excelUtils = new ExcelUtility();
	public WebDriverUtility webDriverUtils = new WebDriverUtility();
	 public TrelloLogintoContinuepage continueToLogin;
	 public  TrelloHomepage trelloLoginoption;
	 public TrelloLoginPage trelloLogin;
	 public TrelloBoardsPage boardPage;
	 public TrelloUserCreatedBoardpage userPage;
	 public TrelloLogoutPage logOut;
	@BeforeClass
	public void configBeforeMethod() throws IOException {
		String browserName=fileUtils.readDataFromPropertyFile("browser");
		if (browserName.equals("chrome"))
		{
			driver=new ChromeDriver();
		}else if (browserName.equals("edge"))
		{
			driver= new EdgeDriver();
		}else if (browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(fileUtils.readDataFromPropertyFile("url"));
		trelloLoginoption=new TrelloHomepage(driver);
		trelloLogin=new TrelloLoginPage(driver);
		 continueToLogin=new TrelloLogintoContinuepage(driver);
		 boardPage=new TrelloBoardsPage(driver);
		 userPage =new TrelloUserCreatedBoardpage(driver);
		 logOut=new TrelloLogoutPage(driver);
	}
	@AfterClass
	public void configAfterMethod() {
		driver.manage().window().minimize();
		driver.quit();
	}
}
