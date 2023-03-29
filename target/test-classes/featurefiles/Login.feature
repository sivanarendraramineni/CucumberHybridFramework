Feature: Login functionality

Scenario: Login with valid credentials
Given user navigate to login page
When user entered valid email address "sivanarendra@gmail.com" into email field
And user enter valid password "12345" into password fied
And click on login button
Then user loggedin successfully

Scenario: Login with invalid credentials
Given user navigate to login page
When user entered invalid email "siva@gmail.com" into email field
And user entered invalid password "123" into password field
And click on login button
Then user get warning massage for invalid credentials

Scenario: Login with valid email and invalid password
Given user navigate to login page
When user entered valid email address "sivanarendra@gmail.com" into email field
And user entered invalid password "123" into password field
And click on login button
Then user get warning massage for invalid credentials

Scenario: Login with invalid email and valid password
Given user navigate to login page
When user entered invalid email "siva@gmail.com" into email field
And user enter valid password "12345" into password fied
And click on login button
Then user get warning massage for invalid credentials
 
 Scenario: Login without any credentials
 Given user navigate to login page
 When user not entered any email 
 And user not enter any password
 And click on login button
Then user get warning massage for invalid credentials
 