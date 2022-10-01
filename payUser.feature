@PayUser
Feature: Login functionality
@Regression
Scenario: Verify user is able to login with valid credentails
Given  If user is on home page
When   Click on login link
And    Enter login details
Then   Verify logout buttton

