#Author: Sudarshan V

Feature: Account creation and login

  
  Scenario Outline: As a user I want to create an account and login
    Given I am on the software testing board homepage
    When I click on create an account link and submitted user details <FirstName>, <LastName>, <Email> and <Password>
    Then I verify that am able to login to my account

    Examples: 
      | FirstName  | LastName | Email  					 		| Password	| 
      | Mike 			 |  Ross    | mi1222ws@gmail.com | Mike1234! |
