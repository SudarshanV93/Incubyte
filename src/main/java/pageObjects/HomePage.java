package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.WebUtility;

public class HomePage{
	WebDriver driver;
	WebUtility util;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		util = new WebUtility(driver);
	}
    
    By createAccountLink = By.linkText("Create an Account");
    By firstName = By.id("firstname");
    By lastName = By.id("lastname");
    By email = By.name("email");
    By password = By.id("password");
    By resetPassword = By.id("password-confirmation");
    By submitBtn = By.xpath("// button[@title='Create an Account']/span");
    
    public void navigateToHomePage(String url) {
    	util.navigate(url);
    }
    
    public void createAccount(String firstName, String lastName, String email, String password) {
    	util.click(createAccountLink);
    	util.inputText(this.firstName, firstName);
    	util.inputText(this.lastName, lastName);
    	util.inputText(this.email, email);
    	util.inputText(this.password, password);
    	util.inputText(this.resetPassword, password);
    	util.click(submitBtn);
    }
}