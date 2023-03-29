Feature: Search functionality

Scenario: User search valid product
Given user navigate to search bar
When user enter valid product "hp" in search field
And user click on search button
Then user get valid product in reults

Scenario: User search invalid product
Given user navigate to search bar
When user enter invalid product "hero" in search field
And user click on search button
Then user get warning massage

Scenario: User search without any product
Given user navigate to search bar
When user not enter any product in search field
And user click on search button
Then user get warning massage