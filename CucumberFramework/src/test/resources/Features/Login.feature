@LoginAll
Feature: Login Functionlity

Background:
Given user should be on login page

@smoke @regression
Scenario: Valid Login
When user enters the valid userid as "admin" and password as "admin"
And click on login button
Then User should be navigated to home page
And user can see Logout Link appear on the home page 
And close browser


@validlogin
Scenario: Valid Login
When user enters the valid userid as "admin" and password as "admin"
And click on login button
Then User should be navigated to home page
And user can see Logout Link appear on the home page 
And close browser



@test
Scenario: Valid Login2
When user enters the valid userid as "<userid>" and valid password as "<password>"
|userid |password|
|admin|admin|
And click on login button
Then User should be navigated to home page
And user can see Logout Link appear on the home page 
And close browser


@test2 @sanity
Scenario Outline: InValid Login
When user enters the invalid userid as "<username>" and invalid password as "<password>"
And click on login button
And close browser
Examples:
|username | password  |
|admin1   | admin12345|
|admin2   | 12345     |
|admin3   | 123       |
