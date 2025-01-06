package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageFactoryManager;

public class AccountStepDefinitions extends PageFactoryManager{

	@Given("I am on the software testing board homepage")
	public void i_am_on_the_software_testing_board_homepage() {
	    homePage.navigateToHomePage("https://magento.softwaretestingboard.com");
	}
	
	@When("^I click on create an account link and submitted user details (.+), (.+), (.+) and (.+)$")
	public void i_click_on_create_an_account_link_and_submit_user_details(String firstName, String lastName, String email, String password) {
	    homePage.createAccount(firstName, lastName, email, password);
	}
	
	@Then("I verify that am able to login to my account")
	public void i_verify_that_am_able_to_login_into_my_account() {
		Assert.assertTrue(login.verifyAccCreation());
		
	}
}
