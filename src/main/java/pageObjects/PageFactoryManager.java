package pageObjects;


import org.openqa.selenium.WebDriver;

import utility.DriverManager;
import utility.WebUtility;

public class PageFactoryManager {
	private WebDriver driver;
	public HomePage homePage;
	public LoginPage login;
	public WebUtility util;

	public PageFactoryManager() {
		driver = DriverManager.getdriver();
		homePage = new HomePage(driver);
		login = new LoginPage(driver);
		util = new WebUtility(driver);

	}

}
