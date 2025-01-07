package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.WebUtility;

public class LoginPage {
	WebDriver driver;
	WebUtility util;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		util = new WebUtility(driver);
	}

	By accountSuccessMsg = By.xpath("//div[contains(@class,'success message')]");
	
	public boolean verifyAccntCreation() {
		return util.waitAndVerifyElement(accountSuccessMsg);
		
	}
}
