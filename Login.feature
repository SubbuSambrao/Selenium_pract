@Login
Feature: Login functionality
Background:
Given  If user is on home page
When   Click on login link
@Sanity
Scenario Outline: Verify user is able to login with valid credentails

And    Enter user name as "<Username>" and password as "<Password>"
Then   Verify logout buttton
Examples:
    | Username | Password |
    | demo5    | 1235     |
    | demo3    | 1234     |



@Regression @Sanity
Scenario: Verify user is able to generate QR code
And    Enter user name as "demo5" and password as "1235"
And    Click on Receive QR-code payment
And    Enter amount  as "34"
And    Click on next button
Then   Verify QR code

@DB
Scenario: Verify database values
And    Enter user name as "demo3" and password as "1234"



